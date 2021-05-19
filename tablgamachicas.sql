create table 
CREATE TABLE `Detailtemptpay` (
  `idDetailtemptpay` int(11) NOT NULL AUTO_INCREMENT,
  `idclothingline` decimal(10,0) NOT NULL,
  `idclothing` decimal(10,0) NOT NULL,
  `idcolor` decimal(10,0) NOT NULL,
  `iddescription` decimal(10,0) NOT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `idvaucher` decimal(10,0) DEFAULT NULL,
  `totalprice` decimal(10,0) DEFAULT NULL,
  `totalitem` decimal(10,0) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `idstatus` decimal(10,0) NOT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(1) DEFAULT NULL,
  `idusercreate` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`idDetailtemptpay`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `clothing` (
  `idclothing` int(11) NOT NULL AUTO_INCREMENT,
  `idclothingline` decimal(10,0) DEFAULT NULL,
  `idcolor` decimal(10,0) DEFAULT NULL,
  `NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`idclothing`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `clothingline` (
  `idclothingline` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`idclothingline`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

CREATE TABLE `color` (
  `idcolor` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  PRIMARY KEY (`idcolor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `Detailtemptpay` (
  `idDetailtemptpay` int(11) NOT NULL AUTO_INCREMENT,
  `idclothingline` decimal(10,0) NOT NULL,
  `idclothing` decimal(10,0) NOT NULL,
  `idcolor` decimal(10,0) NOT NULL,
  `iddescription` decimal(10,0) NOT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `idvaucher` decimal(10,0) DEFAULT NULL,
  `totalprice` decimal(10,0) DEFAULT NULL,
  `totalitem` decimal(10,0) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `idstatus` decimal(10,0) NOT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(1) DEFAULT NULL,
  `idusercreate` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`idDetailtemptpay`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `Groupparameter` (
  `idGroupparameter` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`idGroupparameter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `color` (
  `idcolor` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  PRIMARY KEY (`idcolor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `Detailtemptpay` (
  `idDetailtemptpay` int(11) NOT NULL AUTO_INCREMENT,
  `idclothingline` decimal(10,0) NOT NULL,
  `idclothing` decimal(10,0) NOT NULL,
  `idcolor` decimal(10,0) NOT NULL,
  `iddescription` decimal(10,0) NOT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `idvaucher` decimal(10,0) DEFAULT NULL,
  `totalprice` decimal(10,0) DEFAULT NULL,
  `totalitem` decimal(10,0) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `idstatus` decimal(10,0) NOT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(1) DEFAULT NULL,
  `idusercreate` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`idDetailtemptpay`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `Groupparameter` (
  `idGroupparameter` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`idGroupparameter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `imagen` (
  `idimagen` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `idclothing` int(11) NOT NULL,
  `idposition` int(11) NOT NULL,
  `positionweb` int(11) NOT NULL,
  `countViews` int(11) NOT NULL,
  `imagendata` longblob,
  `url` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `idclothingline` int(11) DEFAULT NULL,
  PRIMARY KEY (`idimagen`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
CREATE TABLE `Menu` (
  `idmenu` int(11) NOT NULL AUTO_INCREMENT,
  `idparentMenu` int(11) DEFAULT NULL,
  `name` varchar(200) NOT NULL,
  `path` varchar(100) NOT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NULL DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idmenu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `parameter` (
  `idparameter` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`idparameter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `parentMenu` (
  `idparentMenu` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `path` varchar(100) NOT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NULL DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idparentMenu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
CREATE TABLE `Position` (
  `idPosition` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPosition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `sizes` (
  `idsize` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(5) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `STATUS` decimal(10,0) NOT NULL,
  PRIMARY KEY (`idsize`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `stock` (
  `idstock` int(11) NOT NULL AUTO_INCREMENT,
  `idclothingline` decimal(10,0) NOT NULL,
  `idclothing` decimal(10,0) NOT NULL,
  `idcolor` decimal(10,0) NOT NULL,
  `iddescription` decimal(10,0) NOT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `count` decimal(10,0) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(1) DEFAULT NULL,
  `idusercreate` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`idstock`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `temptpayheader` (
  `idtemptpayheader` int(11) NOT NULL AUTO_INCREMENT,
  `idvaucher` decimal(10,0) DEFAULT NULL,
  `totalprice` decimal(10,0) DEFAULT NULL,
  `totalitem` decimal(10,0) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `idstatus` decimal(10,0) NOT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(1) DEFAULT NULL,
  `idusercreate` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`idtemptpayheader`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
`iduser` int(11) NOT NULL AUTO_INCREMENT,
 `idRol` int(11)  null,
 `idSystem` int(11)  null,
 `alias` varchar(200)  NULL,
  `user` varchar(200)  NULL,
  `username` varchar(200)  NULL,
  `mobilPhone` varchar(200)  NULL,
  `mail` varchar(100)  NULL,
 `password` varchar(100)  NULL,
 `apiPassword` varchar(1000)  NULL,
 `salPassword` varchar(1000)  NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NULL DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

