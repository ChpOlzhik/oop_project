package kz.aitu.aquarium;

import java.sql.*;

public class FishCreator extends Creator {
    private MyDatabase db;

    @Override
    public AquariumMember createMember(int id , String name , int price , int count ){
        Fish f =  new Fish(id , name , price , count);
        f.setCount(count);
        return f;
    }

}
