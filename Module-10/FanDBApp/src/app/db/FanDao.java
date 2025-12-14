package app.db;

import java.sql.SQLException;
import java.util.Optional;

public interface FanDao {
    Optional<Fan> findById(int id) throws SQLException;
    boolean update(Fan fan) throws SQLException;
}

