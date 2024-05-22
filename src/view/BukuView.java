package view;

import controller.BukuController;
import model.Buku;

import java.util.Scanner;


public class BukuView {
    private BukuController buku;
    private Scanner scanner;
    private final BukuController controller;
    
    public BukuView(BukuController controller){
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    
    }
    
    public void showMenu(){
    while(true){
        System.out.println("Menu");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Lihat Buku");
        System.out.println("3. Update Buku");
        System.out.println("4. Hapus Buku");
        System.out.println("5. Keluar");
        System.out.println("Masukkan Pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();
        
        switch (pilihan){
            case 1:
                addBuku();
                break;
            case 2:
                viewAllBuku();
                break;
            case 3:
                updateBuku();
                break;
            case 4:
                deleteBuku();
                break;
            case 5:
                return;
            default:
                System.out.println("Pilihan tidak valid. Pilih lagi");
                    
        
        }
    
    }
    
    
    }
    
    private void addBuku(){
        System.out.println("Masukkan Judul Buku: ");
        String title = scanner.nextLine();
        System.out.println("Masukkan Penulis: ");
        String penulis = scanner.nextLine();
        System.out.println("Masukkan Rating (0-5): ");
        double rating = scanner.nextDouble();
        System.out.println("Masukkan Harga Buku: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        controller.addBuku(title, penulis, rating, harga);
        System.out.println("Buku berhasil ditambahkan");
    
    }
    
    private void viewAllBuku(){
        for(Buku buku : controller.getAllBuku()){
        System.out.println(buku);
        }
    }
    
    private void updateBuku(){
        System.out.println("Masukkan judul buku yang mau diubah: ");
        String title = scanner.nextLine();
        System.out.println("Masukkan Penulis Baru: ");
        String penulis = scanner.nextLine();
        System.out.println("Masukkan Rating Baru (0-5): ");
        double rating = scanner.nextDouble();
        System.out.println("Masukkan Harga Buku Baru: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        if(controller.updateBuku(title, penulis, rating, harga)){
            System.out.println("Buku berhasil diubah");
        } else {
            System.out.println("Buku tidak ditemukan");
            }
    }
    
    private void deleteBuku(){
        System.out.println("Masukkan Judul Buku Yang Akan Dihapus");
        String title = scanner.nextLine();
        if(controller.deleteBuku(title)){
            System.out.println("Buku berhasil dihapus");
        } else {
            System.out.println("Buku tidak ditemukan");
        }
    }
}
