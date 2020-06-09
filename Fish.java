package com.company;

public class Fish extends AquariumMember {

    public Fish( int id , String name , int price ) {
        super(price, name , id);

    }


    public int getID(){ // get id
        return this.id;
    }

    @Override
    public String toString() {
        return "Fish{ " + super.toString() +
                " }";
    }
}
