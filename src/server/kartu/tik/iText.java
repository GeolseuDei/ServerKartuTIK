/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.kartu.tik;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author GeolseuDei
 */
public class iText {

    private String id;
    private String namalengkap;
    private String alias;
    private String tglnoktp;
    private String tglnopasport;
    private String agama;
    private String tgllahir;
    private String umur;
    private String tempatlahir;
    private String alamat;
    private String perubahanalamat1;
    private String perubahanalamat2;
    private String perubahanalamat3;
    private String kedudukan;
    private String namabapak;
    private String namaibu;
    private String alamatorgtua;
    private String pekerjaan;
    private String jabatan;
    private String instansilembagakantor;
    private String namaistri;
    private String umuristri;
    private String pekerjaanistri;
    private String namabapakistri;
    private String umurbapakistri;
    private String pekerjaanbapakistri;
    private String namaibuistri;
    private String umuribuistri;
    private String pekerjaanibuistri;
    private String alamatorgtuaistri;
    private String tanggungan;
    private String alamattanggungan;
    private String namaanak1;
    private String umuranak1;
    private String pekerjaananak1;
    private String namaanak2;
    private String umuranak2;
    private String pekerjaananak2;
    private String namaanak3;
    private String umuranak3;
    private String pekerjaananak3;
    private String namaanak4;
    private String umuranak4;
    private String pekerjaananak4;
    private String namaanak5;
    private String umuranak5;
    private String pekerjaananak5;
    private String namaanak6;
    private String umuranak6;
    private String pekerjaananak6;
    private String rambut;
    private String muka;
    private String kulit;
    private String tinggi;
    private String tandaistimewa;
    private String rumussidikjari;
    private String namasekolah1;
    private String tahunlulussekolah1;
    private String namasekolah2;
    private String tahunlulussekolah2;
    private String namasekolah3;
    private String tahunlulussekolah3;
    private String namasekolah4;
    private String tahunlulussekolah4;
    private String namasekolah5;
    private String tahunlulussekolah5;
    private String namasekolah6;
    private String tahunlulussekolah6;
    private String hobi;
    private String catatankriminal1;
    private String catatankriminal2;
    private String catatankriminal3;
    private String urlfoto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTglnoktp() {
        return tglnoktp;
    }

    public void setTglnoktp(String tglnoktp) {
        this.tglnoktp = tglnoktp;
    }

    public String getTglnopasport() {
        return tglnopasport;
    }

    public void setTglnopasport(String tglnopasport) {
        this.tglnopasport = tglnopasport;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(String tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getTempatlahir() {
        return tempatlahir;
    }

    public void setTempatlahir(String tempatlahir) {
        this.tempatlahir = tempatlahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPerubahanalamat1() {
        return perubahanalamat1;
    }

    public void setPerubahanalamat1(String perubahanalamat1) {
        this.perubahanalamat1 = perubahanalamat1;
    }

    public String getPerubahanalamat2() {
        return perubahanalamat2;
    }

    public void setPerubahanalamat2(String perubahanalamat2) {
        this.perubahanalamat2 = perubahanalamat2;
    }

    public String getPerubahanalamat3() {
        return perubahanalamat3;
    }

    public void setPerubahanalamat3(String perubahanalamat3) {
        this.perubahanalamat3 = perubahanalamat3;
    }

    public String getKedudukan() {
        return kedudukan;
    }

    public void setKedudukan(String kedudukan) {
        this.kedudukan = kedudukan;
    }

    public String getNamabapak() {
        return namabapak;
    }

    public void setNamabapak(String namabapak) {
        this.namabapak = namabapak;
    }

    public String getNamaibu() {
        return namaibu;
    }

    public void setNamaibu(String namaibu) {
        this.namaibu = namaibu;
    }

    public String getAlamatorgtua() {
        return alamatorgtua;
    }

    public void setAlamatorgtua(String alamatorgtua) {
        this.alamatorgtua = alamatorgtua;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getInstansilembagakantor() {
        return instansilembagakantor;
    }

    public void setInstansilembagakantor(String instansilembagakantor) {
        this.instansilembagakantor = instansilembagakantor;
    }

    public String getNamaistri() {
        return namaistri;
    }

    public void setNamaistri(String namaistri) {
        this.namaistri = namaistri;
    }

    public String getUmuristri() {
        return umuristri;
    }

    public void setUmuristri(String umuristri) {
        this.umuristri = umuristri;
    }

    public String getPekerjaanistri() {
        return pekerjaanistri;
    }

    public void setPekerjaanistri(String pekerjaanistri) {
        this.pekerjaanistri = pekerjaanistri;
    }

    public String getNamabapakistri() {
        return namabapakistri;
    }

    public void setNamabapakistri(String namabapakistri) {
        this.namabapakistri = namabapakistri;
    }

    public String getUmurbapakistri() {
        return umurbapakistri;
    }

    public void setUmurbapakistri(String umurbapakistri) {
        this.umurbapakistri = umurbapakistri;
    }

    public String getPekerjaanbapakistri() {
        return pekerjaanbapakistri;
    }

    public void setPekerjaanbapakistri(String pekerjaanbapakistri) {
        this.pekerjaanbapakistri = pekerjaanbapakistri;
    }

    public String getNamaibuistri() {
        return namaibuistri;
    }

    public void setNamaibuistri(String namaibuistri) {
        this.namaibuistri = namaibuistri;
    }

    public String getUmuribuistri() {
        return umuribuistri;
    }

    public void setUmuribuistri(String umuribuistri) {
        this.umuribuistri = umuribuistri;
    }

    public String getPekerjaanibuistri() {
        return pekerjaanibuistri;
    }

    public void setPekerjaanibuistri(String pekerjaanibuistri) {
        this.pekerjaanibuistri = pekerjaanibuistri;
    }

    public String getAlamatorgtuaistri() {
        return alamatorgtuaistri;
    }

    public void setAlamatorgtuaistri(String alamatorgtuaistri) {
        this.alamatorgtuaistri = alamatorgtuaistri;
    }

    public String getTanggungan() {
        return tanggungan;
    }

    public void setTanggungan(String tanggungan) {
        this.tanggungan = tanggungan;
    }

    public String getAlamattanggungan() {
        return alamattanggungan;
    }

    public void setAlamattanggungan(String alamattanggungan) {
        this.alamattanggungan = alamattanggungan;
    }

    public String getNamaanak1() {
        return namaanak1;
    }

    public void setNamaanak1(String namaanak1) {
        this.namaanak1 = namaanak1;
    }

    public String getUmuranak1() {
        return umuranak1;
    }

    public void setUmuranak1(String umuranak1) {
        this.umuranak1 = umuranak1;
    }

    public String getPekerjaananak1() {
        return pekerjaananak1;
    }

    public void setPekerjaananak1(String pekerjaananak1) {
        this.pekerjaananak1 = pekerjaananak1;
    }

    public String getNamaanak2() {
        return namaanak2;
    }

    public void setNamaanak2(String namaanak2) {
        this.namaanak2 = namaanak2;
    }

    public String getUmuranak2() {
        return umuranak2;
    }

    public void setUmuranak2(String umuranak2) {
        this.umuranak2 = umuranak2;
    }

    public String getPekerjaananak2() {
        return pekerjaananak2;
    }

    public void setPekerjaananak2(String pekerjaananak2) {
        this.pekerjaananak2 = pekerjaananak2;
    }

    public String getNamaanak3() {
        return namaanak3;
    }

    public void setNamaanak3(String namaanak3) {
        this.namaanak3 = namaanak3;
    }

    public String getUmuranak3() {
        return umuranak3;
    }

    public void setUmuranak3(String umuranak3) {
        this.umuranak3 = umuranak3;
    }

    public String getPekerjaananak3() {
        return pekerjaananak3;
    }

    public void setPekerjaananak3(String pekerjaananak3) {
        this.pekerjaananak3 = pekerjaananak3;
    }

    public String getNamaanak4() {
        return namaanak4;
    }

    public void setNamaanak4(String namaanak4) {
        this.namaanak4 = namaanak4;
    }

    public String getUmuranak4() {
        return umuranak4;
    }

    public void setUmuranak4(String umuranak4) {
        this.umuranak4 = umuranak4;
    }

    public String getPekerjaananak4() {
        return pekerjaananak4;
    }

    public void setPekerjaananak4(String pekerjaananak4) {
        this.pekerjaananak4 = pekerjaananak4;
    }

    public String getNamaanak5() {
        return namaanak5;
    }

    public void setNamaanak5(String namaanak5) {
        this.namaanak5 = namaanak5;
    }

    public String getUmuranak5() {
        return umuranak5;
    }

    public void setUmuranak5(String umuranak5) {
        this.umuranak5 = umuranak5;
    }

    public String getPekerjaananak5() {
        return pekerjaananak5;
    }

    public void setPekerjaananak5(String pekerjaananak5) {
        this.pekerjaananak5 = pekerjaananak5;
    }

    public String getNamaanak6() {
        return namaanak6;
    }

    public void setNamaanak6(String namaanak6) {
        this.namaanak6 = namaanak6;
    }

    public String getUmuranak6() {
        return umuranak6;
    }

    public void setUmuranak6(String umuranak6) {
        this.umuranak6 = umuranak6;
    }

    public String getPekerjaananak6() {
        return pekerjaananak6;
    }

    public void setPekerjaananak6(String pekerjaananak6) {
        this.pekerjaananak6 = pekerjaananak6;
    }

    public String getRambut() {
        return rambut;
    }

    public void setRambut(String rambut) {
        this.rambut = rambut;
    }

    public String getMuka() {
        return muka;
    }

    public void setMuka(String muka) {
        this.muka = muka;
    }

    public String getKulit() {
        return kulit;
    }

    public void setKulit(String kulit) {
        this.kulit = kulit;
    }

    public String getTinggi() {
        return tinggi;
    }

    public void setTinggi(String tinggi) {
        this.tinggi = tinggi;
    }

    public String getTandaistimewa() {
        return tandaistimewa;
    }

    public void setTandaistimewa(String tandaistimewa) {
        this.tandaistimewa = tandaistimewa;
    }

    public String getRumussidikjari() {
        return rumussidikjari;
    }

    public void setRumussidikjari(String rumussidikjari) {
        this.rumussidikjari = rumussidikjari;
    }

    public String getNamasekolah1() {
        return namasekolah1;
    }

    public void setNamasekolah1(String namasekolah1) {
        this.namasekolah1 = namasekolah1;
    }

    public String getTahunlulussekolah1() {
        return tahunlulussekolah1;
    }

    public void setTahunlulussekolah1(String tahunlulussekolah1) {
        this.tahunlulussekolah1 = tahunlulussekolah1;
    }

    public String getNamasekolah2() {
        return namasekolah2;
    }

    public void setNamasekolah2(String namasekolah2) {
        this.namasekolah2 = namasekolah2;
    }

    public String getTahunlulussekolah2() {
        return tahunlulussekolah2;
    }

    public void setTahunlulussekolah2(String tahunlulussekolah2) {
        this.tahunlulussekolah2 = tahunlulussekolah2;
    }

    public String getNamasekolah3() {
        return namasekolah3;
    }

    public void setNamasekolah3(String namasekolah3) {
        this.namasekolah3 = namasekolah3;
    }

    public String getTahunlulussekolah3() {
        return tahunlulussekolah3;
    }

    public void setTahunlulussekolah3(String tahunlulussekolah3) {
        this.tahunlulussekolah3 = tahunlulussekolah3;
    }

    public String getNamasekolah4() {
        return namasekolah4;
    }

    public void setNamasekolah4(String namasekolah4) {
        this.namasekolah4 = namasekolah4;
    }

    public String getTahunlulussekolah4() {
        return tahunlulussekolah4;
    }

    public void setTahunlulussekolah4(String tahunlulussekolah4) {
        this.tahunlulussekolah4 = tahunlulussekolah4;
    }

    public String getNamasekolah5() {
        return namasekolah5;
    }

    public void setNamasekolah5(String namasekolah5) {
        this.namasekolah5 = namasekolah5;
    }

    public String getTahunlulussekolah5() {
        return tahunlulussekolah5;
    }

    public void setTahunlulussekolah5(String tahunlulussekolah5) {
        this.tahunlulussekolah5 = tahunlulussekolah5;
    }

    public String getNamasekolah6() {
        return namasekolah6;
    }

    public void setNamasekolah6(String namasekolah6) {
        this.namasekolah6 = namasekolah6;
    }

    public String getTahunlulussekolah6() {
        return tahunlulussekolah6;
    }

    public void setTahunlulussekolah6(String tahunlulussekolah6) {
        this.tahunlulussekolah6 = tahunlulussekolah6;
    }

    public String getHobi() {
        return hobi;
    }

    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

    public String getCatatankriminal1() {
        return catatankriminal1;
    }

    public void setCatatankriminal1(String catatankriminal1) {
        this.catatankriminal1 = catatankriminal1;
    }

    public String getCatatankriminal2() {
        return catatankriminal2;
    }

    public void setCatatankriminal2(String catatankriminal2) {
        this.catatankriminal2 = catatankriminal2;
    }

    public String getCatatankriminal3() {
        return catatankriminal3;
    }

    public void setCatatankriminal3(String catatankriminal3) {
        this.catatankriminal3 = catatankriminal3;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }

    public String createPDF(String tanggal, ArrayList kegiatan) {
        ArrayList<Kegiatan> list = new ArrayList<>(kegiatan);

        String output = System.getProperty("user.dir") + "\\src\\data\\pdf\\" + tanggal + " " + getNamalengkap() + "-" + getTglnoktp() + ".pdf";
        Document document = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(document,
                    new FileOutputStream(output));

            document.open();

            //------------------------------------------------------------------------------------- TITLE
            PdfPTable title = new PdfPTable(1);
            title.setWidthPercentage(100);
            Font f = new Font(FontFamily.HELVETICA, 14, Font.NORMAL, GrayColor.GRAYWHITE);
            PdfPCell celltitle = new PdfPCell(new Phrase("KARTU TIK", f));
            celltitle.setMinimumHeight(20);
            celltitle.setBackgroundColor(GrayColor.GRAYBLACK);
            celltitle.setHorizontalAlignment(Element.ALIGN_CENTER);
            celltitle.setColspan(3);
            title.addCell(celltitle);
            document.add(title);
            //-------------------------------------------------------------------------------------- END

            //------------------------------------------------------------------------------------- NAMA + ALIAS
            float[] columnWidths = {8, 2};
            PdfPTable tabel1 = new PdfPTable(columnWidths);
            tabel1.setWidthPercentage(100);

            PdfPTable innerTable1 = new PdfPTable(1);
            innerTable1.setWidthPercentage(100);
            PdfPTable innerTable2 = new PdfPTable(1);
            innerTable2.setWidthPercentage(100);
            PdfPCell cell;
            innerTable1.addCell("1.  a. Nama Lengkap : " + getNamalengkap() + " \n\n     b. Alias : " + getAlias() + " \n\n");
            innerTable1.addCell("2.  Kebangsaan \n     a. Tgl. No. KTP : " + getTglnoktp() + " \n\n     b. Tgl. No. Pasport : " + getTglnopasport() + "\n\n");
            innerTable1.addCell("3.  Agama : " + getAgama());
            cell = new PdfPCell(innerTable1);
            cell.setMinimumHeight(135);
            tabel1.addCell(cell);
            Image image = Image.getInstance(getUrlfoto());
            cell = new PdfPCell(image, false);
            if (image.getWidth() < 90) {
                cell.setPaddingLeft(8);
            } else {
                cell.setPaddingLeft(3);
            }
            cell.setMinimumHeight(135);
            tabel1.addCell(cell);
            cell = new PdfPCell();
            cell.setColspan(14);
            tabel1.addCell(cell);

            document.add(tabel1);
            //------------------------------------------------------------------------------------- NAMA + ALIAS END

            //------------------------------------------------------------------------------------- TGL LAHIR + TEMPAT
            PdfPTable tabel4 = new PdfPTable(1);
            tabel4.setWidthPercentage(100);

            Paragraph pTglLahirnTempat = new Paragraph();
            pTglLahirnTempat.add("4.  a. Tgl. Lahir/ Umur : " + getTgllahir());
            pTglLahirnTempat.add("\n\n     b. Tempat Lahir     : " + getTempatlahir());
            pTglLahirnTempat.setLeading(0, 1);

            PdfPCell cTglLahirnTempat = new PdfPCell();
            cTglLahirnTempat.setMinimumHeight(45);
            cTglLahirnTempat.addElement(pTglLahirnTempat);
            tabel4.addCell(cTglLahirnTempat);

            document.add(tabel4);
            //------------------------------------------------------------------------------------- TGL LAHIR + TEMPAT END

            //------------------------------------------------------------------------------------- ALAMAT + PINDAHAN
            PdfPTable tabel5 = new PdfPTable(2);
            tabel5.setWidthPercentage(100);

            Paragraph pAlamat = new Paragraph();
            pAlamat.add("5.  Alamat : \n     ");
            pAlamat.add(getAlamat());
            pAlamat.setLeading(0, 1);

            PdfPCell cAlamat = new PdfPCell();
            cAlamat.setMinimumHeight(30);
            cAlamat.addElement(pAlamat);
            tabel5.addCell(cAlamat);

            Paragraph pAlamatUbah = new Paragraph();
            pAlamatUbah.add("6.  Perubahan Alamat :");
            pAlamatUbah.add("\n\n    1. " + getPerubahanalamat1());
            pAlamatUbah.add("\n\n    2. " + getPerubahanalamat2());
            pAlamatUbah.add("\n\n    3. " + getPerubahanalamat3());
            pAlamatUbah.add("\n\n");
            pAlamatUbah.setLeading(0, 1);

            PdfPCell cAlamatUbah = new PdfPCell();
            cAlamatUbah.setMinimumHeight(30);
            cAlamatUbah.addElement(pAlamatUbah);
            tabel5.addCell(cAlamatUbah);

            document.add(tabel5);
            //------------------------------------------------------------------------------------- ALAMAT + PINDAHAN END

            //------------------------------------------------------------------------------------- KEDUDUKAN KELUARGA
            PdfPTable tabel6 = new PdfPTable(2);
            tabel6.setWidthPercentage(100);

            Paragraph pKedudukanKeluarga = new Paragraph();
            pKedudukanKeluarga.add("7.  Kedudukan dalam Keluarga : \n     " + getKedudukan());
            pKedudukanKeluarga.setLeading(0, 1);

            PdfPCell cKedudukanKeluarga = new PdfPCell();
            cKedudukanKeluarga.setMinimumHeight(70);
            cKedudukanKeluarga.addElement(pKedudukanKeluarga);
            tabel6.addCell(cKedudukanKeluarga);

            Paragraph pNamaBapakIbu = new Paragraph();
            pNamaBapakIbu.add("8.  a.  Nama Bapak : " + getNamabapak());
            pNamaBapakIbu.add("\n\n          Nama Ibu      : " + getNamaibu());
            pNamaBapakIbu.add("\n\n     b.  Alamat : " + getAlamatorgtua());
            pNamaBapakIbu.setLeading(0, 1);

            PdfPCell cNamaBapakIbu = new PdfPCell();
            cNamaBapakIbu.setMinimumHeight(70);
            cNamaBapakIbu.addElement(pNamaBapakIbu);
            tabel6.addCell(cNamaBapakIbu);

            document.add(tabel6);
            //------------------------------------------------------------------------------------- KEDUDUKAN END

            //------------------------------------------------------------------------------------- PEKERJAAN
            PdfPTable tabel7 = new PdfPTable(2);
            tabel7.setWidthPercentage(100);

            Paragraph pPekerjaan = new Paragraph();
            pPekerjaan.add("9.  a. Pekerjaan : " + getPekerjaan());
            pPekerjaan.setLeading(0, 1);

            PdfPCell cPekerjaan = new PdfPCell();
            cPekerjaan.setMinimumHeight(20);
            cPekerjaan.addElement(pPekerjaan);
            tabel7.addCell(cPekerjaan);

            Paragraph pJabatan = new Paragraph();
            pJabatan.add("  b. Jabatan : " + getJabatan());
            pJabatan.setLeading(0, 1);

            PdfPCell cJabatan = new PdfPCell();
            cJabatan.setMinimumHeight(20);
            cJabatan.addElement(pJabatan);
            tabel7.addCell(cJabatan);

            document.add(tabel7);
            //------------------------------------------------------------------------------------- PEKERJAAN END

            //------------------------------------------------------------------------------------- INSTANSI DLL
            PdfPTable tabel8 = new PdfPTable(1);
            tabel8.setWidthPercentage(100);

            Paragraph pInstansi = new Paragraph();
            pInstansi.add("     c. Instansi/Lembaga/Kantor : " + getInstansilembagakantor());
            pInstansi.setLeading(0, 1);

            PdfPCell cInstansi = new PdfPCell();
            cInstansi.setMinimumHeight(20);
            cInstansi.addElement(pInstansi);
            tabel8.addCell(cInstansi);

            document.add(tabel8);
            //------------------------------------------------------------------------------------- INSTANSI DLL END

            //------------------------------------------------------------------------------------- NAMA ISTRI
            float[] colomn = {7, 1, 2};
            PdfPTable tabel9 = new PdfPTable(colomn);
            tabel9.setWidthPercentage(100);

            Paragraph pNamaIstriBapakIbu = new Paragraph();
            pNamaIstriBapakIbu.add("10.");
            pNamaIstriBapakIbu.add("\n       a. Nama Istri : ");
            pNamaIstriBapakIbu.add("\n\n       b. Nama Bapak Istri : ");
            pNamaIstriBapakIbu.add("\n\n       c. Nama Ibu Istri : ");
            pNamaIstriBapakIbu.add("\n\n       d. Alamat : ");
            pNamaIstriBapakIbu.setLeading(0, 1);

            PdfPCell cNamaIstriBapakIbu = new PdfPCell();
            cNamaIstriBapakIbu.setMinimumHeight(110);
            cNamaIstriBapakIbu.addElement(pNamaIstriBapakIbu);
            tabel9.addCell(cNamaIstriBapakIbu);

            Paragraph pUmurIstriBapakIbu = new Paragraph();
            pUmurIstriBapakIbu.add("  Umur :");
            pUmurIstriBapakIbu.setLeading(0, 1);

            PdfPCell cUmurIstriBapakIbu = new PdfPCell();
            cUmurIstriBapakIbu.setMinimumHeight(110);
            cUmurIstriBapakIbu.addElement(pUmurIstriBapakIbu);
            tabel9.addCell(cUmurIstriBapakIbu);

            Paragraph pPekerjaanIstriBapakIbu = new Paragraph();
            pPekerjaanIstriBapakIbu.add("  Pekerjaan :");
            pPekerjaanIstriBapakIbu.setLeading(0, 1);

            PdfPCell cPekerjaanIstriBapakIbu = new PdfPCell();
            cPekerjaanIstriBapakIbu.setMinimumHeight(110);
            cPekerjaanIstriBapakIbu.addElement(pPekerjaanIstriBapakIbu);
            tabel9.addCell(cPekerjaanIstriBapakIbu);

            document.add(tabel9);
            //------------------------------------------------------------------------------------- NAMA ISTRI END

            //------------------------------------------------------------------------------------- SANAK SAUDARA
            PdfPTable tabel10 = new PdfPTable(1);
            tabel10.setWidthPercentage(100);

            Paragraph pSanakSaudara = new Paragraph();
            pSanakSaudara.add("11.  Sanak/Saudara yang menjadi ");
            pSanakSaudara.add("\n\n       Tanggungan : " + getTanggungan());
            pSanakSaudara.add("\n\n\n       Alamat : " + getAlamattanggungan());
            pSanakSaudara.setLeading(0, 1);

            PdfPCell cSanakSaudara = new PdfPCell();
            cSanakSaudara.setMinimumHeight(85);
            cSanakSaudara.addElement(pSanakSaudara);
            tabel10.addCell(cSanakSaudara);

            document.add(tabel10);
            //------------------------------------------------------------------------------------- SANAK SAUDARA END

            //------------------------------------------------------------------------------------- ANAK2
            PdfPTable tabel11 = new PdfPTable(colomn);
            tabel11.setWidthPercentage(100);

            Paragraph pAnak2 = new Paragraph();
            pAnak2.add("12.  Anak-anak : ");
            pAnak2.add("\n\n       1. ");
            pAnak2.add("\n\n       2. ");
            pAnak2.add("\n\n       3. ");
            pAnak2.add("\n\n       4. ");
            pAnak2.add("\n\n       5. ");
            pAnak2.add("\n\n       6. ");
            pAnak2.add("\n");
            pAnak2.setLeading(0, 1);

            PdfPCell cAnak2 = new PdfPCell();
            cAnak2.setMinimumHeight(165);
            cAnak2.addElement(pAnak2);
            tabel11.addCell(cAnak2);

            Paragraph pUmurAnak2 = new Paragraph();
            pUmurAnak2.add("  Umur : ");
            pUmurAnak2.setLeading(0, 1);

            PdfPCell cUmurAnak2 = new PdfPCell();
            cUmurAnak2.setMinimumHeight(165);
            cUmurAnak2.addElement(pUmurAnak2);
            tabel11.addCell(cUmurAnak2);

            Paragraph pPekarjaanAnak2 = new Paragraph();
            pPekarjaanAnak2.add("  Pekerjaan : ");
            pPekarjaanAnak2.setLeading(0, 1);

            PdfPCell cPekerjaanAnak2 = new PdfPCell();
            cPekerjaanAnak2.setMinimumHeight(165);
            cPekerjaanAnak2.addElement(pPekarjaanAnak2);
            tabel11.addCell(cPekerjaanAnak2);

            document.add(tabel11);
            //------------------------------------------------------------------------------------- ANAK2 END

            //------------------------------------------------------------------------------------- CIRI-CIRI
            PdfPTable tabel12 = new PdfPTable(1);
            tabel12.setWidthPercentage(100);

            Paragraph pCiri2 = new Paragraph();
            pCiri2.add("13.  Ciri-ciri badan : ");
            pCiri2.add("\n\n       1. Rambut : " + getRambut());
            for (int i = 0; i < (35 - getRambut().length()); i++) {
                pCiri2.add(" ");
            }
            pCiri2.add("2. Muka : " + getMuka());
            for (int i = 0; i < (35 - getMuka().length()); i++) {
                pCiri2.add(" ");
            }
            pCiri2.add("3. Kulit : " + getKulit());
            pCiri2.setLeading(0, 1);

            PdfPCell cCiri2 = new PdfPCell();
            cCiri2.setMinimumHeight(45);
            cCiri2.addElement(pCiri2);
            tabel12.addCell(cCiri2);

            document.add(tabel12);
            //------------------------------------------------------------------------------------- CIRI-CIRI END

            //------------------------------------------------------------------------------------- LANJUTAN CIRI2
            PdfPTable tabel13 = new PdfPTable(1);
            tabel13.setWidthPercentage(100);

            Paragraph pCiri2Lanjutan = new Paragraph();
            for (int i = 0; i < 20; i++) {
                pCiri2Lanjutan.add(" ");
            }
            pCiri2Lanjutan.add("4.  Tinggi : " + getTinggi());
            for (int i = 0; i < (35 - getTinggi().length()); i++) {
                pCiri2Lanjutan.add(" ");
            }
            pCiri2Lanjutan.add("5.  Tanda Istimewa : " + getTandaistimewa());
            pCiri2Lanjutan.setLeading(0, 1);

            PdfPCell cCiri2Lanjutan = new PdfPCell();
            cCiri2Lanjutan.setMinimumHeight(20);
            cCiri2Lanjutan.addElement(pCiri2Lanjutan);
            tabel13.addCell(cCiri2Lanjutan);

            document.add(tabel13);
            //------------------------------------------------------------------------------------- LANJUTAN CIRI2

            //------------------------------------------------------------------------------------- RUMUS SIDIK JARI
            PdfPTable tabel14 = new PdfPTable(1);
            tabel14.setWidthPercentage(100);

            Paragraph pSidikJari = new Paragraph();
            pSidikJari.add("14.  Rumus Sidik Jari : " + getRumussidikjari());
            pSidikJari.setLeading(0, 1);

            PdfPCell cSidikJari = new PdfPCell();
            cSidikJari.setMinimumHeight(20);
            cSidikJari.addElement(pSidikJari);
            tabel14.addCell(cSidikJari);

            document.add(tabel14);
            //------------------------------------------------------------------------------------- RUMUS SIDIK JARI END

            //------------------------------------------------------------------------------------- RIWAYAT SEKOLAH
            float[] colom = {8, 2};
            PdfPTable tabel15 = new PdfPTable(colom);
            tabel15.setWidthPercentage(100);

            Paragraph pRiwayatSekolah = new Paragraph();
            pRiwayatSekolah.add("15.  Riwayat Sekolah : ");
            pRiwayatSekolah.add("\n\n       1. ");
            pRiwayatSekolah.add("\n\n       2. ");
            pRiwayatSekolah.add("\n\n       3. ");
            pRiwayatSekolah.add("\n\n       4. ");
            pRiwayatSekolah.add("\n\n       5. ");
            pRiwayatSekolah.add("\n\n       6. ");
            pRiwayatSekolah.setLeading(0, 1);

            PdfPCell cRiwayatSekolah = new PdfPCell();
            cRiwayatSekolah.setMinimumHeight(165);
            cRiwayatSekolah.addElement(pRiwayatSekolah);
            tabel15.addCell(cRiwayatSekolah);

            Paragraph pTahunLulus = new Paragraph();
            pTahunLulus.add("Tahun Lulus");
            pTahunLulus.setLeading(0, 1);

            PdfPCell cTahunLulus = new PdfPCell();
            cTahunLulus.setMinimumHeight(165);
            cTahunLulus.addElement(pTahunLulus);
            tabel15.addCell(cTahunLulus);

            document.add(tabel15);
            //------------------------------------------------------------------------------------- RIWAYAT SEKOLAH END

            //------------------------------------------------------------------------------------- KESENANGAN/KEGEMARAN/HOBI
            PdfPTable tabel16 = new PdfPTable(1);
            tabel16.setWidthPercentage(100);

            Paragraph pKesenenanganKegemaranHobi = new Paragraph();
            pKesenenanganKegemaranHobi.add("16.  Kesenangan/Kegemaran/Hobi : " + getHobi());
            pKesenenanganKegemaranHobi.setLeading(0, 1);

            PdfPCell cKesenenanganKegemaranHobi = new PdfPCell();
            cKesenenanganKegemaranHobi.setMinimumHeight(20);
            cKesenenanganKegemaranHobi.addElement(pKesenenanganKegemaranHobi);
            tabel16.addCell(cKesenenanganKegemaranHobi);

            document.add(tabel16);
            //------------------------------------------------------------------------------------- KESENANGAN/KEGEMARAN/HOBI END

            //------------------------------------------------------------------------------------- CATATAN KRIMINAL
            PdfPTable tabel17 = new PdfPTable(1);
            tabel17.setWidthPercentage(100);

            Paragraph pCatatanKriminal = new Paragraph();
            pCatatanKriminal.add("17.  Catatan kriminal yang ada : ");
            pCatatanKriminal.add("\n\n       1. " + getCatatankriminal1());
            pCatatanKriminal.add("\n\n       2. " + getCatatankriminal2());
            pCatatanKriminal.add("\n\n       3. " + getCatatankriminal3());
            pCatatanKriminal.setLeading(0, 1);

            PdfPCell cCatatanKriminal = new PdfPCell();
            cCatatanKriminal.setMinimumHeight(95);
            cCatatanKriminal.addElement(pCatatanKriminal);
            tabel17.addCell(cCatatanKriminal);

            document.add(tabel17);
            //------------------------------------------------------------------------------------- CATATAN KRIMINAL END

            //------------------------------------------------------------------------------------- KETERANGAN DLL
            PdfPTable tabel18 = new PdfPTable(1);
            tabel18.setWidthPercentage(100);

            Paragraph pDataKeteranganLain2 = new Paragraph();
            pDataKeteranganLain2.add("18.  Data Keterangan dan lain2 : ");
            pDataKeteranganLain2.add("\n\n\n");
            pDataKeteranganLain2.setLeading(0, 1);

            PdfPCell cDataKeteranganLain2 = new PdfPCell();
            cDataKeteranganLain2.addElement(pDataKeteranganLain2);

            if (list.size() > 0) {
                float[] kolomkegiatan = {8, 2};
                PdfPTable nestedTable = new PdfPTable(kolomkegiatan);

                nestedTable.addCell(new Paragraph("Kegiatan"));
                nestedTable.addCell(new Paragraph("Tanggal"));

                for (int i = 0; i < list.size(); i++) {
                    nestedTable.addCell(new Paragraph(list.get(i).getNamakegiatan()));
                    nestedTable.addCell(new Paragraph(list.get(i).getTanggal()));
                }

                cDataKeteranganLain2.addElement(nestedTable);
                cDataKeteranganLain2.setPaddingBottom(20f);
                tabel18.addCell(cDataKeteranganLain2);
            }

            document.add(tabel18);
            //------------------------------------------------------------------------------------- KETERANGAN DLL END

            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }
}
