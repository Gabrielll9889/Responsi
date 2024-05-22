/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Buku {
    private String title;
    private String penulis;
    private double rating;
    private double harga;
    
    
    public Buku(String tite, String penulis, double rating, double harga){
        this.title = title;
        this.penulis = penulis;
        this.rating = rating;
        this.harga = harga;
    
    }
    public String getTitle(){
        return title;
    }
    
    public void setTitle(){
        this.title = title;
    }
    
    public String getPenulis(){
        return penulis;
    }
    
    public void setPenulis(){
        this.penulis = penulis;
    }
    
    public double getRating(){
        return rating;
    }
    
    public void setRating(double rating){
        this.rating = rating;
    }
    
    public double getHarga(){
        return (harga + 500 + (rating * 100));
    }
    
    @Override
    public String toString(){
    return "Buku{" + 
            "title=" + title + 
            ", penulis=" + penulis + 
            ", rating =" + rating + 
            ", harga=" + getHarga() + 
            '}';
            
        }
    
}
