/*
SQLyog Ultimate v12.14 (64 bit)
MySQL - 5.7.13-log : Database - football
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`football` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `football`;

/*Table structure for table `player_profile` */

DROP TABLE IF EXISTS `player_profile`;

CREATE TABLE `player_profile` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `player_id` int(3) NOT NULL,
  `position_id` int(3) NOT NULL,
  `weight` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7rscyl2qlky12b5f0ts4l8aq6` (`position_id`),
  KEY `FKobffu1jp354v25sul0btcqcpy` (`player_id`),
  CONSTRAINT `FK7rscyl2qlky12b5f0ts4l8aq6` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`),
  CONSTRAINT `FKehou6s89rv2k40apw44h5onnw` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`),
  CONSTRAINT `FKnbg9ajtc7cf7odugkpl9op9wv` FOREIGN KEY (`player_id`) REFERENCES `players` (`id`),
  CONSTRAINT `FKobffu1jp354v25sul0btcqcpy` FOREIGN KEY (`player_id`) REFERENCES `players` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

/*Data for the table `player_profile` */

insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(1,1,2,6);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(2,1,3,8);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(3,1,4,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(4,2,2,3);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(5,2,3,3);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(6,3,4,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(7,4,2,4);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(8,4,4,5);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(9,5,4,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(10,6,3,5);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(11,9,4,6);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(12,10,2,6);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(13,10,3,6);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(14,11,1,9);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(15,12,2,6);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(16,12,3,5);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(17,13,3,6);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(18,13,4,6);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(19,14,2,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(20,15,2,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(21,15,3,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(22,15,4,6);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(23,16,2,6);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(24,17,2,6);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(25,18,2,8);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(26,20,2,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(27,20,3,8);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(28,23,2,8);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(29,23,3,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(30,24,2,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(31,24,3,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(32,26,2,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(33,28,2,5);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(34,28,3,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(35,30,2,6);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(36,30,3,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(37,30,4,8);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(38,31,2,3);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(39,31,3,2);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(40,31,4,3);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(41,32,3,5);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(42,32,4,6);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(43,33,2,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(44,33,4,6);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(45,34,1,8);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(46,35,2,6);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(47,35,3,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(48,36,2,8);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(49,37,4,7);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(50,7,2,5);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(51,8,2,5);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(52,19,2,5);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(53,21,2,6);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(54,22,2,5);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(55,25,2,5);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(56,27,2,5);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`) values
(57,29,2,4);

/*Table structure for table `players` */

DROP TABLE IF EXISTS `players`;

CREATE TABLE `players` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `players` */

insert  into `players`(`id`,`name`) values
(1,'Педа');
insert  into `players`(`id`,`name`) values
(2,'Башлыков');
insert  into `players`(`id`,`name`) values
(3,'Колоткин');
insert  into `players`(`id`,`name`) values
(4,'Крутиков');
insert  into `players`(`id`,`name`) values
(5,'Каморников');
insert  into `players`(`id`,`name`) values
(6,'Шейкин');
insert  into `players`(`id`,`name`) values
(7,'Шишацкий');
insert  into `players`(`id`,`name`) values
(8,'Марзавин');
insert  into `players`(`id`,`name`) values
(9,'Скварчевский');
insert  into `players`(`id`,`name`) values
(10,'Бирук');
insert  into `players`(`id`,`name`) values
(11,'Жидаль');
insert  into `players`(`id`,`name`) values
(12,'Лосич');
insert  into `players`(`id`,`name`) values
(13,'Бусел');
insert  into `players`(`id`,`name`) values
(14,'Егошин');
insert  into `players`(`id`,`name`) values
(15,'Нейжмак');
insert  into `players`(`id`,`name`) values
(16,'Рыбалко');
insert  into `players`(`id`,`name`) values
(17,'Кириленко');
insert  into `players`(`id`,`name`) values
(18,'Вырко');
insert  into `players`(`id`,`name`) values
(19,'Макеров');
insert  into `players`(`id`,`name`) values
(20,'Скребец');
insert  into `players`(`id`,`name`) values
(21,'Примачок');
insert  into `players`(`id`,`name`) values
(22,'Рощин');
insert  into `players`(`id`,`name`) values
(23,'Титов');
insert  into `players`(`id`,`name`) values
(24,'Шапоров');
insert  into `players`(`id`,`name`) values
(25,'Слиборский Ал');
insert  into `players`(`id`,`name`) values
(26,'Сосновский');
insert  into `players`(`id`,`name`) values
(27,'Сойко');
insert  into `players`(`id`,`name`) values
(28,'Тихонович');
insert  into `players`(`id`,`name`) values
(29,'Мисюля');
insert  into `players`(`id`,`name`) values
(30,'Зубович');
insert  into `players`(`id`,`name`) values
(31,'Чапля');
insert  into `players`(`id`,`name`) values
(32,'Гулькович');
insert  into `players`(`id`,`name`) values
(33,'Рубельский');
insert  into `players`(`id`,`name`) values
(34,'Дима');
insert  into `players`(`id`,`name`) values
(35,'Дуб');
insert  into `players`(`id`,`name`) values
(36,'Дракон');
insert  into `players`(`id`,`name`) values
(37,'Лысый');

/*Table structure for table `position` */

DROP TABLE IF EXISTS `position`;

CREATE TABLE `position` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `position` */

insert  into `position`(`id`,`name`) values
(1,'goalkeeper');
insert  into `position`(`id`,`name`) values
(2,'defender');
insert  into `position`(`id`,`name`) values
(3,'midfield');
insert  into `position`(`id`,`name`) values
(4,'forward');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
