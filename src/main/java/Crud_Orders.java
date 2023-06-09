import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crud_Orders {
    static Scanner sc = new Scanner(System.in);

    public static String insertOrdersHistory() {
        String message = null;
        int val = 0;
        //connect to DB with driver
        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders_history (prodid, orderid, prodgroup, prodname, prodprice, prodquantity,billid,deliveraddress,f_name,l_name,id_card,exp_card_date,card_cvv) " +
                    "SELECT prodid, orderid, prodgroup, prodname, prodprice, prodquantity, billid, deliveraddress, f_name, l_name, id_card, exp_card_date, card_cvv FROM cart,payments ");

            val = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            String m = e.getMessage();
            if (m.contains("authentication failed for"))
                message = "connection problem";
            else if (m.contains("ERROR: value too long"))
                message = " username or password too long";
            else message = "error";
        }
        System.out.println("                                     ");
        System.out.println(" Order successfully sent !");

        return message;

    }

    public static List<Orders_history> readOrdersByAdmin() {
        List<Orders_history> listOfOrders_history = new ArrayList<>();

        //connect to DB


        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT\n" +
                    "  orderid,\n" +
                    "   billid,\n" +
                    "   prodid,prodgroup,prodname,f_name,l_name,deliveraddress,id_card,exp_card_date,card_cvv,prodprice,prodquantity\n" +
                    "FROM   orders_history   ");


            while (resultSet.next()) {
                int order_id = resultSet.getInt("orderid");
                int billid = resultSet.getInt("billid");
                int prodid = resultSet.getInt("prodid");
                int prodquantity = resultSet.getInt("prodquantity");
                String prodgroup = resultSet.getString("prodgroup").trim();
                String prodname = resultSet.getString("prodname").trim();
                String f_name = resultSet.getString("f_name").trim();
                String l_name = resultSet.getString("l_name").trim();
                String deliveraddress = resultSet.getString("deliveraddress").trim();
                int id_card = (int) resultSet.getLong("id_card");
                int exp_card_date = resultSet.getInt("exp_card_date");
                int card_cvv = resultSet.getInt("card_cvv");
                int prodprice = resultSet.getInt("prodprice");


                Orders_history orderHist = new Orders_history(order_id, billid, prodid, prodgroup, prodname, f_name, l_name, prodprice, deliveraddress, id_card, exp_card_date, card_cvv, prodquantity);

                orderHist.setOrderid(order_id);
                orderHist.setBillid(billid);
                orderHist.setProdid(prodid);
                orderHist.setProdquantity(prodquantity);
                orderHist.setProdprice(prodprice);
                orderHist.setProdgroup(prodgroup);
                orderHist.setProdname(prodname);
                orderHist.setF_name(f_name);
                orderHist.setL_name(l_name);
                orderHist.setDeliveraddress(deliveraddress);
                orderHist.setId_card(id_card);
                orderHist.setExp_card_date(exp_card_date);
                orderHist.setCard_cvv(card_cvv);
                listOfOrders_history.add(orderHist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(listOfOrders_history);
        return listOfOrders_history;
    }

    static String updateOrders() {
        String message = null;
        int val = 0;

        //connect to DB

        try {
            Connection connection = DBconnect.ConexiuneDB();

            // run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("update orders_history set deliveraddress = ? ,  f_name = ? ,l_name = ? ,prodquantity = ? where orderid = ?");
            System.out.println("Enter new address :");
            preparedStatement.setString(1, sc.nextLine());
            System.out.println("Enter new first name:");
            preparedStatement.setString(2, sc.nextLine());
            System.out.println("Enter new last name:");
            preparedStatement.setString(3, sc.nextLine());
            System.out.println("Enter new product quantity: ");
            preparedStatement.setInt(4, Integer.parseInt(sc.next()));
            System.out.println("Enter Old order id:");
            preparedStatement.setInt(5, Integer.parseInt(sc.next()));



            val = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            String m = e.getMessage();
            if (m.contains("authentication failed "))
                message = " connection problem!";

            else message = "error ";
        }


        System.out.println(val + " Order/s successfully updated");
        return message;

    }

    static String deleteOrders(){
        String message = null;
        int val = 0;

        //connect to DB

        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("delete from orders_history");

            val = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();


        }


        System.out.println(val + " Order/s deleted ");
        return message;
    }







}
