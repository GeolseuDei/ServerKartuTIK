-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 11, 2017 at 05:50 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `programpendataan`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `id` int(11) NOT NULL,
  `noinduk` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`id`, `noinduk`, `nama`) VALUES
(1, 5555, 'Erwin Kurniawan Adidharma'),
(2, 4444, 'Audi Pratama');

-- --------------------------------------------------------

--
-- Table structure for table `datatik`
--

CREATE TABLE `datatik` (
  `id` int(11) NOT NULL,
  `namalengkap` varchar(100) NOT NULL,
  `alias` varchar(50) NOT NULL,
  `tglnoktp` varchar(50) NOT NULL,
  `tglnopasport` varchar(50) NOT NULL,
  `agama` varchar(10) NOT NULL,
  `tgllahir` varchar(50) NOT NULL,
  `umur` varchar(10) NOT NULL,
  `tempatlahir` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `perubahanalamat1` varchar(50) NOT NULL,
  `perubahanalamat2` varchar(50) NOT NULL,
  `perubahanalamat3` varchar(50) NOT NULL,
  `kedudukandalamkeluarga` varchar(50) NOT NULL,
  `namabapak` varchar(50) NOT NULL,
  `namaibu` varchar(50) NOT NULL,
  `alamatorangtua` varchar(50) NOT NULL,
  `pekerjaan` varchar(50) NOT NULL,
  `jabatan` varchar(50) NOT NULL,
  `instansilembagakantor` varchar(50) NOT NULL,
  `namaistri` varchar(50) NOT NULL,
  `umuristri` varchar(50) NOT NULL,
  `pekerjaanistri` varchar(50) NOT NULL,
  `namabapakistri` varchar(50) NOT NULL,
  `umurbapakistri` varchar(50) NOT NULL,
  `pekerjaanbapakistri` varchar(50) NOT NULL,
  `namaibuistri` varchar(50) NOT NULL,
  `umuribuistri` varchar(50) NOT NULL,
  `pekerjaanibuistri` varchar(50) NOT NULL,
  `alamatorangtuaistri` varchar(50) NOT NULL,
  `tanggungan` varchar(50) NOT NULL,
  `alamattanggungan` varchar(50) NOT NULL,
  `namaanak1` varchar(50) NOT NULL,
  `umuranak1` varchar(50) NOT NULL,
  `pekerjaananak1` varchar(50) NOT NULL,
  `namaanak2` varchar(50) NOT NULL,
  `umuranak2` varchar(50) NOT NULL,
  `pekerjaananak2` varchar(50) NOT NULL,
  `namaanak3` varchar(50) NOT NULL,
  `umuranak3` varchar(50) NOT NULL,
  `pekerjaananak3` varchar(50) NOT NULL,
  `namaanak4` varchar(50) NOT NULL,
  `umuranak4` varchar(50) NOT NULL,
  `pekerjaananak4` varchar(50) NOT NULL,
  `namaanak5` varchar(50) NOT NULL,
  `umuranak5` varchar(50) NOT NULL,
  `pekerjaananak5` varchar(50) NOT NULL,
  `namaanak6` varchar(50) NOT NULL,
  `umuranak6` varchar(50) NOT NULL,
  `pekerjaananak6` varchar(50) NOT NULL,
  `rambut` varchar(50) NOT NULL,
  `muka` varchar(50) NOT NULL,
  `kulit` varchar(50) NOT NULL,
  `tinggi` varchar(50) NOT NULL,
  `tandaistimewa` varchar(50) NOT NULL,
  `rumussidikjari` varchar(50) NOT NULL,
  `namasekolah1` varchar(50) NOT NULL,
  `tahunlulussekolah1` varchar(50) NOT NULL,
  `namasekolah2` varchar(50) NOT NULL,
  `tahunlulussekolah2` varchar(50) NOT NULL,
  `namasekolah3` varchar(50) NOT NULL,
  `tahunlulussekolah3` varchar(50) NOT NULL,
  `namasekolah4` varchar(50) NOT NULL,
  `tahunlulussekolah4` varchar(50) NOT NULL,
  `namasekolah5` varchar(50) NOT NULL,
  `tahunlulussekolah5` varchar(50) NOT NULL,
  `namasekolah6` varchar(50) NOT NULL,
  `tahunlulussekolah6` varchar(50) NOT NULL,
  `hobi` varchar(50) NOT NULL,
  `catatankriminal1` varchar(50) NOT NULL,
  `catatankriminal2` varchar(50) NOT NULL,
  `catatankriminal3` varchar(50) NOT NULL,
  `urlfoto` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datatik`
--

INSERT INTO `datatik` (`id`, `namalengkap`, `alias`, `tglnoktp`, `tglnopasport`, `agama`, `tgllahir`, `umur`, `tempatlahir`, `alamat`, `perubahanalamat1`, `perubahanalamat2`, `perubahanalamat3`, `kedudukandalamkeluarga`, `namabapak`, `namaibu`, `alamatorangtua`, `pekerjaan`, `jabatan`, `instansilembagakantor`, `namaistri`, `umuristri`, `pekerjaanistri`, `namabapakistri`, `umurbapakistri`, `pekerjaanbapakistri`, `namaibuistri`, `umuribuistri`, `pekerjaanibuistri`, `alamatorangtuaistri`, `tanggungan`, `alamattanggungan`, `namaanak1`, `umuranak1`, `pekerjaananak1`, `namaanak2`, `umuranak2`, `pekerjaananak2`, `namaanak3`, `umuranak3`, `pekerjaananak3`, `namaanak4`, `umuranak4`, `pekerjaananak4`, `namaanak5`, `umuranak5`, `pekerjaananak5`, `namaanak6`, `umuranak6`, `pekerjaananak6`, `rambut`, `muka`, `kulit`, `tinggi`, `tandaistimewa`, `rumussidikjari`, `namasekolah1`, `tahunlulussekolah1`, `namasekolah2`, `tahunlulussekolah2`, `namasekolah3`, `tahunlulussekolah3`, `namasekolah4`, `tahunlulussekolah4`, `namasekolah5`, `tahunlulussekolah5`, `namasekolah6`, `tahunlulussekolah6`, `hobi`, `catatankriminal1`, `catatankriminal2`, `catatankriminal3`, `urlfoto`) VALUES
(1, 'Erwin Kurniawan Adidharma', 'Erwin', '3578241911950001', '123456789', 'Kristen', '19-11-1995', '21', 'Surabaya', 'Kutisari Indah Barat 2/23', '', '', '', 'Anak', 'Jusak Pribadi', 'Pinto Yuliwati', 'Kutisari Indah Barat 2/23', 'Mahasiswa', 'Pelajar', 'Universitas Surabaya (UBAYA)', 'Dahyun', '19', 'Idol', '', '', '', '', '', '', 'KOREA', 'Hidup', 'Dalam dirinya', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'Hitam', 'Ganteng', 'Kuning', '180', 'Kurus', '69/69', 'TK Kristen Petra 9', '2000', 'SD Kristen Petra 9', '2008', 'SMP Kristen Petra 5', '2011', 'SMA Kristen Petra 5', '2014', '', '', '', '', 'Gaming', '', '', '', 'F:\\NetBeansProjects\\Server Kartu TIK\\src\\data\\foto\\123456789DAHYUN.jpg'),
(6, 'SMITE', 'SMET', '123456789', '321654987', 'Atheist', '1-1-1945', '99', 'USA', '', '', '', '', '', '', '', 'null', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'F:/NetBeansProjects/Server Kartu TIK/src/data/foto/123456789SMITE.png');

-- --------------------------------------------------------

--
-- Table structure for table `kegiatan`
--

CREATE TABLE `kegiatan` (
  `id` int(11) NOT NULL,
  `id_TIK` int(11) NOT NULL,
  `kegiatan` varchar(1000) NOT NULL,
  `tanggal` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kegiatan`
--

INSERT INTO `kegiatan` (`id`, `id_TIK`, `kegiatan`, `tanggal`) VALUES
(1, 1, 'UVUVWEVWEVWE ONYETENYEVWE UGWEMUBWEM OSSAS', '12-02-2017'),
(2, 1, 'IKAN TONGKOL', '12-02-2017'),
(3, 4444, 'AKU TAK BIASA', '13-02-2017'),
(4, 2, 'GALAW', '13-02-2017'),
(5, 2, ' GALAO ', '13-02-2017'),
(6, 2, 'VUVUVUVUVUVUUVUV', '15-02-2017'),
(7, 1, 'NGODING', '15-02-2017'),
(8, 1, 'ngoding foto form pencarian', '11-03-2017'),
(9, 1, 'testing', '11-03-2017');

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `id` int(11) NOT NULL,
  `id_anggota` int(11) NOT NULL,
  `event` varchar(100) NOT NULL,
  `waktu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`id`, `id_anggota`, `event`, `waktu`) VALUES
(2, 1, 'Sukses Login ke server', '10-23-2017 08:23:51'),
(3, 1, 'Sukses Login ke server', '10-54-2017 10:54:14'),
(4, 1, 'Sukses Login ke server', '10-56-2017 10:56:11'),
(5, 1, 'Sukses Login ke server', '10-57-2017 10:57:18'),
(6, 1, 'Sukses Login ke server', '10-57-2017 10:57:39'),
(7, 2, 'Sukses Login ke server', '12-02-2017 10:24:07'),
(8, 1, 'Sukses Login ke server', '12-02-2017 10:24:18'),
(9, 1, 'Sukses Login ke server', '12-02-2017 10:24:28'),
(10, 1, 'Sukses Login ke server', '12-02-2017 10:24:45'),
(11, 2, 'Sukses Login ke server', '12-02-2017 10:52:48'),
(12, 1, 'Sukses Login ke server', '12-02-2017 10:54:58'),
(13, 1, 'Sukses Login ke server', '12-02-2017 10:55:12'),
(14, 1, 'Sukses Login ke server', '13-02-2017 07:41:36'),
(15, 1, 'Sukses Login ke server', '13-02-2017 07:41:58'),
(16, 1, 'Sukses Login ke server', '13-02-2017 07:43:16'),
(17, 1, 'Sukses Login ke server', '13-02-2017 07:45:45'),
(18, 1, 'Sukses Login ke server', '13-02-2017 07:46:22'),
(19, 1, 'Sukses Login ke server', '13-02-2017 07:46:34'),
(20, 1, 'Sukses Login ke server', '13-02-2017 07:47:51'),
(21, 1, 'Sukses Login ke server', '13-02-2017 07:48:42'),
(22, 1, 'Sukses Login ke server', '15-02-2017 10:52:07'),
(23, 1, 'Sukses Login ke server', '15-02-2017 10:52:24'),
(24, 1, 'Sukses Login ke server', '15-02-2017 10:54:55'),
(25, 1, 'Sukses Login ke server', '15-02-2017 11:19:10'),
(26, 1, 'Sukses Login ke server', '15-02-2017 11:19:21'),
(27, 1, 'Pencabutan hak akses spesial kepada Audi Pratama', '15-02-2017 11:19:29'),
(28, 1, 'Pemberian hak akses spesial kepada Audi Pratama', '15-02-2017 11:20:15'),
(29, 1, 'Sukses Login ke server', '15-02-2017 11:40:58'),
(30, 1, 'Pencabutan hak akses spesial kepada Audi Pratama', '15-02-2017 11:41:12'),
(31, 1, 'Sukses Login ke server', '15-02-2017 11:42:41'),
(32, 1, 'Sukses Login ke server', '15-02-2017 11:44:54'),
(33, 1, 'Menambahkan kegiatan ke server', '15-02-2017 11:45:04'),
(34, 1, 'Sukses Login ke server', '15-02-2017 11:52:16'),
(35, 1, 'Sukses Login ke server', '15-02-2017 11:53:09'),
(36, 1, 'Berhasil mengganti password', '15-02-2017 11:53:23'),
(37, 1, 'Sukses Login ke server', '15-02-2017 11:56:04'),
(38, 1, 'Berhasil mengganti password', '15-02-2017 11:56:43'),
(39, 1, 'Sukses Login ke server', '15-02-2017 11:58:04'),
(40, 1, 'Sukses Login ke server', '15-02-2017 11:57:18'),
(41, 1, 'Sukses Login ke server', '16-02-2017 02:00:00'),
(42, 1, 'Sukses Login ke server', '16-02-2017 02:00:44'),
(43, 1, 'Sukses Login ke server', '16-02-2017 02:02:22'),
(44, 1, 'Sukses Login ke server', '16-02-2017 02:02:51'),
(45, 1, 'Sukses Login ke server', '16-02-2017 02:13:31'),
(46, 1, 'Pencabutan hak akses spesial kepada Yasmin Fernandes Branco', '16-02-2017 02:13:38'),
(47, 1, 'Sukses Login ke server', '18-02-2017 06:34:41'),
(48, 1, 'Sukses Login ke server', '18-02-2017 06:40:09'),
(49, 1, 'Keluar dari sistem server', '18-02-2017 06:40:12'),
(50, 1, 'Sukses Login ke server', '18-02-2017 06:40:14'),
(51, 1, 'Keluar dari sistem server', '18-02-2017 06:43:22'),
(52, 1, 'Sukses Login ke server', '18-02-2017 06:44:59'),
(53, 1, 'Sukses Login ke server', '18-02-2017 06:46:33'),
(54, 1, 'Sukses Login ke server', '18-02-2017 06:49:46'),
(55, 1, 'Sukses Login ke server', '22-02-2017 12:01:57');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `status` int(11) NOT NULL,
  `hakspesial` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`, `status`, `hakspesial`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 1, 0),
(2, 'member', 'aa08769cdcb26674c6706093503ff0a3', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `datatik`
--
ALTER TABLE `datatik`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kegiatan`
--
ALTER TABLE `kegiatan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anggota`
--
ALTER TABLE `anggota`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `datatik`
--
ALTER TABLE `datatik`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `kegiatan`
--
ALTER TABLE `kegiatan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `log`
--
ALTER TABLE `log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;
--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
