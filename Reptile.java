package com.company;

public class Reptile extends AquariumMember {


    public Reptile( int id , String name , int price ) {
        super(price, name ,  id);


    }

    public int getID(){

        return this.id;
    }

    @Override
    public String toString() {
        return "Reptile{ " + super.toString() +
                " }";
    }
}
