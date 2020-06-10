package kz.aitu.aquarium;

import java.sql.SQLException;

public abstract class Creator {
    public abstract AquariumMember  createMember(int id) throws SQLException;
}
