package com.company;

public  class AquariumMember {
    private String name;
    private int price;
    int id;


    protected AquariumMember(int price, String name ,  int id) {
        this.price = price;
        this.name = name;
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {

        this.price = price;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID(){
        return this.id;
    }


    @Override
    public String toString() {
        return "AquariumMember{ " + ", id=" + id + "price=" + name + ", name='" + price + '\'' + " }";
    }
}

