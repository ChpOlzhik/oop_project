package kz.aitu.aquarium;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Shop {
    private ArrayList<AquariumMember> AquariumMembers;
    private static Creator cf = new FishCreator();
    private static Creator ca = new AcessoryCreator();
    private static Creator cr = new ReptileCreator();
    private static Creator creator;

    public Shop() {
        AquariumMembers = new ArrayList<AquariumMember>();
    }

    private Creator getCreator(String type){
        if (type.equals("fish")) return cf;
        if (type.equals("reptile")) return cr;
        if (type.equals("accessory")) return ca;
        return null;
    }

    public void fillShop(){
        try{
            if (MyDatabase.getConn() == null){
                MyDatabase db = new MyDatabase("oop" , "root" , "123456");
            }
            Connection cn = MyDatabase.getConn();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT  * FROM members");
            while(rs.next()){
                creator = getCreator(rs.getString("type"));
                AquariumMember aq = creator.createMember(
                        rs.getInt("id") ,
                        rs.getString("name") ,
                        rs.getInt("price"),
                        rs.getInt("count"));
                AquariumMembers.add(aq);
            }
            st.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }



    public void show(String type) {
        System.out.println();

        System.out.println("ID  Type  Name  Price  Amount");
        for (AquariumMember aq: AquariumMembers) {
            if (aq.getType() == type){
                System.out.println(
                        aq.getID() + " "
                                +aq.getType() + " "
                                + aq.getName() + " "
                                + aq.getPrice() + " "
                                + aq.getCount());
            }
        }
        System.out.println();
    }

    public AquariumMember getMember(int id){
        for (AquariumMember aq: AquariumMembers) {
            if(aq.getID() == id) return aq;
        }
        return null;
    }

    public void showAll(){
        for (AquariumMember a: AquariumMembers
             ) {
            System.out.println(a.getType() + " " + a.getName());
        }
    }


}

