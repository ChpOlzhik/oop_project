package kz.aitu.aquarium;
import java.sql.SQLException;
import java.util.ArrayList;
public class Container {
    private ArrayList<AquariumMember> AquariumMembers;
    private int totalsum = 0;
    private Creator cf = new FishCreator();
    private Creator ca = new AcessoryCreator();
    private Creator cr = new ReptileCreator();
    private Creator creator;
    public Container() {
        AquariumMembers = new ArrayList<AquariumMember>();
    }

    private void setTotalsum(){
        int ts = 0;
        for (AquariumMember aq: AquariumMembers) {
            ts += aq.getCount()*aq.getPrice();
        }
        this.totalsum = ts;
    }
    public int getTotalsum() {
        setTotalsum();
        return totalsum;
    }

    public String addMember(int id, String type) throws SQLException {
        for(AquariumMember aq: AquariumMembers){
            if(aq.getID() == id && aq.getType() == type){
                if( aq.getMaxnum() == aq.getCount()) return "We don't have more";
                aq.setCount(aq.getCount()+1);
                return "Added successfully";
            }
        }

            if(type == "fish"){
                creator = cf;
            } else if(type == "accessory"){
                creator = ca;
            } else if(type == "reptile"){
                creator = cr;
            } else return "We don't have such type.";

            AquariumMember aq = creator.createMember(id);
            if(aq == null) return "We don't have such member";
            AquariumMembers.add(aq);
            return "Added successfully";
    }

    public String deleteMember(int id , int cnt) throws SQLException{
        if(cnt < 0) return "Amount of item can not be less than 0";
        for(AquariumMember aq: AquariumMembers){
            if(aq.getID() == id){
                if(aq.getCount() == cnt){
                    AquariumMembers.remove(aq);
                    return "Item deleted successfully";
                } else if(aq.getCount() < cnt){
                    return "It is too much";
                } else{
                    aq.setCount(aq.getCount()-cnt);
                    return "Item deleted successfully";
                }
            }
        }
        return "In the basket not exists such item";
    }



    public void printContainer() {
        System.out.println();
        System.out.println("Your basket:");
        if (AquariumMembers.isEmpty()) {
            System.out.println("Basket is empty.");
            return;
        }
        System.out.println("Type  Name  Price  Amount  Cost");
        for (AquariumMember aq: AquariumMembers) {
            System.out.println(
                    aq.getType() + " "
                        + aq.getName() + " "
                            + aq.getPrice() + " "
                                + aq.getCount() + " "
                                    + aq.getCount()*aq.getPrice());
        }
        setTotalsum();
        System.out.println("Total :" + String.valueOf(getTotalsum()));
        System.out.println();
    }
}

