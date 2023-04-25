import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crud_Products {
    Scanner sc =new Scanner(System.in);

    String createProduct(){
        String message=null;
        int val=0;

        //connect to DB with driver

        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products (prodid, prodgroup, prodname, prodprice, prodquantity) VALUES (?,?,?,?,?)");
            System.out.println("Enter product id name :");
            preparedStatement.setInt(1, sc.nextInt());
            System.out.println("Enter product group :");
            preparedStatement.setString(2, sc.next());
            System.out.println("Enter product name :");
            preparedStatement.setString(3, sc.next());
            System.out.println("Enter product price :");
            preparedStatement.setInt(4,sc.nextInt());
            System.out.println("Enter product quantity :");
            preparedStatement.setInt(5, sc.nextInt());

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


        System.out.println(val + " product successfully created ");
        return message;
    }
//**************************************************************************************************
    public List<Products> readProdByAdmin(){
        List<Products> listOfProd = new ArrayList<>();

        //connect to DB


        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from products order by prodid asc");

            while(resultSet.next()){
                int  producid = resultSet.getInt("prodid");
                String producgroup = resultSet.getString("prodgroup").trim();
                String producname = resultSet.getString("prodname").trim();
                int  producprice = resultSet.getInt("prodprice");
                int  producquantity = resultSet.getInt("prodquantity");


                int id = resultSet.getInt("prodid");
                Products products = new Products(producid,producgroup,producname,producprice,producquantity);
                products.setProdid(producid);
                products.setProdGroup(producgroup);
                products.setProdName(producname);
                products.setProdPrice(producprice);
                products.setProdQuantity(producquantity);




                listOfProd.add(products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(listOfProd);
        return listOfProd;
    }
//**************************************************************************************************************
    String updateProdByAdmin() {
        String message=null;
        int val = 0;

        //connect to DB

        try {
            Connection connection = DBconnect.ConexiuneDB();

            // run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("update products set prodgroup = ? ,prodname = ?, prodprice = ? ,prodquantity = ?  where prodid = ? ");
            System.out.println("new product group :");
            preparedStatement.setString(1,sc.next());
            System.out.println("new product name ");
            preparedStatement.setString(2, sc.next());
            System.out.println("new product price");
            preparedStatement.setInt(3, Integer.parseInt(sc.next()));
            System.out.println("new product quantity");
            preparedStatement.setInt(4, Integer.parseInt(sc.next()));
            System.out.println("old product id");
            preparedStatement.setInt(5, Integer.parseInt(sc.next()));



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


        System.out.println(val + " Product/s successfully updated");
        return message;

    }

    String deleteProductsByAdmin(){
        String message = " ";
        int val = 0;

        //connect to DB

        try {
            Connection connection = DBconnect.ConexiuneDB();

            //run SQL
            PreparedStatement preparedStatement = connection.prepareStatement("delete from products where prodid = ?");
            System.out.println("Enter product id to be deleted");
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
        System.out.println(val + " Product/s deleted ");
        return message;
    }






}
