package oop.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {



    private static DbConnection dataConnection;

    private Connection connection;

    private DbConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentForm", "root", "Ijse@1234");
    }

    public static DbConnection getInstance() throws SQLException {
      /*return  (null==dataConnection) ? dataConnection = new DbConnection() : dataConnection;*/


        if (dataConnection == null) {
            dataConnection = new DbConnection();
        }
        return dataConnection;
    }

    public Connection getConnection() {

        return connection;

    }




}
