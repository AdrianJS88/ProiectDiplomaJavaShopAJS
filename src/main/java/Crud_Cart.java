import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crud_Cart {
    Scanner sc = new Scanner(System.in);

    public String insertProdInCartForUserID() {
        String message = null;
        int val = 0;

        //connect to DB with driver

        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cart (prodid, prodgroup, prodname, prodprice, prodquantity, iduser)  SELECT prodid,prodgroup,prodname,prodprice,prodquantity,iduser FROM products WHERE prodid = ?");
            System.out.println("Enter product id name to add :");
            preparedStatement.setInt(1, Integer.parseInt(sc.next()));


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


        System.out.println(val + " product successfully created ");
        return message;
    }


    public List<Cart> readCartListOfAnUser() {
        List<Cart> listOfCart = new ArrayList<>();

        //connect to DB

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter the user id to see your product from cart:");
           Integer str = sc.nextInt();
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from cart left outer join users on cart.iduser = users.id where users.id = " +str+"");


            while (resultSet.next()) {
                int prodid = resultSet.getInt("prodid");
                String prodgroup = resultSet.getString("prodgroup").trim();
                String prodname = resultSet.getString("prodname").trim();
                int prodprice = resultSet.getInt("prodprice");
                int prodquantity = resultSet.getInt("prodquantity");
                int iduser = resultSet.getInt("iduser");


               Cart listCart = new Cart(prodid, prodgroup, prodname, prodprice, prodquantity,iduser);
               listCart.setProdid(prodid);
                listCart.setProdgroup(prodgroup);
                listCart.setProdname(prodname);
                listCart.setProdprice(prodprice);
                listCart.setProdquantity(prodquantity);
                listCart.setIduser(iduser);


                listOfCart.add(listCart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(listOfCart);
        return listOfCart;
    }


    String updateProductFromCart(Cart cart) {
        String message= null;
        int val=0;

        //connect to DB


        try {
            Connection connection = DBconnect.ConexiuneDB();
            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("update cart set prodname = ? where iduser = ?");
            System.out.println("Enter new  product name to update ");
            preparedStatement.setString(1,sc.nextLine());
            System.out.println("Enter id to be update");
            preparedStatement.setInt(2,sc.nextInt());

            val = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            String m = e.getMessage();
            if(m.contains("authentication failed "))
                message=" connection problem. ";
            else if(m.contains("ERROR: value too long for type character"))
                message="  Product name  too long";
            else if(m.contains(" not exist"))
                message=" cannot update product  does not exist. ";
            else message=" error";

        }

        System.out.println(message);
        System.out.println(val + "Product /s successfully updated ");
        return message;
    }

    //food
    String deleteProductFromCart(Cart cart){
        String message = null;
        int val = 0;

        //connect to DB


        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("delete from cart where prodid = ? ");
            System.out.println("Enter prod id to delete  ");
            preparedStatement.setString(1,sc.nextLine());



            val = preparedStatement.executeUpdate();


            message=String.valueOf(val + " product succesfully deleted");
        } catch (SQLException e) {
            e.printStackTrace();
            String m = e.getMessage();
            if(m.contains(" authentication failed "))
                message= " connection problem ";
            else if(m.contains("violates foreign key constraint"))
                message= "cannot delete  product exist product registered for it";
            else  message=" error";
        }

        if(val<=0) System.out.println("The product  does not exist ");
        if(message!=null) System.out.println(message);
        return message;
    }


}
