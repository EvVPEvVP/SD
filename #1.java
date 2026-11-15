import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseStorage implements Storage {
    private final Connection connection;

    public DatabaseStorage(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(String data) {
        String sql = "INSERT INTO storage_entries (data) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, data);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка сохранения", e);
        }
    }

    @Override
    public String retrieve(int id) {
        String sql = "SELECT data FROM storage_entries WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet result = statement.executeQuery()) {
                return result.next() ? result.getString("data") : null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка чтения", e);
        }
    }
}
