/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.kartu.tik;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
                Thread.sleep(5000);
            }
        } catch (IOException ex) {
            System.out.println("Server sudah dibuka.");
        }
    }

    private static void handleSocket(Socket incoming) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        Date date = new Date();
        String haritanggalskrg = sdf.format(date);
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
            } else {
                output.println(false);
            }
        }
        if (jenisdata.equalsIgnoreCase("menulog")) {
            ArrayList<Log> list = new ArrayList<>(ds.Ambil10DataLogMenuAdmin());
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
            
            ds.InsertTIK();
            System.out.println(ds.d.getNamalengkap());
            output.println(true);
        }
        if (jenisdata.equalsIgnoreCase("foto")) {
            String nama = input.readLine();

            System.out.println("Reading: " + System.currentTimeMillis());

            byte[] sizeAr = new byte[4];
            inputStream.read(sizeAr);
            int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

            byte[] imageAr = new byte[size];
            inputStream.read(imageAr);

            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

            System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
            ImageIO.write(image, "png", new File(System.getProperty("user.dir") + "\\src\\data\\foto\\" + nama));

        }
    }
}
