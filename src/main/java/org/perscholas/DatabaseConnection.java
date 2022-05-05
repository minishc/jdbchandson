package org.perscholas;

import java.sql.*;

public class DatabaseConnection {
    private final String DB_URL = "jdbc:mariadb://localhost:3306/jdbchandson";
    private final String USER = "root";
    private final String PASSWORD = "C44Hb7yAseY3oa";
    private final Driver driver = new org.mariadb.jdbc.Driver();

    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public DatabaseConnection() {
    }

    public void connect() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * closes the connection and the various statements
     */
    public void dispose() {
        try {
            if(conn != null) {
                if(!conn.isClosed()) {
                    conn.close();
                }
            }
            if(ps != null) {
                if(!ps.isClosed()) {
                    ps.close();
                }
            }
            if(rs != null) {
                if(!rs.isClosed()) {
                    rs.close();
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
