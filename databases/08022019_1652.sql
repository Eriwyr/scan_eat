-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 08, 2019 at 03:52 PM
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
-- Table structure for table `additive`
--

DROP TABLE IF EXISTS `additive`;
CREATE TABLE IF NOT EXISTS `additive` (
  `id` varchar(10) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `additive`
--

INSERT INTO `additive` (`id`, `name`) VALUES
('E160', NULL),
('E160A', NULL),
('E160AI', NULL),
('E172', NULL),
('E172II', NULL),
('E250', NULL),
('E270', NULL),
('E300', NULL),
('E340', NULL),
('E407', NULL),
('E415', NULL),
('E450', NULL),
('E461', NULL),
('E472B', NULL),
('E500', NULL),
('E500II', NULL),
('E535', NULL),
('E621', NULL),
('E627', NULL),
('E631', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `barcode` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `last_refresh` bigint(20) DEFAULT NULL,
  `id_unit` int(11) DEFAULT NULL,
  `nutriscore` char(1) DEFAULT NULL,
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

INSERT INTO `ingredient` (`barcode`, `name`, `last_refresh`, `id_unit`, `nutriscore`, `kcal_100g`, `proteins_100g`, `sugars_100g`, `fat_100g`, `salt_100g`, `fiber_100g`, `image_url`) VALUES
(20012878, 'Saucisses de francfort', 1549635033892, 1, 'E', 285, 13, 1, 25, 1.9, 0, 'https://static.openfoodfacts.org/images/products/20012878/front_fr.24.400.jpg'),
(20261214, 'Haricots verts extra fins', 1549635034011, 1, 'A', 27, 1.2, 1.6, 0.1, 1, 1.5, 'https://static.openfoodfacts.org/images/products/20261214/front_fr.15.400.jpg'),
(26062334, 'Oignons Jaunes (Cat.1, Cal. 50/70)', 1549635034060, 2, NULL, 31, 1.35, 1.57, 5.68, 0, 0, 'https://static.openfoodfacts.org/images/products/26062334/front_fr.6.400.jpg'),
(3029330003533, 'Crousti Moelleux Complet', 1549635034118, 1, 'A', 265, 8.9, 7.2, 4.5, 1.2, 5.5, 'https://static.openfoodfacts.org/images/products/302/933/000/3533/front_fr.96.400.jpg'),
(3060731005900, 'Ciboulette ciselée', 1549635034164, 1, 'A', 31, 2.8, 1.6, 0.6, 0.03, 3.9, 'https://static.openfoodfacts.org/images/products/306/073/100/5900/front_fr.5.400.jpg'),
(3068110702235, 'Farine de Blé Tous usages', 1549635034208, 2, 'A', 345, 10, 1.5, 1.3, 0, 3.5, 'https://static.openfoodfacts.org/images/products/306/811/070/2235/front_fr.21.400.jpg'),
(3166290200197, 'Cannelle Moulue', 1549635034250, 1, 'B', 0, 0, 0, 0, 0, 0, 'https://static.openfoodfacts.org/images/products/316/629/020/0197/front_fr.21.400.jpg'),
(3166290200562, 'Clous de Girofle', 1549635034281, 1, NULL, 0, 0, 0, 0, 0, 0, 'https://static.openfoodfacts.org/images/products/316/629/020/0562/front_fr.7.400.jpg'),
(3184030001187, 'Le Beurre Moulé Doux (82 % MG)', 1549635034327, 1, 'E', 744, 0.8, 0.6, 82, 0.1, 0, 'https://static.openfoodfacts.org/images/products/318/403/000/1187/front_fr.23.400.jpg'),
(3220035150007, 'Sucre en poudre', 1549635034368, 2, 'D', 400, 0, 100, 0, 0, 0, 'https://static.openfoodfacts.org/images/products/322/003/515/0007/front_fr.37.400.jpg'),
(3220035210008, 'Cassonade', 1549637899002, 2, 'D', 396, 0, 99, 0, 0, 0, 'https://static.openfoodfacts.org/images/products/322/003/521/0008/front_fr.85.400.jpg'),
(3252371303519, 'Bicarbonate alimentaire', 1549635034427, 1, 'B', 0, 0, 0, 0, 0, 0, 'https://static.openfoodfacts.org/images/products/325/237/130/3519/front_fr.38.400.jpg'),
(3252378001319, 'Sel fin iodé', 1549635034471, 1, 'C', 0, 0, 0, 0, 100, 0, 'https://static.openfoodfacts.org/images/products/325/237/800/1319/front_fr.79.400.jpg'),
(3270190205685, 'Œufs de poules \nElevées en plein air', 1549635034523, 3, 'A', 142, 12.6, 0.8, 9.9, 0.3, 0, 'https://static.openfoodfacts.org/images/products/327/019/020/5685/front_fr.54.400.jpg'),
(3329770006805, 'Creme Fleurette', 1549635034574, 4, 'D', 302, 2.3, 3.3, 31, 0.1, 0, 'https://static.openfoodfacts.org/images/products/332/977/000/6805/front_fr.20.400.jpg'),
(3417960023029, 'Quatre-épices', 1549635034624, 1, NULL, 0, 0, 0, 0, 0, 0, 'https://static.openfoodfacts.org/images/products/341/796/002/3029/front_fr.15.400.jpg'),
(3450970049405, 'Filet de pomme de terre', 1549635034671, 2, 'A', 80, 1.86, 0, 0.7, 0, 0, 'https://static.openfoodfacts.org/images/products/345/097/004/9405/front_fr.7.400.jpg'),
(5010477301246, 'Jordan\'s Special Muesli 30% de fruits & noix', 1549635034759, 1, 'A', 375, 9.4, 15.4, 9.2, 0.03, 8.7, 'https://static.openfoodfacts.org/images/products/501/047/730/1246/front_fr.3.400.jpg'),
(5410188014211, 'Pure Premium Tomate', 1549635034808, 4, 'B', 17, 0.7, 3.2, 0, 0.2, 1.5, 'https://static.openfoodfacts.org/images/products/541/018/801/4211/front_fr.6.400.jpg'),
(7290000537337, 'Hot Dogs', 1549635034849, 1, 'C', 171, 13, 2, 11, 1.6, 0, 'https://static.openfoodfacts.org/images/products/729/000/053/7337/front_fr.14.400.jpg'),
(7613031335107, 'Bouillon Kub ® Goût Boeuf dégraissé', 1549635034931, 1, NULL, 217, 12, 4.3, 3.2, 46.3, 1.3, 'https://static.openfoodfacts.org/images/products/761/303/133/5107/front_fr.15.400.jpg'),
(8712100530463, 'Planta Fin Doux', 1549635034988, 1, NULL, 540, 0.5, 0.5, 60, 0, 0.5, 'https://static.openfoodfacts.org/images/products/871/210/053/0463/front_fr.67.400.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `ingredient_additive`
--

DROP TABLE IF EXISTS `ingredient_additive`;
CREATE TABLE IF NOT EXISTS `ingredient_additive` (
  `barcode_ingredient` bigint(20) NOT NULL,
  `id_additive` varchar(10) NOT NULL,
  PRIMARY KEY (`barcode_ingredient`,`id_additive`),
  KEY `FK_recipe_ingredient_id_additive` (`id_additive`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ingredient_additive`
--

INSERT INTO `ingredient_additive` (`barcode_ingredient`, `id_additive`) VALUES
(8712100530463, 'E160'),
(8712100530463, 'E160A'),
(8712100530463, 'E160AI'),
(7290000537337, 'E172'),
(7290000537337, 'E172II'),
(20012878, 'E250'),
(8712100530463, 'E270'),
(20012878, 'E300'),
(7290000537337, 'E300'),
(7290000537337, 'E340'),
(3329770006805, 'E407'),
(3329770006805, 'E415'),
(20012878, 'E450'),
(7290000537337, 'E461'),
(3329770006805, 'E472B'),
(3252371303519, 'E500'),
(3252371303519, 'E500II'),
(3252378001319, 'E535'),
(7613031335107, 'E621'),
(7613031335107, 'E627'),
(7613031335107, 'E631');

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
  `serving_modifier` float NOT NULL DEFAULT '1',
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_recipe_owner` (`owner`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `recipe`
--

INSERT INTO `recipe` (`id`, `title`, `owner`, `image_url`, `serving_modifier`, `deleted`) VALUES
(1, 'Rød grød med fløde', 'john', 'https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA', 1, 0),
(2, 'Frikadeller med brun sovs og kartofler', 'john', 'https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA', 1, 0),
(3, 'Pebernødder', 'john', 'https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA', 1, 0),
(4, 'Stegt flæsk med kartofler', 'john', 'https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA', 1, 0),
(84, 'Svensk pølseret', 'aaa', 'https://www.dk-kogebogen.dk/billeder-opskrifter/vis_billede_stor_slider.php?id=3084&billede=4', 1, 0),
(85, 'Rød grød med fløde', 'aaa', NULL, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `recipe_ingredient`
--

DROP TABLE IF EXISTS `recipe_ingredient`;
CREATE TABLE IF NOT EXISTS `recipe_ingredient` (
  `id_recipe` int(11) NOT NULL,
  `barcode_ingredient` bigint(20) NOT NULL,
  `quantity` float NOT NULL DEFAULT '0',
  `id_unit` int(11) NOT NULL,
  PRIMARY KEY (`id_recipe`,`barcode_ingredient`),
  KEY `id_recipe` (`id_recipe`),
  KEY `barcode_ingredient` (`barcode_ingredient`),
  KEY `FK_recipe_ingredient_id_unit` (`id_unit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recipe_ingredient`
--

INSERT INTO `recipe_ingredient` (`id_recipe`, `barcode_ingredient`, `quantity`, `id_unit`) VALUES
(3, 3068110702235, 500, 1),
(3, 3166290200197, 0.25, 8),
(3, 3166290200562, 0.12, 8),
(3, 3184030001187, 200, 1),
(3, 3220035150007, 350, 1),
(3, 3252371303519, 0.5, 8),
(3, 3270190205685, 1, 3),
(3, 3329770006805, 4, 7),
(3, 3417960023029, 0.75, 8),
(84, 20012878, 450, 1),
(84, 26062334, 100, 1),
(84, 3060731005900, 0, 1),
(84, 3252378001319, 0, 1),
(84, 3450970049405, 1250, 1),
(84, 5410188014211, 1, 9),
(84, 7613031335107, 22, 1),
(84, 8712100530463, 75, 1),
(85, 3029330003533, 200, 1),
(85, 5010477301246, 456, 1);

-- --------------------------------------------------------

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
CREATE TABLE IF NOT EXISTS `unit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `mapping` varchar(255) NOT NULL,
  `base_unit` int(11) NOT NULL,
  `base_unit_conversion` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `unit`
--

INSERT INTO `unit` (`id`, `name`, `mapping`, `base_unit`, `base_unit_conversion`) VALUES
(1, 'g', '^\\d+((\\.|,)\\d)?\\d*\\s{0,1}g(\\s{0,1}\\(.+\\)){0,1}$', 1, 1),
(2, 'kg', '^\\d+(\\.\\d)?\\d*\\s{0,1}kg$', 1, 1000),
(3, 'pièces', '^\\d+$', 1, 1),
(4, 'cl', '(^\\d*\\s{0,1}cl e$|^\\d*\\s{0,1}cl$)', 5, 10),
(5, 'ml', '^\\d*\\s{0,1}ml$', 5, 1),
(6, 'l', '^\\d*\\s{0,1}l$', 5, 1000),
(7, 'CàS', '', 5, 15),
(8, 'CàC', '', 5, 5),
(9, 'dl', '', 5, 100),
(10, 'tonnes', '', 1, 1000000);

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
-- Constraints for table `ingredient_additive`
--
ALTER TABLE `ingredient_additive`
  ADD CONSTRAINT `FK_ingredient_additive_barcode_ingredient` FOREIGN KEY (`barcode_ingredient`) REFERENCES `ingredient` (`barcode`),
  ADD CONSTRAINT `FK_recipe_ingredient_id_additive` FOREIGN KEY (`id_additive`) REFERENCES `additive` (`id`);

--
-- Constraints for table `recipe`
--
ALTER TABLE `recipe`
  ADD CONSTRAINT `FK_recipe_owner` FOREIGN KEY (`owner`) REFERENCES `user` (`username`);

--
-- Constraints for table `recipe_ingredient`
--
ALTER TABLE `recipe_ingredient`
  ADD CONSTRAINT `FK_recipe_ingredient_barcode_ingredient` FOREIGN KEY (`barcode_ingredient`) REFERENCES `ingredient` (`barcode`),
  ADD CONSTRAINT `FK_recipe_ingredient_id_recipe` FOREIGN KEY (`id_recipe`) REFERENCES `recipe` (`id`),
  ADD CONSTRAINT `FK_recipe_ingredient_id_unit` FOREIGN KEY (`id_unit`) REFERENCES `unit` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
