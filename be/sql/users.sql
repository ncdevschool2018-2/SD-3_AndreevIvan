CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `email` varchar(800) DEFAULT NULL,
  `tokens` integer(10000) DEFAULT NULL,
  `password` varchar (32) DEFAULT NULL,
  `status` varchar (32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=1