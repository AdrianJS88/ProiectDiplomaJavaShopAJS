import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;




public class ProgPrinc {
    static Scanner sc = new Scanner(System.in);
    static DemoCrudUser dbaccess = new DemoCrudUser();

    static Crud_Products dbaccessprod = new Crud_Products();
    static User user1 = new User("adi","1");

    static Food food = new Food("food",1);

    public static void main(String[] args) throws IOException, SQLException {

        System.out.println("Login app food menu");

        long id = -1;
        User u = null;
        while (true) {
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

        // ura sunt logat , deci pot baga mancare
        while (true) {

            boolean isAdmin = dbaccess.isAdmin(u);

        if (!isAdmin) {
            //user menu.


            Scanner s = new Scanner(System.in);

            int ch;
            do {
                System.out.println("1.INSERT  FOOD FOR CURRENT USER");
                System.out.println("2.DISPLAY LIST OF FOOD FOR CURRENT ID USER");
                System.out.println("3.DELETE FOOD FROM LIST");
                System.out.println("4.UPDATE FOOD FROM LIST");
                System.out.println("5.Exit");
                System.out.print("Enter Your Choice : ");
                ch = s.nextInt();

                switch (ch) {
                    case 1:


                        dbaccess.insertFoodForUserID(food,id);
                        break;
                    case 2:

                        dbaccess.readFoodsOfAnUser();

                        break;
                    case 3:
                        dbaccess.deleteFood(food);
                        break;
                    case 4:
                        dbaccess.updateFood(food);
                        break;

                }
            } while (ch != 5);
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
                    System.out.println("9.Exit");//ok
                    System.out.print("Enter Your Choice : ");
                    ch2 = s.nextInt();

                    switch (ch2) {
                        case 1:
                            dbaccess.createUser(user1,false);//ok

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


                    }


                }
                while (ch2 != 9);
                System.out.println("YOU EXIT THE APP");
                break;
            }
        }
    }
}




