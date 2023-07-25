/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class KoneksiMySql {

    public Connection conn;
    public KoneksiMySql(){}

    public Connection getConnection() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connURL = "jdbc:mysql://localhost:3306/indomaret?autoReconnect=true&useSSL=false"
                    + "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(connURL, user, password);
            return conn;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Tidak ada koneksi yang terbuka atau salah konfigurasi database.");
            return null;
        }
    }
    
    public void closeConnection() throws SQLException{
        try{
            if(conn != null){
                System.out.print("Tutup Koneksi\n");
            }
        }catch(Exception ex){
        }
    } 
}
