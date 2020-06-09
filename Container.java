package com.company;
import java.util.ArrayList;
public class Container {
    private ArrayList<AquariumMember> AquariumMembers;

    public Container()
    {
        AMember = new ArrayList<AquariumMember>();
    }
    public void addMember(final int Id, final float Price)
    {
        AMember.add( new AquariumMember (Id, Price));
    }
    public void printContainer()
    {
       // for(int i = 0; i < AquariumMembers.size(); i++)
       // { AquariumMember.get(i).print(); }
        for(AquariumMember p : AquariumMembers)
        {
            p.print();
        }
    }
}

