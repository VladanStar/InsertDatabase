package com.company;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Baza {

    private static java.sql.Connection con = null;
    private static String url = "jdbc:mysql://localhost/korisnici";
    private static String username = "root";
    private static String password = "";

    public static List<User> getAllUsers() {
        ArrayList<User> listaUsera = new ArrayList<User>();
        try {
            con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM users";
            Statement st = (Statement) con.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String adresa = rs.getString("adresa");
                String telefon = rs.getString("telefon");
                int godine = rs.getInt("godina");
                listaUsera.add(new User(ime, prezime, adresa, telefon, godine));
            }
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaUsera;
    }
}