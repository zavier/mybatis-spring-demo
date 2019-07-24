CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);

--INSERT INTO t_user (id, user_name, user_age) VALUES (1, 'testname', 1);