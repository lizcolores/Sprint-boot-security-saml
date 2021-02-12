DROP DATABASE IF EXISTS saml_security;
CREATE DATABASE saml_security;
USE saml_security;

###################### TABLE DEFINITIONS ######################
CREATE TABLE `user` (
  `ID` varchar(255) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD_HASH` varchar(255) DEFAULT NULL,
  `SALESFORCE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
###################### TABLE DEFINITIONS ######################

###################### INSERT DATA ######################
INSERT INTO user (ID, USERNAME, PASSWORD_HASH) VALUES
('17e3d83c-6e09-41b8-b4ee-b4b14cb8a797', 'dbuser@dbauth.com', 'test1234'),
('17e3d83c-6e09-41b8-b4ee-b4b14cb8a792', 'test@gmail.com', 'test.1234');
###################### INSERT DATA ######################