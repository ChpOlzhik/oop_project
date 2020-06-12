package kz.aitu.aquarium;

public class Reptile implements AquariumMember {

    private String name;
    private int price;
    private int id;
    private int count;
    private int maxnum;
    public Reptile( int id , String name , int price , int maxnum ) {
        this.price = price;
        this.name = name;
        this.id = id;
        this.count = 1;
        this.maxnum = maxnum;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return this.id;
    }
    @Override
    public int getCount() {
        return this.count;
    }
    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String getType() {
        return "reptile";
    }
    @Override
    public int getMaxnum() {
        return maxnum;
    }
    @Override
    public void setMaxnum(int maxnum) {
        this.maxnum = maxnum;
    }
}