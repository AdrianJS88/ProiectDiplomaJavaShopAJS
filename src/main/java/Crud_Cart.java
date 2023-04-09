import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crud_Cart {
    Scanner sc =new Scanner(System.in);

    boolean insertProdInCartForUserID(Cart cart, long id)  {


        final String URLDB = "jdbc:postgresql://localhost:5432/grupajava";
        final String USERNAMEDB ="postgres";
        final String PWDDB ="postgres";
        int val = 0; // 1
        try {
            Connection conn = DriverManager.getConnection(URLDB, USERNAMEDB, PWDDB);

            // rulare sql
            //  PreparedStatement pst = conn.prepareStatement("INSERT INTO loggedfood ( prodname, prodprice, prodquantity,id,iduser) VALUES (?,?,?,?,?)");
            PreparedStatement pst = conn.prepareStatement("Update cart set prodname = products.prodname , prodprice=products.prodprice ,prodquantity=products.prodquantity from products where products.prodid = ?");
            System.out.println("Enter product id  :");
            pst.setInt(1, sc.nextInt());

            val = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean ok = false;
        if(val!=0)
            ok=true;
        return ok;
    }




    public List<Cart> readCartListOfAnUser() {
        List<Cart> listOfCart = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //connect to DB

        try {
            Connection connection = DBconnect.ConexiuneDB();
            //  ("select * from users order by id asc");
            //run SQL

            PreparedStatement preparedStatement = connection.prepareStatement("select * from cart where iduser = ?");

            System.out.println("enter id of user : ");
            preparedStatement.setInt(1, Integer.parseInt(sc.next()));

            ResultSet resultSet = preparedStatement.executeQuery();


            while(resultSet.next()) {
                String productname = resultSet.getString("prodname").trim();
                Integer prodprice = resultSet.getInt("prodprice");
                Integer prodquantity = resultSet.getInt("prodquantity");
                int iduser = resultSet.getInt("iduser");
                int id = resultSet.getInt("id");
                Cart cart = new Cart(productname,iduser,id,prodprice,prodquantity);

                listOfCart.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            String message=null;
            String m = e.getMessage();
            if(m.contains(" authentication failed"))
                message= "connection problem! ";
            else message="error";
            System.out.println(message);
        }
        if(listOfCart.isEmpty())
            System.out.println(" user  no registered ");
        else
            System.out.println( " user selected has the following Product: ");
        System.out.println(listOfCart);
        System.out.println("");
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
            preparedStatement.setString(1,sc.nextLine());
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
            PreparedStatement preparedStatement = connection.prepareStatement("delete from cart where prodname = ? and iduser=?");
            preparedStatement.setString(1,sc.nextLine());
            preparedStatement.setInt(2,sc.nextInt());

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
