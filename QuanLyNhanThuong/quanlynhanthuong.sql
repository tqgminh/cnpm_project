/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  khuongvien
 * Created: Dec 14, 2020
 */

-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 14, 2020 lúc 12:52 PM
-- Phiên bản máy phục vụ: 10.4.14-MariaDB
-- Phiên bản PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlynhanthuong`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoc_sinh_gioi`
--

CREATE TABLE `hoc_sinh_gioi` (
  `id` int(11) DEFAULT NULL,
  `hoTen` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tuoi` int(11) DEFAULT NULL,
  `truongLop` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thanhTich` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `chungNhan` bit(1) DEFAULT NULL,
  `id_hoGiaDinh` int(11) DEFAULT NULL,
  `phanThuong` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `giaTri` int(11) DEFAULT NULL,
  `id_nhanThuong` int(11) NOT NULL,
  `ngayThuong` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoc_sinh_gioi`
--

INSERT INTO `hoc_sinh_gioi` (`id`, `hoTen`, `tuoi`, `truongLop`, `thanhTich`, `chungNhan`, `id_hoGiaDinh`, `phanThuong`, `giaTri`, `id_nhanThuong`, `ngayThuong`) VALUES
(2, 'Trần Thảo Linh', 18, 'THPT chuyên KHTN, ĐHQG Hà Nội', 'Học sinh giỏi quốc gia', b'1', 2, '10 quyển vở', 100000, 2, '2020-11-14'),
(3, 'Nguyễn Thu Minh', 14, 'THCS Ngô Gia Tự, Hà Nội', 'Học sinh tiên tiến', b'1', 1, '7 quyển vở', 70000, 3, '2020-11-14'),
(4, 'Nguyễn Ngọc Bảo Lan', 8, 'Tiểu học Bạch Mai, Hà Nội', 'Học sinh giỏi', b'0', 3, NULL, NULL, 4, NULL),
(5, 'Nguyễn Hồ Hoài Anh', 10, 'Tiểu học Bạch Mai, Hà Nội', 'Học sinh khá', b'1', 4, '5 quyển vở', 50000, 5, '2020-11-14'),
(6, 'Trần Thanh Tùng', 11, 'THCS Ngô Gia Tự, Hà Nội', 'Học sinh tiên tiến', b'1', 3, '7 quyển vở', 70000, 6, '2020-11-14'),
(7, 'Lê Tiến Đạt', 15, 'THPT Thăng Long, Hà Nội', 'Học sinh giỏi', b'1', 2, '10 quyển vở', 100000, 7, '2020-11-14'),
(1, 'Hoàng Minh Quang', 17, 'THPT Thăng Long, Hà Nội', 'Học sinh giỏi thành phố', b'1', 1, '10 quyển vở', 100000, 8, '2020-11-14');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ho_gia_dinh`
--

CREATE TABLE `ho_gia_dinh` (
  `id` int(11) NOT NULL,
  `chuHo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diaChi` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `soTien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ho_gia_dinh`
--

INSERT INTO `ho_gia_dinh` (`id`, `chuHo`, `diaChi`, `soTien`) VALUES
(1, 'Nguyễn Hải Dương', 'Số 15, Bạch Mai, Hai Bà Trưng, Hà Nội', 220000),
(2, 'Đỗ Nam Trung', 'Số 20, Minh Khai, Hai Bà Trưng, Hà Nội', 250000),
(3, 'Nguyễn Văn Trung', 'Số 30, Trần Đại Nghĩa, Hai Bà Trưng, Hà Nội', 170000),
(4, 'Mã Tiến An', 'Số 27, Đại La, Hai Bà Trưng, Hà Nội', 100000),
(5, 'Trần Huyền Trang', 'Số 17, Tạ Quang Bửu, Hai Bà Trưng, Hà Nội', 100000),
(6, 'Phạm Nhật Vượng', 'Chung cư Tímes City', 50000),
(7, 'Đặng Nhật Minh', 'Số 120, Minh Khai, Hai bà Trưng, Hà Nội', 100000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quy_tien_thuong`
--

CREATE TABLE `quy_tien_thuong` (
  `id` int(11) NOT NULL,
  `hoTen` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `soTien` int(11) NOT NULL,
  `ngayThang` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `quy_tien_thuong`
--

INSERT INTO `quy_tien_thuong` (`id`, `hoTen`, `soTien`, `ngayThang`) VALUES
(1, 'Phạm Nhật Vượng', 10000000, '2020-11-01'),
(2, 'Trần Thảo Linh', -100000, '2020-11-14'),
(3, 'Nguyễn Thu Minh', -70000, '2020-11-14'),
(4, 'Nguyễn Ngọc Bảo Lan', 0, '2020-11-14'),
(5, 'Nguyễn Hồ Hoài Anh', -50000, '2020-11-14'),
(6, 'Trần Thanh Tùng', -70000, '2020-11-14'),
(7, 'Lê Tiến Đạt', -100000, '2020-11-14'),
(8, 'Hoàng Minh Quang', -100000, '2020-11-14'),
(9, 'Phùng Quang Lâm', -50000, '2020-11-14'),
(10, 'Nguyễn Quang Hải', -50000, '2020-11-14'),
(11, 'Nguyễn Ngọc Bảo Lan', -50000, '2020-11-14'),
(12, 'Trần Thanh Tùng', -50000, '2020-11-13'),
(13, 'Lê Tiến Đạt', -50000, '2020-11-14'),
(14, 'Trần Đức An', -50000, '2020-11-14'),
(15, 'Hoàng Minh Quang', -50000, '2020-11-14'),
(16, 'Trần Đăng Quang', -50000, '2020-11-14'),
(17, 'Nguyễn Minh Quân', -50000, '2020-11-14'),
(18, 'Hoàng Bá Thái', -50000, '2020-11-14');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tre_em`
--

CREATE TABLE `tre_em` (
  `id` int(11) NOT NULL,
  `hoTen` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tuoi` int(11) NOT NULL,
  `id_hoGiaDinh` int(11) NOT NULL,
  `phanThuong` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `giaTri` int(11) NOT NULL,
  `id_nhanThuong` int(11) NOT NULL,
  `ngayThuong` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tre_em`
--

INSERT INTO `tre_em` (`id`, `hoTen`, `tuoi`, `id_hoGiaDinh`, `phanThuong`, `giaTri`, `id_nhanThuong`, `ngayThuong`) VALUES
(8, 'Phùng Quang Lâm', 15, 5, '1 hộp bánh Chocopie', 50000, 9, '2020-11-14'),
(9, 'Nguyễn Quang Hải', 10, 4, '1 vỉ sữa Vinamilk', 50000, 10, '2020-11-14'),
(4, 'Nguyễn Ngọc Bảo Lan', 8, 3, '1 hộp bánh Chocopie', 50000, 11, '2020-11-14'),
(6, 'Trần Thanh Tùng', 11, 3, '1 bộ truyện cổ tích', 50000, 12, '2020-11-13'),
(7, 'Lê Tiến Đạt', 15, 2, '1 gói kẹo', 50000, 13, '2020-11-14'),
(12, 'Trần Đức An', 14, 5, '1 vỉ sữa TH-True Milk', 50000, 14, '2020-11-14'),
(1, 'Hoàng Minh Quang', 17, 1, '1 hộp thạch rau câu', 50000, 15, '2020-11-14'),
(11, 'Trần Đăng Quang', 10, 6, '1 vỉ sữa Ba Vì', 50000, 16, '2020-11-14'),
(13, 'Nguyễn Minh Quân', 9, 7, '1 hộp bánh Chocopie', 50000, 17, '2020-11-14'),
(14, 'Hoàng Bá Thái', 5, 7, '1 gói kẹo', 50000, 18, '2020-11-14');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'minhtq', 'minhtq'),
(2, 'hoangbv', 'hoangbv'),
(3, 'duytd', 'duytd'),
(4, 'thoaitv', 'thoaitv'),
(5, 'khuongvd', 'khuongvd');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `hoc_sinh_gioi`
--
ALTER TABLE `hoc_sinh_gioi`
  ADD PRIMARY KEY (`id_nhanThuong`),
  ADD KEY `id_hoGiaDinh` (`id_hoGiaDinh`);

--
-- Chỉ mục cho bảng `ho_gia_dinh`
--
ALTER TABLE `ho_gia_dinh`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `quy_tien_thuong`
--
ALTER TABLE `quy_tien_thuong`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tre_em`
--
ALTER TABLE `tre_em`
  ADD PRIMARY KEY (`id_nhanThuong`),
  ADD KEY `id_hoGiaDinh` (`id_hoGiaDinh`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `hoc_sinh_gioi`
--
ALTER TABLE `hoc_sinh_gioi`
  ADD CONSTRAINT `hoc_sinh_gioi_ibfk_1` FOREIGN KEY (`id_hoGiaDinh`) REFERENCES `ho_gia_dinh` (`id`),
  ADD CONSTRAINT `hoc_sinh_gioi_ibfk_2` FOREIGN KEY (`id_nhanThuong`) REFERENCES `quy_tien_thuong` (`id`);

--
-- Các ràng buộc cho bảng `tre_em`
--
ALTER TABLE `tre_em`
  ADD CONSTRAINT `tre_em_ibfk_1` FOREIGN KEY (`id_hoGiaDinh`) REFERENCES `ho_gia_dinh` (`id`),
  ADD CONSTRAINT `tre_em_ibfk_2` FOREIGN KEY (`id_nhanThuong`) REFERENCES `quy_tien_thuong` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
