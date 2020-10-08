package ru.makhmutov.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pass = "postgress";

        Connection connection = DriverManager.getConnection(url, user, pass);
        System.out.println("done: " + connection.isClosed());
    }

}
