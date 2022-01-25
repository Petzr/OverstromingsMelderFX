package com.controller;

import java.sql.*;

public class Database {

    // schema naam invullen (niet hoofdletter gevoelig
    static String schema = "overstromingmelder";

    // root username
    static String user = "root";
    // root password
    static String password = "root";

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

    public static void insertIntoDatabase(String query) throws Exception{

            PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
            preparedStatement.executeUpdate();

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

        // de SQL query dit moet worden uitgevoerd:
        ResultSet gemeente = statement.executeQuery(
                "select naam, waterniveau\n" +
                "from gemeente join microbit \n" +
                "on gemeente.microbit = microbit.idmicrobit");

        // mogelijk statements veranderen voor de correcte antributen/ column
        while (gemeente.next()) {
            if (gemeenteNaam.equals(gemeente.getString("naam"))) {
                String waterniveau = gemeente.getString("waterniveau");
                return "Waterniveau: " + waterniveau;
            }
        }
        return "Geen overeenkomsten gevonden";

    }
}
