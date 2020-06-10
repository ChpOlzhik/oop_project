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
    private static Container busket = new Container();
    private static Scanner sc = new Scanner(System.in);

    private static void showAssortment(String type) throws SQLException {
        Statement st = conn.createStatement();
        String sql = "SELECT  * FROM members WHERE type='fish'";
        if (type != "fish")
            sql = "SELECT  * FROM members WHERE type='accessory'";
        ResultSet rs = st.executeQuery(sql);
        System.out.println("id  type  name  price  count");
        while(rs.next()){
            System.out.println(
                    rs.getInt("id") + " "
                            + rs.getString("type") + " "
                            + rs.getString("name") + " "
                            + rs.getInt("price") + " "
                            + rs.getInt("count")
            );
        }
        st.close();
    }

    private static void addBusket(String type) throws SQLException {
        String title = type.substring(0, 1).toUpperCase() + type.substring(1);
        while(true){
            System.out.println("Press 1-toAddToBasket 2-toShow"+type+" anyone else to exit to main menu");
            int st = sc.nextInt();
            if(st == 1){
                System.out.println("Enter id of the fish to add to the basket");
                int id = sc.nextInt();
                System.out.println(busket.addMember(id,type));
                System.out.println("If you want to see fish press 2 else press 1 to " +
                        "add more anyone else to exit to main menu");
            } else if(st == 2){
                showAssortment(type);
            } else break;
        }
    }

    private static void CustomConsole() throws SQLException {
        System.out.println("You are welcome in our store");
        while(true){
            System.out.println("Press 1-toShowFish 2-toShowAccessories 3-toShowBusket 4-toExit");
            int st = sc.nextInt();
            if ( st == 1){
                showAssortment("fish");
                addBusket("fish");
            } else if( st == 2 ){
                showAssortment("accessory");
                addBusket("accessory");
            } else if(st == 3){
                busket.printContainer();
            } else if(st == 4){
                break;
            } else {
                System.out.println("We don't have such command");
            }
        }
    }

    public static void main(String[] args) throws SQLException {
            CustomConsole();
    }
}
