package app;

import java.util.Scanner;

public class logSys {
    static Scanner sc = new Scanner(System.in);
    static ShopEmag dbaccess = new ShopEmag();
    Admin u = null;

    public static void LogginSys() {
        long id = -1;
        Customer u2 = null;
        Admin u3 = null;
        while (true) {
        System.out.println("Enter username:");
        String email = sc.nextLine();
        System.out.println("Enter password:");
        String pwd = sc.nextLine();
        System.out.println("Enter true if are admin:");
        Boolean isadmin = sc.nextBoolean();

        u2 = new Customer(email, pwd, isadmin);
        id = ShopEmag.login(u2);
        u2.setCustId((int) id);
        if (id != -1)
            break;
    }

    // ura sunt logat , deci pot baga mancare


                while(true){


        boolean isAdmin = dbaccess.isAdmin(u3);

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


//                                    dbaccess.insertFoodForUserID(food,id);
                        break;
                    case 2:

//                                    dbaccess.readFoodsOfAnUser();

                        break;
                    case 3:
                        //  dbaccess.deleteFood(food);
                        break;
                    case 4:
                        //    dbaccess.updateFood(food);
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
                System.out.println("1.INSERT  USER OR ADMIN");
                System.out.println("2.DISPLAY LIST OF USER");
                System.out.println("3.DELETE USER");
                System.out.println("4.UPDATE USER LIST");
                System.out.println("5.Exit");
                System.out.print("Enter Your Choice : ");
                ch2 = s.nextInt();

                switch (ch2) {
                    case 1:
                        //  dbaccess.createUser(user1,false);

                        break;
                    case 2:
                        //   dbaccess.read();
                        break;
                    case 3:
                        //  dbaccess.delete(user1);

                        break;
                    case 4:
                        //  dbaccess.update(user1);
                        break;
                }


            }
            while (ch2 != 5);
            System.out.println("YOU EXIT THE APP");
            break;
        }
    }
}
}
