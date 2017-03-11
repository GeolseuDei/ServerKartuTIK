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

    public void InsertLog(String id, String event, String waktu) {
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

    public ArrayList AmbilDataTabelTIK() {
        ArrayList list = new ArrayList<>();
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "SELECT * from datatik"
                );
                ResultSet hasil = sql.executeQuery();
                while (hasil.next()) {
                    DataTIK l = new DataTIK();
                    l.setNamalengkap(hasil.getString("namalengkap"));
                    l.setAlias(hasil.getString("alias"));
                    l.setTglnoktp(hasil.getString("tglnoktp"));
                    l.setAgama(hasil.getString("agama"));
                    l.setTgllahir(hasil.getString("tgllahir"));
                    l.setTempatlahir(hasil.getString("tempatlahir"));
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
                        "INSERT INTO datatik (namalengkap, alias, tglnoktp, tglnopasport, agama, tgllahir, umur, tempatlahir, alamat,"
                        + " perubahanalamat1, perubahanalamat2, perubahanalamat3, kedudukandalamkeluarga, namabapak, namaibu, alamatorangtua,"
                        + " pekerjaan, jabatan, instansilembagakantor, namaistri, umuristri, pekerjaanistri, namabapakistri, umurbapakistri,"
                        + " pekerjaanbapakistri, namaibuistri, umuribuistri, pekerjaanibuistri, alamatorangtuaistri, tanggungan,"
                        + " alamattanggungan, namaanak1, umuranak1, pekerjaananak1, namaanak2, umuranak2, pekerjaananak2, namaanak3,"
                        + " umuranak3, pekerjaananak3, namaanak4, umuranak4, pekerjaananak4, namaanak5, umuranak5, pekerjaananak5, namaanak6,"
                        + " umuranak6, pekerjaananak6, rambut, muka, kulit, tinggi, tandaistimewa, rumussidikjari, namasekolah1,"
                        + " tahunlulussekolah1, namasekolah2, tahunlulussekolah2, namasekolah3, tahunlulussekolah3, "
                        + " namasekolah4, tahunlulussekolah4, namasekolah5, tahunlulussekolah5, namasekolah6, tahunlulussekolah6, "
                        + " hobi, catatankriminal1, catatankriminal2, catatankriminal3, urlfoto) "
                        + "VALUES ('" + d.getNamalengkap() + "', '" + d.getAlias() + "', '" + d.getTglnoktp() + "', '" + d.getTglnopasport() + "', '" + d.getAgama() + "', '" + d.getTgllahir() + "', '" + d.getUmur() + "', '" + d.getTempatlahir() + "', '" + d.getAlamat() + "', "
                        + " '" + d.getPerubahanalamat1() + "', '" + d.getPerubahanalamat2() + "', '" + d.getPerubahanalamat3() + "', '" + d.getKedudukan() + "', '" + d.getNamabapak() + "', '" + d.getNamaibu() + "',"
                        + " '" + d.getAlamatorgtua() + "', '" + d.getPekerjaan() + "', '" + d.getJabatan() + "', '" + d.getInstansilembagakantor() + "', '" + d.getNamaistri() + "', '" + d.getUmuristri() + "', '" + d.getPekerjaanistri() + "', "
                        + " '" + d.getNamabapakistri() + "', '" + d.getUmurbapakistri() + "', '" + d.getPekerjaanbapakistri() + "', '" + d.getNamaibuistri() + "', '" + d.getUmuribuistri() + "', '" + d.getPekerjaanibuistri() + "',"
                        + " '" + d.getAlamatorgtuaistri() + "', '" + d.getTanggungan() + "', '" + d.getAlamattanggungan() + "', '" + d.getNamaanak1() + "', '" + d.getUmuranak1() + "', '" + d.getPekerjaananak1() + "', '" + d.getNamaanak2() + "',"
                        + " '" + d.getUmuranak2() + "', '" + d.getPekerjaananak2() + "', '" + d.getNamaanak3() + "', '" + d.getUmuranak3() + "', '" + d.getPekerjaananak3() + "', '" + d.getNamaanak4() + "', '" + d.getUmuranak4() + "', '" + d.getPekerjaananak4() + "',"
                        + " '" + d.getNamaanak5() + "', '" + d.getUmuranak5() + "', '" + d.getPekerjaananak5() + "', '" + d.getNamaanak6() + "', '" + d.getUmuranak6() + "', '" + d.getPekerjaananak6() + "', '" + d.getRambut() + "', '" + d.getMuka() + "', '" + d.getKulit() + "', "
                        + " '" + d.getTinggi() + "', '" + d.getTandaistimewa() + "', '" + d.getRumussidikjari() + "', '" + d.getNamasekolah1() + "', '" + d.getTahunlulussekolah1() + "', '" + d.getNamasekolah2() + "', "
                        + " '" + d.getTahunlulussekolah2() + "', '" + d.getNamasekolah3() + "', '" + d.getTahunlulussekolah3() + "', '" + d.getNamasekolah4() + "', '" + d.getTahunlulussekolah4() + "', '" + d.getNamasekolah5() + "',"
                        + " '" + d.getTahunlulussekolah5() + "', '" + d.getNamasekolah6() + "', '" + d.getTahunlulussekolah6() + "', '" + d.getHobi() + "', '" + d.getCatatankriminal1() + "', '" + d.getCatatankriminal2() + "',"
                        + " '" + d.getCatatankriminal3() + "', '')"
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

    public void AmbilDataTIKbyNama(String namalengkap) {
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "select * from datatik where namalengkap='" + namalengkap + "'"
                );
                ResultSet hasil = sql.executeQuery();
                if (hasil.next()) {
                    d.setId(hasil.getString("id"));
                    d.setNamalengkap(hasil.getString("namalengkap"));
                    d.setAlias(hasil.getString("alias"));
                    d.setTglnoktp(hasil.getString("tglnoktp"));
                    d.setTglnopasport(hasil.getString("tglnopasport"));
                    d.setAgama(hasil.getString("agama"));
                    d.setTgllahir(hasil.getString("tgllahir"));
                    d.setUmur(hasil.getString("umur"));
                    d.setTempatlahir(hasil.getString("tempatlahir"));
                    d.setAlamat(hasil.getString("alamat"));
                    d.setPerubahanalamat1(hasil.getString("perubahanalamat1"));
                    d.setPerubahanalamat2(hasil.getString("perubahanalamat2"));
                    d.setPerubahanalamat3(hasil.getString("perubahanalamat3"));
                    d.setKedudukan(hasil.getString("kedudukandalamkeluarga"));
                    d.setNamabapak(hasil.getString("namabapak"));
                    d.setNamaibu(hasil.getString("namaibu"));
                    d.setAlamatorgtua(hasil.getString("alamatorangtua"));
                    d.setPekerjaan(hasil.getString("pekerjaan"));
                    d.setJabatan(hasil.getString("jabatan"));
                    d.setInstansilembagakantor(hasil.getString("instansilembagakantor"));
                    d.setNamaistri(hasil.getString("namaistri"));
                    d.setUmuristri(hasil.getString("umuristri"));
                    d.setPekerjaanistri(hasil.getString("pekerjaanistri"));
                    d.setNamabapakistri(hasil.getString("namabapakistri"));
                    d.setUmurbapakistri(hasil.getString("umurbapakistri"));
                    d.setPekerjaanbapakistri(hasil.getString("pekerjaanbapakistri"));
                    d.setNamaibuistri(hasil.getString("namaibuistri"));
                    d.setUmuribuistri(hasil.getString("umuribuistri"));
                    d.setPekerjaanibuistri(hasil.getString("pekerjaanibuistri"));
                    d.setAlamatorgtuaistri(hasil.getString("alamatorangtuaistri"));
                    d.setTanggungan(hasil.getString("tanggungan"));
                    d.setAlamattanggungan(hasil.getString("alamattanggungan"));
                    d.setRambut(hasil.getString("rambut"));
                    d.setMuka(hasil.getString("muka"));
                    d.setKulit(hasil.getString("kulit"));
                    d.setTinggi(hasil.getString("tinggi"));
                    d.setTandaistimewa(hasil.getString("tandaistimewa"));
                    d.setRumussidikjari(hasil.getString("rumussidikjari"));
                    d.setNamaanak1(hasil.getString("namaanak1"));
                    d.setNamaanak2(hasil.getString("namaanak2"));
                    d.setNamaanak3(hasil.getString("namaanak3"));
                    d.setNamaanak4(hasil.getString("namaanak4"));
                    d.setNamaanak5(hasil.getString("namaanak5"));
                    d.setNamaanak6(hasil.getString("namaanak6"));
                    d.setUmuranak1(hasil.getString("umuranak1"));
                    d.setUmuranak2(hasil.getString("umuranak2"));
                    d.setUmuranak3(hasil.getString("umuranak3"));
                    d.setUmuranak4(hasil.getString("umuranak4"));
                    d.setUmuranak5(hasil.getString("umuranak5"));
                    d.setUmuranak6(hasil.getString("umuranak6"));
                    d.setPekerjaananak1(hasil.getString("pekerjaananak1"));
                    d.setPekerjaananak2(hasil.getString("pekerjaananak2"));
                    d.setPekerjaananak3(hasil.getString("pekerjaananak3"));
                    d.setPekerjaananak4(hasil.getString("pekerjaananak4"));
                    d.setPekerjaananak5(hasil.getString("pekerjaananak5"));
                    d.setPekerjaananak6(hasil.getString("pekerjaananak6"));
                    d.setNamasekolah1(hasil.getString("namasekolah1"));
                    d.setNamasekolah2(hasil.getString("namasekolah2"));
                    d.setNamasekolah3(hasil.getString("namasekolah3"));
                    d.setNamasekolah4(hasil.getString("namasekolah4"));
                    d.setNamasekolah5(hasil.getString("namasekolah5"));
                    d.setNamasekolah6(hasil.getString("namasekolah6"));
                    d.setTahunlulussekolah1(hasil.getString("tahunlulussekolah1"));
                    d.setTahunlulussekolah2(hasil.getString("tahunlulussekolah2"));
                    d.setTahunlulussekolah3(hasil.getString("tahunlulussekolah3"));
                    d.setTahunlulussekolah4(hasil.getString("tahunlulussekolah4"));
                    d.setTahunlulussekolah5(hasil.getString("tahunlulussekolah5"));
                    d.setTahunlulussekolah6(hasil.getString("tahunlulussekolah6"));
                    d.setHobi(hasil.getString("hobi"));
                    d.setCatatankriminal1(hasil.getString("catatankriminal1"));
                    d.setCatatankriminal2(hasil.getString("catatankriminal2"));
                    d.setCatatankriminal3(hasil.getString("catatankriminal3"));
                    d.setUrlfoto(hasil.getString("urlfoto"));
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
    }

    public boolean UpdateTIK(String id) {
        boolean status = false;
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "UPDATE `datatik` SET `namalengkap`=" + d.getNamalengkap() + ",`alias`=" + d.getAlias() + ",`tglnoktp`=" + d.getTglnoktp() + ",`tglnopasport`=[value-5],`agama`=[value-6],`tgllahir`=[value-7],`umur`=[value-8],`tempatlahir`=[value-9],`alamat`=[value-10],`perubahanalamat1`=[value-11],`perubahanalamat2`=[value-12],`perubahanalamat3`=[value-13],`kedudukandalamkeluarga`=[value-14],`namabapak`=[value-15],`namaibu`=[value-16],`alamatorangtua`=[value-17],`pekerjaan`=[value-18],`jabatan`=[value-19],`instansilembagakantor`=[value-20],`namaistri`=[value-21],`umuristri`=[value-22],`pekerjaanistri`=[value-23],`namabapakistri`=[value-24],`umurbapakistri`=[value-25],`pekerjaanbapakistri`=[value-26],`namaibuistri`=[value-27],`umuribuistri`=[value-28],`pekerjaanibuistri`=[value-29],`alamatorangtuaistri`=[value-30],`tanggungan`=[value-31],`alamattanggungan`=[value-32],`namaanak1`=[value-33],`umuranak1`=[value-34],`pekerjaananak1`=[value-35],`namaanak2`=[value-36],`umuranak2`=[value-37],`pekerjaananak2`=[value-38],`namaanak3`=[value-39],`umuranak3`=[value-40],`pekerjaananak3`=[value-41],`namaanak4`=[value-42],`umuranak4`=[value-43],`pekerjaananak4`=[value-44],`namaanak5`=[value-45],`umuranak5`=[value-46],`pekerjaananak5`=[value-47],`namaanak6`=[value-48],`umuranak6`=[value-49],`pekerjaananak6`=[value-50],`rambut`=[value-51],`muka`=[value-52],`kulit`=[value-53],`tinggi`=[value-54],`tandaistimewa`=[value-55],`rumussidikjari`=[value-56],`namasekolah1`=[value-57],`tahunlulussekolah1`=[value-58],`namasekolah2`=[value-59],`tahunlulussekolah2`=[value-60],`namasekolah3`=[value-61],`tahunlulussekolah3`=[value-62],`namasekolah4`=[value-63],`tahunlulussekolah4`=[value-64],`namasekolah5`=[value-65],`tahunlulussekolah5`=[value-66],`namasekolah6`=[value-67],`tahunlulussekolah6`=[value-68],`hobi`=[value-69],`catatankriminal1`=[value-70],`catatankriminal2`=[value-71],`catatankriminal3`=[value-72],`urlfoto`=[value-73] WHERE id=" + id
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

    public boolean DeleteTIK(String namalengkap) {
        boolean status = false;
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "delete from datatik where namalengkap='" + namalengkap + "'"
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

    public boolean AmbilDataTIKbyKTP(String ktp) {
        boolean status = false;
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "select * from datatik where tglnoktp='" + ktp + "'"
                );
                ResultSet hasil = sql.executeQuery();
                if (hasil.next()) {
                    d.setId(hasil.getString("id"));
                    d.setNamalengkap(hasil.getString("namalengkap"));
                    d.setAlias(hasil.getString("alias"));
                    d.setTglnoktp(hasil.getString("tglnoktp"));
                    d.setTglnopasport(hasil.getString("tglnopasport"));
                    d.setAgama(hasil.getString("agama"));
                    d.setTgllahir(hasil.getString("tgllahir"));
                    d.setUmur(hasil.getString("umur"));
                    d.setTempatlahir(hasil.getString("tempatlahir"));
                    d.setAlamat(hasil.getString("alamat"));
                    d.setPerubahanalamat1(hasil.getString("perubahanalamat1"));
                    d.setPerubahanalamat2(hasil.getString("perubahanalamat2"));
                    d.setPerubahanalamat3(hasil.getString("perubahanalamat3"));
                    d.setKedudukan(hasil.getString("kedudukandalamkeluarga"));
                    d.setNamabapak(hasil.getString("namabapak"));
                    d.setNamaibu(hasil.getString("namaibu"));
                    d.setAlamatorgtua(hasil.getString("alamatorangtua"));
                    d.setPekerjaan(hasil.getString("pekerjaan"));
                    d.setJabatan(hasil.getString("jabatan"));
                    d.setInstansilembagakantor(hasil.getString("instansilembagakantor"));
                    d.setNamaistri(hasil.getString("namaistri"));
                    d.setUmuristri(hasil.getString("umuristri"));
                    d.setPekerjaanistri(hasil.getString("pekerjaanistri"));
                    d.setNamabapakistri(hasil.getString("namabapakistri"));
                    d.setUmurbapakistri(hasil.getString("umurbapakistri"));
                    d.setPekerjaanbapakistri(hasil.getString("pekerjaanbapakistri"));
                    d.setNamaibuistri(hasil.getString("namaibuistri"));
                    d.setUmuribuistri(hasil.getString("umuribuistri"));
                    d.setPekerjaanibuistri(hasil.getString("pekerjaanibuistri"));
                    d.setAlamatorgtuaistri(hasil.getString("alamatorangtuaistri"));
                    d.setTanggungan(hasil.getString("tanggungan"));
                    d.setAlamattanggungan(hasil.getString("alamattanggungan"));
                    d.setRambut(hasil.getString("rambut"));
                    d.setMuka(hasil.getString("muka"));
                    d.setKulit(hasil.getString("kulit"));
                    d.setTinggi(hasil.getString("tinggi"));
                    d.setTandaistimewa(hasil.getString("tandaistimewa"));
                    d.setRumussidikjari(hasil.getString("rumussidikjari"));
                    d.setNamaanak1(hasil.getString("namaanak1"));
                    d.setNamaanak2(hasil.getString("namaanak2"));
                    d.setNamaanak3(hasil.getString("namaanak3"));
                    d.setNamaanak4(hasil.getString("namaanak4"));
                    d.setNamaanak5(hasil.getString("namaanak5"));
                    d.setNamaanak6(hasil.getString("namaanak6"));
                    d.setUmuranak1(hasil.getString("umuranak1"));
                    d.setUmuranak2(hasil.getString("umuranak2"));
                    d.setUmuranak3(hasil.getString("umuranak3"));
                    d.setUmuranak4(hasil.getString("umuranak4"));
                    d.setUmuranak5(hasil.getString("umuranak5"));
                    d.setUmuranak6(hasil.getString("umuranak6"));
                    d.setPekerjaananak1(hasil.getString("pekerjaananak1"));
                    d.setPekerjaananak2(hasil.getString("pekerjaananak2"));
                    d.setPekerjaananak3(hasil.getString("pekerjaananak3"));
                    d.setPekerjaananak4(hasil.getString("pekerjaananak4"));
                    d.setPekerjaananak5(hasil.getString("pekerjaananak5"));
                    d.setPekerjaananak6(hasil.getString("pekerjaananak6"));
                    d.setNamasekolah1(hasil.getString("namasekolah1"));
                    d.setNamasekolah2(hasil.getString("namasekolah2"));
                    d.setNamasekolah3(hasil.getString("namasekolah3"));
                    d.setNamasekolah4(hasil.getString("namasekolah4"));
                    d.setNamasekolah5(hasil.getString("namasekolah5"));
                    d.setNamasekolah6(hasil.getString("namasekolah6"));
                    d.setTahunlulussekolah1(hasil.getString("tahunlulussekolah1"));
                    d.setTahunlulussekolah2(hasil.getString("tahunlulussekolah2"));
                    d.setTahunlulussekolah3(hasil.getString("tahunlulussekolah3"));
                    d.setTahunlulussekolah4(hasil.getString("tahunlulussekolah4"));
                    d.setTahunlulussekolah5(hasil.getString("tahunlulussekolah5"));
                    d.setTahunlulussekolah6(hasil.getString("tahunlulussekolah6"));
                    d.setHobi(hasil.getString("hobi"));
                    d.setCatatankriminal1(hasil.getString("catatankriminal1"));
                    d.setCatatankriminal2(hasil.getString("catatankriminal2"));
                    d.setCatatankriminal3(hasil.getString("catatankriminal3"));
                    d.setUrlfoto(hasil.getString("urlfoto"));
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

    public ArrayList AmbilDataKegiatan(String id) {
        ArrayList list = new ArrayList<>();
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "SELECT * from kegiatan where id_TIK=" + id
                );
                ResultSet hasil = sql.executeQuery();
                while (hasil.next()) {
                    Kegiatan k = new Kegiatan();
                    k.setNamakegiatan(hasil.getString("kegiatan"));
                    k.setTanggal(hasil.getString("tanggal"));
                    list.add(k);
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

    public boolean InsertKegiatan(String id, String kegiatan, String waktu) {
        boolean status = false;
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "insert into kegiatan (id_TIK,kegiatan,tanggal) values('" + id + "','" + kegiatan + "','" + waktu + "')"
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
    
    public boolean UpdateFOTO(String urlfoto , String noktp) {
        boolean status = false;
        String urlfixed = urlfoto.replaceAll("\\\\", "/");
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "update datatik set urlfoto='"+urlfixed+"' where tglnoktp='"+noktp+"'"
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
