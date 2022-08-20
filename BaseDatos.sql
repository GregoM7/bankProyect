CREATE DATABASE  IF NOT EXISTS `bancodevsu` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bancodevsu`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bancodevsu
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cliente_id` int NOT NULL AUTO_INCREMENT,
  `contrasenia` varchar(255) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `estado` bit(1) DEFAULT NULL,
  `genero` varchar(255) NOT NULL,
  `identificacion` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  PRIMARY KEY (`cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'1234','Otavalo sn y principal',30,_binary '','Masculino','40234059','Jose Lema','98254785'),(2,'5678','Amazonas y NNUU',31,_binary '','Femenino','40234459','Marianela Montalvo','93452333'),(3,'1245','13 junio y Equinoccial',28,_binary '','Masculino','40234459','Juan Osorio','93452333');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuenta` (
  `cuenta_id` int NOT NULL AUTO_INCREMENT,
  `estado` bit(1) DEFAULT NULL,
  `numero_cuenta` int DEFAULT NULL,
  `saldo_inicial` int DEFAULT NULL,
  `tipo_cuenta` varchar(255) DEFAULT NULL,
  `cliente_id` int NOT NULL,
  PRIMARY KEY (`cuenta_id`),
  KEY `FK4p224uogyy5hmxvn8fwa2jlug` (`cliente_id`),
  CONSTRAINT `FK4p224uogyy5hmxvn8fwa2jlug` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
INSERT INTO `cuenta` VALUES (1,_binary '',478758,1425,'Ahorro',1),(2,_binary '',225487,1300,'Corriente',2),(3,_binary '',495878,150,'Ahorro',3),(4,_binary '',496825,540,'Ahorro',2),(5,_binary '',585545,1000,'Corriente',1);
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos` (
  `movimiento_id` int NOT NULL AUTO_INCREMENT,
  `fecha` datetime(6) DEFAULT NULL,
  `tipo_movimiento` varchar(255) DEFAULT NULL,
  `valor` int DEFAULT NULL,
  `cuenta_id` int DEFAULT NULL,
  `reporte_id` int DEFAULT NULL,
  PRIMARY KEY (`movimiento_id`),
  KEY `FKof0364849tnpw8nw69v8m1vq4` (`cuenta_id`),
  KEY `FK4tr9uukso0oqo5a5x7iblc251` (`reporte_id`),
  CONSTRAINT `FK4tr9uukso0oqo5a5x7iblc251` FOREIGN KEY (`reporte_id`) REFERENCES `reportes` (`reporte_id`),
  CONSTRAINT `FKof0364849tnpw8nw69v8m1vq4` FOREIGN KEY (`cuenta_id`) REFERENCES `cuenta` (`cuenta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (1,'2021-10-20 12:00:00.000000','Debito',-575,1,NULL),(3,'2021-10-20 12:00:00.000000','Credito',600,2,NULL),(4,'2021-10-20 12:00:00.000000','Credito',150,3,NULL),(5,'2021-10-20 12:00:00.000000','Debito',-540,4,NULL);
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id` int NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `identificacion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportes`
--

DROP TABLE IF EXISTS `reportes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reportes` (
  `reporte_id` int NOT NULL AUTO_INCREMENT,
  `estado` bit(1) DEFAULT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `numero_cuenta` int DEFAULT NULL,
  `saldo_disponible` int DEFAULT NULL,
  `saldo_inicial` int DEFAULT NULL,
  `tipo_cuenta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`reporte_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportes`
--

LOCK TABLES `reportes` WRITE;
/*!40000 ALTER TABLE `reportes` DISABLE KEYS */;
/*!40000 ALTER TABLE `reportes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-20  1:14:31
