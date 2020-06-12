package kz.aitu.aquarium;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Application {

    private static MyDatabase db = new MyDatabase("oop" , "root" , "123456");
    private static   Connection conn = MyDatabase.getConn();
    private static Basket basket = new Basket();
    private static Shop shop = new Shop();
    private static Scanner sc = new Scanner(System.in);

    private static void add1(String type) {
        String title = type.substring(0, 1).toUpperCase() + type.substring(1);
        System.out.println("Enter id of the "+title+" to add to the basket");
        int id = sc.nextInt();
        basket.addMember(shop.getMember(id));
    }

    private static void addBasket(String type){
        String title = type.substring(0, 1).toUpperCase() + type.substring(1);
        while(true){
            System.out.println("1-toAddToBasket\n2-toShow"+title+"\nAnything-Back");
            int st = sc.nextInt();
            if(st == 1){
                add1(type);
            } else if(st == 2){
                shop.show(type);
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
                basket.removeMember(id, cnt);
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
                shop.show("fish");
                addBasket("fish");
            } else if( st == 2 ){
                shop.show("accessory");
                addBasket("accessory");
            } else if(st == 3){
                shop.show("reptile");
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
            shop.fillShop();
            CustomConsole();

    }
}
