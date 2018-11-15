-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Temps de generació: 13-11-2018 a les 10:17:24
-- Versió del servidor: 10.1.36-MariaDB
-- Versió de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `locales`
--

-- --------------------------------------------------------

--
-- Estructura de la taula `Licencia`
--

CREATE TABLE `Licencia` (
  `id` int(10) NOT NULL PRIMARY KEY,
  `Titulo` varchar(255) NOT NULL,
  `FechaCreacion` varchar(255) NOT NULL,
  `Expediente` varchar(255) NOT NULL,
  `ANYO` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Bolcament de dades per a la taula `Licencia`
--

INSERT INTO `Licencia` (`id`, `Titulo`, `FechaCreacion`, `Expediente`, `ANYO`) VALUES
(1, 'Nombre Ejemplar Licencia 1', '01/01/2010', '1001', '2010'),
(2, 'Nombre Ejemplar Licencia 2', '01/02/2010', '1002', '2011');

-- --------------------------------------------------------

--
-- Estructura de la taula `Local`
--

CREATE TABLE `Local` (
  `ID` int(10) NOT NULL PRIMARY KEY,
  `Emplazamiento` varchar(255) NOT NULL,
  `CodigoPortal` varchar(255) NOT NULL,
  `CodigoVia` varchar(255) NOT NULL,
  `NumeroVia` varchar(255) NOT NULL,
  `RefCatas` varchar(255) NOT NULL,
  `RefMuni` varchar(255) NOT NULL,
  `Poligono` int(20) NOT NULL,
  `ZonaSaturada` varchar(255) NOT NULL,
  `Comentarios` varchar(255) NOT NULL,
  `IdLicencia` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Bolcament de dades per a la taula `Local`
--

INSERT INTO `Local` (`ID`, `Emplazamiento`, `CodigoPortal`, `CodigoVia`, `NumeroVia`, `RefCatas`, `RefMuni`, `Poligono`, `ZonaSaturada`, `Comentarios`, `IdLicencia`) VALUES
(1, 'Emplazamiento de ejemplo', '2000', '3000', '4000', '5000', '6000', 0, 'zona de ejemplo 1', 'comentario de ejemplo', 1),
(2, 'Emplazamiento de ejemplo2', '2002', '3002', '4002', '5002', '6002', 0, 'zona de ejemplo 2', 'comentario de ejemplo2', 1);

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `Licencia`
--
ALTER TABLE `Licencia`
  ADD PRIMARY KEY (`id`);

--
-- Índexs per a la taula `Local`
--
ALTER TABLE `Local`
  ADD KEY `IdLicencia` (`IdLicencia`) USING BTREE;

--
-- Restriccions per a les taules bolcades
--

--
-- Restriccions per a la taula `Local`
--
ALTER TABLE `Local`
  ADD CONSTRAINT `Local_ibfk_1` FOREIGN KEY (`IdLicencia`) REFERENCES `Licencia` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
