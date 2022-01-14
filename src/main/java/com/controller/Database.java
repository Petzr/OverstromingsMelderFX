package com.controller;

import java.sql.*;

public class Database {

    // schema naam invullen (niet hoofdletter gevoelig
    static String schema = "";

    // root username
    static String user = "";
    // root password
    static String password = "";

    static Connection databaseConnection;
    static Statement statement;
    static {
        try {
            databaseConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/"+ schema, user, password
            );
            statement = databaseConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean getAdmin(String email, String wachtwoord) throws SQLException {

        // table naam invullen (niet hoofdletter gevoelig)
        String table = "login";

        ResultSet admin = statement.executeQuery("select * from "+ table);

        // mogelijk statments veranderen voor de correcte antributen
        while (admin.next()) {
            if (email.equals(admin.getString("emailadres"))) {
                if (wachtwoord.equals(admin.getString("wachtwoord"))) {
                    return true;
                }
            }
        }
        return false;


    }

    public static String getGemeente(String gemeenteNaam) throws SQLException {

        // table naam invullen (niet hoofdletter gevoelig)
        String table = "gemeente";

        ResultSet gemeente = statement.executeQuery("select * from "+ table);

        // mogelijk statements veranderen voor de correcte antributen
        while (gemeente.next()) {
            if (gemeenteNaam.equals(gemeente.getString("naam"))) {
                String waterniveau = gemeente.getString("waterniveau");
                return "Waterniveau: " + waterniveau;
            }
        }
        return "Geen overeenkomsten gevonden";

    }
}
