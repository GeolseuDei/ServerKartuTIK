/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.kartu.tik;

import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author GeolseuDei
 */
public class ServerKartuTIK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        String jamskrg = sdf.format(date);

        ServerSocket ss;
        int port = 8888;
        try {
            ss = new ServerSocket(port);
            System.out.println("Server started | " + jamskrg);
            while (true) {
                Socket socket = ss.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            handleSocket(socket);
                        } catch (IOException ex) {
                            Logger.getLogger(ServerKartuTIK.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }).start();
                //Thread.sleep(1000);
            }
        } catch (IOException ex) {
            System.out.println("Server sudah dibuka.");
        }
    }

    private static void handleSocket(Socket incoming) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        String tanggaljamskrg = sdf.format(date);

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = new Date();
        String tanggalskrg = sdf1.format(date1);
        //Input -> Nerima
        //Output -> Ngasi

        //Input
        BufferedReader input = new BufferedReader(new InputStreamReader(incoming.getInputStream()));

        //Output
        PrintStream output = new PrintStream(incoming.getOutputStream());

        BufferedInputStream inputStream = new BufferedInputStream(incoming.getInputStream());

        DatabaseServer ds = new DatabaseServer();

        String jenisdata = input.readLine();
        if (jenisdata.equalsIgnoreCase("login")) {
            String username, passwordmd5;
            username = input.readLine();
            passwordmd5 = DigestUtils.md5Hex(input.readLine());
            if (ds.Login(username, passwordmd5)) {
                output.println(true);
                output.println(ds.idUser);
                output.println(ds.namaUser);
                output.println(ds.tipeUser);
                output.println(ds.hakspesialUser);
                ds.InsertLog(ds.idUser, "Berhasil masuk ke sistem", tanggaljamskrg);
            } else {
                output.println(false);
            }
        }
        if (jenisdata.equalsIgnoreCase("menulog")) {
            ArrayList<Log> list = new ArrayList<>(ds.Ambil10DataLogMenuAdmin(tanggalskrg));
            int sizeArray = list.size();
            output.println(sizeArray);
            for (int i = 0; i < sizeArray; i++) {
                output.println(list.get(i).getNama());
                output.println(list.get(i).getEvent());
                output.println(list.get(i).getWaktu());
            }
        }
        if (jenisdata.equalsIgnoreCase("tanggallog")) {
            String tanggal = input.readLine();
            String bulan = input.readLine();
            String tahun = input.readLine();
            ArrayList<Log> list = new ArrayList<>(ds.AmbilDataLogDenganTanggal(tanggal, bulan, tahun));
            int sizeArray = list.size();
            output.println(sizeArray);
            for (int i = 0; i < sizeArray; i++) {
                output.println(list.get(i).getNama());
                output.println(list.get(i).getEvent());
                output.println(list.get(i).getWaktu());
            }
        }
        if (jenisdata.equalsIgnoreCase("tabeltik")) {
            ArrayList<DataTIK> list = new ArrayList<>(ds.AmbilDataTabelTIK());
            int sizeArray = list.size();
            output.println(sizeArray);
            for (int i = 0; i < sizeArray; i++) {
                output.println(list.get(i).getNamalengkap());
                output.println(list.get(i).getAlias());
                output.println(list.get(i).getTglnoktp());
                output.println(list.get(i).getAgama());
                output.println(list.get(i).getTgllahir());
                output.println(list.get(i).getTempatlahir());
            }
        }
        if (jenisdata.equalsIgnoreCase("tabelkegiatan")) {
            String id = input.readLine();
            ArrayList<Kegiatan> list = new ArrayList<>(ds.AmbilDataKegiatan(id));
            int sizeArray = list.size();
            output.println(sizeArray);
            for (int i = 0; i < sizeArray; i++) {
                output.println(list.get(i).getNamakegiatan());
                output.println(list.get(i).getTanggal());
            }
        }
        if (jenisdata.equalsIgnoreCase("insertTIK")) {

            String namalengkap = input.readLine();
            String alias = input.readLine();
            String noktp = input.readLine();
            String nopasport = input.readLine();
            String agama = input.readLine();
            String tgllahir = input.readLine();
            String umur = input.readLine();
            String tempatlahir = input.readLine();
            String alamat = input.readLine();
            String perubahanalamat1 = input.readLine();
            String perubahanalamat2 = input.readLine();
            String perubahanalamat3 = input.readLine();
            String kedudukan = input.readLine();
            String namabapak = input.readLine();
            String namaibu = input.readLine();
            String alamatorangtua = input.readLine();
            String pekerjaan = input.readLine();
            String jabatan = input.readLine();
            String instansi = input.readLine();
            String namaistri = input.readLine();
            String umuristri = input.readLine();
            String pekerjaanistri = input.readLine();
            String namabapakistri = input.readLine();
            String umurbapakistri = input.readLine();
            String pekerjaanbapakistri = input.readLine();
            String namaibuistri = input.readLine();
            String umuribuistri = input.readLine();
            String pekerjaanibuistri = input.readLine();
            String alamatorangtuaistri = input.readLine();
            String tanggungan = input.readLine();
            String alamattanggungan = input.readLine();
            String namaanak1 = input.readLine();
            String namaanak2 = input.readLine();
            String namaanak3 = input.readLine();
            String namaanak4 = input.readLine();
            String namaanak5 = input.readLine();
            String namaanak6 = input.readLine();
            String umuranak1 = input.readLine();
            String umuranak2 = input.readLine();
            String umuranak3 = input.readLine();
            String umuranak4 = input.readLine();
            String umuranak5 = input.readLine();
            String umuranak6 = input.readLine();
            String pekerjaananak1 = input.readLine();
            String pekerjaananak2 = input.readLine();
            String pekerjaananak3 = input.readLine();
            String pekerjaananak4 = input.readLine();
            String pekerjaananak5 = input.readLine();
            String pekerjaananak6 = input.readLine();
            String rambut = input.readLine();
            String muka = input.readLine();
            String kulit = input.readLine();
            String tinggi = input.readLine();
            String tandaistimewa = input.readLine();
            String rumussidikjari = input.readLine();
            String namasekolah1 = input.readLine();
            String namasekolah2 = input.readLine();
            String namasekolah3 = input.readLine();
            String namasekolah4 = input.readLine();
            String namasekolah5 = input.readLine();
            String namasekolah6 = input.readLine();
            String tahunlulussekolah1 = input.readLine();
            String tahunlulussekolah2 = input.readLine();
            String tahunlulussekolah3 = input.readLine();
            String tahunlulussekolah4 = input.readLine();
            String tahunlulussekolah5 = input.readLine();
            String tahunlulussekolah6 = input.readLine();
            String hobi = input.readLine();
            String catatankriminal1 = input.readLine();
            String catatankriminal2 = input.readLine();
            String catatankriminal3 = input.readLine();

            ds.d.setNamalengkap(namalengkap);
            ds.d.setAlias(alias);
            ds.d.setTglnoktp(noktp);
            ds.d.setTglnopasport(nopasport);
            ds.d.setAgama(agama);
            ds.d.setTgllahir(tgllahir);
            ds.d.setUmur(umur);
            ds.d.setTempatlahir(tempatlahir);
            ds.d.setAlamat(alamat);
            ds.d.setPerubahanalamat1(perubahanalamat1);
            ds.d.setPerubahanalamat2(perubahanalamat2);
            ds.d.setPerubahanalamat3(perubahanalamat3);
            ds.d.setKedudukan(kedudukan);
            ds.d.setNamabapak(namabapak);
            ds.d.setNamaibu(namaibu);
            ds.d.setAlamatorgtua(alamatorangtua);
            ds.d.setPekerjaan(pekerjaan);
            ds.d.setJabatan(jabatan);
            ds.d.setInstansilembagakantor(instansi);
            ds.d.setNamaistri(namaistri);
            ds.d.setUmuristri(umuristri);
            ds.d.setPekerjaanistri(pekerjaanistri);
            ds.d.setNamabapakistri(namabapakistri);
            ds.d.setUmurbapakistri(umurbapakistri);
            ds.d.setPekerjaanbapakistri(pekerjaanbapakistri);
            ds.d.setNamaibuistri(namaibuistri);
            ds.d.setUmuribuistri(umuribuistri);
            ds.d.setPekerjaanibuistri(pekerjaanibuistri);
            ds.d.setAlamatorgtuaistri(alamatorangtuaistri);
            ds.d.setTanggungan(tanggungan);
            ds.d.setAlamattanggungan(alamattanggungan);
            ds.d.setRambut(rambut);
            ds.d.setMuka(muka);
            ds.d.setKulit(kulit);
            ds.d.setTinggi(tinggi);
            ds.d.setTandaistimewa(tandaistimewa);
            ds.d.setRumussidikjari(rumussidikjari);
            ds.d.setNamaanak1(namaanak1);
            ds.d.setNamaanak2(namaanak2);
            ds.d.setNamaanak3(namaanak3);
            ds.d.setNamaanak4(namaanak4);
            ds.d.setNamaanak5(namaanak5);
            ds.d.setNamaanak6(namaanak6);
            ds.d.setUmuranak1(umuranak1);
            ds.d.setUmuranak2(umuranak2);
            ds.d.setUmuranak3(umuranak3);
            ds.d.setUmuranak4(umuranak4);
            ds.d.setUmuranak5(umuranak5);
            ds.d.setUmuranak6(umuranak6);
            ds.d.setPekerjaananak1(pekerjaananak1);
            ds.d.setPekerjaananak2(pekerjaananak2);
            ds.d.setPekerjaananak3(pekerjaananak3);
            ds.d.setPekerjaananak4(pekerjaananak4);
            ds.d.setPekerjaananak5(pekerjaananak5);
            ds.d.setPekerjaananak6(pekerjaananak6);
            ds.d.setNamasekolah1(namasekolah1);
            ds.d.setNamasekolah2(namasekolah2);
            ds.d.setNamasekolah3(namasekolah3);
            ds.d.setNamasekolah4(namasekolah4);
            ds.d.setNamasekolah5(namasekolah5);
            ds.d.setNamasekolah6(namasekolah6);
            ds.d.setTahunlulussekolah1(tahunlulussekolah1);
            ds.d.setTahunlulussekolah2(tahunlulussekolah2);
            ds.d.setTahunlulussekolah3(tahunlulussekolah3);
            ds.d.setTahunlulussekolah4(tahunlulussekolah4);
            ds.d.setTahunlulussekolah5(tahunlulussekolah5);
            ds.d.setTahunlulussekolah6(tahunlulussekolah6);
            ds.d.setHobi(hobi);
            ds.d.setCatatankriminal1(catatankriminal1);
            ds.d.setCatatankriminal2(catatankriminal2);
            ds.d.setCatatankriminal3(catatankriminal3);

            if (ds.InsertTIK()) {
                output.println(true);
                String id = input.readLine();
                ds.InsertLog(id, "Menambahkan data TIK (" + ds.d.getNamalengkap() + ")", tanggaljamskrg);
            } else {
                output.println(false);
            }
        }
        if (jenisdata.equalsIgnoreCase("insertfoto")) {
            String namafoto = input.readLine();
            String noktp = input.readLine();
            System.out.println("Reading: " + System.currentTimeMillis());

            byte[] sizeAr = new byte[4];
            inputStream.read(sizeAr);
            int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

            byte[] imageAr = new byte[size];
            inputStream.read(imageAr);

            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

            System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
            ImageIO.write(image, "png", new File(System.getProperty("user.dir") + "\\src\\data\\foto\\" + namafoto));
            String urlfoto = System.getProperty("user.dir") + "\\src\\data\\foto\\" + namafoto;
            if (ds.InsertFOTOTIK(urlfoto, noktp)) {
                output.println(true);
                String id = input.readLine();
                ds.InsertLog(id, "Menambahkan foto milik " + ds.d.getNamalengkap(), tanggaljamskrg);
            } else {
                output.println(false);
            }
        }
        if (jenisdata.equalsIgnoreCase("updatefoto")) {
            String namafoto = input.readLine();
            String id = input.readLine();
            System.out.println("Reading: " + System.currentTimeMillis());

            byte[] sizeAr = new byte[4];
            inputStream.read(sizeAr);
            int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

            byte[] imageAr = new byte[size];
            inputStream.read(imageAr);

            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

            System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
            ImageIO.write(image, "png", new File(System.getProperty("user.dir") + "\\src\\data\\foto\\" + namafoto));
            String urlfoto = System.getProperty("user.dir") + "\\src\\data\\foto\\" + namafoto;
            if (ds.UpdateFOTOTIK(urlfoto, id)) {
                output.println(true);
                String idUser = input.readLine();
                ds.InsertLog(idUser, "Menambahkan foto milik " + ds.d.getNamalengkap(), tanggaljamskrg);
            } else {
                output.println(false);
            }
        }
        if (jenisdata.equalsIgnoreCase("ambildatalengkapbynamalengkap")) {
            String namalengkap = input.readLine();
            ds.AmbilDataTIKbyNama(namalengkap);

            output.println(ds.d.getId());
            output.println(ds.d.getNamalengkap());
            output.println(ds.d.getAlias());
            output.println(ds.d.getTglnoktp());
            output.println(ds.d.getTglnopasport());
            output.println(ds.d.getAgama());
            output.println(ds.d.getTgllahir());
            output.println(ds.d.getUmur());
            output.println(ds.d.getTempatlahir());
            output.println(ds.d.getAlamat());
            output.println(ds.d.getPerubahanalamat1());
            output.println(ds.d.getPerubahanalamat2());
            output.println(ds.d.getPerubahanalamat3());
            output.println(ds.d.getKedudukan());
            output.println(ds.d.getNamabapak());
            output.println(ds.d.getNamaibu());
            output.println(ds.d.getAlamatorgtua());
            output.println(ds.d.getPekerjaan());
            output.println(ds.d.getJabatan());
            output.println(ds.d.getInstansilembagakantor());
            output.println(ds.d.getNamaistri());
            output.println(ds.d.getUmuristri());
            output.println(ds.d.getPekerjaanistri());
            output.println(ds.d.getNamabapakistri());
            output.println(ds.d.getUmurbapakistri());
            output.println(ds.d.getPekerjaanbapakistri());
            output.println(ds.d.getNamaibuistri());
            output.println(ds.d.getUmuribuistri());
            output.println(ds.d.getPekerjaanibuistri());
            output.println(ds.d.getAlamatorgtuaistri());
            output.println(ds.d.getTanggungan());
            output.println(ds.d.getAlamattanggungan());
            output.println(ds.d.getRambut());
            output.println(ds.d.getMuka());
            output.println(ds.d.getKulit());
            output.println(ds.d.getTinggi());
            output.println(ds.d.getTandaistimewa());
            output.println(ds.d.getRumussidikjari());
            output.println(ds.d.getNamaanak1());
            output.println(ds.d.getNamaanak2());
            output.println(ds.d.getNamaanak3());
            output.println(ds.d.getNamaanak4());
            output.println(ds.d.getNamaanak5());
            output.println(ds.d.getNamaanak6());
            output.println(ds.d.getUmuranak1());
            output.println(ds.d.getUmuranak2());
            output.println(ds.d.getUmuranak3());
            output.println(ds.d.getUmuranak4());
            output.println(ds.d.getUmuranak5());
            output.println(ds.d.getUmuranak6());
            output.println(ds.d.getPekerjaananak1());
            output.println(ds.d.getPekerjaananak2());
            output.println(ds.d.getPekerjaananak3());
            output.println(ds.d.getPekerjaananak4());
            output.println(ds.d.getPekerjaananak5());
            output.println(ds.d.getPekerjaananak6());
            output.println(ds.d.getNamasekolah1());
            output.println(ds.d.getNamasekolah2());
            output.println(ds.d.getNamasekolah3());
            output.println(ds.d.getNamasekolah4());
            output.println(ds.d.getNamasekolah5());
            output.println(ds.d.getNamasekolah6());
            output.println(ds.d.getTahunlulussekolah1());
            output.println(ds.d.getTahunlulussekolah2());
            output.println(ds.d.getTahunlulussekolah3());
            output.println(ds.d.getTahunlulussekolah4());
            output.println(ds.d.getTahunlulussekolah5());
            output.println(ds.d.getTahunlulussekolah6());
            output.println(ds.d.getHobi());
            output.println(ds.d.getCatatankriminal1());
            output.println(ds.d.getCatatankriminal2());
            output.println(ds.d.getCatatankriminal3());

            System.out.println(ds.d.getUrlfoto());
            output.println(ds.d.getTglnoktp() + ds.d.getNamalengkap() + ".jpg");
            OutputStream outputStream = incoming.getOutputStream();

            BufferedImage image = ImageIO.read(new File(ds.d.getUrlfoto()));

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", byteArrayOutputStream);

            byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
            outputStream.write(size);
            outputStream.write(byteArrayOutputStream.toByteArray());
            outputStream.flush();
            System.out.println("Flushed: " + System.currentTimeMillis());

            System.out.println("Closing: " + System.currentTimeMillis());

        }
        if (jenisdata.equalsIgnoreCase("ambildatalengkapbyktp")) {
            String ktp = input.readLine();
            ds.AmbilDataTIKbyKTP(ktp);

            output.println(ds.d.getId());
            output.println(ds.d.getNamalengkap());
            output.println(ds.d.getAlias());
            output.println(ds.d.getTglnoktp());
            output.println(ds.d.getTglnopasport());
            output.println(ds.d.getAgama());
            output.println(ds.d.getTgllahir());
            output.println(ds.d.getUmur());
            output.println(ds.d.getTempatlahir());
            output.println(ds.d.getAlamat());
            output.println(ds.d.getPerubahanalamat1());
            output.println(ds.d.getPerubahanalamat2());
            output.println(ds.d.getPerubahanalamat3());
            output.println(ds.d.getKedudukan());
            output.println(ds.d.getNamabapak());
            output.println(ds.d.getNamaibu());
            output.println(ds.d.getAlamatorgtua());
            output.println(ds.d.getPekerjaan());
            output.println(ds.d.getJabatan());
            output.println(ds.d.getInstansilembagakantor());
            output.println(ds.d.getNamaistri());
            output.println(ds.d.getUmuristri());
            output.println(ds.d.getPekerjaanistri());
            output.println(ds.d.getNamabapakistri());
            output.println(ds.d.getUmurbapakistri());
            output.println(ds.d.getPekerjaanbapakistri());
            output.println(ds.d.getNamaibuistri());
            output.println(ds.d.getUmuribuistri());
            output.println(ds.d.getPekerjaanibuistri());
            output.println(ds.d.getAlamatorgtuaistri());
            output.println(ds.d.getTanggungan());
            output.println(ds.d.getAlamattanggungan());
            output.println(ds.d.getRambut());
            output.println(ds.d.getMuka());
            output.println(ds.d.getKulit());
            output.println(ds.d.getTinggi());
            output.println(ds.d.getTandaistimewa());
            output.println(ds.d.getRumussidikjari());
            output.println(ds.d.getNamaanak1());
            output.println(ds.d.getNamaanak2());
            output.println(ds.d.getNamaanak3());
            output.println(ds.d.getNamaanak4());
            output.println(ds.d.getNamaanak5());
            output.println(ds.d.getNamaanak6());
            output.println(ds.d.getUmuranak1());
            output.println(ds.d.getUmuranak2());
            output.println(ds.d.getUmuranak3());
            output.println(ds.d.getUmuranak4());
            output.println(ds.d.getUmuranak5());
            output.println(ds.d.getUmuranak6());
            output.println(ds.d.getPekerjaananak1());
            output.println(ds.d.getPekerjaananak2());
            output.println(ds.d.getPekerjaananak3());
            output.println(ds.d.getPekerjaananak4());
            output.println(ds.d.getPekerjaananak5());
            output.println(ds.d.getPekerjaananak6());
            output.println(ds.d.getNamasekolah1());
            output.println(ds.d.getNamasekolah2());
            output.println(ds.d.getNamasekolah3());
            output.println(ds.d.getNamasekolah4());
            output.println(ds.d.getNamasekolah5());
            output.println(ds.d.getNamasekolah6());
            output.println(ds.d.getTahunlulussekolah1());
            output.println(ds.d.getTahunlulussekolah2());
            output.println(ds.d.getTahunlulussekolah3());
            output.println(ds.d.getTahunlulussekolah4());
            output.println(ds.d.getTahunlulussekolah5());
            output.println(ds.d.getTahunlulussekolah6());
            output.println(ds.d.getHobi());
            output.println(ds.d.getCatatankriminal1());
            output.println(ds.d.getCatatankriminal2());
            output.println(ds.d.getCatatankriminal3());
            output.println(ds.d.getUrlfoto());
        }

        if (jenisdata.equalsIgnoreCase("updatetik")) {
            String id = input.readLine();
            String namalengkap = input.readLine();
            String alias = input.readLine();
            String noktp = input.readLine();
            String nopasport = input.readLine();
            String agama = input.readLine();
            String tgllahir = input.readLine();
            String umur = input.readLine();
            String tempatlahir = input.readLine();
            String alamat = input.readLine();
            String perubahanalamat1 = input.readLine();
            String perubahanalamat2 = input.readLine();
            String perubahanalamat3 = input.readLine();
            String kedudukan = input.readLine();
            String namabapak = input.readLine();
            String namaibu = input.readLine();
            String alamatorangtua = input.readLine();
            String pekerjaan = input.readLine();
            String jabatan = input.readLine();
            String instansi = input.readLine();
            String namaistri = input.readLine();
            String umuristri = input.readLine();
            String pekerjaanistri = input.readLine();
            String namabapakistri = input.readLine();
            String umurbapakistri = input.readLine();
            String pekerjaanbapakistri = input.readLine();
            String namaibuistri = input.readLine();
            String umuribuistri = input.readLine();
            String pekerjaanibuistri = input.readLine();
            String alamatorangtuaistri = input.readLine();
            String tanggungan = input.readLine();
            String alamattanggungan = input.readLine();
            String namaanak1 = input.readLine();
            String namaanak2 = input.readLine();
            String namaanak3 = input.readLine();
            String namaanak4 = input.readLine();
            String namaanak5 = input.readLine();
            String namaanak6 = input.readLine();
            String umuranak1 = input.readLine();
            String umuranak2 = input.readLine();
            String umuranak3 = input.readLine();
            String umuranak4 = input.readLine();
            String umuranak5 = input.readLine();
            String umuranak6 = input.readLine();
            String pekerjaananak1 = input.readLine();
            String pekerjaananak2 = input.readLine();
            String pekerjaananak3 = input.readLine();
            String pekerjaananak4 = input.readLine();
            String pekerjaananak5 = input.readLine();
            String pekerjaananak6 = input.readLine();
            String rambut = input.readLine();
            String muka = input.readLine();
            String kulit = input.readLine();
            String tinggi = input.readLine();
            String tandaistimewa = input.readLine();
            String rumussidikjari = input.readLine();
            String namasekolah1 = input.readLine();
            String namasekolah2 = input.readLine();
            String namasekolah3 = input.readLine();
            String namasekolah4 = input.readLine();
            String namasekolah5 = input.readLine();
            String namasekolah6 = input.readLine();
            String tahunlulussekolah1 = input.readLine();
            String tahunlulussekolah2 = input.readLine();
            String tahunlulussekolah3 = input.readLine();
            String tahunlulussekolah4 = input.readLine();
            String tahunlulussekolah5 = input.readLine();
            String tahunlulussekolah6 = input.readLine();
            String hobi = input.readLine();
            String catatankriminal1 = input.readLine();
            String catatankriminal2 = input.readLine();
            String catatankriminal3 = input.readLine();

            ds.d.setNamalengkap(namalengkap);
            ds.d.setAlias(alias);
            ds.d.setTglnoktp(noktp);
            ds.d.setTglnopasport(nopasport);
            ds.d.setAgama(agama);
            ds.d.setTgllahir(tgllahir);
            ds.d.setUmur(umur);
            ds.d.setTempatlahir(tempatlahir);
            ds.d.setAlamat(alamat);
            ds.d.setPerubahanalamat1(perubahanalamat1);
            ds.d.setPerubahanalamat2(perubahanalamat2);
            ds.d.setPerubahanalamat3(perubahanalamat3);
            ds.d.setKedudukan(kedudukan);
            ds.d.setNamabapak(namabapak);
            ds.d.setNamaibu(namaibu);
            ds.d.setAlamatorgtua(alamatorangtua);
            ds.d.setPekerjaan(pekerjaan);
            ds.d.setJabatan(jabatan);
            ds.d.setInstansilembagakantor(instansi);
            ds.d.setNamaistri(namaistri);
            ds.d.setUmuristri(umuristri);
            ds.d.setPekerjaanistri(pekerjaanistri);
            ds.d.setNamabapakistri(namabapakistri);
            ds.d.setUmurbapakistri(umurbapakistri);
            ds.d.setPekerjaanbapakistri(pekerjaanbapakistri);
            ds.d.setNamaibuistri(namaibuistri);
            ds.d.setUmuribuistri(umuribuistri);
            ds.d.setPekerjaanibuistri(pekerjaanibuistri);
            ds.d.setAlamatorgtuaistri(alamatorangtuaistri);
            ds.d.setTanggungan(tanggungan);
            ds.d.setAlamattanggungan(alamattanggungan);
            ds.d.setRambut(rambut);
            ds.d.setMuka(muka);
            ds.d.setKulit(kulit);
            ds.d.setTinggi(tinggi);
            ds.d.setTandaistimewa(tandaistimewa);
            ds.d.setRumussidikjari(rumussidikjari);
            ds.d.setNamaanak1(namaanak1);
            ds.d.setNamaanak2(namaanak2);
            ds.d.setNamaanak3(namaanak3);
            ds.d.setNamaanak4(namaanak4);
            ds.d.setNamaanak5(namaanak5);
            ds.d.setNamaanak6(namaanak6);
            ds.d.setUmuranak1(umuranak1);
            ds.d.setUmuranak2(umuranak2);
            ds.d.setUmuranak3(umuranak3);
            ds.d.setUmuranak4(umuranak4);
            ds.d.setUmuranak5(umuranak5);
            ds.d.setUmuranak6(umuranak6);
            ds.d.setPekerjaananak1(pekerjaananak1);
            ds.d.setPekerjaananak2(pekerjaananak2);
            ds.d.setPekerjaananak3(pekerjaananak3);
            ds.d.setPekerjaananak4(pekerjaananak4);
            ds.d.setPekerjaananak5(pekerjaananak5);
            ds.d.setPekerjaananak6(pekerjaananak6);
            ds.d.setNamasekolah1(namasekolah1);
            ds.d.setNamasekolah2(namasekolah2);
            ds.d.setNamasekolah3(namasekolah3);
            ds.d.setNamasekolah4(namasekolah4);
            ds.d.setNamasekolah5(namasekolah5);
            ds.d.setNamasekolah6(namasekolah6);
            ds.d.setTahunlulussekolah1(tahunlulussekolah1);
            ds.d.setTahunlulussekolah2(tahunlulussekolah2);
            ds.d.setTahunlulussekolah3(tahunlulussekolah3);
            ds.d.setTahunlulussekolah4(tahunlulussekolah4);
            ds.d.setTahunlulussekolah5(tahunlulussekolah5);
            ds.d.setTahunlulussekolah6(tahunlulussekolah6);
            ds.d.setHobi(hobi);
            ds.d.setCatatankriminal1(catatankriminal1);
            ds.d.setCatatankriminal2(catatankriminal2);
            ds.d.setCatatankriminal3(catatankriminal3);

            if (ds.UpdateTIK(id)) {
                output.println(true);
                String idUser = input.readLine();
                ds.InsertLog(idUser, "Merubah data milik " + ds.d.getNamalengkap(), tanggaljamskrg);
            } else {
                output.println(false);
            }

        }
        if (jenisdata.equalsIgnoreCase("deleteTIK")) {
            String namalengkap = input.readLine();
            if (ds.DeleteTIK(namalengkap)) {
                output.println(true);
                String idUser = input.readLine();
                ds.InsertLog(idUser, "Menghapus data milik " + namalengkap, tanggaljamskrg);
            } else {
                output.println(false);
            }
        }
        if (jenisdata.equalsIgnoreCase("ambildataTIKbyKTP")) {
            String ktp = input.readLine();
            if (ds.AmbilDataTIKbyKTP(ktp)) {
                output.println(true);
                output.println(ds.d.getId());
                output.println(ds.d.getNamalengkap());
                output.println(ds.d.getAlias());
                output.println(ds.d.getTglnoktp());
                output.println(ds.d.getAgama());
                output.println(ds.d.getTgllahir());
                output.println(ds.d.getTempatlahir());

                System.out.println(ds.d.getUrlfoto());
                output.println(ds.d.getTglnoktp() + ds.d.getNamalengkap() + ".jpg");
                OutputStream outputStream = incoming.getOutputStream();

                BufferedImage image = ImageIO.read(new File(ds.d.getUrlfoto()));

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ImageIO.write(image, "jpg", byteArrayOutputStream);

                byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
                outputStream.write(size);
                outputStream.write(byteArrayOutputStream.toByteArray());
                outputStream.flush();
                System.out.println("Flushed: " + System.currentTimeMillis());

                System.out.println("Closing: " + System.currentTimeMillis());
            } else {
                output.println(false);
            }
        }
        if (jenisdata.equalsIgnoreCase("printdatatik")) {
            String namalengkap = input.readLine();
            ds.AmbilDataTIKbyNama(namalengkap);

            iText i = new iText();
            i.setNamalengkap(ds.d.getNamalengkap());
            i.setAlias(ds.d.getAlias());
            i.setTglnoktp(ds.d.getTglnoktp());
            i.setTglnopasport(ds.d.getTglnopasport());
            i.setAgama(ds.d.getAgama());
            i.setTgllahir(ds.d.getTgllahir());
            i.setUmur(ds.d.getUmur());
            i.setTempatlahir(ds.d.getTempatlahir());
            i.setAlamat(ds.d.getAlamat());
            i.setPerubahanalamat1(ds.d.getPerubahanalamat1());
            i.setPerubahanalamat2(ds.d.getPerubahanalamat2());
            i.setPerubahanalamat3(ds.d.getPerubahanalamat3());
            i.setKedudukan(ds.d.getKedudukan());
            i.setNamabapak(ds.d.getNamabapak());
            i.setNamaibu(ds.d.getNamaibu());
            i.setAlamatorgtua(ds.d.getAlamatorgtua());
            i.setPekerjaan(ds.d.getPekerjaan());
            i.setJabatan(ds.d.getJabatan());
            i.setInstansilembagakantor(ds.d.getInstansilembagakantor());
            i.setNamaistri(ds.d.getNamaistri());
            i.setUmuristri(ds.d.getUmuristri());
            i.setPekerjaanistri(ds.d.getPekerjaanistri());
            i.setNamabapakistri(ds.d.getNamabapakistri());
            i.setUmurbapakistri(ds.d.getUmurbapakistri());
            i.setPekerjaanbapakistri(ds.d.getPekerjaanbapakistri());
            i.setNamaibuistri(ds.d.getNamaibuistri());
            i.setUmuribuistri(ds.d.getUmuribuistri());
            i.setPekerjaanibuistri(ds.d.getPekerjaanibuistri());
            i.setAlamatorgtuaistri(ds.d.getAlamatorgtuaistri());
            i.setTanggungan(ds.d.getTanggungan());
            i.setAlamattanggungan(ds.d.getAlamattanggungan());
            i.setRambut(ds.d.getRambut());
            i.setMuka(ds.d.getMuka());
            i.setKulit(ds.d.getKulit());
            i.setTinggi(ds.d.getTinggi());
            i.setTandaistimewa(ds.d.getTandaistimewa());
            i.setRumussidikjari(ds.d.getRumussidikjari());
            i.setNamaanak1(ds.d.getNamaanak1());
            i.setNamaanak2(ds.d.getNamaanak2());
            i.setNamaanak3(ds.d.getNamaanak3());
            i.setNamaanak4(ds.d.getNamaanak4());
            i.setNamaanak5(ds.d.getNamaanak5());
            i.setNamaanak6(ds.d.getNamaanak6());
            i.setUmuranak1(ds.d.getUmuranak1());
            i.setUmuranak2(ds.d.getUmuranak2());
            i.setUmuranak3(ds.d.getUmuranak3());
            i.setUmuranak4(ds.d.getUmuranak4());
            i.setUmuranak5(ds.d.getUmuranak5());
            i.setUmuranak6(ds.d.getUmuranak6());
            i.setPekerjaananak1(ds.d.getPekerjaananak1());
            i.setPekerjaananak2(ds.d.getPekerjaananak2());
            i.setPekerjaananak3(ds.d.getPekerjaananak3());
            i.setPekerjaananak4(ds.d.getPekerjaananak4());
            i.setPekerjaananak5(ds.d.getPekerjaananak5());
            i.setPekerjaananak6(ds.d.getPekerjaananak6());
            i.setNamasekolah1(ds.d.getNamasekolah1());
            i.setNamasekolah2(ds.d.getNamasekolah2());
            i.setNamasekolah3(ds.d.getNamasekolah3());
            i.setNamasekolah4(ds.d.getNamasekolah4());
            i.setNamasekolah5(ds.d.getNamasekolah5());
            i.setNamasekolah6(ds.d.getNamasekolah6());
            i.setTahunlulussekolah1(ds.d.getTahunlulussekolah1());
            i.setTahunlulussekolah2(ds.d.getTahunlulussekolah2());
            i.setTahunlulussekolah3(ds.d.getTahunlulussekolah3());
            i.setTahunlulussekolah4(ds.d.getTahunlulussekolah4());
            i.setTahunlulussekolah5(ds.d.getTahunlulussekolah5());
            i.setTahunlulussekolah6(ds.d.getTahunlulussekolah6());
            i.setHobi(ds.d.getHobi());
            i.setCatatankriminal1(ds.d.getCatatankriminal1());
            i.setCatatankriminal2(ds.d.getCatatankriminal2());
            i.setCatatankriminal3(ds.d.getCatatankriminal3());
            i.setUrlfoto(ds.d.getUrlfoto());
            ArrayList<Kegiatan> list = new ArrayList<>(ds.AmbilDataKegiatan(ds.d.getId()));
            String url = i.createPDF(tanggalskrg, list);
            try {
                FileInputStream fis = new FileInputStream(url);
                classPrint p = new classPrint(fis, "Print TIK (" + i.getNamalengkap() + ")");
                p.print();
                output.println(true);

                String idUser = input.readLine();
                ds.InsertLog(idUser, "Meminta Print TIK (" + ds.d.getTglnoktp() + "," + ds.d.getNamalengkap() + ")", tanggaljamskrg);
            } catch (PrinterException e) {
                output.println(false);
            }
        }
        if (jenisdata.equalsIgnoreCase("insertkegiatan")) {
            String noktp = input.readLine();
            String kegiatan = input.readLine();
            String waktu = input.readLine();
            String nama = input.readLine();
            if (ds.InsertKegiatan(noktp, kegiatan, waktu)) {
                output.println(true);
                String idUser = input.readLine();
                ds.InsertLog(idUser, "Menambah kegiatan (" + kegiatan + ") untuk " + nama, tanggaljamskrg);
            } else {
                output.println(false);
            }
        }
        if (jenisdata.equalsIgnoreCase("gantinama")) {
            String namabaru, id;
            namabaru = input.readLine();
            id = input.readLine();
            if (ds.UpdateNama(id, namabaru)) {
                output.println(true);
            } else {
                output.println(false);
            }
        }
        if (jenisdata.equalsIgnoreCase("cekpassword")) {
            String passwordlama, id;
            passwordlama = DigestUtils.md5Hex(input.readLine());
            id = input.readLine();
            if (ds.CekPasswordLama(id, passwordlama)) {
                output.println(true);
            } else {
                output.println(false);
            }
        }
        if (jenisdata.equalsIgnoreCase("gantipassword")) {
            String passwordbaru, id;
            passwordbaru = DigestUtils.md5Hex(input.readLine());
            id = input.readLine();
            if (ds.UpdatePassword(id, passwordbaru)) {
                output.println(true);
            } else {
                output.println(false);
            }
        }
        if (jenisdata.equalsIgnoreCase("datahakakses")) {
            String noinduk = input.readLine();
            if (ds.AmbilDataHakAkses(noinduk) == "") {
                output.println(false);
            } else {
                output.println(true);
                output.println(ds.AmbilDataHakAkses(noinduk));
            }
        }
        if (jenisdata.equalsIgnoreCase("ubahhakakses")) {
            String noinduk = input.readLine();
            String jenis = input.readLine();
            if (ds.UpdateHakAkses(noinduk, jenis)) {
                output.println(true);
                String idUser = input.readLine();
                if (jenis.equalsIgnoreCase("beri")) {
                    ds.InsertLog(idUser, "Memberi hak akses spesial kepada no induk " + noinduk, tanggaljamskrg);
                } else {
                    ds.InsertLog(idUser, "Mencabut hak akses spesial no induk " + noinduk, tanggaljamskrg);
                }
            } else {
                output.println(false);
            }
        }
        if (jenisdata.equalsIgnoreCase("logout")) {
            String id = input.readLine();
            ds.InsertLog(id, "Keluar dari sistem", tanggaljamskrg);
        }

        if (jenisdata.equalsIgnoreCase("ambilnamabyktp")) {
            String ktp = input.readLine();
            output.println(ds.AmbilNamaByKTP(ktp));
        }
    }
}
