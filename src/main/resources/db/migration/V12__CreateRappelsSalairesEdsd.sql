-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)


DROP TABLE IF EXISTS `heroku_5889aeb3caa53dd`.`rappels_salaires_edsd`;

CREATE TABLE `heroku_5889aeb3caa53dd`.`rappels_salaires_edsd` (
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
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

ALTER TABLE `heroku_5889aeb3caa53dd`.`rappels_salaires_edsd` AUTO_INCREMENT=0;
