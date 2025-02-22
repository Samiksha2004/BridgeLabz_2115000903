import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnection {
    private boolean connected;

    public void connect() {
        connected = true;
        System.out.println("Connecting to the database...");
    }

    public void disconnect() {
        connected = false;
        System.out.println("Disconnecting from the database...");
    }

    public boolean isConnected() {
        return connected;
    }
}

public class DatabaseConnectionSingleTest {
    private DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnectionIsEstablished() {
        assertTrue(db.isConnected(), "Database should be connected after setUp()");
    }

    @Test
    void testConnectionIsClosed() {
        db.disconnect();
        assertFalse(db.isConnected(), "Database should be disconnected after calling disconnect()");
    }
}
