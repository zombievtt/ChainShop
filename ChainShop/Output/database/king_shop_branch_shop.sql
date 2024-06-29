CREATE DATABASE  IF NOT EXISTS `king_shop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `king_shop`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: king_shop
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `branch_shop`
--

DROP TABLE IF EXISTS `branch_shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch_shop` (
  `id` int NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(45) DEFAULT NULL,
  `back_r` int DEFAULT NULL,
  `back_g` int DEFAULT NULL,
  `back_b` int DEFAULT NULL,
  `fore_r` int DEFAULT NULL,
  `fore_g` int DEFAULT NULL,
  `fore_b` int DEFAULT NULL,
  `menu_000_name` varchar(45) DEFAULT NULL,
  `menu_000_price` int DEFAULT NULL,
  `menu_001_name` varchar(45) DEFAULT NULL,
  `menu_001_price` int DEFAULT NULL,
  `menu_002_name` varchar(45) DEFAULT NULL,
  `menu_002_price` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch_shop`
--

LOCK TABLES `branch_shop` WRITE;
/*!40000 ALTER TABLE `branch_shop` DISABLE KEYS */;
INSERT INTO `branch_shop` VALUES (3,'火星店',255,0,0,255,255,255,'豬肉炒麵',110,'牛肉炒麵',120,'海鮮炒麵',130),(5,'紫薇店',255,0,255,255,255,255,'綠豆牛奶冰',40,'花生牛奶冰',45,'招牌牛奶冰',50),(6,'北區店',0,0,0,243,255,255,'招牌便當',110,'雙拼便當',130,'排骨便當',90),(7,'中區店',0,197,255,0,0,0,'燒肉拼盤',100,'冷筍沙拉',180,'鮭魚生魚片',220),(10,'水星店',0,0,255,255,255,255,'竹筍炒肉絲',80,'牛雞雙寶便當',150,'招牌便當',120);
/*!40000 ALTER TABLE `branch_shop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-29 12:13:37
