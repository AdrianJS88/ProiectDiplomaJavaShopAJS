package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class Admin {
    private String emailAdmin;
    private String passAdmin;

    private int idAdmin;

    public Admin(String emailAdmin, String passAdmin, int idAdmin) {
        this.emailAdmin = emailAdmin;
        this.passAdmin = passAdmin;
        this.idAdmin = idAdmin;
    }

    public Admin(int uid, String passw) {
    }

    public Admin(String email, String pwd, Boolean isadmin) {
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public String getPassAdmin() {
        return passAdmin;
    }

    public void setPassAdmin(String passAdmin) {
        this.passAdmin = passAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "emailAdmin='" + emailAdmin + '\'' +
                ", passAdmin=" + passAdmin +
                ", idAdmin=" + idAdmin +
                '}';
    }

    public void AdminPage() {

            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            boolean Exit = false;
            int Options;
            System.out.println("WELCOME TO ADMIN SECTION\n");
            while (!Exit) {
                System.out.println("*****************************************************\n");
                System.out.println("1 - MANAGE PRODUCTS");//completed
                System.out.println("2 - ADD CUSTOMERS");//completed
                System.out.println("3 - REMOVE CUSTOMERS");//completed
                System.out.println("4 - EDIT PROFILE");//completed
                System.out.println("5 - VIEW REGISTERED CUSTOMERS");//completed
                System.out.println("6 - LOGOUT FROM SYSTEM");
                System.out.println("*****************************************************\n");
                System.out.print("Enter choice : ");
                try {

                    Options = sc.nextInt();

                    switch (Options) {
                        case 1:
//                        Products ob=new Products();
//                        ob.ProductsPage();
                            break;
                        case 2:
                            newUserInsert() ;
                            break;
                        case 3:
//                        removeCustomer();
                            break;
                        case 4:
//                        editProfile(adminID);
                            break;
                        case 5:
//                        viewCustomers();
                            break;

                        case 6:
                            Exit = true;
                            break;

                    }
                } catch (InputMismatchException e) {
                    System.out.println("YOU MUST ENTER ONLY NUMBERS");

                }
            }
        }
        public boolean newUserInsert() {

            Scanner sc = new Scanner(System.in);

            boolean isInserted=false;
            try {
                // 1. ma conectez la db
                String dbURL = "jdbc:postgresql://localhost:5432/Emag";
                Properties parameters = new Properties();
                parameters.put("user", "postgres");
                parameters.put("password", "postgres");
                Connection conn = DriverManager.getConnection(dbURL, parameters);


                // 2. creez un prepared ststement si il populez cu date
                PreparedStatement pSt = conn.prepareStatement("INSERT INTO customer (custid, custemail, custpass) VALUES(?,?,?)");
                System.out.println("enter  cust id");
                pSt.setInt(1,sc.nextInt());
                System.out.println("enter  cust email");
                pSt.setString(2, sc.next());
                System.out.println("enter  cust pass");
                pSt.setString(3, sc.next());





                // 3. executie
                int insert = pSt.executeUpdate();
                if(insert!=-1)
                    isInserted=true;
                System.out.println(isInserted);

                pSt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                isInserted=false;

            }


            return isInserted;
        }


    }

