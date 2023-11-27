/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg22166010.pbo.lat51;
import java.util.Scanner;
/**
 * Nama : Mufida Anggradita
 * NIM : 22166010
 * Kelas : Sistem Informasi
 * Semester 3
 * Mata Kuliah : Pemrogaman Berorientasi Objek 1
 * LATIHAN 51
 */

class Karyawan {
    private String NIK;
    private String Nama;
    private String Jabatan;
    private int Golongan;

    public String getNik() {
        return NIK;
    }

    public void setNik(String nik) {
        this.NIK = nik;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        this.Nama = nama;
    }

    public String getJabatan() {
        return Jabatan;
    }

    public void setJabatan(String jabatan) {
        this.Jabatan = jabatan;
    }

    public int getGolongan() {
        return Golongan;
    }

    public void setGolongan(int golongan) {
        this.Golongan = golongan;
    }
}

class Manager extends Karyawan {
    private int kehadiran;
    private float tunjanganGolongan;
    private float tunjanganJabatan;
    private float tunjanganKehadiran;

    public int getKehadiran() {
        return kehadiran;
    }

    public void setKehadiran(int kehadiran) {
        this.kehadiran = kehadiran;
    }

    public float tunjanganKehadiran(int hadir) {
        return hadir * 10000;
    }

    public float tunjanganJabatan(String jabatan) {
        if (jabatan.equalsIgnoreCase("Manager")) {
            return 2000000;
        } else if (jabatan.equalsIgnoreCase("Kabag")) {
            return 1000000;
        } else {
            return 0;
        }
    }

    public float tunjanganGolongan(int golongan) {
        switch (golongan) {
            case 1:
                return 500000;
            case 2:
                return 1000000;
            case 3:
                return 1500000;
            default:
                return 0;
        }
    }

    public float gajiTotal() {
        tunjanganKehadiran = tunjanganKehadiran(kehadiran);
        tunjanganJabatan = tunjanganJabatan(getJabatan());
        tunjanganGolongan = tunjanganGolongan(getGolongan());

        return tunjanganJabatan + tunjanganGolongan + tunjanganKehadiran;
    }
}
public class LAT51_Gaji {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);


        System.out.println("===== Program Perhitungan Gaji Karyawan =====");
        System.out.println();
        
        System.out.print("Masukkan NIK: ");
        String nik = scanner.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Golongan (1/2/3): ");
        int golongan = scanner.nextInt();

        System.out.print("Masukkan Jabatan (Manager/Kabag): ");
        scanner.nextLine();
        String jabatan = scanner.nextLine();
        
        System.out.print("Masukkan Jumlah Kehadiran: ");
        int kehadiran = scanner.nextInt();
        System.out.println();

        Manager manager = new Manager();
        manager.setNik(nik);
        manager.setNama(nama);
        manager.setGolongan(golongan);
        manager.setJabatan(jabatan);
        manager.setKehadiran(kehadiran);

        System.out.println("===== Hasil Perhitungan =====");
        System.out.println("NIK: " + manager.getNik());
        System.out.println("Nama: " + manager.getNama());
        System.out.println("Golongan: " + manager.getGolongan());
        System.out.println("Jabatan: " + manager.getJabatan());
        System.out.println();

        System.out.println("Tunjangan Golongan: " + manager.tunjanganGolongan(manager.getGolongan()));
        System.out.println("Tunjangan Jabatan: " + manager.tunjanganJabatan(manager.getJabatan()));
        System.out.println("Tunjangan Kehadiran: " + manager.tunjanganKehadiran(manager.getKehadiran()));

        System.out.println("Gaji Total: " + manager.gajiTotal());
    }
    }