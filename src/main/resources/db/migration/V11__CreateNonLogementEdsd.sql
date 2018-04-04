-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--

DROP TABLE IF EXISTS `heroku_5889aeb3caa53dd`.`non_logement_edsd`;

CREATE TABLE `heroku_5889aeb3caa53dd`.`non_logement_edsd` (
  `non_logement_id` int(11) NOT NULL AUTO_INCREMENT,
  `actual_non_logement` int(11) NOT NULL,
  `computed_non_logement` double NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` date NOT NULL,
  `number_of_months` double NOT NULL,
  `salaire_de_base` double NOT NULL,
  `start_date` date NOT NULL,
  `requester_id` int(11) NOT NULL,
  `created_by_user_id` int(11) NOT NULL,
  PRIMARY KEY (`non_logement_id`),
  KEY `FKow7o20p0utnfxbvn56gyugapp` (`requester_id`),
  KEY `FKcpj5lu81uveqgp5ifuuv2mbaa` (`created_by_user_id`),
  CONSTRAINT `FKcpj5lu81uveqgp5ifuuv2mbaa` FOREIGN KEY (`created_by_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKow7o20p0utnfxbvn56gyugapp` FOREIGN KEY (`requester_id`) REFERENCES `requester` (`requester_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

ALTER TABLE `heroku_5889aeb3caa53dd`.`non_logement_edsd` AUTO_INCREMENT = 0;
