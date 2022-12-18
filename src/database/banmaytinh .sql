-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2022 at 02:24 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banmaytinh`
--

-- --------------------------------------------------------

--
-- Table structure for table `cthoadon`
--

CREATE TABLE `cthoadon` (
  `maHD` int(11) NOT NULL,
  `MaSP` int(11) NOT NULL,
  `soLuong` int(11) NOT NULL,
  `donGia` int(11) NOT NULL,
  `thanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cthoadon`
--

INSERT INTO `cthoadon` (`maHD`, `MaSP`, `soLuong`, `donGia`, `thanhTien`) VALUES
(1, 1, 1, 120000000, 120000000),
(1, 2, 1, 20000000, 20000000),
(2, 2, 1, 15000000, 15000000),
(2, 3, 2, 270000000, 540000000),
(8, 2, 1, 12000000, 12000000),
(8, 3, 1, 12000000, 12000000),
(8, 4, 1, 35000000, 35000000),
(9, 2, 1, 12000000, 12000000),
(10, 3, 1, 12000000, 12000000),
(11, 2, 1, 12000000, 12000000),
(12, 2, 1, 12000000, 12000000),
(12, 3, 1, 12000000, 12000000),
(12, 4, 1, 35000000, 35000000),
(13, 3, 1, 12000000, 12000000),
(14, 2, 1, 12000000, 12000000),
(15, 2, 1, 12000000, 12000000),
(16, 2, 1, 12000000, 12000000),
(16, 3, 1, 12000000, 12000000),
(16, 4, 1, 35000000, 35000000),
(17, 10, 2, 40000000, 80000000),
(17, 20, 1, 18000000, 18000000),
(18, 5, 1, 42000000, 42000000),
(18, 10, 1, 40000000, 40000000),
(18, 15, 1, 29000000, 29000000),
(18, 20, 1, 18000000, 18000000),
(19, 2, 1, 35000000, 35000000),
(19, 4, 1, 27000000, 27000000),
(19, 9, 1, 27000000, 27000000),
(19, 14, 1, 32000000, 32000000),
(20, 6, 2, 40000000, 80000000),
(20, 12, 1, 32000000, 32000000),
(20, 14, 1, 32000000, 32000000),
(20, 19, 1, 25000000, 25000000),
(21, 9, 1, 27000000, 27000000),
(21, 14, 1, 32000000, 32000000),
(21, 18, 1, 25000000, 25000000),
(22, 6, 1, 40000000, 40000000),
(22, 9, 1, 27000000, 27000000),
(22, 16, 1, 27000000, 27000000),
(23, 12, 1, 32000000, 32000000),
(24, 10, 1, 40000000, 40000000),
(24, 11, 1, 28000000, 28000000),
(25, 1, 10, 12000000, 120000000),
(25, 2, 10, 35000000, 350000000),
(26, 3, 1, 19000000, 19000000),
(26, 9, 1, 27000000, 27000000);

-- --------------------------------------------------------

--
-- Table structure for table `ctkhuyenmai`
--

CREATE TABLE `ctkhuyenmai` (
  `maKM` int(11) NOT NULL,
  `maSP` int(11) NOT NULL,
  `phanTramGiam` int(11) NOT NULL,
  `dieuKien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ctkhuyenmai`
--

INSERT INTO `ctkhuyenmai` (`maKM`, `maSP`, `phanTramGiam`, `dieuKien`) VALUES
(0, 0, 0, 0),
(1, 1, 15, 12000000),
(1, 2, 10, 12000000),
(1, 3, 5, 12000000),
(1, 4, 5, 12000000),
(1, 5, 5, 12000000),
(1, 6, 7, 12000000),
(1, 7, 7, 12000000),
(1, 8, 10, 12000000),
(1, 9, 4, 12000000),
(1, 11, 3, 12000000),
(1, 12, 2, 12000000),
(1, 13, 1, 12000000),
(1, 14, 0, 0),
(1, 15, 3, 15000000),
(1, 16, 3, 15000000),
(1, 17, 3, 15000000),
(2, 0, 5, 0),
(2, 1, 15, 9000000),
(2, 4, 10, 0),
(3, 1, 5, 0),
(3, 2, 5, 12000000),
(3, 3, 5, 0),
(3, 4, 10, 0);

-- --------------------------------------------------------

--
-- Table structure for table `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `maPN` int(11) NOT NULL,
  `maSP` int(11) NOT NULL,
  `soLuong` int(11) NOT NULL,
  `donGia` int(11) NOT NULL,
  `thanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ctphieunhap`
--

INSERT INTO `ctphieunhap` (`maPN`, `maSP`, `soLuong`, `donGia`, `thanhTien`) VALUES
(1, 1, 10, 12000000, 12000000),
(1, 2, 5, 23000000, 115000000),
(1, 3, 4, 20000000, 80000000),
(2, 2, 6, 23000000, 138000000),
(2, 3, 7, 15000000, 75000000),
(4, 2, 1, 12000000, 12000000),
(5, 2, 1, 12000000, 12000000),
(5, 4, 1, 12000000, 12000000),
(6, 2, 1, 12000000, 12000000),
(6, 3, 3, 12000000, 36000000),
(7, 4, 2, 15000000, 30000000),
(8, 2, 1, 17000000, 17000000),
(8, 3, 3, 20000000, 60000000),
(8, 4, 3, 23000000, 69000000),
(9, 2, 5, 12000000, 60000000),
(10, 2, 1, 1, 1),
(11, 2, 1, 12000000, 12000000),
(11, 3, 1, 27000000, 27000000),
(11, 4, 1, 30000000, 30000000),
(12, 2, 3, 30000000, 90000000),
(13, 7, 1, 29000000, 29000000),
(13, 9, 1, 29000000, 29000000),
(13, 13, 1, 29000000, 29000000),
(14, 19, 5, 29000000, 145000000),
(14, 22, 5, 40000000, 200000000),
(14, 26, 5, 40000000, 200000000),
(14, 27, 8, 32000000, 232000000),
(15, 1, 3, 23000000, 69000000),
(15, 7, 3, 24000000, 72000000),
(15, 11, 10, 23000000, 240000000),
(15, 28, 3, 40000000, 120000000),
(15, 29, 5, 40000000, 200000000),
(16, 1, 1, 23000000, 23000000),
(16, 6, 1, 23000000, 23000000),
(16, 21, 4, 23000000, 92000000),
(16, 22, 4, 23000000, 92000000),
(16, 26, 4, 23000000, 92000000),
(17, 16, 3, 12000000, 36000000),
(17, 20, 1, 12000000, 12000000),
(17, 21, 3, 12000000, 36000000),
(17, 23, 1, 12000000, 12000000),
(18, 1, 1, 23000000, 23000000),
(18, 4, 1, 23000000, 23000000),
(18, 7, 3, 23000000, 69000000),
(18, 9, 1, 23000000, 23000000),
(18, 10, 1, 23000000, 23000000),
(18, 12, 1, 23000000, 23000000),
(19, 5, 1, 2000000, 2000000),
(20, 1, 1, 23000000, 23000000),
(21, 2, 1, 1, 1),
(22, 3, 1, 1, 1),
(22, 4, 1, 1, 1),
(23, 7, 1, 200000, 200000);

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `maHD` int(11) NOT NULL,
  `maKH` int(11) NOT NULL,
  `maNV` int(11) NOT NULL,
  `ngayLap` date NOT NULL,
  `tongTien` int(11) NOT NULL,
  `ghiChu` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`maHD`, `maKH`, `maNV`, `ngayLap`, `tongTien`, `ghiChu`) VALUES
(1, 1, 1, '2021-04-01', 87000000, 'Đã thanh toán'),
(2, 2, 2, '2021-01-01', 80000000, 'Đã thanh toán'),
(3, 4, 2, '2021-02-01', 120000000, 'Đã thanh toán'),
(4, 2, 1, '2021-05-13', 25000000, 'Đã thanh toán'),
(5, 1, 0, '2021-06-19', 59000000, 'Đã thanh toán'),
(6, 2, 0, '2021-07-19', 59000000, 'Đã thanh toán'),
(7, 2, 0, '2021-08-19', 12000000, 'Đã thanh toán'),
(8, 1, 0, '2021-09-19', 59000000, 'Đã thanh toán'),
(9, 1, 0, '2021-10-20', 12000000, 'Đã thanh toán'),
(10, 1, 0, '2021-11-21', 12000000, 'Đã thanh toán'),
(11, 2, 0, '2021-12-21', 12000000, 'Đã thanh toán'),
(12, 1, 0, '2022-01-21', 59000000, 'Đã thanh toán'),
(13, 1, 0, '2022-02-22', 11400000, 'Đã thanh toán'),
(14, 0, 0, '2022-02-22', 10800000, 'Đã thanh toán'),
(15, 1, 0, '2022-03-22', 10800000, 'Đã thanh toán'),
(16, 2, 0, '2022-03-22', 59000000, 'Đã thanh toán'),
(17, 13, 0, '2022-04-23', 98000000, 'Đã thanh toán'),
(18, 18, 0, '2022-04-23', 118680000, 'Đã thanh toán'),
(19, 1, 0, '2022-05-23', 111320000, 'Đã thanh toán'),
(20, 1, 0, '2022-05-23', 155480000, 'Đã thanh toán'),
(21, 1, 0, '2022-05-23', 80640000, 'Đã thanh toán'),
(22, 10, 0, '2022-05-23', 94000000, 'Đã thanh toán'),
(23, 2, 0, '2022-05-23', 32000000, 'Đã thanh toán'),
(24, 15, 0, '2022-05-23', 68000000, 'Đã thanh toán'),
(25, 1, 0, '2022-05-23', 470000000, 'Đã thanh toán'),
(26, 1, 0, '2022-05-25', 46000000, 'Đã thanh toán');

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `maKH` int(11) NOT NULL,
  `Ho` varchar(255) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `gioiTinh` text NOT NULL,
  `tongChiTieu` int(11) NOT NULL,
  `tinhTrang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`maKH`, `Ho`, `Ten`, `gioiTinh`, `tongChiTieu`, `tinhTrang`) VALUES
(1, 'Nguyễn Văn', 'An', 'Nam', 1109640000, 1),
(2, 'Lê Thị', 'Xuân', 'Nữ', 197000000, 1),
(3, 'Trần Văn', 'Tài', 'Nam', 35000000, 1),
(4, 'Nguyễn Thi Ngọc', 'Anh', 'Nữ', 27000000, 1),
(5, 'Lê Thị', 'B', 'Nam', 0, 0),
(7, 'Lê Anh ', 'Bình', 'Nữ', 46000000, 1),
(8, 'Trần Văn', 'Lâm', 'Nam', 12000000, 1),
(9, 'Trần Xuân ', 'Phúc', 'Nam', 27000000, 1),
(10, 'Nguyễn Thị Lan', 'Anh', 'Nữ', 186000000, 1),
(11, 'Mai Chí', 'Công', 'Nam', 32000000, 1),
(12, 'Lê Văn Công', 'Tiến', 'Nam', 12000000, 1),
(13, 'Nguyễn Thị An', 'Nhiên', 'Nữ', 121000000, 1),
(14, 'Lê Quốc', 'An', 'Nam', 45000000, 1),
(15, 'Trần Thủ Thiên', 'An', 'Nữ', 95000000, 1),
(16, 'Trương Thanh ', 'Xuân', 'Nam', 48000000, 1),
(17, 'Hoàng Xuân  ', 'Sang', 'Nam', 13000000, 1),
(18, 'Lê Quốc Minh  ', 'Anh', 'Nam', 143680000, 1),
(19, 'Trương Thị Thục', 'Tâm', 'Nam', 37000000, 1),
(20, 'Lê Thị Ngọc', 'Diễm', 'Nam', 68000000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `maKM` int(11) NOT NULL,
  `tenKM` varchar(255) NOT NULL,
  `ngayBD` date NOT NULL,
  `ngayKT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khuyenmai`
--

INSERT INTO `khuyenmai` (`maKM`, `tenKM`, `ngayBD`, `ngayKT`) VALUES
(0, 'Không khuyến mãi', '2021-05-01', '2034-05-04'),
(1, 'Khuyến mãi Back to School', '2022-05-01', '2024-10-05'),
(2, 'Tết Nguyên Đán', '2022-01-01', '2024-02-01'),
(3, 'Khuyến mãi Black  Friday', '2021-11-24', '2024-11-30');

-- --------------------------------------------------------

--
-- Table structure for table `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `maLoai` int(11) NOT NULL,
  `tenLoai` varchar(120) NOT NULL,
  `maNCC` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loaisanpham`
--

INSERT INTO `loaisanpham` (`maLoai`, `tenLoai`, `maNCC`) VALUES
(1, 'Dell', 1),
(2, 'MSI', 1),
(3, 'Asus', 3),
(4, 'HP', 2),
(5, 'Acer', 3),
(6, 'Lenovo', 3),
(7, 'MacBook', 4),
(8, 'LG', 4);

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `maNCC` int(11) NOT NULL,
  `tenNCC` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `SDT` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`maNCC`, `tenNCC`, `diachi`, `SDT`) VALUES
(1, 'Công Ty An Phát', '99 An Dương Vương phường 16 quận 8 HCM', '1281015513'),
(2, 'Công ty Đại An', '123 Lý Thái Tổ Phường 2 quận 6 HCM', '1281015513'),
(3, 'Công Ty Hồng Phúc', '144 An Dương Vương Phường  3 quận 5 HCM', '1281015513'),
(4, 'Trung Tâm Máy Tính Hoàng Hải', 'Số 11, ngõ 24, đường Đào Tấn, Phường Cống Vị, Quận Ba Đình, Hà nôi', '1281015513'),
(5, 'Công ty Anh Quân', 'Số 12 ngõ 8, phố Liễu Giai, Phường Cống Vị, Quận Ba Đình, Thành phố Hà Nội\n\n', '0931023066'),
(6, 'Trung Tâm Công Nghệ Đại An', 'Số 26, phố Nguyễn Văn Ngọc, Phường Cống Vị, Quận Ba Đình, Thành phố Hà Nội\n\n', '0864013025'),
(7, 'Cửa Hàng Ngọc Anh', 'Số 35 Điện Biên Phủ, Phường Điện Biên, Quận Ba Đình, Thành phố Hà Nộ\n\n', '0123456789'),
(8, '1', '1', '1111111111');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `maNV` int(11) NOT NULL,
  `Ho` varchar(255) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `gioiTinh` text NOT NULL,
  `chucVu` varchar(100) NOT NULL,
  `tinhTrang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`maNV`, `Ho`, `Ten`, `gioiTinh`, `chucVu`, `tinhTrang`) VALUES
(0, 'Admin', '', '', 'Admin', 1),
(1, 'Trần Thị', 'Loan', 'Nam', 'Nhân viên', 1),
(2, 'Lê Văn', 'Khánh', 'Nam', 'Nhân viên', 1),
(3, 'Trần Công', 'Khang', 'Nam', 'Nhân viên', 1),
(4, 'Nguyễn Thị Ngọc', 'Anh', 'Nam', 'Nhân viên', 1),
(5, 'Nguyễn Văn', 'Linh', 'Nam', 'Nhân viên', 1),
(6, 'Trần Xuân', 'Tùng', 'Nam', 'Quản lý', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phanquyen`
--

CREATE TABLE `phanquyen` (
  `quyen` varchar(255) NOT NULL,
  `NHAPHANG` int(11) NOT NULL,
  `QLSANPHAM` int(11) NOT NULL,
  `QLNHANVIEN` int(11) NOT NULL,
  `QLKHACHHANG` int(11) NOT NULL,
  `THONGKE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phanquyen`
--

INSERT INTO `phanquyen` (`quyen`, `NHAPHANG`, `QLSANPHAM`, `QLNHANVIEN`, `QLKHACHHANG`, `THONGKE`) VALUES
('Admin', 1, 1, 1, 1, 1),
('Nhân viên', 0, 0, 0, 1, 0),
('Quản lý', 1, 0, 0, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maPN` int(11) NOT NULL,
  `maNCC` int(11) NOT NULL,
  `maNV` int(11) NOT NULL,
  `ngayNhap` date NOT NULL,
  `tongTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`maPN`, `maNCC`, `maNV`, `ngayNhap`, `tongTien`) VALUES
(1, 1, 1, '2022-01-02', 120000000),
(2, 2, 2, '2021-02-01', 35000000),
(4, 1, 1, '2021-05-21', 12000000),
(5, 1, 1, '2021-04-21', 12000000),
(6, 2, 1, '2021-05-21', 48000000),
(7, 3, 2, '2021-06-21', 30000000),
(8, 2, 4, '2021-07-21', 146000000),
(9, 4, 1, '2021-07-21', 60000000),
(10, 3, 0, '2021-08-21', 155000000),
(11, 1, 2, '2021-09-22', 69000000),
(12, 2, 0, '2021-10-22', 90000000),
(13, 3, 0, '2022-01-23', 87000000),
(14, 7, 0, '2022-02-23', 777000000),
(15, 7, 0, '2022-03-23', 701000000),
(16, 1, 0, '2022-04-23', 322000000),
(17, 1, 0, '2022-05-23', 72000000),
(18, 1, 0, '2022-05-23', 184000000),
(19, 7, 0, '2022-05-23', 2000000),
(20, 7, 0, '2022-05-23', 23000000),
(21, 1, 0, '2022-05-23', 1),
(22, 1, 0, '2022-05-23', 2),
(23, 5, 0, '2022-11-02', 200000);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSP` int(11) NOT NULL,
  `tenSP` varchar(255) NOT NULL,
  `soLuong` int(11) NOT NULL,
  `donGia` int(11) NOT NULL,
  `maLoai` int(11) NOT NULL,
  `hinhAnh` text NOT NULL,
  `moTa` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `tenSP`, `soLuong`, `donGia`, `maLoai`, `hinhAnh`, `moTa`) VALUES
(1, 'Dell Inprison', 54, 12000000, 1, 'maytinh.jpg', 'none'),
(2, 'Dell XPS', 36, 35000000, 1, 'maytinh.jpg', 'none'),
(3, 'Dell Vostro', 60, 19000000, 1, 'maytinh.jpg', 'none'),
(4, 'Dell Latitude', 20, 27000000, 1, 'maytinh.jpg', 'none'),
(5, 'MSI Creator', 14, 42000000, 2, 'maytinh.jpg', 'none'),
(6, 'MSI GE66 Raider', 12, 40000000, 2, 'maytinh.jpg', 'none'),
(7, 'MSI Summit E13', 19, 29000000, 2, 'maytinh.jpg', 'none'),
(8, 'MSI Gaming Pulse', 10, 30000000, 2, 'maytinh.jpg', 'none'),
(9, 'Asus TUF Gaming', 18, 27000000, 3, 'maytinh.jpg', 'none'),
(10, 'Asus ROG Strix', 6, 40000000, 3, 'maytinh.jpg', 'none'),
(11, 'Asus Zenbook', 23, 28000000, 3, 'maytinh.jpg', 'none'),
(12, 'Asus Vivobook', 17, 32000000, 3, 'maytinh.jpg', 'none'),
(13, 'Asus Expertbook', 15, 28000000, 3, 'maytinh.jpg', 'none'),
(14, 'HP Gaming Victus', 7, 32000000, 4, 'maytinh.jpg', 'none'),
(15, 'HP EliteBook', 11, 29000000, 4, 'maytinh.jpg', 'none'),
(16, 'HP Zbook Firefly', 10, 27000000, 4, 'maytinh.jpg', 'none'),
(17, 'HP Envy x360', 10, 37000000, 4, 'maytinh.jpg', 'none'),
(18, 'HP Pavilion', 10, 25000000, 4, 'maytinh.jpg', 'none'),
(19, 'Acer Nitro 5 Gaming', 14, 25000000, 5, 'maytinh.jpg', 'none'),
(20, 'Acer Swift SFX 16', 9, 18000000, 5, 'maytinh.jpg', 'none'),
(21, 'Acer Aspire 7 Gaming', 20, 21000000, 5, 'maytinh.jpg', 'none'),
(22, 'Lenovo Ideapad 3', 19, 12000000, 6, 'maytinh.jpg', 'none'),
(23, 'Lenovo ILegion 5', 12, 27000000, 6, 'maytinh.jpg', 'none'),
(24, 'Lenovo Yoga Slim 7', 20, 32000000, 6, 'maytinh.jpg', 'none'),
(25, 'Lenovo Thinks book', 12, 35000000, 6, 'maytinh.jpg', 'none'),
(26, 'Macbook Air M1', 29, 28000000, 7, 'maytinh.jpg', 'none'),
(27, 'Macbook Pro M1', 25, 40000000, 7, 'maytinh.jpg', 'none'),
(28, 'LG Gram 17', 21, 44000000, 8, 'maytinh.jpg', 'none'),
(29, 'LG Gram 16', 23, 39000000, 8, 'maytinh.jpg', 'none');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `maNV` int(11) NOT NULL,
  `tenDN` varchar(255) NOT NULL,
  `matKhau` varchar(255) NOT NULL,
  `quyen` varchar(255) NOT NULL,
  `trangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`maNV`, `tenDN`, `matKhau`, `quyen`, `trangThai`) VALUES
(0, 'Admin', 'Admin', 'Admin', 1),
(1, 'nv01', 'nv01', 'Nhân viên', 1),
(6, 'ql06', 'ql06', 'Quản lý', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD PRIMARY KEY (`maHD`,`MaSP`),
  ADD KEY `MaSP` (`MaSP`);

--
-- Indexes for table `ctkhuyenmai`
--
ALTER TABLE `ctkhuyenmai`
  ADD PRIMARY KEY (`maKM`,`maSP`);

--
-- Indexes for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD PRIMARY KEY (`maPN`,`maSP`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`maHD`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`maKH`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`maKM`);

--
-- Indexes for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`maLoai`),
  ADD KEY `maNCC` (`maNCC`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`maNCC`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`maNV`);

--
-- Indexes for table `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`quyen`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`maPN`),
  ADD KEY `maNV` (`maNV`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `sanpham_ibfk_1` (`maLoai`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`maNV`),
  ADD KEY `quyen` (`quyen`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `maHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `maLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `maNCC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `maPN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MaSP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=145;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD CONSTRAINT `cthoadon_ibfk_1` FOREIGN KEY (`maHD`) REFERENCES `hoadon` (`maHD`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ctkhuyenmai`
--
ALTER TABLE `ctkhuyenmai`
  ADD CONSTRAINT `ctkhuyenmai_ibfk_1` FOREIGN KEY (`maKM`) REFERENCES `khuyenmai` (`maKM`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD CONSTRAINT `ctphieunhap_ibfk_1` FOREIGN KEY (`maPN`) REFERENCES `phieunhap` (`maPN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD CONSTRAINT `loaisanpham_ibfk_1` FOREIGN KEY (`maNCC`) REFERENCES `nhacungcap` (`maNCC`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`maLoai`) REFERENCES `loaisanpham` (`maLoai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`maNV`) REFERENCES `nhanvien` (`maNV`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `taikhoan_ibfk_2` FOREIGN KEY (`quyen`) REFERENCES `phanquyen` (`quyen`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
