CREATE DATABASE  IF NOT EXISTS `ratatouille` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ratatouille`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: ratatouille
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `allergen`
--

DROP TABLE IF EXISTS `allergen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allergen` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allergen`
--

LOCK TABLES `allergen` WRITE;
/*!40000 ALTER TABLE `allergen` DISABLE KEYS */;
/*!40000 ALTER TABLE `allergen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `idCategory` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `menu_id` int NOT NULL,
  PRIMARY KEY (`idCategory`),
  KEY `menu_fk_idx` (`menu_id`),
  CONSTRAINT `menu_fk` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`idMenu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'primi',1),(2,'secondi',1),(3,'contorni',1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `table_id` int NOT NULL,
  KEY `table_fk2_idx` (`table_id`),
  CONSTRAINT `table_fk2` FOREIGN KEY (`table_id`) REFERENCES `tablerestaurant` (`idTable`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `composed`
--

DROP TABLE IF EXISTS `composed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `composed` (
  `order_id` int NOT NULL,
  `element_id` int NOT NULL,
  KEY `order_fk_idx` (`order_id`),
  KEY `element_fk1_idx` (`element_id`),
  CONSTRAINT `element_fk1` FOREIGN KEY (`element_id`) REFERENCES `element` (`idElement`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_fk` FOREIGN KEY (`order_id`) REFERENCES `order` (`idOrder`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `composed`
--

LOCK TABLES `composed` WRITE;
/*!40000 ALTER TABLE `composed` DISABLE KEYS */;
/*!40000 ALTER TABLE `composed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contains`
--

DROP TABLE IF EXISTS `contains`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contains` (
  `element_id` int NOT NULL,
  `allergen_name` varchar(50) NOT NULL,
  KEY `allergen_fk_idx` (`allergen_name`),
  KEY `element_fk_idx` (`element_id`),
  CONSTRAINT `allergen_fk` FOREIGN KEY (`allergen_name`) REFERENCES `allergen` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `element_fk` FOREIGN KEY (`element_id`) REFERENCES `element` (`idElement`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contains`
--

LOCK TABLES `contains` WRITE;
/*!40000 ALTER TABLE `contains` DISABLE KEYS */;
/*!40000 ALTER TABLE `contains` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `element`
--

DROP TABLE IF EXISTS `element`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `element` (
  `idElement` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `prePackaged` tinyint NOT NULL,
  `aliment` enum('food','drink') NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`idElement`),
  KEY `category_fk_idx` (`category_id`),
  CONSTRAINT `category_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`idCategory`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `element`
--

LOCK TABLES `element` WRITE;
/*!40000 ALTER TABLE `element` DISABLE KEYS */;
/*!40000 ALTER TABLE `element` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `idMenu` int NOT NULL AUTO_INCREMENT,
  `qrCode` varchar(255) DEFAULT NULL,
  `restaurant_name` varchar(50) NOT NULL,
  PRIMARY KEY (`idMenu`),
  KEY `restaurant_fk3_idx` (`restaurant_name`),
  CONSTRAINT `restaurant_fk3` FOREIGN KEY (`restaurant_name`) REFERENCES `restaurant` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'123','rest');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `idOrder` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `price` double NOT NULL,
  `table_id` int NOT NULL,
  PRIMARY KEY (`idOrder`),
  KEY `table_fk1_idx` (`table_id`),
  CONSTRAINT `table_fk1` FOREIGN KEY (`table_id`) REFERENCES `tablerestaurant` (`idTable`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant` (
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `locality` varchar(50) DEFAULT NULL,
  `tables` int NOT NULL,
  `seats` int NOT NULL,
  `touristic` tinyint NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES ('rest','ristorante','italia',4,12,0);
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tablerestaurant`
--

DROP TABLE IF EXISTS `tablerestaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tablerestaurant` (
  `idTable` int NOT NULL AUTO_INCREMENT,
  `seats` int NOT NULL,
  `restaurant_name` varchar(50) NOT NULL,
  PRIMARY KEY (`idTable`),
  KEY `restaurant_fk2_idx` (`restaurant_name`),
  CONSTRAINT `restaurant_fk2` FOREIGN KEY (`restaurant_name`) REFERENCES `restaurant` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tablerestaurant`
--

LOCK TABLES `tablerestaurant` WRITE;
/*!40000 ALTER TABLE `tablerestaurant` DISABLE KEYS */;
/*!40000 ALTER TABLE `tablerestaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `idUser` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `job` enum('admin','waiter','supervisor') NOT NULL,
  `restaurant_name` varchar(50) NOT NULL,
  PRIMARY KEY (`idUser`),
  KEY `restaurant_fk1_idx` (`restaurant_name`),
  CONSTRAINT `restaurant_fk1` FOREIGN KEY (`restaurant_name`) REFERENCES `restaurant` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ratatouille'
--

--
-- Dumping routines for database 'ratatouille'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-12 18:05:17
