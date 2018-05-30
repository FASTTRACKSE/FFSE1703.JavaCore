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
-- Table structure for table `mon_hoc`
--

CREATE TABLE IF NOT EXISTS `mon_hoc` (
`ID` int(10) NOT NULL,
  `ma_mh` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ten_mh` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tin_chi_mh` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `time_mh` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mon_hoc`
--

INSERT INTO `mon_hoc` (`ID`, `ma_mh`, `ten_mh`, `tin_chi_mh`, `time_mh`) VALUES
(45, 'LP#0', 'Living in a digital world', '10', '30h'),
(46, 'LP#1', 'CSI by visual programming with Scratch', '5', '25h'),
(47, 'LP#2', 'Web programming with html, css, javascript, boostrap', '6', '30h'),
(48, 'LP#3', 'Web-based application development (php, ajax, mysql)', '4', '35h'),
(49, 'LP#4', 'Object-oriented programming with Java (basics)', '4', '40h'),
(50, 'LP#5', 'Web-based application development with Java', '4', '40h'),
(51, 'LP#6', 'Industry trendy projects ', '4', '30h'),
(53, 'E4IT', 'English for infromation technology', '4', '50h');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mon_hoc`
--
ALTER TABLE `mon_hoc`
 ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mon_hoc`
--
ALTER TABLE `mon_hoc`
MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=57;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
