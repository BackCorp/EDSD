INSERT INTO `edsd`.`user`
(`last_name`,
`first_name`,
`username`,
`password`,
`email`,
`active`)
VALUES
('Admin','Admin','admin','padmin','admin@edsd.com',1);

INSERT INTO `edsd`.`user_role` (`user_id`,`role_id`) VALUES (1,1);


INSERT INTO `edsd`.`user`
(`last_name`,
`first_name`,
`username`,
`password`,
`email`,
`active`)
VALUES
('Agent','Agent','agent','pagent','agent@edsd.com',2);