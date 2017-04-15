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
    public String hakspesialUser;
    public String divisi;

    static DataTIK d = new DataTIK();

    public void InsertLog(String id, String event, String waktu, String divisi) {
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "insert into log (id_anggota,event,waktu,divisi) values('" + id + "','" + event + "','" + waktu + "','" + divisi + "')"
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
                        "select login.id,anggota.nama,login.status,login.hakspesial,anggota.divisi from login inner join anggota on login.id=anggota.id where login.username='" + username + "' and login.password='" + password + "'"
                );
                ResultSet hasil = sql.executeQuery();
                if (hasil.next()) {
                    idUser = hasil.getString("id");
                    namaUser = hasil.getString("nama");
                    tipeUser = hasil.getString("status");
                    hakspesialUser = hasil.getString("hakspesial");
                    divisi = hasil.getString("divisi");
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

    public ArrayList Ambil10DataLogMenuAdmin(String tanggalhariini, String divisi) {
        ArrayList list = new ArrayList<>();
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "SELECT anggota.nama,log.event,log.waktu FROM log inner join anggota on log.id_anggota=anggota.id where log.waktu like '" + tanggalhariini + "%' and anggota.divisi = '" + divisi + "' ORDER by waktu DESC LIMIT 10"
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

    public ArrayList AmbilDataTabelTIK(String divisi) {
        ArrayList list = new ArrayList<>();
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "SELECT * from datatik where divisi='" + divisi + "'"
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
                        + " hobi, catatankriminal1, catatankriminal2, catatankriminal3, urlfoto,divisi) "
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
                        + " '" + d.getCatatankriminal3() + "', '','" + d.getDivisi() + "')"
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
                    d.setDivisi(hasil.getString("divisi"));
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

    public void AmbilFOTOTIKbyID(String id) {
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "select * from datatik where id='" + id + "'"
                );
                ResultSet hasil = sql.executeQuery();
                if (hasil.next()) {
                    d.setNamalengkap(hasil.getString("namalengkap"));
                    d.setTglnoktp(hasil.getString("tglnoktp"));
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
                        "UPDATE `datatik` SET `namalengkap`='" + d.getNamalengkap() + "',`alias`='" + d.getAlias() + "',`tglnoktp`='" + d.getTglnoktp() + "',`tglnopasport`='" + d.getTglnopasport() + "',`agama`='" + d.getAgama() + "',`tgllahir`='" + d.getTgllahir() + "',`umur`='" + d.getUmur() + "',`tempatlahir`='" + d.getTempatlahir() + "',`alamat`='" + d.getAlamat() + "',`perubahanalamat1`='" + d.getPerubahanalamat1() + "',`perubahanalamat2`='" + d.getPerubahanalamat2() + "',`perubahanalamat3`='" + d.getPerubahanalamat3() + "',`kedudukandalamkeluarga`='" + d.getKedudukan() + "',`namabapak`='" + d.getNamabapak() + "',`namaibu`='" + d.getNamaibu() + "',`alamatorangtua`='" + d.getAlamatorgtua() + "',`pekerjaan`='" + d.getPekerjaan() + "',`jabatan`='" + d.getJabatan() + "',`instansilembagakantor`='" + d.getInstansilembagakantor() + "',`namaistri`='" + d.getNamaistri() + "',`umuristri`='" + d.getUmuristri() + "',`pekerjaanistri`='" + d.getPekerjaanistri() + "',`namabapakistri`='" + d.getNamabapakistri() + "',`umurbapakistri`='" + d.getUmurbapakistri() + "',`pekerjaanbapakistri`='" + d.getPekerjaanbapakistri() + "',`namaibuistri`='" + d.getNamaibuistri() + "',`umuribuistri`='" + d.getUmuribuistri() + "',`pekerjaanibuistri`='" + d.getPekerjaanibuistri() + "',`alamatorangtuaistri`='" + d.getAlamatorgtuaistri() + "',`tanggungan`='" + d.getTanggungan() + "',`alamattanggungan`='" + d.getAlamattanggungan() + "',`namaanak1`='" + d.getNamaanak1() + "',`umuranak1`='" + d.getUmuranak1() + "',`pekerjaananak1`='" + d.getPekerjaananak1() + "',`namaanak2`='" + d.getNamaanak2() + "',`umuranak2`='" + d.getUmuranak2() + "',`pekerjaananak2`='" + d.getPekerjaananak2() + "',`namaanak3`='" + d.getNamaanak3() + "',`umuranak3`='" + d.getUmuranak3() + "',`pekerjaananak3`='" + d.getPekerjaananak3() + "',`namaanak4`='" + d.getNamaanak4() + "',`umuranak4`='" + d.getUmuranak4() + "',`pekerjaananak4`='" + d.getPekerjaananak4() + "',`namaanak5`='" + d.getNamaanak5() + "',`umuranak5`='" + d.getUmuranak5() + "',`pekerjaananak5`='" + d.getPekerjaananak5() + "',`namaanak6`='" + d.getNamaanak6() + "',`umuranak6`='" + d.getUmuranak6() + "',`pekerjaananak6`='" + d.getPekerjaananak6() + "',`rambut`='" + d.getRambut() + "',`muka`='" + d.getMuka() + "',`kulit`='" + d.getKulit() + "',`tinggi`='" + d.getTinggi() + "',`tandaistimewa`='" + d.getTandaistimewa() + "',`rumussidikjari`='" + d.getRumussidikjari() + "',`namasekolah1`='" + d.getNamasekolah1() + "',`tahunlulussekolah1`='" + d.getTahunlulussekolah1() + "',`namasekolah2`='" + d.getNamasekolah2() + "',`tahunlulussekolah2`='" + d.getTahunlulussekolah2() + "',`namasekolah3`='" + d.getNamasekolah3() + "',`tahunlulussekolah3`='" + d.getTahunlulussekolah3() + "',`namasekolah4`='" + d.getNamasekolah4() + "',`tahunlulussekolah4`='" + d.getTahunlulussekolah4() + "',`namasekolah5`='" + d.getNamasekolah5() + "',`tahunlulussekolah5`='" + d.getTahunlulussekolah5() + "',`namasekolah6`='" + d.getNamasekolah6() + "',`tahunlulussekolah6`='" + d.getTahunlulussekolah6() + "',`hobi`='" + d.getHobi() + "',`catatankriminal1`='" + d.getCatatankriminal1() + "',`catatankriminal2`='" + d.getCatatankriminal2() + "',`catatankriminal3`='" + d.getCatatankriminal3() + "' WHERE id=" + id
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

    public boolean UpdateFOTOTIK(String urlfoto, String id) {
        boolean status = false;
        String urlfixed = urlfoto.replaceAll("\\\\", "/");
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "UPDATE `datatik` SET urlfoto='" + urlfixed + "' where id=" + id
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

    public boolean AmbilDataTIKbyKTP(String ktp, String divisi) {
        boolean status = false;
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "select * from datatik where tglnoktp='" + ktp + "' and divisi='" + divisi + "'"
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

    public boolean InsertKegiatan(String noktp, String kegiatan, String waktu) {
        boolean status = false;
        String id = "";
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "select id from datatik where tglnoktp='" + noktp + "'"
                );
                ResultSet hasil = sql.executeQuery();
                if (hasil.next()) {
                    id = hasil.getString("id");
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

    public boolean InsertFOTOTIK(String urlfoto, String noktp) {
        boolean status = false;
        String urlfixed = urlfoto.replaceAll("\\\\", "/");
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "update datatik set urlfoto='" + urlfixed + "' where tglnoktp='" + noktp + "'"
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

    public boolean UpdateNama(String id, String namabaru) {
        boolean status = false;
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "update anggota set nama='" + namabaru + "' where id=" + id
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

    public boolean CekPasswordLama(String id, String passwordlama) {
        boolean status = false;
        String passworddblama = "";
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "select password from login where id=" + id
                );
                ResultSet hasil = sql.executeQuery();
                if (hasil.next()) {
                    passworddblama = hasil.getString("password");
                    if (passworddblama.equals(passwordlama)) {
                        status = true;
                    }
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

    public boolean UpdatePassword(String id, String password) {
        boolean status = false;
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "update login set password='" + password + "' where id=" + id
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

    public String AmbilDataHakAkses(String noinduk) {
        String data = "";
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "SELECT anggota.nama,login.hakspesial FROM `login` inner join anggota on login.id=anggota.id where anggota.noinduk=" + noinduk
                );
                ResultSet hasil = sql.executeQuery();
                if (hasil.next()) {
                    String nama = hasil.getString("nama");
                    String hak = hasil.getString("hakspesial");
                    data = nama + "," + hak;
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
        return data;
    }

    public boolean UpdateHakAkses(String noinduk, String jenis) {
        boolean status = false;
        String id = "";
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "select id from anggota where noinduk=" + noinduk
                );
                ResultSet hasil = sql.executeQuery();
                if (hasil.next()) {
                    id = hasil.getString("id");
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

        String hakakses = "";
        if (jenis.equalsIgnoreCase("beri")) {
            hakakses = "1";
        } else if (jenis.equalsIgnoreCase("cabut")) {
            hakakses = "0";
        }

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "update login set hakspesial='" + hakakses + "' where id=" + id
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

    public String AmbilNamaByKTP(String ktp, String divisi) {
        String nama = "";
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "select namalengkap from datatik where tglnoktp='" + ktp + "' and divisi='" + divisi + "'"
                );
                ResultSet hasil = sql.executeQuery();
                if (hasil.next()) {
                    nama = hasil.getString("namalengkap");
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
        return nama;
    }

    public boolean BuatAkunMember(String nama, String noinduk, String username, String password, String divisi) {
        boolean status = false;
        Connection myCon = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "insert into login (username,password,status,hakspesial) values ('" + username + "','" + password + "','0','0')"
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
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/programpendataan", "root", "");
            if (!myCon.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myCon.prepareStatement(
                        "insert into anggota (noinduk,nama,divisi) values ('" + noinduk + "','" + nama + "','" + divisi + "')"
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
