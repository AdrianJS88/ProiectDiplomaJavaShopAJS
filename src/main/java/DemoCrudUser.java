import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemoCrudUser {
Scanner sc =new Scanner(System.in);
    String createUser(Prod user, boolean isadmin){
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

    public List<Prod> readUsersByAdmin(){
        List<Prod> listOfUsers = new ArrayList<>();

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
                Prod u = new Prod(user,password);
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

    String updateUser(Prod u) {
        String message=null;
        int val = 0;

        //connect to DB

        try {
            Connection connection = DBconnect.ConexiuneDB();

            // run SQL
             PreparedStatement preparedStatement = connection.prepareStatement("update users set password = ? ,username = ? where id = ? ");
            System.out.println("new pass");
                         preparedStatement.setString(1,sc.nextLine());
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

        System.out.println(message);
        System.out.println(val + " user/s successfully updated");
        return message;

    }

    String deleteUser(Prod u){
        String message = null;
        int val = 0;

        //connect to DB

        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id = ?");

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





//food
    public List<Food> readFoodsOfAnUser() {
        List<Food> listOfFood = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //connect to DB

        try {
            Connection connection = DBconnect.ConexiuneDB();
        //  ("select * from users order by id asc");
            //run SQL

            PreparedStatement preparedStatement = connection.prepareStatement("select  foodname, iduser from loggedfood,users where users.username=? and users.id=loggedfood.iduser");
            System.out.println("enter  username to read the food for: ");
            String username = scanner.nextLine();
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();


            while(resultSet.next()) {
                String foodname = resultSet.getString("foodname").trim();
                int iduser = resultSet.getInt("iduser");
                Food food = new Food(foodname,iduser);
                listOfFood.add(food);
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
        if(listOfFood.isEmpty())
            System.out.println(" user  no registered ");
        else
            System.out.println( " user selected has the following foods: ");
        System.out.println(listOfFood);
        System.out.println("");
        return listOfFood;
    }

//fooddddddddddddd
    String updateFood(Food food) {
        String message= null;
        int val=0;

        //connect to DB


        try {
            Connection connection = DBconnect.ConexiuneDB();
            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("update loggedfood set foodname = ? where iduser = ?");
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
    String deleteFood(Food food){
        String message = null;
        int val = 0;

        //connect to DB


        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("delete from loggedfood where foodname = ? and iduser=?");
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


    long login (Prod user)  {

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

    boolean isAdmin (Prod user)  {

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

//fodddd
    boolean insertFoodForUserID (Food food, long id)  {

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
            PreparedStatement pSt = conn.prepareStatement("insert into loggedfood (foodname,iduser) values (?,?);");
            System.out.println("Enter foodname to add");
            pSt.setString(1,sc.nextLine());
            System.out.println("Enter user  id to add");
            pSt.setLong(2, sc.nextLong());
            val = pSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean ok = false;
        if(val!=0)
            ok=true;
        return ok;
    }


}

