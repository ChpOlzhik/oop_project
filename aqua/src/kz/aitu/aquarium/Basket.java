package kz.aitu.aquarium;
import java.sql.SQLException;
import java.util.ArrayList;
public class Basket {
    private ArrayList<AquariumMember> AquariumMembers;
    private int totalsum = 0;
    private Creator cf = new FishCreator();
    private Creator ca = new AcessoryCreator();
    private Creator cr = new ReptileCreator();
    private Creator creator;
    public Basket() {
        AquariumMembers = new ArrayList<AquariumMember>();
    }

    private Creator getCreator(String type){
        if ( type.equals("fish") ) return cf;
        if (type.equals("reptile")) return cr;
        if (type.equals("accessory")) return ca;
        return null;
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

    public void addMember(AquariumMember a){
        for (AquariumMember aq: AquariumMembers) {
            if (aq.getID() == a.getID()){
                if(aq.getCount() < a.getCount()) {
                    aq.setCount(aq.getCount()+1);
                    return;
                } else return;
            }
        }
        creator = getCreator(a.getType());
        AquariumMembers.add(creator.createMember(a.getID() , a.getName() , a.getPrice() , 1));
    }

    public void removeMember(int id, int count){
        for (AquariumMember aq: AquariumMembers) {
            if (aq.getID() == id){
                if(aq.getCount() >= count) {
                    aq.setCount(aq.getCount()-count);
                    return;
                }
                if(aq.getCount() == 0) AquariumMembers.remove(aq);
            }
        }
    }

    public void printContainer() {
        System.out.println();
        System.out.println("Your basket:");
        if (AquariumMembers.isEmpty()) {
            System.out.println("Basket is empty.");
            return;
        }
        System.out.println("ID  Type  Name  Price  Amount  Cost");
        for (AquariumMember aq: AquariumMembers) {
            System.out.println(
                    aq.getID() + " "
                    +aq.getType() + " "
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

