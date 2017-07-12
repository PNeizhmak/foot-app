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

/*Table structure for table `game` */

DROP TABLE IF EXISTS `game`;

CREATE TABLE `game` (
  `id` int(11) NOT NULL,
  `game_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `game` */

/*Table structure for table `hibernate_sequences` */

DROP TABLE IF EXISTS `hibernate_sequences`;

CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequences` */

/*Table structure for table `player_profile` */

DROP TABLE IF EXISTS `player_profile`;

CREATE TABLE `player_profile` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `player_id` int(3) NOT NULL,
  `position_id` int(3) NOT NULL,
  `weight` int(3) DEFAULT NULL,
  `goals_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7rscyl2qlky12b5f0ts4l8aq6` (`position_id`),
  KEY `FKobffu1jp354v25sul0btcqcpy` (`player_id`),
  CONSTRAINT `FKehou6s89rv2k40apw44h5onnw` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`),
  CONSTRAINT `FKobffu1jp354v25sul0btcqcpy` FOREIGN KEY (`player_id`) REFERENCES `players` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

/*Data for the table `player_profile` */

insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(1,1,2,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(2,1,3,8,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(3,1,4,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(4,2,2,3,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(5,2,3,3,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(6,3,4,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(7,4,2,4,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(8,4,4,5,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(9,5,4,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(10,6,3,5,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(11,9,4,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(12,10,2,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(13,10,3,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(14,11,1,8,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(15,12,2,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(16,12,3,5,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(17,13,3,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(18,13,4,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(19,14,2,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(20,15,2,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(21,15,3,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(22,15,4,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(23,16,2,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(24,17,2,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(25,18,2,8,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(26,20,2,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(27,20,3,8,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(28,23,2,8,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(29,23,3,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(30,24,2,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(31,24,3,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(32,26,2,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(33,28,2,5,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(34,28,3,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(35,30,2,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(36,30,3,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(37,30,4,8,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(38,31,2,3,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(39,31,3,2,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(40,31,4,3,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(41,32,3,5,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(42,32,4,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(43,33,2,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(44,33,4,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(45,34,1,8,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(46,35,2,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(47,35,3,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(48,36,2,8,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(49,37,4,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(50,7,2,5,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(51,8,2,5,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(52,19,2,5,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(53,21,2,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(54,22,2,5,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(55,25,2,5,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(56,27,2,5,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(57,29,2,4,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(58,38,3,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(59,39,3,8,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(60,39,4,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(61,40,2,7,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(62,40,3,6,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(63,41,3,8,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(64,41,4,9,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(65,42,3,5,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(66,42,4,5,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(67,43,3,8,NULL);
insert  into `player_profile`(`id`,`player_id`,`position_id`,`weight`,`goals_count`) values
(68,43,4,7,NULL);

/*Table structure for table `players` */

DROP TABLE IF EXISTS `players`;

CREATE TABLE `players` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `parent_id` int(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

/*Data for the table `players` */

insert  into `players`(`id`,`name`,`parent_id`) values
(1,'Педа',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(2,'Башлыков',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(3,'Колоткин',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(4,'Крутиков',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(5,'Каморников',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(6,'Шейкин',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(7,'Шишацкий',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(8,'Марзавин',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(9,'Скварчевский',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(10,'Бирук',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(11,'Жидаль',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(12,'Лосич',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(13,'Бусел',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(14,'Егошин',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(15,'Нейжмак',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(16,'Рыбалко',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(17,'Кириленко',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(18,'Вырко',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(19,'Макеров',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(20,'Скребец',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(21,'Примачок',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(22,'Рощин',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(23,'Титов',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(24,'Шапоров',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(25,'Слиборский Ал',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(26,'Сосновский',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(27,'Сойко',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(28,'Тихонович',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(29,'Мисюля',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(30,'Зубович',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(31,'Чапля',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(32,'Гулькович',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(33,'Рубельский И',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(34,'Дима',28);
insert  into `players`(`id`,`name`,`parent_id`) values
(35,'Дуб',23);
insert  into `players`(`id`,`name`,`parent_id`) values
(36,'Дракон',23);
insert  into `players`(`id`,`name`,`parent_id`) values
(37,'Лысый',23);
insert  into `players`(`id`,`name`,`parent_id`) values
(38,'Антон',9);
insert  into `players`(`id`,`name`,`parent_id`) values
(39,'Вова',9);
insert  into `players`(`id`,`name`,`parent_id`) values
(40,'Рубельский С',33);
insert  into `players`(`id`,`name`,`parent_id`) values
(41,'Новиков',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(42,'Смолянков',0);
insert  into `players`(`id`,`name`,`parent_id`) values
(43,'Юник',1);

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

/*Table structure for table `pp_in_team` */

DROP TABLE IF EXISTS `pp_in_team`;

CREATE TABLE `pp_in_team` (
  `team_id` int(11) NOT NULL,
  `pp_id` int(11) NOT NULL,
  KEY `FKq29fhkwu363r26eu17r5l7t2e` (`pp_id`),
  KEY `FK6rkoyp29ncumcqx5ggsome17o` (`team_id`),
  CONSTRAINT `FK6rkoyp29ncumcqx5ggsome17o` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`),
  CONSTRAINT `FKq29fhkwu363r26eu17r5l7t2e` FOREIGN KEY (`pp_id`) REFERENCES `player_profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pp_in_team` */

/*Table structure for table `team` */

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `id` int(11) NOT NULL,
  `team_weight` int(11) DEFAULT NULL,
  `game_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrak251g2iec8hmjblec8lmyia` (`game_id`),
  CONSTRAINT `FKrak251g2iec8hmjblec8lmyia` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `team` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
