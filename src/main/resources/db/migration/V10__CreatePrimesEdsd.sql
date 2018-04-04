-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)

DROP TABLE IF EXISTS `heroku_5889aeb3caa53dd`.`primes_edsd`;

CREATE TABLE `heroku_5889aeb3caa53dd`.`primes_edsd` (
  `primes_edsd_id` int(11) NOT NULL AUTO_INCREMENT,
  `retenues` double NOT NULL DEFAULT 0.0,
  `classe_liee_au_grade` varchar(100) NOT NULL,
  `classe_liee_aux_indices` varchar(100) NOT NULL,
  `computed_primes` double NOT NULL,
  `actual_primes` int(11) NOT NULL,
  `computed_primes_grade` double NOT NULL,
  `computed_primes_indices` double NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_date` date NOT NULL,
  `grade` varchar(100) NOT NULL,
  `groupe` varchar(100) NOT NULL,
  `indemnite_liee_au_grade_technicite` double NOT NULL,
  `indemnite_liee_aux_indices_astreinte` double NOT NULL,
  `indemnite_liee_aux_indices_sante_publique` double NOT NULL,
  `number_of_months` double NOT NULL,
  `start_date` date NOT NULL,
  `requester_id` int(11) NOT NULL,
  `created_by_user_id` int(11) NOT NULL,
  PRIMARY KEY (`primes_edsd_id`),
  UNIQUE KEY `UKb92ohaowa9a8eg6uwlj1f4yuq` (`primes_edsd_id`),
  UNIQUE KEY `primes_edsd_id_UNIQUE` (`primes_edsd_id`),
  KEY `FKs4tpxsx2hhfos18dw6wmeor84` (`requester_id`),
  KEY `FK8hdjdm9waefn0x369svcrhryt` (`created_by_user_id`),
  CONSTRAINT `FK8hdjdm9waefn0x369svcrhryt` FOREIGN KEY (`created_by_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKs4tpxsx2hhfos18dw6wmeor84` FOREIGN KEY (`requester_id`) REFERENCES `requester` (`requester_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

ALTER TABLE `heroku_5889aeb3caa53dd`.`primes_edsd` AUTO_INCREMENT=0;

