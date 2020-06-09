package com.company;

public class Accessory extends AquariumMember {


    public Accessory( int id , String name , int price ) {
        super(price, name ,  id);


    }


    public int getID(){ // get id
        return this.id;
    }

    @Override
    public String toString() {
        return "Accessory{ " + super.toString() +
                " }";
    }
}
