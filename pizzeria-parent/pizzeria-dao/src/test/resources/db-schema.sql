CREATE TABLE IF NOT EXISTS `pizza` (
  `id` varchar(255) NOT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prix` decimal(19,2) DEFAULT NULL,
  `url_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);