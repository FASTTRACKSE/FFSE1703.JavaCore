-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2018 at 08:56 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `project_quanlysv`
--

-- --------------------------------------------------------

--
-- Table structure for table `sinh_vien`
--

CREATE TABLE IF NOT EXISTS `sinh_vien` (
`ID` int(10) NOT NULL,
  `codeSV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nameSV` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `addressSV` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `wardSV` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `countySV` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `citySV` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phonenumbSV` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `emailSV` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `classSV` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sinh_vien`
--

INSERT INTO `sinh_vien` (`ID`, `codeSV`, `nameSV`, `addressSV`, `wardSV`, `countySV`, `citySV`, `phonenumbSV`, `emailSV`, `classSV`) VALUES
(51, 'FFSE1703001', 'Phạm Trần Đức', 'Sao Hỏa', 'Phường Giáp Bát', 'Quận Hoàng Mai', 'Thành phố Hà Nội', '0123456789', 'daylaemail@gmai.com', 'FFSE1703'),
(52, 'FFSE1702001', 'Nguyễn Thanh Hiếu', 'Sao Thổ', 'Phường Quang Trung', 'Thành phố Hà Giang', 'Tỉnh Hà Giang', '0123456789', 'daylaemail@gmai.com', 'FFSE1702'),
(53, 'FFSE1802001', 'Nguyễn Phước Hiếu', 'Sao Thủy', 'Phường Sông Hiến', 'Thành phố Cao Bằng', 'Tỉnh Cao Bằng', '0123456789', 'daylaemail@gmai.com', 'FFSE1802'),
(54, 'FFSE1802002', 'Hồ Quang Minh', 'Mặt Trăng', 'Phường Nguyễn Thị Minh Khai', 'Thành Phố Bắc Kạn', 'Tỉnh Bắc Kạn', '0123456789', 'daylaemail@gmai.com', 'FFSE1802'),
(55, 'FFSE1802003', 'Đây Là Tên', 'Mặt Trăng', 'Thị trấn Chợ Mới', 'Huyện Chợ Mới', 'Tỉnh Bắc Kạn', '0123456789', 'daylaemail@gmai.com', 'FFSE1802'),
(56, 'FFSE1801001', 'Đây Cũng Là Tên', 'Mặt Trời', 'Thị trấn Vĩnh Lộc', 'Huyện Chiêm Hóa', 'Tỉnh Tuyên Quang', '0123456789', 'daylaemail@gmai.com', 'FFSE1801'),
(57, 'FFSE1904012', 'Hồ Viết Tú', 'Trái Đất', 'Thị trấn Bắc Hà', 'Huyện Bắc Hà', 'Tỉnh Lào Cai', '0123456789', 'daylaemail@gmai.com', 'FFSE1904'),
(58, 'FFSE1904010', 'Hồ Viết Tú2', 'Trái Đất', 'Thị trấn Bắc Hà', 'Huyện Bắc Hà', 'Tỉnh Lào Cai', '0123456789', 'daylaemail@gmai.com', 'FFSE1904'),
(59, 'FFSE1904011', 'Hồ Viết Tú2', 'Trái Đất', 'Phường Trần Phú', 'Thành phố Hà Tĩnh', 'Tỉnh Hà Tĩnh', '0123456789', 'daylaemail@gmai.com', 'FFSE1904'),
(60, 'FFSE1903001', 'Đây Cũng Là Tên', 'Mặt Trời', 'Thị trấn Tân Bình', 'Huyện Yên Sơn', 'Tỉnh Tuyên Quang', '0123456789', 'daylaemail@gmai.com', 'FFSE1903'),
(61, 'FFSE1903002', 'Đây Cũng Là Tên 2', 'Mặt Trời', 'Phường Thái Bình', 'Thành phố Hòa Bình', 'Tỉnh Hoà Bình', '0123456789', 'daylaemail@gmai.com', 'FFSE1903'),
(62, 'FFSE1703002', 'Phạm Trần Đức 2', 'Sao Hỏa', 'Phường Thượng Thanh', 'Quận Long Biên', 'Thành phố Hà Nội', '0123456789', 'daylaemail@gmai.com', 'FFSE1703');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sinh_vien`
--
ALTER TABLE `sinh_vien`
 ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sinh_vien`
--
ALTER TABLE `sinh_vien`
MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=63;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
