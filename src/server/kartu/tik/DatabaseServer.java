/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.kartu.tik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author GeolseuDei
 */
public class DatabaseServer {

    //untuk login , data dipake client buat perpindahan form, nama di menu, id untuk input log per user
    public String idUser;
    public String namaUser;
    public String tipeUser;
    //untuk form pengaturan hakakses
    public String namaHakakses;
    public String hakspesial;
    //untuk data diri di form pencarian
    public String nik;
    public String nama;
    public String alias;
    public String alamat;
    public String jeniskelamin;
    public String tanggallahir;

    static DataTIK d = new DataTIK();

    public void insertLog(String id, String event, String waktu) {
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "insert into log (id_anggota,event,waktu) values('" + id + "','" + event + "','" + waktu + "')"
                );

                int a = sql.executeUpdate();
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        } finally {
            try {
                if (myCon != null) {
                    myCon.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    public boolean Login(String username, String password) {
        boolean status = false;
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "select login.id,anggota.nama,login.status from login inner join anggota on login.id=anggota.id where login.username='" + username + "' and login.password='" + password + "'"
                );
                ResultSet hasil = sql.executeQuery();
                if (hasil.next()) {
                    idUser = hasil.getString("id");
                    namaUser = hasil.getString("nama");
                    tipeUser = hasil.getString("status");
                    status = true;
                }
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        } finally {
            try {
                if (myCon != null) {
                    myCon.close();
                }
            } catch (SQLException e) {
            }
        }
        return status;
    }

    public ArrayList Ambil10DataLogMenuAdmin() {
        ArrayList list = new ArrayList<>();
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "SELECT anggota.nama,log.event,log.waktu FROM log inner join anggota on log.id_anggota=anggota.id order by log.waktu desc limit 10"
                );
                ResultSet hasil = sql.executeQuery();
                while (hasil.next()) {
                    Log l = new Log();
                    l.setNama(hasil.getString("nama"));
                    l.setEvent(hasil.getString("event"));
                    l.setWaktu(hasil.getString("waktu"));
                    list.add(l);
                }
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        } finally {
            try {
                if (myCon != null) {
                    myCon.close();
                }
            } catch (SQLException e) {
            }
        }
        return list;
    }

    public ArrayList AmbilDataLogDenganTanggal(String tanggal, String bulan, String tahun) {
        ArrayList list = new ArrayList<>();
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "SELECT anggota.nama,log.event,log.waktu FROM log inner join anggota on log.id_anggota=anggota.id WHERE waktu like '" + tanggal + "-" + bulan + "-" + tahun + "%' order by waktu desc"
                );
                ResultSet hasil = sql.executeQuery();
                while (hasil.next()) {
                    Log l = new Log();
                    l.setNama(hasil.getString("nama"));
                    l.setEvent(hasil.getString("event"));
                    l.setWaktu(hasil.getString("waktu"));
                    list.add(l);
                }
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        } finally {
            try {
                if (myCon != null) {
                    myCon.close();
                }
            } catch (SQLException e) {
            }
        }
        return list;
    }

    public boolean InsertTIK() {
        boolean status = false;
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "insert into datatik (namalengkap,alias,tglnoktp,tglnopasport,agama,tgllahir,umur,tempatlahir,alamat,perubahanalamat1,"
                        + "perubahanalamat2,perubahanalamat3,kedudukandalamkeluarga,namabapak,namaibu,alamatorangtua,pekerjaan,jabatan,"
                        + "instansilembagakantor,namaistri,umuristri,pekerjaanistri,namabapakistri,umurbapakistri,pekerjaanbapakistri,"
                        + "namaibuistri,umuribuistri,pekerjaanibuistri,alamatorangtuaistri,tanggungan,alamattanggungan,namaanak1,umuranak1,"
                        + "pekerjaananak1,namaanak2,umuranak2,pekerjaananak2,namaanak3,umuranak3,pekerjaananak3,namaanak4,umuranak4,pekerjaananak4,"
                        + "namaanak5,umuranak5,pekerjaananak5,namaanak6,umuranak6,pekerjaananak6,rambut,muka,kulit,tinggi,tandaistimewa,rumussidikjari,"
                        + "namasekolah1,tahunlulussekolah1,namasekolah2,tahunlulussekolah2,namasekolah3,tahunlulussekolah3,"
                        + "namasekolah4,tahunlulussekolah4,namasekolah5,tahunlulussekolah5,namasekolah6,tahunlulussekolah6,hobi,catatankriminal1,"
                        + "catatankriminal2,catatankriminal3,urlfoto) values ('" + d.getNamalengkap() + "','" + d.getAlias() + "','" + d.getTglnoktp()
                        + "','" + d.getTglnopasport() + "','" + d.getAgama() + "','" + d.getTgllahir() + "','" + d.getUmur() + "','" + d.getTempatlahir() 
                        + "','" + d.getAlamat() + "','" + d.getPerubahanalamat1() + "','" + d.getPerubahanalamat2() + "','"+ d.getPerubahanalamat3() + "','" 
                        + d.getKedudukan() + "','" + d.getNamabapak() + "','" + d.getNamaibu() + "','" + d.getAlamatorgtua() + "','" + d.getPekerjaan() + "','"
                        + d.getJabatan() + "','"+ d.getInstansilembagakantor() + "','" + d.getNamaistri() + "','" + d.getUmuristri() + "','" + d.getPekerjaanistri() 
                        + "','" + d.getNamabapakistri() + "','" + d.getUmurbapakistri() + "','" + d.getPekerjaanbapakistri() + "','" + d.getNamaibuistri() 
                        + "','" + d.getUmuribuistri() + "','" + d.getPekerjaanibuistri() + "','" + d.getAlamatorgtuaistri() + "','" + d.getTanggungan() + "','"
                        + d.getAlamattanggungan() + "','" + d.getNamaanak1() + "','" + d.getUmuranak1() + "','" + d.getPekerjaananak1() + "','" + d.getNamaanak2() 
                        + "','" + d.getUmuranak2() + "','" + d.getPekerjaananak2() + "','" + d.getNamaanak3() + "','" + d.getUmuranak3() + "','" + d.getPekerjaananak3() 
                        + "','" + d.getNamaanak4() + "','" + d.getUmuranak4() + "','" + d.getPekerjaananak4() + "','" + d.getNamaanak5() + "','" + d.getUmuranak5() 
                        + "','" + d.getPekerjaananak5() + "','" + d.getNamaanak6() + "','" + d.getUmuranak6() + "','" + d.getPekerjaananak6() + "','" + d.getRambut() 
                        + "','" + d.getMuka() + "','" + d.getKulit() + "','" + d.getTinggi() + "','" + d.getTandaistimewa() + "','" + d.getRumussidikjari() + "','"
                        + d.getNamasekolah1() + "','" + d.getTahunlulussekolah1() + "','" + d.getNamasekolah2() + "','" + d.getTahunlulussekolah2() + "','" 
                        + d.getNamasekolah3() + "','" + d.getTahunlulussekolah3() + "','" + d.getNamasekolah4() + "','" + d.getTahunlulussekolah4()
                        + d.getNamasekolah5() + "','" + d.getTahunlulussekolah5() + "','" + d.getNamasekolah6() + "','" + d.getTahunlulussekolah6()
                        + "','" + d.getHobi() + "','" + d.getCatatankriminal1() + "','" + d.getCatatankriminal2() + "','" + d.getCatatankriminal3() + "','"
                        + "test" + "')"
                );
                int a = sql.executeUpdate();
                status = true;
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        } finally {
            try {
                if (myCon != null) {
                    myCon.close();
                }
            } catch (SQLException e) {
            }
        }
        return status;
    }
}
