/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NAD
 */
//conman = connection manager
public class ConMan {

    static Connection con;//static sbb xdok main method
    static String url;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                url = "jdbc:mysql://localhost:3306/classicmodels";
                con = DriverManager.getConnection(url, "root", "Sn@312444");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) { //nk check class ade ke dok
            e.printStackTrace();
        }
        return con;
    }

}
