-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: tutormanagementsystem
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `enrolled_tech_details`
--

DROP TABLE IF EXISTS `enrolled_tech_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrolled_tech_details` (
  `enrollid` int(11) NOT NULL AUTO_INCREMENT,
  `createdon` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` varchar(255) DEFAULT NULL,
  `tech_rating` double NOT NULL,
  `studentid` int(11) NOT NULL,
  `technologyid` int(11) NOT NULL,
  `tutorsid` int(11) NOT NULL,
  PRIMARY KEY (`enrollid`),
  KEY `FK5igr9rbb6cu7plhbqrfulh198` (`studentid`),
  KEY `FK48aolspt7ky5proyuaripy5g1` (`technologyid`),
  KEY `FKmnawp9j44qagecs3uc7l47dqe` (`tutorsid`),
  CONSTRAINT `FK48aolspt7ky5proyuaripy5g1` FOREIGN KEY (`technologyid`) REFERENCES `technology` (`technologyid`),
  CONSTRAINT `FK5igr9rbb6cu7plhbqrfulh198` FOREIGN KEY (`studentid`) REFERENCES `student` (`id`),
  CONSTRAINT `FKmnawp9j44qagecs3uc7l47dqe` FOREIGN KEY (`tutorsid`) REFERENCES `tutor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrolled_tech_details`
--

LOCK TABLES `enrolled_tech_details` WRITE;
/*!40000 ALTER TABLE `enrolled_tech_details` DISABLE KEYS */;
INSERT INTO `enrolled_tech_details` VALUES (1,'2021-07-26 11:00:47','APPROVED',4,9,1,2),(2,'2021-07-26 11:00:51','APPROVED',5,9,2,2),(3,'2021-07-26 11:05:00','APPROVED',3,9,5,3),(4,'2021-07-26 11:05:02','APPROVED',4,9,6,3),(5,'2021-07-26 11:15:18','APPROVED',3,9,9,4),(6,'2021-07-26 11:15:28','APPROVED',4,9,17,7),(7,'2021-07-26 11:15:30','APPROVED',0,9,19,7),(8,'2021-07-26 11:16:36','APPROVED',0,9,16,6),(9,'2021-07-26 11:17:33','APPROVED',0,10,20,7),(10,'2021-07-26 11:17:37','APPROVED',0,10,16,6),(11,'2021-07-26 11:17:39','APPROVED',0,10,13,4),(12,'2021-07-26 11:17:46','APPROVED',4,10,14,6),(13,'2021-07-26 11:17:49','APPROVED',0,10,7,3),(14,'2021-07-26 11:17:51','APPROVED',0,10,3,2),(15,'2021-07-26 11:17:58','APPROVED',4,10,2,2),(16,'2021-07-26 11:18:00','APPROVED',5,10,10,4),(17,'2021-07-26 11:18:55','APPROVED',0,11,1,2),(18,'2021-07-26 11:18:56','APPROVED',0,11,4,2),(19,'2021-07-26 11:18:56','APPROVED',0,11,6,3),(20,'2021-07-26 11:18:57','APPROVED',0,11,8,3),(21,'2021-07-26 11:18:59','APPROVED',0,11,11,4),(22,'2021-07-26 11:18:59','APPROVED',0,11,10,4),(23,'2021-07-26 11:19:02','APPROVED',0,11,18,7),(24,'2021-07-26 11:19:03','APPROVED',0,11,20,7),(25,'2021-07-26 11:19:45','APPROVED',0,12,3,2),(26,'2021-07-26 11:19:49','APPROVED',0,12,7,3),(27,'2021-07-26 11:19:50','APPROVED',0,12,9,4),(28,'2021-07-26 11:19:57','APPROVED',0,12,15,6),(29,'2021-07-26 11:19:58','APPROVED',0,12,16,6),(30,'2021-07-26 11:20:00','APPROVED',0,12,18,7),(31,'2021-07-26 11:20:01','APPROVED',0,12,20,7);
/*!40000 ALTER TABLE `enrolled_tech_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-26 17:13:36
