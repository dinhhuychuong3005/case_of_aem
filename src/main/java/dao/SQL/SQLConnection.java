package dao.SQL;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    private String jdbcURL = "jdbc:mysql://localhost:3306/caseStudyMD3?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    public java.sql.Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
