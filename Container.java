package kz.aitu.aquarium;
import java.sql.SQLException;
import java.util.ArrayList;
public class Container {
    private ArrayList<AquariumMember> AquariumMembers;
    Creator cf = new FishCreator();
    Creator ca = new AcessoryCreator();
    Creator creator;
    public Container() {
        AquariumMembers = new ArrayList<AquariumMember>();
    }


    public String addMember(int id, String type) throws SQLException {
        for(AquariumMember aq: AquariumMembers){
            if(aq.getID() == id){
                aq.setCount(aq.getCount()+1);
                return "Added successfully";
            }
        }


            if(type == "fish"){
                creator = cf;
            } else {
                creator = ca;
            }
            AquariumMember aq = creator.createMember(id);
            AquariumMembers.add(aq);
            return "Added successfully";
    }

    public void deleteMember(int id) throws SQLException{
        for(AquariumMember aq: AquariumMembers){
            if(aq.getID() == id){
                aq.setCount(aq.getCount()-1);
                if (aq.getCount() == 0){
                    AquariumMembers.remove(aq);
                }
                break;
            }
        }
    }

    public void printContainer() {
        for (AquariumMember aq: AquariumMembers) {
            System.out.println(
                    aq.getType() + " "
                        + aq.getName() + " "
                            + aq.getPrice() + " "
                                + aq.getCount()
            );
        }
    }
}

