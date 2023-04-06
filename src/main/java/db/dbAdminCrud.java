package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class dbAdminCrud {

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
