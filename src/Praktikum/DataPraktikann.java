package Praktikum;

import java.util.HashMap;
import java.util.Scanner;

public class DataPraktikann {
    HashMap<String, String> dataTabel = new HashMap<>();
    HashMap<String, String> tabelSesiLogin = new HashMap<>();
    Scanner input = new Scanner(System.in);
    
    boolean tambahData(String nimPraktikan, String namaAsisten){
        if(!dataTabel.containsKey(nimPraktikan)){
            if(nimPraktikan.contains("IF")){
                dataTabel.put(nimPraktikan, namaAsisten);
            }else{
                System.out.println("--- Format NIM Salah ---");
            }
        }else{
            System.out.println("--- Data Sudah Ada ----");  
        }
        return !dataTabel.containsKey(nimPraktikan);
    }
    
    public void tampil(){
        System.out.println("Total Data yang Tersimpan: " +dataTabel.size());
        String[] nim = dataTabel.keySet().toArray(new String[0]);
        String[] asisten = dataTabel.values().toArray(new String[0]);
        
        for(int i=0; i<dataTabel.size(); i++){
            System.out.println("NIM: " + nim[i] + "   |   " + "Nama Asisten: " + asisten[i]);
        }
    }
    
    public void listNimPraktikan(){
        System.out.println(dataTabel.keySet());
    }
    
    public void listNamaAsisten(){
        System.out.println(dataTabel.values());
    }
    
    public int totalEmail() {
        return dataTabel.size();
    }
    
    public boolean hapusData(String nimPraktikan, String namaAsisten){
        if(dataTabel.containsKey(nimPraktikan)){
            dataTabel.remove(nimPraktikan, namaAsisten);
        }else{
            System.out.println("--- Data Tidak Ditemukan ---");
        }
        return true;
    }
    
    public boolean editData (String nimPraktikan, String namaAsisten){
        for(String nim: dataTabel.keySet()){
            if(nim.equals(nimPraktikan)){
                System.out.println("Data lama yang diedit NIM: " +nimPraktikan);
                System.out.println("Nama Asisten: " +namaAsisten);
                System.out.print("Masukkan Nama Asisten yang Baru: ");
                String namaBaru = input.next();
                dataTabel.replace(nimPraktikan, namaBaru);
            }else{
                System.out.println("--- Data Tidak Ditemukan ---");
            }
            return true;
        }
        return false;
    }
    
    public void login(){
        tabelSesiLogin.put("Mahasiswa@umm.ac.id", "Mahasiswa");
        System.out.println("--- Login ----");
        System.out.print("Silahkan Masukkan Email: ");
        String Email = input.next();
        if(tabelSesiLogin.containsKey(Email)){
            if(Email.contains("@umm.ac.id")){
                System.out.print("Masukkan Password: ");
                String password = input.next();
                if(tabelSesiLogin.containsValue(password)){
                    System.out.println("~ Login Berhasil ~");
                    while(true){
                        System.out.println("--------------------------------------------");
                        System.out.println("Pilih Menu:");
                        System.out.println("1. Tambah Data");
                        System.out.println("2. Tampilan Seluruh Data");
                        System.out.println("3. List NIM Praktikan");
                        System.out.println("4. List Nama Asisten");
                        System.out.println("5. Total Data");
                        System.out.println("6. Hapus Data");
                        System.out.println("7. Edit Data");
                        System.out.println("8. Keluar");
                        System.out.print("Pilihan: ");
                        int pilih = input.nextInt();
                        System.out.println("--------------------------------------------");
                        switch (pilih){
                            case 1:
                                System.out.println("~ Tambah Data Baru ~");
                                System.out.print("Masukkan NIM: ");
                                String nimT = input.next();
                                System.out.print("Masukkan Nama Asisten: ");
                                String namaT = input.next();
                                tambahData(nimT, namaT);
                                break;
                            case 2:
                                tampil();
                                break;
                            case 3:
                                listNimPraktikan();
                                break;
                            case 4:
                                listNamaAsisten();
                                break;
                            case 5:
                                System.out.println(totalEmail());
                                break;
                            case 6:
                                System.out.println("~ Hapus Data ~");
                                System.out.print("Masukkan NIM: ");
                                String nimH = input.next();
                                System.out.print("Masukkan Nama Asisten: ");
                                String namaH = input.next();
                                hapusData(nimH, namaH);
                                break;
                            case 7:
                                System.out.println("~ Edit Data ~");
                                System.out.print("Masukkan NIM: ");
                                String nimE = input.next();
                                System.out.print("Masukkan Nama Asisten: ");
                                String namaE = input.next();
                                editData(nimE, namaE);
                                break;
                            case 8:
                                logout();
                        }
                    }
                }else{
                    System.out.println("~ Login Gagal ~");
                }
            }else{
                System.out.println("~ Email Anda Salah ~");
            }
        }
    }
    
    public void logout(){
        System.out.println("--- Keluar ---");
        System.exit(0);
    }
    
    public static void main(String[] args){
        DataPraktikann dp = new DataPraktikann();
        dp.login();
    }
}