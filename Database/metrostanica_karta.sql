-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: metrostanica
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `karta`
--

DROP TABLE IF EXISTS `karta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `karta` (
  `idKarte` int(11) NOT NULL,
  `vazenjeKarteDo` date NOT NULL,
  `cenaKarte` double NOT NULL,
  `vremeKupovine` varchar(45) NOT NULL,
  `validnostKarte` varchar(45) NOT NULL,
  `tip` varchar(45) NOT NULL,
  `idTipMesecne` int(11) DEFAULT NULL,
  PRIMARY KEY (`idKarte`),
  UNIQUE KEY `id_UNIQUE` (`idKarte`),
  KEY `idTipMesecne_idx` (`idTipMesecne`),
  CONSTRAINT `idTipMesecne` FOREIGN KEY (`idTipMesecne`) REFERENCES `tipmesecne` (`idtipMesecne`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `karta`
--

LOCK TABLES `karta` WRITE;
/*!40000 ALTER TABLE `karta` DISABLE KEYS */;
INSERT INTO `karta` VALUES (1,'2022-05-28',200,'28.06.2022.','validna','jednokratna',NULL),(2,'2022-05-28',400,'29.06.2022.','validna','dnevna',NULL),(3,'2022-05-28',1000,'28.06.2022.','validna','mesecna',1),(4,'2022-05-29',1000,'29.06.2022.','validna','mesecna ',2),(5,'2022-05-22',1000,'29.06.2022.','validna','mesecna',3);
/*!40000 ALTER TABLE `karta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-31 17:26:27
