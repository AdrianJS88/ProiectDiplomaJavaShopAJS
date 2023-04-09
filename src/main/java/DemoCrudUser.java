import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemoCrudUser {
Scanner sc =new Scanner(System.in);
    String createUser(User user, boolean isadmin){
        String message=null;
        int val=0;

        //connect to DB with driver

        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS (username, password, isadmin) VALUES (?,?,?)");
            System.out.println("Enter user name :");
            preparedStatement.setString(1,sc.nextLine());
            System.out.println("Enter user password :");
            preparedStatement.setString(2, sc.nextLine());
            System.out.println("Enter true  if user is admin or false if no :");
            preparedStatement.setBoolean(3,sc.nextBoolean());

            val=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            String m = e.getMessage();
            if(m.contains("authentication failed for"))
                message="connection problem";
            else if(m.contains("ERROR: value too long"))
                message=" username or password too long";
            else message="error";
        }


        System.out.println(val + " user successfully created ");
        return message;
    }

    public List<User> readUsersByAdmin(){
        List<User> listOfUsers = new ArrayList<>();

        //connect to DB


        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users order by id asc");

            while(resultSet.next()){
                String user = resultSet.getString("username").trim();
                String password = resultSet.getString("password").trim();
                boolean isadmin = resultSet.getBoolean("isadmin");
                int id = resultSet.getInt("id");
                User u = new User(user,password);
                u.setId(id);
                u.setIsadmin(isadmin);
                listOfUsers.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(listOfUsers);
        return listOfUsers;
    }

    String updateUser(User u) {
        String message=null;
        int val = 0;

        //connect to DB

        try {
            Connection connection = DBconnect.ConexiuneDB();

            // run SQL
             PreparedStatement preparedStatement = connection.prepareStatement("update users set password = ? ,username = ? where id = ? ");
            System.out.println("new pass");
                         preparedStatement.setString(1,sc.next());
            System.out.println("new username");
                        preparedStatement.setString(2, sc.next());
            System.out.println("old id");
                        preparedStatement.setInt(3, Integer.parseInt(sc.next()));
                        val = preparedStatement.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
            String m = e.getMessage();
            if(m.contains("authentication failed "))
                message=" connection problem!";
            else if(m.contains("ERROR: value too long "))
                message="username or password too long! ";
            else message="error ";
        }


        System.out.println(val + " user/s successfully updated");
        return message;

    }

    String deleteUser(User u){
        String message = null;
        int val = 0;

        //connect to DB

        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id = ?");
            System.out.println("Enter id number to delete :");
            preparedStatement.setInt(1, sc.nextInt());

            val = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            String m = e.getMessage();
            if(m.contains(" authentication failed for"))
                message= " connection problem ";
            else if(m.contains("violates foreign key constraint"))
                message= " cannot delete  user  food registered for him";
            else if(m.contains("is not present"))
                message=" user  does not exist!";
            else message= " error";
        }

        System.out.println(message);
        System.out.println(val + " user/sdeleted ");
        return message;
    }


//*******************************CART CRUD***************************************************************************************



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
            System.out.println( " user selected has the following foods: ");
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
                message="  food name  too long";
            else if(m.contains(" not exist"))
                message=" cannot update user  does not exist. ";
            else message=" error";

        }

        System.out.println(message);
        System.out.println(val + " food/s successfully updated ");
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


            message=String.valueOf(val + " food/s succesfully deleted");
        } catch (SQLException e) {
            e.printStackTrace();
            String m = e.getMessage();
            if(m.contains(" authentication failed "))
                message= " connection problem ";
            else if(m.contains("violates foreign key constraint"))
                message= "cannot delete  food exist user registered for it";
            else  message=" error";
        }

        if(val<=0) System.out.println("The food  does not exist ");
        if(message!=null) System.out.println(message);
        return message;
    }
//*******************************CART CRUD***************************************************************************************

    long login (User user)  {

        // -1 daca nu exista , si id-ul usaerului daca exista
        long id = -1;

        //connect to DB


        try {
            Connection connection = DBconnect.ConexiuneDB();
            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("select id from users where username=? and password=? ");

            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();


            while(resultSet.next()) {
                id = resultSet.getLong("id");
                return id;
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(id);
        return id;
    }

    boolean isAdmin (User user)  {

        // -1 daca nu exista , si id-ul usaerului daca exista


        boolean isAdmin=false;

        //connect to DB

        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("select isadmin from users where username=? and password=? ");

            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();


            while(resultSet.next()) {

                isAdmin = resultSet.getBoolean("isadmin");
                return isAdmin;

            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isAdmin;
    }

    //*******************************CART CRUD***************************************************************************************
    boolean insertProdInCartForUserID(Cart cart, long id)  {

        // COD CARE SCRIE IN DB



        // daca are rezultate, citirea lor


        // conectare la db cu incarcare driver
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
//*******************************CART CRUD***************************************************************************************

}

