/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simapel;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Koneksi {
    public static Connection koneksi() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/simapel", "root", "");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal! " + e.getMessage());
            return null;
        }
    }
}