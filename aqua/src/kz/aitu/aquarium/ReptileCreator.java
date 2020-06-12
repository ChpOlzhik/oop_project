package kz.aitu.aquarium;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReptileCreator extends Creator {
    private MyDatabase db;

    @Override
    public AquariumMember createMember(int id , String name , int price , int count ){
        Reptile r =  new Reptile(id , name , price , count);
        r.setCount(count);
        return r;
    }

}
