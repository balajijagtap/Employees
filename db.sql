CREATE DATABASE  IF NOT EXISTS `employeeDB`;
USE `employeeDB`;

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
    `username` varchar(68) NOT NULL,
    `password` varchar(68) NOT NULL,
    `role` varchar(50) NOT NULL,
    `manager` varchar(68),
    `active` tinyint NOT NULL,
    PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `employees`
VALUES
('Imandi','{noop}fun123','ROLE_MANAGER', NULL, 1),
('Ajit','{noop}fun123','ROLE_MANAGER', NULL, 1),
('Balaji','{noop}123','ROLE_EMPLOYEE', 'Imandi', 1),
('Pranay','{noop}fun123','ROLE_EMPLOYEE', 'Imandi', 1),
('Vishnu','{noop}fun123','ROLE_EMPLOYEE', 'Imandi', 1),
('Utkarsh','{noop}fun123','ROLE_EMPLOYEE', 'Ajit', 1),
('Avesh','{noop}fun123','ROLE_EMPLOYEE', 'Ajit', 1),
('Sanjay','{noop}fun123','ROLE_EMPLOYEE', 'Ajit', 1);