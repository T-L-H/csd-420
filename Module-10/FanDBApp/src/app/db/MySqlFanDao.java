package app.db;

import java.sql.*;
import java.util.Optional;

public class MySqlFanDao implements FanDao {

    private final String url;
    private final String user;
    private final String pass;

    public MySqlFanDao(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    @Override
    public Optional<Fan> findById(int id) throws SQLException {
        String sql = "SELECT id, firstname, lastname, favoriteteam FROM fans WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return Optional.empty();

                Fan fan = new Fan(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("favoriteteam")
                );
                return Optional.of(fan);
            }
        }
    }

    @Override
    public boolean update(Fan fan) throws SQLException {
        String sql = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, fan.getFirstname());
            ps.setString(2, fan.getLastname());
            ps.setString(3, fan.getFavoriteteam());
            ps.setInt(4, fan.getId());

            return ps.executeUpdate() == 1;
        }
    }
}
