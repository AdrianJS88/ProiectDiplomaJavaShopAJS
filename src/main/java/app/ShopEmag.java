package app;

import java.io.IOException;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class ShopEmag {
    static ShopEmag dbaccess = new ShopEmag();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //DatabaseConnection.makeDatabase();
        Admin u = null;
        sc.useDelimiter("\n");
        boolean Exit = false;
        int Options;
        System.out.println("WELCOME TO ONLINE SHOPPING SYSTEM\n");
        while (!Exit) {
            System.out.println("*****************************************************\n");
            System.out.println("1 - REGISTER AS ADMIN");
            System.out.println("2 - REGISTER AS CUSTOMER");
            System.out.println("3 - LOGIN TO SYSTEM");
            System.out.println("4 - EXIT");
            System.out.println("*****************************************************\n");
            System.out.print("Enter choice : ");
            try {

                Options = sc.nextInt();

                switch (Options) {
                    case 1:
                        registerAdmin();
                        break;
                    case 2:
                        registerCustomer();
                        break;
                    case 3:
                        logSys.LogginSys();
                        break;
                }
            } catch (InputMismatchException | IOException e) {
                System.out.println("YOU MUST ENTER ONLY NUMBERS");

            }
        }
    }
    static long login(Customer user)  {

        // -1 daca nu exista , si id-ul usaerului daca exista
        long id = -1;

        //connect to DB


        try {
            String dbURL = "jdbc:postgresql://localhost:5432/Emag";
            Properties parameters = new Properties();
            parameters.put("user", "postgres");
            parameters.put("password", "postgres");
            Connection conn = DriverManager.getConnection(dbURL, parameters);

            PreparedStatement preparedStatement = conn.prepareStatement("select custid from customer where  custemail=? and custpass=? ");

            preparedStatement.setString(1,user.getCustEmail());
            preparedStatement.setString(2,user.getCustpass());
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

    boolean isAdmin (Admin ad)  {

        // -1 daca nu exista , si id-ul usaerului daca exista


        boolean isAdmin=false;

        //connect to DB

        try {
            String dbURL = "jdbc:postgresql://localhost:5432/Emag";
            Properties parameters = new Properties();
            parameters.put("user", "postgres");
            parameters.put("password", "postgres");
            Connection conn = DriverManager.getConnection(dbURL, parameters);

            //run SQL
            PreparedStatement preparedStatement = conn.prepareStatement("select isadmin from admin where emailadmin=? and passadmin=? ");

            preparedStatement.setString(1,ad.getEmailAdmin());
            preparedStatement.setString(2,ad.getPassAdmin());
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

    static void registerAdmin()throws IOException
    {

        String pass,email;
        boolean isadmin ;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWELCOME TO ADMIN REGISTRATION PAGE\n");
        System.out.println("*****************************************************\n");
        System.out.print("Enter email = ");
         email= sc.next();
        System.out.print("Enter password = ");
        pass = sc.next();
        System.out.print("Enter true if you are admin = ");
       isadmin = sc.nextBoolean();

        //inserting data into database
        try
        {
            String dbURL = "jdbc:postgresql://localhost:5432/Emag";
            Properties parameters = new Properties();
            parameters.put("user", "postgres");
            parameters.put("password", "postgres");
            Connection conn = DriverManager.getConnection(dbURL, parameters);
            PreparedStatement ps=conn.prepareStatement("insert into admin(emailadmin, passadmin,isadmin) values(?,?,?)");
            PreparedStatement ps1=conn.prepareStatement("insert into logininfo(emailuser, userpass,isadmin) values(?,?,?)");
            ps.setString(1,email);
            ps.setString(2, pass);
            ps.setBoolean(3,isadmin );
            ps1.setString(1,email);
            ps1.setString(2, pass);
            ps1.setBoolean(3,isadmin );


            int x=ps.executeUpdate();

            if(x>0 )
                System.out.println("REGISTRATION DONE SUCCESSFULLY !\n");
            else
                System.out.println("REGISTRATION FAILED !\n");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    static void registerCustomer()throws IOException
    {  String pass,email;
        boolean isadmin ;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWELCOME TO CUSTOMER REGISTRATION PAGE\n");
        System.out.println("*****************************************************\n");
        System.out.print("Enter email = ");
        email= sc.next();
        System.out.print("Enter password = ");
        pass = sc.next();
        System.out.print("Enter true if you are admin = ");
        isadmin = sc.nextBoolean();



        //inserting data into database
        try
        {
            String dbURL = "jdbc:postgresql://localhost:5432/Emag";
            Properties parameters = new Properties();
            parameters.put("user", "postgres");
            parameters.put("password", "postgres");
            Connection conn = DriverManager.getConnection(dbURL, parameters);
            PreparedStatement ps=conn.prepareStatement("insert into customer(custemail, custpass,isadmin) values(?,?,?)");
            PreparedStatement ps1=conn.prepareStatement("insert into logininfo(emailuser, userpass,isadmin) values(?,?,?)");
            ps.setString(1,email);
            ps.setString(2, pass);
            ps.setBoolean(3,isadmin );
            ps1.setString(1,email);
            ps1.setString(2, pass);
            ps1.setBoolean(3,isadmin );



            int x=ps.executeUpdate();

            if(x>0 )
                System.out.println("REGISTRATION DONE SUCCESSFULLY !\n");
            else
                System.out.println("REGISTRATION FAILED !\n");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

   }

}
