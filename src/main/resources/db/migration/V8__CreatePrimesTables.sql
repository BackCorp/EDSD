-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)

DROP TABLE IF EXISTS `heroku_5889aeb3caa53dd`.`primes_liees_au_grade_ou_categorie`;

CREATE TABLE `heroku_5889aeb3caa53dd`.`primes_liees_au_grade_ou_categorie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classe` varchar(100) NOT NULL,
  `grade_ou_categorie` varchar(100) NOT NULL,
  `indemnite` varchar(100) NOT NULL,
  `montant` double NOT NULL,
  `observations` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

ALTER TABLE `heroku_5889aeb3caa53dd`.`primes_liees_au_grade_ou_categorie` AUTO_INCREMENT=0;



DROP TABLE IF EXISTS `heroku_5889aeb3caa53dd`.`primes_liees_aux_indices`;

CREATE TABLE `heroku_5889aeb3caa53dd`.`primes_liees_aux_indices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classe` varchar(100) NOT NULL,
  `groupe` varchar(100) NOT NULL,
  `indemnite` varchar(100) NOT NULL,
  `montant` double NOT NULL,
  `observations` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK3cukgum7m6wofvplul5816jor` (`id`,`groupe`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

ALTER TABLE `heroku_5889aeb3caa53dd`.`primes_liees_aux_indices` AUTO_INCREMENT=0;



ALTER TABLE `heroku_5889aeb3caa53dd`.`primes_liees_au_grade_ou_categorie` 
COLLATE = utf8_unicode_ci ;

ALTER TABLE `heroku_5889aeb3caa53dd`.`primes_liees_aux_indices` 
COLLATE = utf8_unicode_ci ;
