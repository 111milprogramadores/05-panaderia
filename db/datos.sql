-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: poo-panaderia
-- ------------------------------------------------------
-- Server version	5.6.25

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
-- Dumping data for table `Caja`
--

LOCK TABLES `Caja` WRITE;
/*!40000 ALTER TABLE `Caja` DISABLE KEYS */;
/*!40000 ALTER TABLE `Caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Cobro`
--

LOCK TABLES `Cobro` WRITE;
/*!40000 ALTER TABLE `Cobro` DISABLE KEYS */;
/*!40000 ALTER TABLE `Cobro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ComposicionCaja`
--

LOCK TABLES `ComposicionCaja` WRITE;
/*!40000 ALTER TABLE `ComposicionCaja` DISABLE KEYS */;
/*!40000 ALTER TABLE `ComposicionCaja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `DetalleProductoCobrado`
--

LOCK TABLES `DetalleProductoCobrado` WRITE;
/*!40000 ALTER TABLE `DetalleProductoCobrado` DISABLE KEYS */;
/*!40000 ALTER TABLE `DetalleProductoCobrado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Dinero`
--

LOCK TABLES `Dinero` WRITE;
/*!40000 ALTER TABLE `Dinero` DISABLE KEYS */;
INSERT INTO `Dinero` VALUES (1,0,2.00,'Billete de dos pesos','/resources/imagenes/dinero/2-pesos.gif'),(2,0,5.00,'Billete de cinco pesos','/resources/imagenes/dinero/5-pesos.gif'),(3,0,10.00,'Billete de diez pesos','/resources/imagenes/dinero/10-pesos.gif'),(4,0,20.00,'Billete de veinte pesos','/resources/imagenes/dinero/20-pesos.gif'),(5,0,50.00,'Billete de cincuenta pesos','/resources/imagenes/dinero/50-pesos.gif'),(6,0,100.00,'Billete de cien pesos','/resources/imagenes/dinero/100-pesos.gif'),(7,0,500.00,'Billete de quinientos pesos','/resources/imagenes/dinero/500-pesos.gif'),(8,1,1.00,'Moneda de un peso','/resources/imagenes/dinero/1-peso.jpg'),(9,1,0.50,'Moneda de cincuenta centavos','/resources/imagenes/dinero/50-centavos.jpg'),(10,1,0.25,'Moneda de veinticinco centavos','/resources/imagenes/dinero/25-centavos.jpg'),(11,1,0.10,'Moneda de diez centavos','/resources/imagenes/dinero/10-centavos.jpg'),(12,1,0.05,'Moneda de cinco centavos','/resources/imagenes/dinero/5-centavos.jpg'),(13,1,2.00,'Moneda de dos pesos','/resources/imagenes/dinero/2-pesos-moneda.jpg');
/*!40000 ALTER TABLE `Dinero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `DineroRecibido`
--

LOCK TABLES `DineroRecibido` WRITE;
/*!40000 ALTER TABLE `DineroRecibido` DISABLE KEYS */;
/*!40000 ALTER TABLE `DineroRecibido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `MovimientoCaja`
--

LOCK TABLES `MovimientoCaja` WRITE;
/*!40000 ALTER TABLE `MovimientoCaja` DISABLE KEYS */;
/*!40000 ALTER TABLE `MovimientoCaja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Producto`
--

LOCK TABLES `Producto` WRITE;
/*!40000 ALTER TABLE `Producto` DISABLE KEYS */;
INSERT INTO `Producto` VALUES (1,'Alfajor Cordobés','Alfajores Cordobeces',20.00,'/resources/imagenes/productos/alfajor.jpg',1),(2,'Vigilante','Vigilantes Calentitos',15.00,'/resources/imagenes/productos/vigilante.jpg',1);
/*!40000 ALTER TABLE `Producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `TipoMovimiento`
--

LOCK TABLES `TipoMovimiento` WRITE;
/*!40000 ALTER TABLE `TipoMovimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `TipoMovimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `UnidadMedida`
--

LOCK TABLES `UnidadMedida` WRITE;
/*!40000 ALTER TABLE `UnidadMedida` DISABLE KEYS */;
INSERT INTO `UnidadMedida` VALUES (1,'Unidad','u','u');
/*!40000 ALTER TABLE `UnidadMedida` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-20 21:04:03
