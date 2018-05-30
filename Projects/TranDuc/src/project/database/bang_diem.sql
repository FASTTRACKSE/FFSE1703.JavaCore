-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2018 at 08:55 AM
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
-- Table structure for table `bang_diem`
--

CREATE TABLE IF NOT EXISTS `bang_diem` (
  `lop_sv` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ma_sv` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `LP0` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `LP1` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `LP2` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `LP3` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `LP4` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `LP5` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `LP6` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `E4IT` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `bang_diem`
--

INSERT INTO `bang_diem` (`lop_sv`, `ma_sv`, `LP0`, `LP1`, `LP2`, `LP3`, `LP4`, `LP5`, `LP6`, `E4IT`) VALUES
('FFSE1703', 'FFSE1703001', '1', '1', '1', '1', '1', '1', '1', '1'),
('FFSE1702', 'FFSE1702001', '2', '2', '2', '2', '2', '2', '2', '2'),
('FFSE1802', 'FFSE1802001', '3', '3', '3', '3', '3', '3', '3', '3'),
('FFSE1802', 'FFSE1802002', '4', '4', '4', '4', '4', '4', '4', '4'),
('FFSE1802', 'FFSE1802003', '5', '5', '5', '5', '5', '5', '5', '5'),
('FFSE1801', 'FFSE1801001', '6', '6', '6', '6', '6', '6', '6', '6'),
('FFSE1904', 'FFSE1904012', '7', '7', '7', '7', '7', '7', '7', '7'),
('FFSE1904', 'FFSE1904010', '8', '8', '8', '8', '8', '8', '8', '8'),
('FFSE1904', 'FFSE1904011', '9', '9', '9', '9', '9', '9', '9', '9'),
('FFSE1903', 'FFSE1903001', '10', '10', '10', '10', '10', '10', '10', '10'),
('FFSE1903', 'FFSE1903002', '7', '7', '7', '7', '7', '7', '7', '7'),
('FFSE1703', 'FFSE1703002', '7', '7', '7', '7', '7', '7', '7', '7');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
