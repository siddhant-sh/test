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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdon` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2021-07-26 10:23:01','admin@cybage.com',NULL,'$2a$10$dK8ZHLtOQFgVVQHsqQzPwudvnKlxxjr0RDTP2u/9Ls0RaDtyDkkUa','ADMIN','APPROVED','admin'),(2,'2021-07-26 10:26:45','prajyotw@cybage.com','MALE','$2a$10$9D0eR9nMvUlHQzxvC.nvr.d6LSaXnnBYBFz.Y9HBe51RkMEgGOv/u','TUTOR','APPROVED','Prajyot Waradkar'),(3,'2021-07-26 10:28:04','faisalt@cybage.com','MALE','$2a$10$KuNDG4HeHG7PHkhGocYqAOmq/OizZwXc4AtYJqA6ct0ntNKOeolce','TUTOR','APPROVED','Faisal Tamboli'),(4,'2021-07-26 10:29:33','vishwajeetl@cybage.com','MALE','$2a$10$g.MCYkid35hz..ZXnG2in.Kbl98ZK7T0t8UFsTW6RRZUMB.Bo9c.i','TUTOR','APPROVED','Vishwajeet Latpate'),(5,'2021-07-26 10:31:54','johnc@cybage.com','MALE','$2a$10$xhgyyBIaD0UaUhSl7JdhBuvNDo3AN/85xjASgsy4APRtrJkuyeN8i','TUTOR','REJECTED','John Cena'),(6,'2021-07-26 10:33:06','vartikam@cybage.com','FEMALE','$2a$10$FlR2hNXq1ZpBoaAl36X3IO/O470JHP2oBFpGUZ2Qz0F5sPh.4trAq','TUTOR','APPROVED','Vartika Modi'),(7,'2021-07-26 10:34:43','poojak@cybage.com','FEMALE','$2a$10$Opk3mXDjiQmqMdH/z9JzZONR.uzcoxDAlAaErOymdbc0wYNT77FkC','TUTOR','APPROVED','Pooja Kadam'),(8,'2021-07-26 10:35:52','manishk@cybage.com','MALE','$2a$10$qsUET4RZejFcx5DqkYquEewLxxVufXpGwXcQ3gw9pHlf/svyCXBWm','TUTOR','REJECTED','Manish Kumar'),(9,'2021-07-26 10:36:47','lalitcha@cybage.com','MALE','$2a$10$6C.0zYeDTSefG3wuEK5AtumXs4dRI3OGVe66iVj5T4CQE834YTGc.','STUDENT','APPROVED','Lalit Chaudhari'),(10,'2021-07-26 10:37:51','ashwinipatil@cybage.com','FEMALE','$2a$10$t9KrdCCpkyXAdFNW0YHxyekq0uMpIy0HIZflJMP7slLM8fW0A..j.','STUDENT','APPROVED','Ashwini Patil'),(11,'2021-07-26 10:39:42','siddhantsh@cybage.com','MALE','$2a$10$fYrMWKRi84K/3y8WLQiuHO/w4ZpcZ5Ez0CHgTaWYCpMF/88yoRL2y','STUDENT','APPROVED','Siddhant Shah'),(12,'2021-07-26 10:40:46','priyad@cybage.com','FEMALE','$2a$10$Zjo4dMESIAvb1OT06HUxyeq97iV3emZQfKfLWyb58O6vAbT.xw6ui','STUDENT','APPROVED','Priya Deokar'),(13,'2021-07-26 10:41:49','shrutir@cybage.com','FEMALE','$2a$10$L2rBPIQqAMCeJ7Z8aZL.GOFDp00LPTj9wCAh3GrdkKWQQm.enrsJG','STUDENT','APPROVED','Shruti Rao'),(14,'2021-07-26 10:42:45','deepakt@cybage.com','MALE','$2a$10$HixfMYiewN8LzLZqcwJf6O6kxvLFk4qFQ.rOTOcL0umlPlkOp1IgG','STUDENT','APPROVED','Deepak Thakur'),(15,'2021-07-26 10:43:43','rahulk@cybage.com','MALE','$2a$10$GemELxJBkh/MHkxsmBCkhuglaNBhBKKRipAQj.afh45uyoxVq7TYC','STUDENT','REJECTED','Rahul Khairnar'),(16,'2021-07-26 10:44:53','vaibhavp@cybage.com','MALE','$2a$10$TSObJCIZDZsNKwhIktFGlesogaWXF34vHJpg/ZLwBGY4M65fHFFoG','STUDENT','REJECTED','Vaibhav Patil'),(17,'2021-07-26 10:45:50','krushnas@cybage.com','MALE','$2a$10$mmlduIwl9/EmhrWkJn444.UsIGj8hzTkxXwsA7WWudGNlE3Avs3fO','STUDENT','PENDING','Krushna Shinde'),(18,'2021-07-26 10:46:48','kiranj@cybage.com','FEMALE','$2a$10$dvARIBJGXvCvj5JjxCRyguRpKQ3w/SLTHY8dS38BE65N2LOC/DrQK','STUDENT','PENDING','Kiran Jadhav'),(19,'2021-07-26 10:49:54','manojt@cybage.com','MALE','$2a$10$/MZvHPcVKTcEGZNuhfBMdeSTr1vhJDP8gO/SVkNvl/LrtEIyDhMhi','TUTOR','PENDING','Manoj Tiwari'),(20,'2021-07-26 10:50:53','divyak@cybage.com','FEMALE','$2a$10$8E1Ve7WSsk.7ZGv93pMYXO.W.3fUTUq3cLCzjqhN0sYuCuMJqP8HS','TUTOR','PENDING','Divya Kumari');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
