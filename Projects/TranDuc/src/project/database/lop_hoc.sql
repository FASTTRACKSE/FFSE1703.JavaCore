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
-- Table structure for table `lop_hoc`
--

CREATE TABLE IF NOT EXISTS `lop_hoc` (
`ID` int(10) NOT NULL,
  `ma_lop` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ten_lop` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `nam_hoc` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `mo_ta` char(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lop_hoc`
--

INSERT INTO `lop_hoc` (`ID`, `ma_lop`, `ten_lop`, `nam_hoc`, `mo_ta`) VALUES
(104, 'FFSE1904', 'Một Chín Không Bốn', '2019', 'Không Biết Ghi Gì 1'),
(105, 'FFSE1903', 'Một Chín Không Ba', '2019', 'Không Biết Ghi Gì 2'),
(108, 'FFSE1703', 'Một Bảy Không Ba', '2017', 'Không Biết Ghi Gì 3'),
(109, 'FFSE1702', 'Một Bảy Không Hai', '2017', 'Không Biết Ghi Gì4'),
(110, 'FFSE1801', 'Một Tám Không Một', '2018', 'Không Biết Ghi Gì 5'),
(111, 'FFSE1802', 'Một Tám Không Hai', '2018', 'Không Biết Ghi Gì 6');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `lop_hoc`
--
ALTER TABLE `lop_hoc`
 ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `lop_hoc`
--
ALTER TABLE `lop_hoc`
MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=112;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
