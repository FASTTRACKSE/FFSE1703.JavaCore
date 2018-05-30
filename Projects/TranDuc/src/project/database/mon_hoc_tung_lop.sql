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
-- Table structure for table `mon_hoc_tung_lop`
--

CREATE TABLE IF NOT EXISTS `mon_hoc_tung_lop` (
`ID` int(5) NOT NULL,
  `ma_lop` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ma_mon` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ten_mh` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mon_hoc_tung_lop`
--

INSERT INTO `mon_hoc_tung_lop` (`ID`, `ma_lop`, `ma_mon`, `ten_mh`) VALUES
(1, 'FFSE1702', 'LP#1', 'CSI by visual programming with Scratch'),
(3, 'FFSE1703', 'LP#4', 'Object-oriented programming with Java (basics)'),
(4, 'FFSE1705', 'LP#2', 'Web programming with html, css, javascript, boostrap'),
(5, 'FFSE1801', 'LP#3', 'Web-based application development (php, ajax, mysql)'),
(6, 'FFSE1802', 'LP#5', 'Web-based application development with Java'),
(7, 'FFSE1704', 'LP#6', 'Industry trendy projects '),
(9, 'FFSE1905', 'LP#3', 'Web-based application development (php, ajax, mysql)');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mon_hoc_tung_lop`
--
ALTER TABLE `mon_hoc_tung_lop`
 ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mon_hoc_tung_lop`
--
ALTER TABLE `mon_hoc_tung_lop`
MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
