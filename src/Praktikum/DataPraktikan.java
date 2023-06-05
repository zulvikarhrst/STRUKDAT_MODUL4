package Praktikum;

import java.util.HashMap;
import java.util.Scanner;

public class DataPraktikan {

    HashMap<String, String> dataTabel = new HashMap<>();
    HashMap<String, String> tabelSesiLogin = new HashMap<>();
    Scanner input = new Scanner(System.in);

    public boolean tambahData(String nimPraktikan, String namaAsisten) {

        if (!dataTabel.containsKey(nimPraktikan)) {
            if (nimPraktikan.contains("IF")) {
                dataTabel.put(nimPraktikan, namaAsisten);
            } else {
                System.out.println(" ===============================");
                System.out.println(" =====================");
                System.out.println(" | Format NIM Salah! | ");
                System.out.println(" =====================\n");
            }
        } else {
            System.out.println(" ===============================");
            System.out.println(" ==================");
            System.out.println(" | Data Sudah Ada | ");
            System.out.println(" ==================\n");
        }
        return !dataTabel.containsKey(nimPraktikan);
    }

    public void tampil() {
        System.out.println(" ===============================\n");
        System.out.println(" ===============================");
        System.out.println(" | Total Data Yang Tersimpan : " + dataTabel.size());
        String[] nim = dataTabel.keySet().toArray(new String[0]);
        String[] asisten = dataTabel.values().toArray(new String[0]);

        for (int i = 0; i < dataTabel.size(); i++) {
            System.out.println(" =================================================");
            System.out.println(" | NIM : " + nim[i] + "\t\t" + "Nama Asisten : " + asisten[i]);
            System.out.println(" =================================================");
        }
    }

    public void listNimPraktikan() {
        System.out.println(" ===============================");
        System.out.println(dataTabel.keySet());
    }

    public void listNamaAsisten() {
        System.out.println(" ===============================");
        System.out.println(dataTabel.values());
    }

    public int totalEmail() {
        return dataTabel.size();
    }

    public boolean hapusData(String nimPraktikan, String namaAsisten) {
        if (dataTabel.containsKey(nimPraktikan)) {
            dataTabel.remove(nimPraktikan, namaAsisten);
        } else {
            System.out.println(" =========================");
            System.out.println(" | Data Tidak Ditemukan! | ");
            System.out.println(" =========================\n");
        }
        return true;
    }

    public boolean editData(String nimPraktikan, String namaAsisten) {
        for (String nim : dataTabel.keySet()) {
            if (nim.equals(nimPraktikan)) {
                
                System.out.println(" ===============================\n");
                System.out.println(" =======================================");
                System.out.println(" | Data Lama Yang Diedit NIM : " + nimPraktikan) ;
                System.out.println(" | Nama Asisten : " + namaAsisten);
                System.out.println(" =======================================\n");
                System.out.println(" ========================================");
                System.out.print(" | Masukkan Nama Asisten Yang Baru : ");
                String namaBaru = input.next();
                dataTabel.replace(nimPraktikan, namaBaru);
            } else {
                System.out.println(" =========================");
                System.out.println(" | Data Tidak Ditemukan! | ");
                System.out.println(" =========================\n");
            }
            return true;
        }
        return false;
    }

    public void search(String namaAsisten) {
        int i = 1;
        System.out.println(" | List NIM Dengan Asisten " + namaAsisten + " : ");
        for (String key : dataTabel.keySet()) {
            if (dataTabel.get(key).equals(namaAsisten)) {
                System.out.println(i + ". " + key);
                i++;
            }
        }
        System.out.println();
    }

    public void login() {

        tabelSesiLogin.put("admin@umm.ac.id", "admin");
        System.out.println(" =========");
        System.out.println(" | LOGIN | ");
        System.out.println(" =========");
        System.out.println(" ============================================");
        System.out.print(" | Silahkan Masukkan Email : ");
        String email = input.next();
        if (tabelSesiLogin.containsKey(email)) {
            if (email.contains("@umm.ac.id")) {
                System.out.println(" ============================================");
                System.out.print(" | Masukkan Password : ");
                String password = input.next();
                if (tabelSesiLogin.containsValue(password)) {
                    System.out.println(" ============================================\n");
                    System.out.println(" ================");
                    System.out.println(" | Login Sukses | ");
                    System.out.println(" ================\n");
                    while (true) {
                        System.out.println(" ===================================");
                        System.out.println(" |              MENU               | ");
                        System.out.println(" ===================================");
                        System.out.println(" | 1. Tambah Data                  | ");
                        System.out.println(" ===================================");
                        System.out.println(" | 2. Tampilkan Data               | ");
                        System.out.println(" ===================================");
                        System.out.println(" | 3. Tampilkan List NIM Praktikan | ");
                        System.out.println(" ===================================");
                        System.out.println(" | 4. Tampilkan List Nama Asisten  |");
                        System.out.println(" ===================================");
                        System.out.println(" | 5. Total Jumlah Data            |");
                        System.out.println(" ===================================");
                        System.out.println(" | 6. Hapus Data                   |");
                        System.out.println(" ===================================");
                        System.out.println(" | 7. Edit Data                    | ");
                        System.out.println(" ===================================");
                        System.out.println(" | 8. Cari Data                    |");
                        System.out.println(" ===================================");
                        System.out.println(" | 9. Logout                       |");
                        System.out.println(" ===================================\n");
                        
                        System.out.println(" ===============================");
                        System.out.print(" | Silahkan Masukkan Pilihan : ");
                        int pilih = input.nextInt();
                        switch (pilih) {
                            case 1:
                                System.out.println(" ===============================\n");
                                System.out.println(" ===============================");
                                System.out.println(" |       TAMBAH DATA BARU      |");
                                System.out.println(" ===============================");
                                System.out.print(" | Masukkan NIM : ");
                                String nim = input.next();
                                System.out.print(" | Masukkan Nama Asisten : ");
                                String namaA = input.next();
                                tambahData(nim, namaA);
                                System.out.println(" ===============================\n");
                                break;
                            case 2:
                                tampil();
                            case 3:
                                listNimPraktikan();
                            case 4:
                                listNamaAsisten();
                            case 5:
                                System.out.println(" ===============================");
                                System.out.println(totalEmail());
                                break;
                            case 6:
                                System.out.println(" ===============================\n");
                                System.out.println(" ===============================");
                                System.out.println(" |          HAPUS DATA         | ");
                                System.out.println(" ===============================");;
                                System.out.print(" | Masukkan NIM : ");
                                String nimHapus = input.next();
                                System.out.print(" | Masukkan Nama Asisten : ");
                                String namaHapus = input.next();
                                hapusData(nimHapus, namaHapus);
                                System.out.println(" ===============================\n");
                                break;
                            case 7:
                                System.out.println(" ===============================");
                                System.out.println(" |           EDIT DATA         | ");
                                System.out.println(" ===============================");
                                System.out.print(" | Masukkan NIM : ");
                                String nimEdit = input.next();
                                System.out.print(" | Nama Asisten Lama : ");
                                String namaEdit = input.next();
                                editData(nimEdit, namaEdit);
                                System.out.println(" ========================================\n");
                                break;
                            case 8:
                                System.out.println(" ===============================");
                                System.out.println(" |      SEARCH DATA ASISTEN    | ");
                                System.out.println(" ===============================");
                                System.out.print(" | Masukkan Nama Asisten : ");
                                String namaAsisten = input.next();
                                System.out.println(" ===============================");
                                search(namaAsisten);
                                break;
                            case 9:
                                logout();
                        }
                    }

                } else {
                    System.out.println(" ===============");
                    System.out.println(" | Gagal Login | ");
                    System.out.println(" ===============\n");
                    login();
                }
            }
            
        } else {
            System.out.println(" =============================");
            System.out.println(" | Gagal Login, Email Salah! | ");
            System.out.println(" =============================\n");
            login();
        }
    }

    public void logout() {
        System.out.println(" ===============================\n");
        System.out.println(" ==========");
        System.out.println(" | LOGOUT | ");
        System.out.println(" ==========");
        System.exit(0);
    }

    public static void main(String[] args) {
        DataPraktikan dp = new DataPraktikan();
        dp.login();
    }
}