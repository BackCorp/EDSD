
--- DROP DATABASE IF EXISTS `edsd`;
--- CREATE DATABASE `edsd`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `email` varchar(100) CHARACTER SET utf8 NOT NULL,
  `first_name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `last_name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `mid_name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(60) CHARACTER SET utf8 NOT NULL,
  `username` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UKku8s9ykb4c149v6ttg9nuypsx` (`user_id`,`username`,`email`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

ALTER TABLE `user` AUTO_INCREMENT = 0;


DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `UKqwjh7xto53qcy2b835c6l4x14` (`role_id`,`role`),
  UNIQUE KEY `UK_bjxn5ii7v7ygwx39et0wawu0q` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

ALTER TABLE `role` AUTO_INCREMENT = 0;


DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



DROP TABLE IF EXISTS `requester`;
CREATE TABLE `requester` (
  `requester_id` int(11) NOT NULL AUTO_INCREMENT,
  `account_number` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `region` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `health_district` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `structure` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `genre` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `dob` date NOT NULL,
  `place_of_birth` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `field_of_work` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `recruitment_date` date DEFAULT NULL,
  `grade_at_recruitment` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `current_grade` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `category_at_recruitment` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `current_category` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `current_index` int(10) NOT NULL,
  `current_situation` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `rank_position` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `occupied_organic_position` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_of_appointment_or_assignment` date DEFAULT NULL,
  `appointment_type` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reference_appointment_or_assignment` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`requester_id`),
  UNIQUE KEY `requester_id_UNIQUE` (`requester_id`),
  UNIQUE KEY `account_number_UNIQUE` (`account_number`),
  UNIQUE KEY `UKrvu1x64s164w06j7j6qectx5k` (`requester_id`,`account_number`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='This table describes whoever is submitting an EDSD request';

ALTER TABLE `requester` AUTO_INCREMENT = 0;

