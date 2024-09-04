package Koneksi;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conek {
    private static Connection koneksi;

    public static Connection GetConnection() throws SQLException {
        if (koneksi == null || koneksi.isClosed()) {
            try {
                new Driver();
                koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kosmetikk", "root", "");
                System.out.println("Connection to MySQL database is successful");
            } catch (SQLException e) {
                System.err.println("Error establishing connection: " + e.getMessage());
                throw e; // Rethrow the exception after logging it
            }
        }
        return koneksi;
    }

    public static void closeConnection() {
        if (koneksi != null) {
            try {
                koneksi.close();
                System.out.println("Connection closed successfully");
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        try {
            Connection conn = Conek.GetConnection();
            // Perform database operations
            Conek.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}