package ass3;


import java.util.Properties;

class TestDatabaseConnection {
    public static void main(String[] args) {
        DatabaseConnection dbConn1 = DatabaseConnection.getInstance();
        DatabaseConnection dbConn2 = DatabaseConnection.getInstance();

        if (dbConn1 == dbConn2) {
            System.out.println("Singleton instance verified.");
        } else {
            System.out.println("Singleton instance failed.");
        }

        Properties props = dbConn1.getConnectionInfo();
        System.out.println("Database Connection Info:");
        props.forEach((key, value) -> System.out.println(key + ": " + value));


        dbConn1.executeSQL("SELECT * FROM users");
    }
}
