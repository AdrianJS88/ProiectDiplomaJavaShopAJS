import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Register {
    static Scanner sc =new Scanner(System.in);
    static String customerRegister(){


        System.out.println("Customer register menu");
        String message=null;
        int val=0;

        //connect to DB with driver

        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?,?)");
            System.out.println("Enter user name :");
            preparedStatement.setString(1,sc.nextLine());
            System.out.println("Enter user password :");
            preparedStatement.setString(2, sc.nextLine());


            val=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            String m = e.getMessage();
            if(m.contains("authentication failed "))
                message="connection problem";
            else if(m.contains("ERROR: value too long"))
                message=" username or password too long";
            else message="error";
        }


        System.out.println(val + " user successfully created ");
        return message;
    }
}
