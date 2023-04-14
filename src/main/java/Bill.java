import java.sql.*;
import java.util.Scanner;

public class Bill {

    public static String generateBill() {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        String message = null;
        int val = 0;
        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL

            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT SUM(prodprice)    FROM cart  ");

            while (res.next()) {
                int c = res.getInt(1);
                sum = sum + c;
            }
            System.out.println("Total sum of your products is : " + sum + "$");
            System.out.println("             ");

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return message;
    }

}






