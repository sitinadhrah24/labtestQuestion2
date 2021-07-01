/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author NAD
 */
public class DBApi {

    //define kat atas jdi x perlu define byk kali
    static Connection con;
    static ResultSet rs;

    //return json object
    public static JSONArray getStaffByEmail(String email) {
        JSONArray ja = new JSONArray();
        int index = 0;
        int ada = 0;
        try {
            con = ConMan.getConnection();
            String sql = "select * from staff where email = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                ada = 1;
                JSONObject jo = new JSONObject();
                jo.put("firstname", rs.getString("firstname"));
                jo.put("lastname", rs.getString("lastname"));
                jo.put("extension", rs.getString("extension"));
                jo.put("jobtitle", rs.getString("jobtitle"));
                jo.put("id", rs.getString("id"));
                jo.put("email", rs.getString("email"));

                ja.add(index++, jo);

            }
            if (ada == 1) {//ada data account
                JSONObject jo = new JSONObject();
                jo.put("status", 1);
                ja.add(index++, jo);

            } else {//tdk data
                JSONObject jo = new JSONObject();
                jo.put("status", 0);
                ja.add(index++, jo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ja;
    }

    public static JSONObject getStaffById(String id) {
        JSONObject jo = new JSONObject();
        
        int ada = 0;
        try {
            con = ConMan.getConnection();
            String sql = "select * from account where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ada = 1;
                jo.put("firstname", rs.getString("firstname"));
                jo.put("lastname", rs.getString("lastname"));
                jo.put("extension", rs.getString("extension"));
                jo.put("jobtitle", rs.getString("jobtitle"));
                jo.put("id", rs.getString("id"));
                jo.put("email", rs.getString("email"));

            }
            if (ada == 1) {//ada data account

                jo.put("status", 1);

            } else {//tdk data

                jo.put("status", 0);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jo;
    }

}
