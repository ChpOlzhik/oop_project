package kz.aitu.aquarium;

import java.net.ContentHandler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Application {

    private static MyDatabase db = new MyDatabase("oop" , "root" , "123456");
    private static   Connection conn = MyDatabase.getConn();
    private static Container basket = new Container();
    private static Scanner sc = new Scanner(System.in);

    private static void showAssortment(String type) throws SQLException {
        System.out.println();
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM members";
        if(type == "fish" ) sql = "SELECT  * FROM members WHERE type='fish'";
        if(type == "accessory" ) sql = "SELECT  * FROM members WHERE type='accessory'";
        if(type == "reptile") sql = "SELECT  * FROM members WHERE type='reptile'";
        ResultSet rs = st.executeQuery(sql);
        System.out.println("id  name  price  count");
        while(rs.next()){
            System.out.println(
                    rs.getInt("id") + " "
                            + rs.getString("name") + " "
                            + rs.getInt("price") + " "
                            + rs.getInt("count")
            );
        }
        st.close();
        System.out.println();
    }

    private static void add1(String type) throws SQLException {
        String title = type.substring(0, 1).toUpperCase() + type.substring(1);
        System.out.println("Enter id of the "+title+" to add to the basket");
        int id = sc.nextInt();
        System.out.println(basket.addMember(id,type));
    }

    private static void addBasket(String type) throws SQLException {
        String title = type.substring(0, 1).toUpperCase() + type.substring(1);
        while(true){
            System.out.println("1-toAddToBasket\n2-toShow"+title+"\nAnything-Back");
            int st = sc.nextInt();
            if(st == 1){
                add1(type);
            } else if(st == 2){
                showAssortment(type);
            } else break;
        }
    }

    private static void BasketComand() throws SQLException {
        basket.printContainer();
        while(true){
            System.out.println("1-ShowBasket\n2-DeleteItem\nAnything-Exit");
            int cm = sc.nextInt();
            if (cm == 1){
                basket.printContainer();
            } else if(cm == 2){
                System.out.println("Enter id to delete item");
                int id = sc.nextInt();
                System.out.println("Enter amount of item");
                int cnt = sc.nextInt();
                System.out.println(basket.deleteMember(id,cnt));
            } else {
                break;
            }
        }
    }

    private static void CustomConsole() throws SQLException {
        System.out.println("You are welcome in our store");
        while(true){
            System.out.println("1-Fish\n2-Accessories\n3-Reptiles\n4-Basket\n5-Exit");
            int st = sc.nextInt();
            if ( st == 1){
                showAssortment("fish");
                addBasket("fish");
            } else if( st == 2 ){
                showAssortment("accessory");
                addBasket("accessory");
            } else if(st == 3){
                showAssortment("reptile");
                addBasket("reptile");
            } else if(st == 4){
                BasketComand();
            }else if(st == 5) {
                break;
            }else {
                System.out.println("We don't have such command");
            }
        }
    }

    public static void main(String[] args) throws SQLException {
            CustomConsole();
    }
}
