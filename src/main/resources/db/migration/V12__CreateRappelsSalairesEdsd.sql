-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: edsd
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `rappels_salaires_edsd`
--

DROP TABLE IF EXISTS `rappels_salaires_edsd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rappels_salaires_edsd` (
  `rappels_salaires_id` int(11) NOT NULL AUTO_INCREMENT,
  `actual_rappels_salaires` int(11) NOT NULL,
  `computed_rappels_salaires` double NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` date NOT NULL,
  `number_of_months` double NOT NULL,
  `salaire_de_base` double NOT NULL,
  `start_date` date NOT NULL,
  `requester_id` int(11) NOT NULL,
  `created_by_user_id` int(11) NOT NULL,
  PRIMARY KEY (`rappels_salaires_id`),
  KEY `FKlyaykammyimcb4jsp51t7wa4g` (`requester_id`),
  KEY `FKll7u2dhphbnnoqyh92052fj9e` (`created_by_user_id`),
  CONSTRAINT `FKll7u2dhphbnnoqyh92052fj9e` FOREIGN KEY (`created_by_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKlyaykammyimcb4jsp51t7wa4g` FOREIGN KEY (`requester_id`) REFERENCES `requester` (`requester_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

ALTER TABLE `heroku_e677632625f8d81`.`rappels_salaires_edsd` AUTO_INCREMENT = 0;

--
-- Dumping data for table `rappels_salaires_edsd`
--

LOCK TABLES `rappels_salaires_edsd` WRITE;
/*!40000 ALTER TABLE `rappels_salaires_edsd` DISABLE KEYS */;
/*!40000 ALTER TABLE `rappels_salaires_edsd` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-31  0:32:21
