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

        if(rs.next() == false) {
            st.close();
            return null;
        }
        int idw = rs.getInt("id");
        String name = rs.getString("name");
        int price = rs.getInt("price");
        int count = rs.getInt("count");
        st.close();
        return new Fish(idw , name , price , count);
    }

}
