-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2017 at 07:40 AM
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
(6, 'TESTESTSET', '', '', '', '', '1-1-1945', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'C:/Users/GeolseuDei/Desktop/ServerKartuTIK/src/data/foto/TESTESTSET.jpg');

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
(9, 1, 'testing', '11-03-2017'),
(10, 1, 'selesai ngoding', '16-03-2017');

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
(55, 1, 'Sukses Login ke server', '22-02-2017 12:01:57'),
(58, 2, 'Berhasil login', '16-03-2017 11:59:56'),
(59, 1, 'Berhasil login', '16-03-2017 12:01:18'),
(60, 1, 'Berhasil login', '16-03-2017 12:02:22'),
(61, 1, 'Berhasil login', '16-03-2017 12:02:55'),
(62, 1, 'Berhasil login', '16-03-2017 12:04:04'),
(63, 2, 'Berhasil login', '16-03-2017 12:16:17'),
(64, 2, 'Berhasil login', '16-03-2017 12:17:52'),
(65, 1, 'Berhasil login', '16-03-2017 12:19:54'),
(66, 1, 'Berhasil login', '16-03-2017 12:21:38'),
(67, 1, 'Berhasil login', '16-03-2017 12:21:43'),
(68, 1, 'Berhasil login', '16-03-2017 12:23:40'),
(69, 2, 'Berhasil login', '16-03-2017 12:23:48'),
(70, 2, 'Keluar dari sistem', '16-03-2017 12:23:54'),
(71, 1, 'Berhasil login', '16-03-2017 12:24:02'),
(72, 1, 'Keluar dari sistem', '16-03-2017 12:24:05'),
(73, 1, 'Keluar dari sistem', '16-03-2017 12:24:32'),
(74, 1, 'Berhasil masuk ke sistem', '16-03-2017 12:55:36'),
(75, 1, 'Berhasil masuk ke sistem', '16-03-2017 12:55:44'),
(76, 1, 'Menghapus data milik asdasdasd', '16-03-2017 12:56:01'),
(77, 1, 'Memberi hak akses spesial kepada no induk 5555', '16-03-2017 12:56:22'),
(78, 1, 'Berhasil masuk ke sistem', '16-03-2017 12:57:19'),
(79, 1, 'Mencabut hak akses spesial no induk 5555', '16-03-2017 12:57:39'),
(80, 1, 'Keluar dari sistem', '16-03-2017 12:58:19'),
(81, 1, 'Berhasil masuk ke sistem', '16-03-2017 12:58:53'),
(82, 1, 'Keluar dari sistem', '16-03-2017 12:58:58'),
(83, 2, 'Berhasil masuk ke sistem', '16-03-2017 12:59:01'),
(84, 2, 'Berhasil masuk ke sistem', '16-03-2017 13:01:44'),
(85, 2, 'Berhasil masuk ke sistem', '16-03-2017 13:02:26'),
(86, 2, 'Berhasil masuk ke sistem', '16-03-2017 13:04:46'),
(87, 2, 'Berhasil masuk ke sistem', '16-03-2017 13:05:11'),
(88, 2, 'Keluar dari sistem', '16-03-2017 13:05:17'),
(89, 1, 'Berhasil masuk ke sistem', '16-03-2017 13:05:19'),
(90, 1, 'Mencabut hak akses spesial no induk 4444', '16-03-2017 13:05:30'),
(91, 1, 'Keluar dari sistem', '16-03-2017 13:05:32'),
(92, 2, 'Berhasil masuk ke sistem', '16-03-2017 13:05:34'),
(93, 2, 'Keluar dari sistem', '16-03-2017 13:05:55'),
(94, 1, 'Berhasil masuk ke sistem', '16-03-2017 13:06:00'),
(95, 1, 'Memberi hak akses spesial kepada no induk 4444', '16-03-2017 13:06:59'),
(96, 1, 'Keluar dari sistem', '16-03-2017 13:07:01'),
(97, 2, 'Berhasil masuk ke sistem', '16-03-2017 13:07:03'),
(98, 1, 'Berhasil masuk ke sistem', '16-03-2017 13:07:15'),
(99, 2, 'Menambah kegiatan selesai ngoding', '16-03-2017 13:07:50'),
(100, 2, 'Keluar dari sistem', '16-03-2017 13:08:09'),
(101, 1, 'Berhasil masuk ke sistem', '16-03-2017 21:08:42'),
(102, 1, 'Keluar dari sistem', '16-03-2017 21:09:14'),
(103, 1, 'Berhasil masuk ke sistem', '16-03-2017 21:20:27'),
(104, 2, 'Berhasil masuk ke sistem', '16-03-2017 21:21:20'),
(105, 2, 'Menghapus data milik dsadsa', '16-03-2017 21:22:00'),
(106, 2, 'Menghapus data milik sadasd', '16-03-2017 21:22:04'),
(107, 2, 'Merubah data milik Erwin Kurniawan Adidharma', '16-03-2017 21:22:14'),
(108, 2, 'Menambahkan data milik asdasdsadsad', '16-03-2017 21:22:30'),
(109, 2, 'Menambahkan foto milik asdasdsadsad', '16-03-2017 21:22:51'),
(110, 2, 'Menghapus data milik asdasdsadsad', '16-03-2017 21:22:59'),
(111, 1, 'Keluar dari sistem', '16-03-2017 21:26:05'),
(112, 1, 'Berhasil masuk ke sistem', '17-03-2017 19:58:01'),
(113, 1, 'Keluar dari sistem', '17-03-2017 19:58:05'),
(114, 2, 'Berhasil masuk ke sistem', '17-03-2017 19:58:08'),
(115, 2, 'Keluar dari sistem', '17-03-2017 19:58:11'),
(116, 1, 'Berhasil masuk ke sistem', '17-03-2017 19:58:14'),
(117, 1, 'Keluar dari sistem', '17-03-2017 19:58:24'),
(118, 1, 'Berhasil masuk ke sistem', '20-03-2017 22:39:03'),
(119, 1, 'Keluar dari sistem', '20-03-2017 22:39:09'),
(120, 1, 'Berhasil masuk ke sistem', '20-03-2017 22:44:17'),
(121, 1, 'Berhasil masuk ke sistem', '20-03-2017 22:44:34'),
(122, 1, 'Berhasil masuk ke sistem', '20-03-2017 22:47:51'),
(123, 1, 'Berhasil masuk ke sistem', '20-03-2017 22:50:51'),
(124, 1, 'Berhasil masuk ke sistem', '20-03-2017 22:54:37'),
(125, 1, 'Keluar dari sistem', '20-03-2017 22:54:47'),
(126, 1, 'Berhasil masuk ke sistem', '20-03-2017 22:54:51'),
(127, 1, 'Berhasil masuk ke sistem', '20-03-2017 22:56:30'),
(128, 2, 'Berhasil masuk ke sistem', '20-03-2017 22:56:35'),
(129, 2, 'Keluar dari sistem', '20-03-2017 22:57:10'),
(130, 2, 'Berhasil masuk ke sistem', '20-03-2017 22:57:16'),
(131, 2, 'Keluar dari sistem', '20-03-2017 22:57:43'),
(132, 1, 'Menghapus data milik TEST', '20-03-2017 22:57:56'),
(133, 1, 'Menambahkan data TIK (TEST)', '20-03-2017 22:58:05'),
(134, 1, 'Keluar dari sistem', '20-03-2017 22:58:23'),
(135, 1, 'Berhasil masuk ke sistem', '20-03-2017 22:58:51'),
(136, 1, 'Menghapus data milik TEST', '20-03-2017 22:59:31'),
(137, 1, 'Menambahkan data TIK (TESTESTSET)', '20-03-2017 22:59:38'),
(138, 1, 'Menambahkan foto milik TESTESTSET', '20-03-2017 22:59:43'),
(139, 1, 'Keluar dari sistem', '20-03-2017 23:00:35'),
(140, 1, 'Berhasil masuk ke sistem', '20-03-2017 23:06:09'),
(141, 1, 'Keluar dari sistem', '20-03-2017 23:06:59');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `log`
--
ALTER TABLE `log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=142;
--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
