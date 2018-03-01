-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: db2
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

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
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `date` varchar(255) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `type` char(1) NOT NULL,
  PRIMARY KEY (`date`,`emp_id`),
  KEY `FK59ughl3n5vxs1xop5eiurkc66` (`emp_id`),
  CONSTRAINT `FK59ughl3n5vxs1xop5eiurkc66` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES ('01 FEB 2018',1,'P'),('01 FEB 2018',2,'P'),('01 FEB 2018',3,'P'),('01 FEB 2018',4,'P'),('01 FEB 2018',5,'P'),('01 FEB 2018',6,'P'),('01 FEB 2018',7,'P'),('01 Mar 2018',1,'P'),('01 Mar 2018',3,'P'),('01 Mar 2018',5,'P'),('02 FEB 2018',1,'L'),('02 FEB 2018',2,'O'),('02 FEB 2018',3,'A'),('02 FEB 2018',4,'A'),('02 FEB 2018',5,'P'),('02 FEB 2018',6,'P'),('02 FEB 2018',7,'P');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'ajender'),(2,'vijay'),(3,'hr'),(4,'ajay'),(5,'karthik'),(6,'kalyan'),(7,'suman');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_details`
--

DROP TABLE IF EXISTS `employee_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_details` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_details`
--

LOCK TABLES `employee_details` WRITE;
/*!40000 ALTER TABLE `employee_details` DISABLE KEYS */;
INSERT INTO `employee_details` VALUES (1,'ajender','$2a$10$JzJgdGGgiA1c7sTqDnayx.LeNPulPHHXgFr2TETqU9gNoIkz6wneW','employee'),(2,'vijay','$2a$10$mVFz.2kPuk59P1rAf9KZb.PHNypnLn8n9rpbE3Wze4VmQTJ1lPTAC','employee'),(3,'hr','$2a$10$wK9sn4IshwZRhHnQCpqVDu/Mkt3BzENAR9K.Jd.Mhlx8mYW4AxQsC','hr'),(4,'ajay','$2a$10$4V5Y41bPLi8t/pAB2eGH/OtFEbldLBhYDZXkqoaS4NZWBuqfyzRRq','employee'),(5,'karthik','$2a$10$G1cx1fveAyOLm5v5imWdnu8QqgFmPFkGhIjvVi02VQhGVsJr23JtC','employee'),(6,'kalyan','$2a$10$kxUO2JyvaYMPYPEvnOhVyO1inFoaSvV795gAjW3LYGxMUvo..Rd7.','employee'),(7,'suman','$2a$10$A73KWR0v8viIDsOvAHergORUgFAM5Bnndqe9gN4odQaEAjGyu9wue','employee');
/*!40000 ALTER TABLE `employee_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-01 16:30:36
