-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 06, 2019 at 12:07 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `scan_eat`
--

-- --------------------------------------------------------

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `barcode` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `last_refresh` bigint(20) DEFAULT NULL,
  `kcal_100g` int(11) NOT NULL,
  `proteins_100g` double NOT NULL,
  `sugars_100g` double NOT NULL,
  `fat_100g` double NOT NULL,
  `salt_100g` double NOT NULL,
  `fiber_100g` double NOT NULL,
  `image_url` text,
  PRIMARY KEY (`barcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ingredient`
--

INSERT INTO `ingredient` (`barcode`, `name`, `last_refresh`, `kcal_100g`, `proteins_100g`, `sugars_100g`, `fat_100g`, `salt_100g`, `fiber_100g`, `image_url`) VALUES
(3029330003533, 'Pain de mie complet', 1549299090539, 265, 8.9, 7.2, 4.5, 1.2, 5.5, ''),
(5010477301246, 'Muesli', 1549381518587, 375, 9.4, 15.4, 9.2, 0.03, 8.7, '');

-- --------------------------------------------------------

--
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
CREATE TABLE IF NOT EXISTS `recipe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(60) NOT NULL,
  `owner` varchar(36) NOT NULL,
  `image_url` text,
  PRIMARY KEY (`id`),
  KEY `FK_recipe_owner` (`owner`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `recipe`
--

INSERT INTO `recipe` (`id`, `title`, `owner`, `image_url`) VALUES
(1, 'Rød grød med fløde', 'john', 'https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA'),
(2, 'Frikadeller med brun sovs og kartofler', 'john', 'https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA'),
(3, 'Pebernødder', 'john', 'https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA'),
(4, 'Stegt flæsk med kartofler', 'john', 'https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA'),
(77, 'Pebernødder', 'aaa', 'https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA'),
(78, 'Rød grød med fløde', 'aaa', 'https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA'),
(79, 'Rød grød med fløde', 'aaa', 'https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA'),
(80, 'Rød grød med fløde', 'aaa', 'https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA'),
(81, 'Rød grød med fløde', 'aaa', 'https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA'),
(82, 'Rød grød med fløde', 'aaa', 'https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA'),
(83, 'Rød grød med fløde', 'aaa', 'https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA');

-- --------------------------------------------------------

--
-- Table structure for table `recipe_ingredient`
--

DROP TABLE IF EXISTS `recipe_ingredient`;
CREATE TABLE IF NOT EXISTS `recipe_ingredient` (
  `id_recipe` int(11) NOT NULL,
  `barcode_ingredient` bigint(20) NOT NULL,
  `quantity` float NOT NULL,
  `id_unit` int(11) NOT NULL,
  PRIMARY KEY (`id_recipe`,`barcode_ingredient`),
  KEY `id_recipe` (`id_recipe`),
  KEY `barcode_ingredient` (`barcode_ingredient`),
  KEY `FK_recipe_ingredient_id_unit` (`id_unit`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recipe_ingredient`
--

INSERT INTO `recipe_ingredient` (`id_recipe`, `barcode_ingredient`, `quantity`, `id_unit`) VALUES
(82, 3029330003533, 200, 1),
(81, 5010477301246, 456, 1),
(81, 3029330003533, 200, 1),
(80, 5010477301246, 456, 1),
(80, 3029330003533, 200, 1),
(79, 5010477301246, 456, 1),
(79, 3029330003533, 200, 1),
(78, 5010477301246, 456, 1),
(78, 3029330003533, 200, 1),
(77, 3029330003533, 200, 1),
(82, 5010477301246, 456, 1),
(83, 3029330003533, 200, 1),
(83, 5010477301246, 456, 1);

-- --------------------------------------------------------

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
CREATE TABLE IF NOT EXISTS `unit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `unit`
--

INSERT INTO `unit` (`id`, `name`) VALUES
(1, 'g');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(36) CHARACTER SET utf8 NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `first_name`, `last_name`, `password`) VALUES
('aaa', 'lol', 'lollol', '$2a$10$WdrNGn1XquRSMvZXHoS.6.oO5ZpKKc9446xBEnVS.CMspjx.sD.B6'),
('john', 'lol', 'lollol', '$2a$10$et4WnQXL.HcFNMCJcyE37Ou82iYtdodKYfej005GEAew4jB04T.Ui');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `recipe`
--
ALTER TABLE `recipe`
  ADD CONSTRAINT `FK_recipe_owner` FOREIGN KEY (`owner`) REFERENCES `user` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
