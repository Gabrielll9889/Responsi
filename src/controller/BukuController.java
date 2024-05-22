package controller;

import databaseconn.DatabaseConnection;
import model.Buku;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BukuController {
    public void addBuku(String title, String penulis, double rating, double harga){
        try (Connection conn = DatabaseConnection.getConnection()){
            String sql = "INSERT INTO perpus (title, penulis, rating, harga) VALUES(?,?,?,?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, title);
                stmt.setString(2, penulis);
                stmt.setDouble(3, rating);
                stmt.setDouble(4, harga);
                stmt.executeUpdate();
            }
        } catch(SQLException e){
            e.printStackTrace();
            }
        
    }
    
    public List<Buku>getAllBuku(){
    List<Buku> bukus = new ArrayList<>();
    try(Connection conn = DatabaseConnection.getConnection()){
        String sql = "SELECT * FROM perpus";
        try(Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                String title = rs.getString("title");
                String penulis = rs.getString("penulis");
                double rating = rs.getDouble("rating");
                double harga = rs.getDouble("harga");
                Buku buku = new Buku(title, penulis, rating, harga);
                bukus.add(buku);
            }
        }
    } catch (SQLException e){
            e.printStackTrace();
        }
    return bukus;
    }
            
    public Buku getBuku(String title){
        Buku buku = null;
        try(Connection conn = DatabaseConnection.getConnection()){
            String sql = "SELECT * FROM perpus WHERE title = ?";
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, title);
                try(ResultSet rs = stmt.executeQuery()){
                    if(rs.next()){
                        String penulis = rs.getString("penulis");
                        double rating = rs.getDouble("rating");
                        double harga = rs.getDouble("harga");
                        buku = new Buku(title, penulis, rating, harga);
                
                    }
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
            }
        return buku;
    
    }
    
    public boolean updateBuku(String title,String penulis, double rating, double harga){
        try(Connection conn = DatabaseConnection.getConnection()){
            String sql = "UPDATE perpus SET penulis = ?, rating = ?, harga = ? WHERE title = ?";
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, title);
                stmt.setString(2, penulis);
                stmt.setDouble(3, rating);
                stmt.setDouble(4, harga);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e){
            e.printStackTrace();
            }
        return false;
    }
    
    
    public boolean deleteBuku(String title){
        try(Connection conn = DatabaseConnection.getConnection()){
            String sql = "DELETE FROM perpus WHERE title = ?";
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, title);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            
            }
        
        } catch (SQLException e){
            e.printStackTrace();
            }
        return false;
    }
    
}
