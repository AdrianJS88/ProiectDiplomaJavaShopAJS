import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Crud_Payment {

    public static String insertPaymentDetails() {
        String message = null;
        int val = 0;

        //connect to DB with driver

        try {
            Connection connection = DBconnect.ConexiuneDB();
             Scanner sc = new Scanner(System.in);
            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO payments ( deliveraddress, f_name, l_name, id_card, exp_card_date, card_cvv) " +
                    " SELECT ?,?,?,?,?,? ");
            System.out.println("Enter your delivery address:");
            preparedStatement.setString(1, sc.nextLine());
            System.out.println("Enter first name:");
            preparedStatement.setString(2, sc.nextLine());
            System.out.println("Enter last name:");
            preparedStatement.setString(3, sc.nextLine());
            System.out.println("Enter number card :");
            preparedStatement.setBigDecimal(4, sc.nextBigDecimal());
            System.out.println("Enter exp card date number :");
            preparedStatement.setInt(5, Integer.parseInt(sc.next()));
            System.out.println("Enter cvv  card number :");
            preparedStatement.setInt(6, Integer.parseInt(sc.next()));

            val = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            String m = e.getMessage();
            if (m.contains("authentication failed for"))
                message = "connection problem";
            else message = "error";
        }


        System.out.println(val + " payment  successfully completed ");
        System.out.println("                                     ");
        System.out.println("Thanks for buying!!!.");
        System.out.println("                                     ");
        return message;
    }




}
