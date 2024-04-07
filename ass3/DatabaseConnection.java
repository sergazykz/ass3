package ass3;

import java.io.InputStream;
import java.util.Properties;

public class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private Properties connectionProps;

    private DatabaseConnection() {
        this.connectionProps = new Properties();
        try {

            InputStream is = DatabaseConnection.class.getResourceAsStream("db.json");
            if (is == null) {
                throw new RuntimeException("Cannot find 'db.json' in the package");
            }
            connectionProps.load(is);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public void executeSQL(String sql) {
        System.out.println("Executing SQL: " + sql);
    }

    public Properties getConnectionInfo() {
        return connectionProps;
    }
}
