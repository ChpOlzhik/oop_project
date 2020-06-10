package kz.aitu.aquarium;

import java.sql.*;

public class FishCreator extends Creator {
    private MyDatabase db;
    @Override
    public AquariumMember createMember(int id) throws SQLException {
        if (MyDatabase.getConn() == null)
            db = new MyDatabase("oop" ,"root" ,"123456");
        Connection conn = MyDatabase.getConn();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM members WHERE type = 'fish' AND id = " + String.valueOf(id));
        rs.next();
        return new Fish(rs.getInt("id") , rs.getString("name") , rs.getInt("price"));
    }

}
