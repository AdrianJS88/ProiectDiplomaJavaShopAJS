import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Main {
    static Scanner sc = new Scanner(System.in);
    static DemoCrudUser dbaccess = new DemoCrudUser();

    static float total = 0;

    static Crud_Products dbaccessprod = new Crud_Products();

    static Crud_Cart dbaccessCartList = new Crud_Cart();



    static User user1 = new User("adi","1");

    static Cart shopingCart = new Cart("","",1,2,3,5);

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {


        System.out.println("************Login Shop App menu**********");
        int ch;
        do {
            System.out.println("*****************************************************************************");
            System.out.println("1.Register Customer menu ***********");
            System.out.println("2.Login shop menu****************");
            System.out.println("3.Exit app*******************");
            System.out.println("*****************************************************************************");
            System.out.print("Enter Your Choice : ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    Register.customerRegister();
                    break;
                case 2:
                    shopSystem();
                    break;

            }
        }while (ch != 3);
        System.out.println("YOU EXIT THE APP");

    }
    private static void shopSystem() throws IOException, SQLException, ClassNotFoundException {
        long id = -1;
        User u = null;

        while (true) {
            System.out.println("LOGIN SHOP MENU!!!!!!!");
            System.out.println("Enter username:");
            Scanner sc = new Scanner(System.in);
            String username = sc.nextLine();
            System.out.println("Enter password:");
            String pwd = sc.nextLine();
            u = new User(username, pwd);
            id = dbaccess.login(u);
            u.setId(id);
            if (id != -1)
                break;
        }


        while (true) {

            boolean isAdmin = dbaccess.isAdmin(u);

        if (!isAdmin) {
            //user menu.


            Scanner s = new Scanner(System.in);

            int ch;
            do {
                System.out.println("0.AVAILABLE  PRODUCTS IN STORE TO BUY ");
                System.out.println("1.INSERT PRODUCTS IN CART");
                System.out.println("2.DISPLAY CART LIST ");
                System.out.println("3.DELETE PRODUCTS FROM  CART");
                System.out.println("4.EDIT  CART");
                System.out.println("5.GENERATE bill ");
//                System.out.println("7.displayBill() ");
//                System.out.println("8.add bill to database ");
                System.out.println("6.Exit");
                System.out.print("Enter Your Choice : ");
                ch = s.nextInt();

                switch (ch) {
                    case 0:
                        dbaccessprod.readProdByAdmin();
                        break;
                    case 1:
                        dbaccessCartList.insertProdInCartForUserID();
                        break;
                    case 2:

                        dbaccessCartList.readCartListOfAnUser();

                        break;
                    case 3:
                        dbaccessCartList.deleteProductFromCart();
                        break;
                    case 4:
                  dbaccessCartList.updateProductFromCart(shopingCart);
                  break;
                    case 5:
                        Bill.generateBill();
                        break;
                    case 7:

                        break;
                    case 8:

                        break;


                }
            } while (ch != 6);
            System.out.println("YOU EXIT THE APP");
            break;
        }
            //is admin
            while (true) {
                //admin user menu.

                Scanner s = new Scanner(System.in);
                Scanner s1 = new Scanner(System.in);
                int ch2;
                do {
                    System.out.println("******* Admin menu ******* ");
                    System.out.println("1.INSERT  USER OR ADMIN");//ok
                    System.out.println("2.DISPLAY LIST OF USER");//ok
                    System.out.println("3.DELETE USER");//ok
                    System.out.println("4.UPDATE USER LIST");//ok
                    System.out.println("5.INSERT PRODUCTS TO STORE LIST");
                    System.out.println("6.READ PRODUCTS FROM STORE LIST");
                    System.out.println("7.UPDATE PRODUCTS FROM STORE LIST");
                    System.out.println("8.DELETE  PRODUCTS FROM STORE LIST");
                    System.out.println("9.Register  menu");
                    System.out.println("10.Exit");//ok
                    System.out.print("Enter Your Choice : ");
                    ch2 = s.nextInt();

                    switch (ch2) {
                        case 1:
                            dbaccess.createUser(user1, false);//ok

                            break;
                        case 2:
                            dbaccess.readUsersByAdmin();//ok
                            break;
                        case 3:
                            dbaccess.deleteUser(user1);//ok

                            break;
                        case 4:
                            dbaccess.updateUser(user1);//ok
                            break;
                        case 5:
                            dbaccessprod.createProduct();
                            break;
                        case 6:
                            dbaccessprod.readProdByAdmin();
                            break;
                        case 7:
                            dbaccessprod.updateProdByAdmin();
                            break;
                        case 8:
                            dbaccessprod.deleteProductsByAdmin();
                            break;
                        case 9:
                            System.out.println("*********Shop register menu*************");

                            break;


                    }


                }

                while (ch2 != 10);
                System.out.println("YOU EXIT THE APP");
                break;
            }
            break;
        }
    }

}




