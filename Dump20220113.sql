CREATE DATABASE  IF NOT EXISTS `greenshare` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `greenshare`;
-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: localhost    Database: greenshare
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `rent`
--

DROP TABLE IF EXISTS `rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `end_time` datetime(6) DEFAULT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `vehicle_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg3q3j6lq13lh6qkjw2fpj2kdk` (`user_id`),
  KEY `FK5lywatsmefl4l9s1kdc32aq66` (`vehicle_id`),
  CONSTRAINT `FK5lywatsmefl4l9s1kdc32aq66` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`),
  CONSTRAINT `FKg3q3j6lq13lh6qkjw2fpj2kdk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent`
--

LOCK TABLES `rent` WRITE;
/*!40000 ALTER TABLE `rent` DISABLE KEYS */;
INSERT INTO `rent` VALUES (57,'2022-01-12 15:07:11.000000','2022-01-12 15:01:09.000000',2,8),(58,'2022-01-12 15:32:46.000000','2022-01-12 15:32:09.000000',2,13),(59,'2022-01-12 15:35:06.000000','2022-01-12 15:33:52.000000',2,12),(60,'2022-01-12 16:10:45.000000','2022-01-12 16:09:30.000000',2,8),(61,'2022-01-12 17:34:15.000000','2022-01-12 16:13:14.000000',2,8),(62,'2022-01-12 17:34:16.000000','2022-01-12 16:13:15.000000',2,9),(63,'2022-01-12 18:50:40.000000','2022-01-12 17:50:06.000000',2,8),(64,'2022-01-13 11:27:06.000000','2022-01-13 10:29:30.000000',2,10),(65,'2022-01-13 14:30:41.000000','2022-01-13 12:36:59.000000',1,8),(66,'2022-01-13 12:42:32.000000','2022-01-13 12:42:28.000000',1,9),(67,NULL,'2022-01-13 12:44:21.000000',2,9),(68,'2022-01-13 16:18:45.000000','2022-01-13 14:30:51.000000',1,8),(69,'2022-01-13 14:31:42.000000','2022-01-13 14:31:39.000000',1,10),(70,NULL,'2022-01-13 15:04:06.000000',2,12),(71,'2022-01-13 16:12:37.000000','2022-01-13 16:12:23.000000',1,10);
/*!40000 ALTER TABLE `rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `share`
--

DROP TABLE IF EXISTS `share`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `share` (
  `id` int NOT NULL AUTO_INCREMENT,
  `end_time` datetime(6) DEFAULT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `vehicle_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhwfan84wqm1mflkf4dp8wcic0` (`user_id`),
  KEY `FK7g6aa4x2kglq6b63x400bnkqg` (`vehicle_id`),
  CONSTRAINT `FK7g6aa4x2kglq6b63x400bnkqg` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`),
  CONSTRAINT `FKhwfan84wqm1mflkf4dp8wcic0` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `share`
--

LOCK TABLES `share` WRITE;
/*!40000 ALTER TABLE `share` DISABLE KEYS */;
/*!40000 ALTER TABLE `share` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `creation_date` datetime(6) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2021-12-22 10:57:04.500000',_binary '','$2a$10$uRNP1zhn4XSmfBsIssUTAOJPxmzz6aBHhk6OyYBrCCBNqYeTevSMC','ROLE_USER','user@user.com'),(2,'2021-12-23 11:41:31.543000',_binary '','$2a$10$lrlilwhSH5M29Sy8n/gJF.KAraejSpgTABRRdpbT0a06zp94k3nuy','ROLE_ADMIN','admin@admin.com'),(3,'2021-12-30 17:40:05.995000',_binary '','$2a$10$OtC3MehXuA7KWjQTPk4se.Cra7FEdFx0l3MMAGFSvo1.brWaA0kdi','ROLE_USER','user2@user.com'),(4,'2022-01-08 22:33:21.692000',_binary '','$2a$10$hxBbABSJGk8ASbvd5SQZS.JYpNUQ80t.9g1yeG3S0bnk.8NssaMAa','ROLE_USER','user10@user.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `battery` int NOT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `current_location` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `max_autonomy` int NOT NULL,
  `price_per_minute` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `id_user` bigint DEFAULT NULL,
  `coordinates` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmx022plpycqvusyr6dq121see` (`id_user`),
  CONSTRAINT `FKmx022plpycqvusyr6dq121see` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (8,15,'2021-12-29 17:32:20.000000','Via Roma 360, Torino','Fiat 500-e',321,0.48,'Automobile',NULL,'45.0646229;7.6801284','/immagini/upload/8//immagini/upload/8//immagini/upload/8//immagini/upload/8//immagini/upload/8//immagini/upload/8/vehicleImage.png','vehicleImage.png'),(9,54,'2021-12-31 16:46:08.000000','Via Onorato Vigliani, Torino','BMW i3',359,0.61,'Automobile',NULL,'45.0175118;7.6529801','vehicleImage.png','vehicleImage.png'),(10,100,'2022-01-03 21:42:47.000000','Via Malta, Torino','Tesla Model S',740,0.99,'Automobile',NULL,'45.0569872;7.6448817','vehicleImage.png','vehicleImage.png'),(12,89,'2022-01-04 22:32:38.000000','Corso Principe Oddone, Torino',' Mi Electric Scooter',30,0.29,'Monopattino',NULL,'45.0880146;7.6762296','vehicleImage.png','vehicleImage.png'),(13,78,'2022-01-06 20:51:49.000000','Via Nizza, Torino','Ghost Kato',40,0.33,'Bicicletta',NULL,'45.0176734;7.6615487','vehicleImage.png','vehicleImage.png'),(57,36,'2022-01-11 12:17:56.000000','Via Candiolo, Torino','Ghost Kato',40,0.33,'Bicicletta',NULL,'45.0154839;7.6496987',NULL,'vehicleImage.png'),(59,100,'2022-01-11 18:14:32.000000','Via Marco Polo, Torino','BMW i3',359,0.61,'Automobile',NULL,'45.0585717;7.6608764',NULL,'vehicleImage.png'),(60,100,'2022-01-11 18:15:24.000000','Via Dego, Torino','Fiat 500-e',321,0.48,'Automobile',NULL,'45.0592626;7.6582175',NULL,'vehicleImage.png'),(61,100,'2022-01-11 18:17:32.000000','Via Vigone, Torino','Ghost Kato',40,0.33,'Bicicletta',NULL,'45.0656813;7.6461019',NULL,'vehicleImage.png'),(62,100,'2022-01-11 18:18:51.000000','Via Chianocco, Torino',' Mi Electric Scooter',30,0.29,'Monopattino',NULL,'45.0715218;7.6469805',NULL,'vehicleImage.png'),(63,100,'2022-01-11 18:19:35.000000','Via Pietro Piffetti, Torino',' Mi Electric Scooter',30,0.29,'Monopattino',NULL,'45.0770192;7.6565341',NULL,'vehicleImage.png'),(64,100,'2022-01-11 18:20:37.000000','Via Carlo Bossi, Torino',' Mi Electric Scooter',30,0.39,'Monopattino',NULL,'45.0806207;7.658317',NULL,'vehicleImage.png'),(65,100,'2022-01-11 18:21:12.000000','Corso Svizzera',' Mi Electric Scooter',30,0.29,'Monopattino',NULL,'45.0875588;7.6568213',NULL,'vehicleImage.png'),(66,100,'2022-01-11 18:21:51.000000','Corso Vigevano, Torino','Ghost Kato',40,0.33,'Bicicletta',NULL,'45.0900982;7.6786634',NULL,'vehicleImage.png'),(67,100,'2022-01-11 18:22:17.000000','Via Monte Rosa, Torino','Ghost Kato',40,0.33,'Bicicletta',NULL,'45.0926745;7.6966244',NULL,'vehicleImage.png'),(68,100,'2022-01-13 14:17:46.000000','Via Marsigli, Torino','Tesla Model S',740,0.99,'Automobile',NULL,'45.0651046;7.6268584',NULL,'vehicleImage.png'),(69,100,'2022-01-13 14:22:45.000000','Via Nicomede Bianchi, Torino','Fiat 500e',321,0.48,'Automobile',NULL,'45.0820672;7.6314069',NULL,'vehicleImage.png'),(70,100,'2022-01-13 16:21:15.000000','Centro di Torino','BMW i3',321,0.56,'Automobile',NULL,'45.0579999;7.6628873',NULL,'vehicleImage.png');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-13 16:24:48
