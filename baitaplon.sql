-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: baitaplon
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_admin`
--

DROP TABLE IF EXISTS `tbl_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_admin` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `roles` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_noi_dung_de_xuat`
--

DROP TABLE IF EXISTS `tbl_noi_dung_de_xuat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_noi_dung_de_xuat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `don_gia` int(11) DEFAULT NULL,
  `ghi_chu` varchar(45) DEFAULT NULL,
  `noi_dung_de_xuat` varchar(45) DEFAULT NULL,
  `so_luong` int(11) DEFAULT NULL,
  `so_ngay` int(11) DEFAULT NULL,
  `thanh_tien` double DEFAULT NULL,
  `id_phieu_de_xuat` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_phieu_de_xuat` (`id_phieu_de_xuat`),
  CONSTRAINT `tbl_noi_dung_de_xuat_ibfk_1` FOREIGN KEY (`id_phieu_de_xuat`) REFERENCES `tbl_phieu_de_xuat` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_phieu_chi`
--

DROP TABLE IF EXISTS `tbl_phieu_chi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_phieu_chi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dia_chi` varchar(45) DEFAULT NULL,
  `giam_doc` varchar(45) DEFAULT NULL,
  `hinh_anh` varchar(45) DEFAULT NULL,
  `ly_do_chi` varchar(45) DEFAULT NULL,
  `ngay_lap_phieu` date DEFAULT NULL,
  `nguoi_lap_phieu` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nguoi_nhan_tien` varchar(45) DEFAULT NULL,
  `so_tien` double DEFAULT NULL,
  `trang_thai` int(11) DEFAULT NULL,
  `viet_bang_chu` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `kem_theo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_phieu_de_xuat`
--

DROP TABLE IF EXISTS `tbl_phieu_de_xuat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_phieu_de_xuat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `de_Xuat_Ngay_Mua` date DEFAULT NULL,
  `giam_doc` varchar(45) DEFAULT NULL,
  `kinh_gui` varchar(45) DEFAULT NULL,
  `ngay_bat_dau` date DEFAULT NULL,
  `ngay_de_xuat` date DEFAULT NULL,
  `ngay_hoan_thanh` date DEFAULT NULL,
  `nguoi_de_nghi` varchar(45) DEFAULT NULL,
  `nguoi_ke_toan` varchar(45) DEFAULT NULL,
  `noi_dung_de_xuat` varchar(45) DEFAULT NULL,
  `tong_tien` int(11) DEFAULT NULL,
  `trang_thai` int(11) DEFAULT NULL,
  `y_kien_lanh_dao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-19 14:37:58
