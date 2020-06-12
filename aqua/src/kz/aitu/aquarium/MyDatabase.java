package kz.aitu.aquarium;

import java.sql.*;

public class MyDatabase {
    private static Connection conn = null;
    
    public MyDatabase(String db, String user , String pass) {
        Connection cn = null;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+db , user , pass);
           conn = cn;
       } catch (Exception e){
           System.out.println("Can not connect to database");
       } finally {
           conn = cn;
       }
    }

    public static Connection getConn(){
        return conn;
    }

}
