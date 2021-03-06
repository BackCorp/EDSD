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
-- Table structure for table `primes_edsd`
--

DROP TABLE IF EXISTS `primes_edsd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `primes_edsd` (
  `primes_edsd_id` int(11) NOT NULL AUTO_INCREMENT,
  `retenues` double NOT NULL DEFAULT 0.0,
  `classe_liee_au_grade` varchar(100) NOT NULL,
  `classe_liee_aux_indices` varchar(100) NOT NULL,
  `computed_primes` double NOT NULL,
  `actual_primes` int(11) NOT NULL,
  `computed_primes_grade` double NOT NULL,
  `computed_primes_indices` double NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` date NOT NULL,
  `grade` varchar(100) NOT NULL,
  `groupe` varchar(100) NOT NULL,
  `indemnite_liee_au_grade_technicite` double NOT NULL,
  `indemnite_liee_aux_indices_astreinte` double NOT NULL,
  `indemnite_liee_aux_indices_sante_publique` double NOT NULL,
  `number_of_months` double NOT NULL,
  `start_date` date NOT NULL,
  `requester_id` int(11) NOT NULL,
  `created_by_user_id` int(11) NOT NULL,
  PRIMARY KEY (`primes_edsd_id`),
  UNIQUE KEY `UKb92ohaowa9a8eg6uwlj1f4yuq` (`primes_edsd_id`),
  UNIQUE KEY `primes_edsd_id_UNIQUE` (`primes_edsd_id`),
  KEY `FKs4tpxsx2hhfos18dw6wmeor84` (`requester_id`),
  KEY `FK8hdjdm9waefn0x369svcrhryt` (`created_by_user_id`),
  CONSTRAINT `FK8hdjdm9waefn0x369svcrhryt` FOREIGN KEY (`created_by_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKs4tpxsx2hhfos18dw6wmeor84` FOREIGN KEY (`requester_id`) REFERENCES `requester` (`requester_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `primes_edsd` AUTO_INCREMENT = 0;

/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `primes_edsd`
--

LOCK TABLES `primes_edsd` WRITE;
/*!40000 ALTER TABLE `primes_edsd` DISABLE KEYS */;
/*!40000 ALTER TABLE `primes_edsd` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-23 20:44:14
