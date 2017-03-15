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

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(6);

/*Table structure for table `players` */

DROP TABLE IF EXISTS `players`;

CREATE TABLE `players` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `players` */

insert  into `players`(`id`,`name`) values 
(1,'Нейжмак');
insert  into `players`(`id`,`name`) values 
(2,'Егошин');
insert  into `players`(`id`,`name`) values 
(3,'Титов');
insert  into `players`(`id`,`name`) values 
(4,'Рубельский');
insert  into `players`(`id`,`name`) values 
(5,'Каморников');

/*Table structure for table `players_position` */

DROP TABLE IF EXISTS `players_position`;

CREATE TABLE `players_position` (
  `player_id` int(3) NOT NULL,
  `position_id` int(3) NOT NULL,
  PRIMARY KEY (`player_id`,`position_id`),
  KEY `FK7rscyl2qlky12b5f0ts4l8aq6` (`position_id`),
  CONSTRAINT `FK7rscyl2qlky12b5f0ts4l8aq6` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`),
  CONSTRAINT `FKnbg9ajtc7cf7odugkpl9op9wv` FOREIGN KEY (`player_id`) REFERENCES `players` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `players_position` */

insert  into `players_position`(`player_id`,`position_id`) values 
(1,2);
insert  into `players_position`(`player_id`,`position_id`) values 
(2,2);
insert  into `players_position`(`player_id`,`position_id`) values 
(4,2);
insert  into `players_position`(`player_id`,`position_id`) values 
(1,3);
insert  into `players_position`(`player_id`,`position_id`) values 
(4,4);
insert  into `players_position`(`player_id`,`position_id`) values 
(5,4);
insert  into `players_position`(`player_id`,`position_id`) values 
(3,5);

/*Table structure for table `position` */

DROP TABLE IF EXISTS `position`;

CREATE TABLE `position` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `position` */

insert  into `position`(`id`,`name`) values 
(1,'goalkeeper');
insert  into `position`(`id`,`name`) values 
(2,'defender');
insert  into `position`(`id`,`name`) values 
(3,'midfield');
insert  into `position`(`id`,`name`) values 
(4,'forward');
insert  into `position`(`id`,`name`) values 
(5,'universal');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
