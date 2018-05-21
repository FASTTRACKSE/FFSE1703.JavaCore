-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 18, 2018 lúc 12:21 PM
-- Phiên bản máy phục vụ: 10.1.31-MariaDB
-- Phiên bản PHP: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ffse1703005`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `atm_atm`
--

CREATE TABLE `atm_atm` (
  `id_atm` int(20) NOT NULL,
  `code` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `code_districts` int(10) NOT NULL,
  `code_wards` int(10) NOT NULL,
  `streets` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `amount` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `atm_atm`
--

INSERT INTO `atm_atm` (`id_atm`, `code`, `code_districts`, `code_wards`, `streets`, `amount`) VALUES
(1, 'MATM803499', 1, 20195, '81 Xuân Thiều', 497430000),
(2, 'MATM803498', 2, 20207, '342 Trần Cao Vân', 247070000),
(3, 'MATM803497', 3, 20236, '72 Lê Duẫn', 729620000),
(4, 'MATM803496', 4, 20263, '573 Ngô Quyền', 366180000),
(5, 'MATM803495', 5, 20285, '274 Lê Văn Hiến', 418070000),
(6, 'MATM803494', 6, 20306, '387 Nguyễn Đình Tứ', 122580000),
(7, 'MATM803493', 7, 20302, 'Quốc Lộ AH1', 199827877);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `atm_customer`
--

CREATE TABLE `atm_customer` (
  `id_cus` int(20) NOT NULL,
  `code` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `fullname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `code_districts` int(10) NOT NULL,
  `code_wards` int(10) NOT NULL,
  `streets` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `cardnumber` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `pin` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `amount` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `atm_customer`
--

INSERT INTO `atm_customer` (`id_cus`, `code`, `fullname`, `code_districts`, `code_wards`, `streets`, `phone`, `email`, `cardnumber`, `pin`, `amount`) VALUES
(1, 'MKH14041994', 'Chung Hải Nam', 1, 20197, '856 Tôn Đức Thắng', '01699803499', 'hainamchung94@gmail.com', '100014041994', 'hainam', 96230000),
(2, 'MKH14041995', 'Nguyễn Đức Thạch', 2, 20207, '80 Kỳ Đồng', '0967828469', 'thachduc@gmail.com', '100014041995', '123456', 9200000),
(3, 'MKH14041998', 'Vũ Thị Lan Hương', 4, 20263, '573 Ngô Quyền', '01283578800', 'huongvtl@gmail.com', '100014041998', '123456', 49110000),
(4, 'MKH14041987', 'Lê Vĩnh Ngọc', 5, 20287, '31 Võ Chí Công', '0968258480', 'ngocvinh@gmail.com', '100014041987', '123456', 74600000),
(5, 'MKH14041990', 'Lê Hữu Hoài Nam', 4, 20263, '69 Lê Văn Chương', '0972333378', 'namlehuu@gmail.com', '100014041990', '123456', 35940000),
(6, 'MKH14041996', 'Tống Lê Quốc Đạt', 5, 20287, '287 Võ Chí Công', '0914872632', 'datle@gmail.com', '100014041996', '123456', 1007800),
(7, 'MKH14041993', 'Trần Đình Tuấn', 1, 20198, '72 Lạc Long Quân', '0978843260', 'tuan@gmail.com', '100014041993', '123456', 81000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `atm_districts`
--

CREATE TABLE `atm_districts` (
  `code_districts` varchar(5) CHARACTER SET utf8 NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `type` varchar(30) CHARACTER SET utf8 NOT NULL,
  `matp` varchar(5) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `atm_districts`
--

INSERT INTO `atm_districts` (`code_districts`, `name`, `type`, `matp`) VALUES
('1', 'Liên Chiểu', 'Quận', '48'),
('2', 'Thanh Khê', 'Quận', '48'),
('3', 'Hải Châu', 'Quận', '48'),
('4', 'Sơn Trà', 'Quận', '48'),
('5', 'Ngũ Hành Sơn', 'Quận', '48'),
('6', 'Cẩm Lệ', 'Quận', '48'),
('7', 'Huyện Hòa Vang', 'Huyện', '48');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `atm_transactions`
--

CREATE TABLE `atm_transactions` (
  `id_transactions` int(20) NOT NULL,
  `code_customer` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `code_atm` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `code_transactions` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `time_transactions` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` int(20) NOT NULL,
  `status` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `atm_transactions`
--

INSERT INTO `atm_transactions` (`id_transactions`, `code_customer`, `code_atm`, `code_transactions`, `time_transactions`, `amount`, `status`) VALUES
(1, 'MKH14041994', 'MATM803499', 'MGD3639000', '2018-05-07 22:00:39', 370000, 'Rút Tiền'),
(2, 'MKH14041994', 'MATM803499', 'MGD12964000', '2018-05-08 17:23:56', 1000000, 'Rút Tiền'),
(3, 'MKH14041995', 'MATM803498', 'MGD38531000', '2018-05-08 17:42:11', 50000, 'Rút Tiền'),
(4, 'MKH14041994', 'MATM803497', 'MGD33416000', '2018-05-10 16:16:56', 50000, 'Rút Tiền'),
(5, 'MKH14041998', 'MATM803496', 'MGD47991000', '2018-05-12 20:19:51', 700000, 'Rút Tiền'),
(6, 'MKH14041987', 'MATM803496', 'MGD48121000', '2018-05-12 20:22:01', 370000, 'Rút Tiền'),
(7, 'MKH14041987', 'MATM803495', 'MGD48304000', '2018-05-12 20:25:04', 30000, 'Rút Tiền'),
(8, 'MKH14041990', 'MATM803498', 'MGD48392000', '2018-05-12 20:26:32', 2300000, 'Rút Tiền'),
(9, 'MKH14041996', 'MATM803493', 'MGD49158000', '2018-05-12 20:39:18', 172123, 'Rút Tiền'),
(10, 'MKH14041998', 'MATM803496', 'MGD49584000', '2018-05-12 20:46:24', 1230000, 'Rút Tiền'),
(11, 'MKH14041994', 'MATM803495', 'MGD49798000', '2018-05-12 20:49:58', 1210000, 'Rút Tiền'),
(12, 'MKH14041996', 'MATM803498', 'MGD49940000', '2018-05-12 20:52:20', 110000, 'Rút Tiền'),
(13, 'MKH14041994', 'MATM803498', 'MGD56210000', '2018-05-15 22:36:50', 370000, 'Rút Tiền'),
(14, 'MKH14041995', 'MATM803497', 'MGD56318000', '2018-05-15 22:38:38', 280000, 'Rút Tiền'),
(15, 'MKH14041996', 'Tại Hệ Thống', 'MGD25121000', '2018-05-16 00:01:19', 30000, 'Nạp Tiền'),
(16, 'MKH14041998', 'Tại Hệ Thống', 'MGD24587000', '2018-05-16 00:10:13', 1270000, 'Nạp Tiền'),
(17, 'MKH14041996', 'MATM803497', 'MGD-23876000', '2018-05-16 00:22:04', 50000, 'Rút Tiền'),
(18, 'MKH14041990', 'Tại Hệ Thống', 'MGD-17530000', '2018-05-16 02:07:50', 240000, 'Nạp Tiền'),
(19, 'MKH14041994', 'MATM803498', 'MGD-12797000', '2018-05-16 03:26:43', 70000, 'Rút Tiền'),
(20, 'MKH14041995', 'MATM803498', 'MGD-12716000', '2018-05-16 03:28:04', 30000, 'Rút Tiền'),
(21, 'MKH14041995', 'MATM803495', 'MGD34381000', '2018-05-18 16:33:01', 370000, 'Rút Tiền'),
(22, 'MKH14041995', 'MATM803495', 'MGD34390000', '2018-05-18 16:33:10', 240000, 'Rút Tiền'),
(23, 'MKH14041995', 'MATM803495', 'MGD34396000', '2018-05-18 16:33:16', 10000, 'Rút Tiền'),
(24, 'MKH14041995', 'MATM803495', 'MGD34401000', '2018-05-18 16:33:21', 70000, 'Rút Tiền'),
(25, 'MKH14041996', 'MATM803494', 'MGD34480000', '2018-05-18 16:34:40', 420000, 'Rút Tiền'),
(26, 'MKH14041998', 'MATM803496', 'MGD34739000', '2018-05-18 16:38:59', 90000, 'Rút Tiền'),
(27, 'MKH14041998', 'MATM803496', 'MGD34747000', '2018-05-18 16:39:07', 1200000, 'Rút Tiền'),
(28, 'MKH14041998', 'MATM803496', 'MGD34753000', '2018-05-18 16:39:13', 230000, 'Rút Tiền');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `atm_user`
--

CREATE TABLE `atm_user` (
  `id_user` int(20) NOT NULL,
  `username` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `code` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `fullname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `position` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `agency` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `atm_user`
--

INSERT INTO `atm_user` (`id_user`, `username`, `code`, `password`, `fullname`, `position`, `agency`) VALUES
(1, 'hainam', 'MNV699803', '123123', 'Chung Hải Nam', 'Chuyên Viên KH', 'Liên Chiểu'),
(2, 'admin', 'MNV699802', '123456', 'adminitration', 'NV Kinh Doanh', 'Hải Châu');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `atm_wards`
--

CREATE TABLE `atm_wards` (
  `code_wards` varchar(5) CHARACTER SET utf8 NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `type` varchar(30) CHARACTER SET utf8 NOT NULL,
  `code_districts` varchar(5) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `atm_wards`
--

INSERT INTO `atm_wards` (`code_wards`, `name`, `type`, `code_districts`) VALUES
('20194', 'Hòa Hiệp Bắc', 'Phường', '1'),
('20195', 'Hòa Hiệp Nam', 'Phường', '1'),
('20197', 'Hòa Khánh Bắc', 'Phường', '1'),
('20198', 'Hòa Khánh Nam', 'Phường', '1'),
('20200', 'Hòa Minh', 'Phường', '1'),
('20203', 'Tam Thuận', 'Phường', '2'),
('20206', 'Thanh Khê Tây', 'Phường', '2'),
('20207', 'Thanh Khê Đông', 'Phường', '2'),
('20209', 'Xuân Hà', 'Phường', '2'),
('20212', 'Tân Chính', 'Phường', '2'),
('20215', 'Chính Gián', 'Phường', '2'),
('20218', 'Vĩnh Trung', 'Phường', '2'),
('20221', 'Thạc Gián', 'Phường', '2'),
('20224', 'An Khê', 'Phường', '2'),
('20225', 'Hòa Khê', 'Phường', '2'),
('20227', 'Thanh Bình', 'Phường', '3'),
('20230', 'Thuận Phước', 'Phường', '3'),
('20233', 'Thạch Thang', 'Phường', '3'),
('20236', 'Hải Châu  I', 'Phường', '3'),
('20239', 'Hải Châu II', 'Phường', '3'),
('20242', 'Phước Ninh', 'Phường', '3'),
('20245', 'Hòa Thuận Tây', 'Phường', '3'),
('20246', 'Hòa Thuận Đông', 'Phường', '3'),
('20248', 'Nam Dương', 'Phường', '3'),
('20251', 'Bình Hiên', 'Phường', '3'),
('20254', 'Bình Thuận', 'Phường', '3'),
('20257', 'Hòa Cường Bắc', 'Phường', '3'),
('20258', 'Hòa Cường Nam', 'Phường', '3'),
('20260', 'Khuê Trung', 'Phường', '6'),
('20263', 'Thọ Quang', 'Phường', '4'),
('20266', 'Nại Hiên Đông', 'Phường', '4'),
('20269', 'Mân Thái', 'Phường', '4'),
('20272', 'An Hải Bắc', 'Phường', '4'),
('20275', 'Phước Mỹ', 'Phường', '4'),
('20278', 'An Hải Tây', 'Phường', '4'),
('20281', 'An Hải Đông', 'Phường', '4'),
('20284', 'Mỹ An', 'Phường', '5'),
('20285', 'Khuê Mỹ', 'Phường', '5'),
('20287', 'Hoà Quý', 'Phường', '5'),
('20290', 'Hoà Hải', 'Phường', '5'),
('20293', 'Xã Hòa Bắc', 'Xã', '7'),
('20296', 'Xã Hòa Liên', 'Xã', '7'),
('20299', 'Xã Hòa Ninh', 'Xã', '7'),
('20302', 'Xã Hòa Sơn', 'Xã', '7'),
('20305', 'Hòa Phát', 'Phường', '6'),
('20306', 'Hòa An', 'Phường', '6'),
('20308', 'Xã Hòa Nhơn', 'Xã', '7'),
('20311', 'Hòa Thọ Tây', 'Phường', '6'),
('20312', 'Hòa Thọ Đông', 'Phường', '6'),
('20314', 'Hòa Xuân', 'Phường', '6'),
('20317', 'Xã Hòa Phú', 'Xã', '7'),
('20320', 'Xã Hòa Phong', 'Xã', '7'),
('20323', 'Xã Hòa Châu', 'Xã', '7'),
('20326', 'Xã Hòa Tiến', 'Xã', '7'),
('20329', 'Xã Hòa Phước', 'Xã', '7'),
('20332', 'Xã Hòa Khương', 'Xã', '7');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `atm_atm`
--
ALTER TABLE `atm_atm`
  ADD PRIMARY KEY (`id_atm`);

--
-- Chỉ mục cho bảng `atm_customer`
--
ALTER TABLE `atm_customer`
  ADD PRIMARY KEY (`id_cus`);

--
-- Chỉ mục cho bảng `atm_districts`
--
ALTER TABLE `atm_districts`
  ADD PRIMARY KEY (`code_districts`);

--
-- Chỉ mục cho bảng `atm_transactions`
--
ALTER TABLE `atm_transactions`
  ADD PRIMARY KEY (`id_transactions`);

--
-- Chỉ mục cho bảng `atm_user`
--
ALTER TABLE `atm_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `atm_atm`
--
ALTER TABLE `atm_atm`
  MODIFY `id_atm` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `atm_customer`
--
ALTER TABLE `atm_customer`
  MODIFY `id_cus` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `atm_transactions`
--
ALTER TABLE `atm_transactions`
  MODIFY `id_transactions` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT cho bảng `atm_user`
--
ALTER TABLE `atm_user`
  MODIFY `id_user` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
