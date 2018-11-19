-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-11-2018 a las 19:10:53
-- Versión del servidor: 10.1.29-MariaDB
-- Versión de PHP: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `locales`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `licencia`
--

CREATE TABLE `licencia` (
  `idLicencia` int(11) NOT NULL,
  `Titulo` varchar(255) NOT NULL,
  `FechaCreacion` varchar(255) NOT NULL,
  `Expediente` varchar(255) NOT NULL,
  `ANYO` varchar(255) NOT NULL,
  `LocalID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `licencia`
--

INSERT INTO `licencia` (`idLicencia`, `Titulo`, `FechaCreacion`, `Expediente`, `ANYO`, `LocalID`) VALUES
(13, 'Licencia de Funcionamiento', '2007-05-25T00:00:00Z', '1013801', '2015', 26),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '1017275', '2014', 43),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '1025584', '2016', 14),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '1046690', '2005', 40),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '1063993', '2001', 25),
(16, 'Cambio de Titularidad de Licencia Funcionamiento', '2009-03-17T00:00:00Z', '1086634', '2010', 8),
(16, 'Cambio de Titularidad de Licencia Funcionamiento', '2009-03-17T00:00:00Z', '1103257', '2007', 8),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '1109796', '2015', 37),
(6, 'Licencia de Apertura', '2007-04-01T00:00:00Z', '112990', '2013', 4),
(24, 'Comunicación previa cambio Titularidad Apertura', '2012-02-28T00:00:00Z', '113318', '2012', 46),
(36, 'Declarar la caducidad', '2015-06-12T00:00:00Z', '1138566', '2014', 42),
(36, 'Declarar la caducidad', '2015-06-12T00:00:00Z', '1139109', '2014', 46),
(21, 'Comunicación Previa', '2011-09-30T00:00:00Z', '1139160', '2014', 40),
(13, 'Licencia de Funcionamiento', '2007-05-25T00:00:00Z', '1148810', '2011', 48),
(24, 'Comunicación previa cambio Titularidad Apertura', '2012-02-28T00:00:00Z', '1168129', '2012', 23),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '1173073', '2001', 4),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '1173207', '2001', 10),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '1177849', '2014', 23),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '1198007', '2002', 2),
(0, 'Otras', '2007-04-01T00:00:00Z', '1201110', '2016', 28),
(13, 'Licencia de Funcionamiento', '2007-05-25T00:00:00Z', '1204913', '2014', 27),
(13, 'Licencia de Funcionamiento', '2007-05-25T00:00:00Z', '1212748', '2011', 16),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '1255558', '2016', 10),
(0, 'Otras', '2007-04-01T00:00:00Z', '1351931', '2010', 8),
(6, 'Licencia de Apertura', '2007-04-01T00:00:00Z', '1361707', '2016', 23),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '1373481', '2008', 27),
(13, 'Licencia de Funcionamiento', '2007-05-25T00:00:00Z', '1373529', '2008', 43),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '140386', '2001', 11),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '1432264', '2007', 43),
(3, 'Ampliación Licencia Urbanística', '2007-04-01T00:00:00Z', '146164', '2001', 3),
(33, 'Declaración Responsable de actividad de bar', '2014-10-14T00:00:00Z', '1463250', '2016', 42),
(11, 'Cambio de titularidad', '2007-04-19T00:00:00Z', '147608', '2008', 39),
(33, 'Declaración Responsable de actividad de bar', '2014-10-14T00:00:00Z', '1483126', '2016', 15),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '170299', '1984', 38),
(0, 'Otras', '2007-04-01T00:00:00Z', '18250', '2011', 20),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '196340', '2016', 35),
(36, 'Declarar la caducidad', '2015-06-12T00:00:00Z', '202072', '2015', 32),
(15, 'Cambio de Titularidad de Licencia Urbanística', '2009-03-17T00:00:00Z', '238471', '2001', 17),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '242657', '1986', 9),
(0, 'Otras', '2007-04-01T00:00:00Z', '247040', '2012', 16),
(0, 'Otras', '2007-04-01T00:00:00Z', '249368', '2016', 42),
(13, 'Licencia de Funcionamiento', '2007-05-25T00:00:00Z', '295903', '2015', 48),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '297932', '1986', 33),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3001880', '2000', 34),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3003993', '1997', 49),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3006432', '1990', 4),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3006768', '1989', 25),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3011260', '1989', 7),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3011840', '1990', 19),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '301380', '1983', 27),
(6, 'Licencia de Apertura', '2007-04-01T00:00:00Z', '3014540', '1993', 14),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3015803', '1989', 5),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3017649', '1995', 13),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3017941', '1989', 41),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3026630', '1996', 16),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3030548', '1990', 26),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3034176', '1990', 35),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3037538', '1995', 37),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3039309', '1995', 34),
(3, 'Ampliación Licencia Urbanística', '2007-04-01T00:00:00Z', '3040479', '1999', 11),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3044587', '1994', 28),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3059137', '1995', 37),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3059167', '1994', 21),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3061080', '1989', 20),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3065454', '1995', 46),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3070080', '2000', 42),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3075447', '1995', 40),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3078729', '1999', 47),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3092060', '1988', 10),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3095959', '1995', 1),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3097890', '1993', 28),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3099191', '1996', 3),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3099439', '1993', 28),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3101362', '1994', 8),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3103699', '1989', 48),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3105943', '1994', 45),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3108269', '1994', 39),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3108910', '1991', 18),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3111917', '1994', 23),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3114664', '1989', 11),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3117610', '1992', 47),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3117777', '1999', 49),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3118538', '1995', 32),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3120039', '1991', 13),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3120418', '1989', 22),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3127803', '1989', 26),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3128970', '1989', 15),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3129295', '1995', 27),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3131801', '1995', 3),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3133247', '1994', 24),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3134374', '1999', 38),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3135553', '1999', 41),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3138260', '1988', 22),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3140350', '1988', 15),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3145445', '1993', 29),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3146921', '1999', 8),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3147978', '1990', 16),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3150590', '1994', 45),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3154460', '1988', 31),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3154764', '1999', 29),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3155940', '1989', 48),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3157668', '1994', 24),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3160075', '1993', 35),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3162470', '1993', 30),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3163953', '1991', 19),
(15, 'Cambio de Titularidad de Licencia Urbanística', '2009-03-17T00:00:00Z', '3164042', '1998', 5),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3169499', '1993', 12),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3169501', '1995', 32),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3170371', '1998', 36),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3178088', '1994', 23),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3180721', '1989', 7),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3181449', '1995', 6),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3182773', '1991', 2),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3187648', '1994', 36),
(16, 'Cambio de Titularidad de Licencia Funcionamiento', '2009-03-17T00:00:00Z', '319337', '2016', 29),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3193789', '1997', 33),
(6, 'Licencia de Apertura', '2007-04-01T00:00:00Z', '3195520', '1998', 46),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3198859', '1998', 5),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3202440', '1991', 43),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3203801', '1991', 18),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3215070', '1999', 21),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3227993', '1997', 43),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '335430', '2005', 31),
(10, 'Lic Urbanística y de Actividad Ambiental (R.Única)', '2007-04-19T00:00:00Z', '335977', '2016', 28),
(13, 'Licencia de Funcionamiento', '2007-05-25T00:00:00Z', '345201', '2016', 46),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3566393', '2000', 39),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3566429', '2000', 20),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '3573901', '2000', 17),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '3622318', '2000', 44),
(10, 'Lic Urbanística y de Actividad Ambiental (R.Única)', '2007-04-19T00:00:00Z', '366585', '2014', 39),
(16, 'Cambio de Titularidad de Licencia Funcionamiento', '2009-03-17T00:00:00Z', '368446', '2011', 14),
(14, 'Cambio de Titularidad de Licencia de Apertura', '2009-03-17T00:00:00Z', '378262', '2010', 6),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '395614', '2017', 19),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '402635', '2003', 33),
(10, 'Lic Urbanística y de Actividad Ambiental (R.Única)', '2007-04-19T00:00:00Z', '403290', '2016', 35),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '410546', '1986', 9),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '417600', '2015', 25),
(0, 'Otras', '2007-04-01T00:00:00Z', '420344', '2017', 28),
(13, 'Licencia de Funcionamiento', '2007-05-25T00:00:00Z', '435452', '2010', 16),
(0, 'Otras', '2007-04-01T00:00:00Z', '449721', '2010', 6),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '462295', '1984', 0),
(33, 'Declaración Responsable de actividad de bar', '2014-10-14T00:00:00Z', '475287', '2015', 42),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '478586', '2003', 44),
(15, 'Cambio de Titularidad de Licencia Urbanística', '2009-03-17T00:00:00Z', '481488', '2003', 14),
(6, 'Licencia de Apertura', '2007-04-01T00:00:00Z', '499188', '2001', 28),
(16, 'Cambio de Titularidad de Licencia Funcionamiento', '2009-03-17T00:00:00Z', '50252', '2010', 29),
(13, 'Licencia de Funcionamiento', '2007-05-25T00:00:00Z', '502953', '2008', 23),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '536284', '1987', 17),
(16, 'Cambio de Titularidad de Licencia Funcionamiento', '2009-03-17T00:00:00Z', '60950', '2011', 46),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '633134', '2002', 6),
(13, 'Licencia de Funcionamiento', '2007-05-25T00:00:00Z', '655127', '2010', 23),
(13, 'Licencia de Funcionamiento', '2007-05-25T00:00:00Z', '658521', '2015', 3),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '658959', '2001', 31),
(11, 'Cambio de titularidad', '2007-04-19T00:00:00Z', '671459', '2004', 29),
(13, 'Licencia de Funcionamiento', '2007-05-25T00:00:00Z', '717571', '2009', 20),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '738634', '2001', 42),
(21, 'Comunicación Previa', '2011-09-30T00:00:00Z', '749636', '2016', 7),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '75090', '2013', 29),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '775449', '2001', 1),
(16, 'Cambio de Titularidad de Licencia Funcionamiento', '2009-03-17T00:00:00Z', '776060', '2011', 6),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '785668', '2013', 11),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '790180', '2016', 48),
(13, 'Licencia de Funcionamiento', '2007-05-25T00:00:00Z', '804201', '2018', 28),
(1, 'Licencia de Apertura Actual', '2007-04-01T00:00:00Z', '836341', '2001', 12),
(13, 'Licencia de Funcionamiento', '2007-05-25T00:00:00Z', '84872', '2017', 38),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '855530', '1985', 30),
(15, 'Cambio de Titularidad de Licencia Urbanística', '2009-03-17T00:00:00Z', '856714', '2004', 18),
(24, 'Comunicación previa cambio Titularidad Apertura', '2012-02-28T00:00:00Z', '859948', '2012', 28),
(44, 'LICENCIA URBANISTICA Y DE ACTIVIDAD CLASIFICADA', '2016-08-22T00:00:00Z', '87405', '2015', 43),
(24, 'Comunicación previa cambio Titularidad Apertura', '2012-02-28T00:00:00Z', '877910', '2014', 10),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '888550', '2015', 3),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '89042', '2015', 18),
(13, 'Licencia de Funcionamiento', '2007-05-25T00:00:00Z', '89750', '2011', 48),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '900299', '2015', 18),
(24, 'Comunicación previa cambio Titularidad Apertura', '2012-02-28T00:00:00Z', '915612', '2013', 46),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '916747', '2012', 28),
(11, 'Cambio de titularidad', '2007-04-19T00:00:00Z', '929671', '2007', 46),
(6, 'Licencia de Apertura', '2007-04-01T00:00:00Z', '930500', '2002', 44),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '94245', '2012', 26),
(29, 'COMUNICACIÓN PREVIA CAMBIO TITULARIDAD ACTIVIDAD', '2012-12-04T00:00:00Z', '95596', '2014', 10),
(2, 'Licencia Urbanística', '2007-04-01T00:00:00Z', '965659', '2003', 32),
(15, 'Cambio de Titularidad de Licencia Urbanística', '2009-03-17T00:00:00Z', '986881', '2004', 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `local`
--

CREATE TABLE `local` (
  `ID` int(10) NOT NULL,
  `Emplazamiento` varchar(255) NOT NULL,
  `CodigoPortal` varchar(255) NOT NULL,
  `CodigoVia` varchar(255) NOT NULL,
  `NumeroVia` varchar(255) NOT NULL,
  `RefCatas` varchar(255) NOT NULL,
  `RefMuni` varchar(255) NOT NULL,
  `Poligono` int(20) NOT NULL,
  `ZonaSaturada` varchar(255) NOT NULL,
  `Comentarios` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `local`
--

INSERT INTO `local` (`ID`, `Emplazamiento`, `CodigoPortal`, `CodigoVia`, `NumeroVia`, `RefCatas`, `RefMuni`, `Poligono`, `ZonaSaturada`, `Comentarios`) VALUES
(0, 'CALLE UNCETA, 92 ', '6898', '32440', '92', '4832516XM7143B', '74894,13208', 1, 'C', 'I 14/03/2018  EN EL LOCAL PONE QUE SE TRASPASA.'),
(1, 'CALLE MATIAS CARRICA, 11 (ZARAGOZA)', '861', '6220', '11', '6438608', '76527,13839', 1, 'C', 'ESQUINA CON C/ CONTAMINA'),
(2, 'CALLE MANIFESTACION, 2 (ZARAGOZA)', '869', '17980', '2', '6439402', '76464,13998', 1, 'C', '(Manifestacion,2)'),
(3, 'CALLE CIPRÉS, 4 (ZARAGOZA)', '855', '7520', '4', '6438414', '76424,13881', 1, 'C', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(4, 'CALLE CONTAMINA, 2 (ZARAGOZA)', '863', '8220', '2', '6438601', '76484,13868', 1, 'C', 'Modificado horario según Acuerdo Municipal 23-05-06\nDECLARAR LA CADUCIDAD DE LA LICENCIA'),
(5, 'CALLE CONTAMINA, 3 (ZARAGOZA)', '903', '8220', '3', '6538309', '76488,13882', 1, 'C', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(6, 'CALLE CONTAMINA, 5 (ZARAGOZA)', '904', '8220', '5', '6538307', '76508,13880', 1, 'C', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(7, 'CALLE CONTAMINA, 6 (ZARAGOZA)', '1143', '8220', '6', '6438603', '76510,13858', 1, 'C', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(8, 'CALLE CONTAMINA, 7 (ZARAGOZA)', '19633', '8220', '7', '6538307', '76508,13880', 1, 'C', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(9, 'PLAZA DE ARIÑO, 1 (ZARAGOZA)', '1042', '2490', '1', '6736401', '76764,13705', 1, 'D', 'angular a C/ San Felix'),
(10, 'CALLE CONTAMINA, 8 (ZARAGOZA)', '862', '8220', '8', '6438604', '76516,13854', 1, 'C', 'ANTERIORMENTE SE LLAMABA \"EL COLUMPIO\". Modificado horario según Acuerdo Municipal 23-05-06'),
(11, 'CALLE CONTAMINA, 9 (ZARAGOZA)', '19622', '8220', '9', '6538306', '76521,13871', 1, 'C', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(12, 'PLAZUELA SAN BRAULIO, 1 (ZARAGOZA)', '1068', '27150', '1', '6738101', '76711,13824', 1, 'D', 'En ocasiones puede aparecer por Espoz y Mina nº 12.'),
(13, 'CALLE CONTAMINA, 10 (ZARAGOZA)', '19620', '8220', '10', '6438605', '76521,13851', 1, 'C', ''),
(14, 'CALLE CONTAMINA, 11 (ZARAGOZA)', '905', '8220', '11', '6538305', '76528,13865', 1, 'C', 'pendiente de nueva resolución (15-2-2006)'),
(15, 'CALLE ESPOZ Y MINA, 12 (ZARAGOZA)', '1067', '11060', '12', '6738102', '76731,13829', 1, 'D', ''),
(16, 'CALLE CONTAMINA, 15 (ZARAGOZA)', '920', '8220', '15', '6538910', '76544,13853', 1, 'C', '       '),
(17, 'CALLE ESPOZ Y MINA, 24-26 (ZARAGOZA)', '1052', '11060', '24-26', '6737508', '76781,13777', 1, 'D', ''),
(18, 'CALLE CONTAMINA, 18 (ZARAGOZA)', '918', '8220', '18', '6538803', '76552,13822', 1, 'C', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(19, 'CALLE JUSSEPE MARTINEZ, 4 (ZARAGOZA)', '991', '18380', '4', '6637302', '76613,13791', 1, 'D', ''),
(20, 'CALLE JUSSEPE MARTINEZ, 7 (ZARAGOZA)', '1060', '18380', '7', '6738114', '76641,13798', 1, 'D', 'iniciado tramites posible expediente de ruina. Modificado horario según Acuerdo Municipal 23-05-06'),
(21, 'CALLE JUSSEPE MARTINEZ, 7 (ZARAGOZA)', '1060', '18380', '7', '6738114', '76641,13798', 1, 'D', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(22, 'CALLE CASTO MENDEZ NUÑEZ, 12 (ZARAGOZA)', '19626', '18900', '12', '6637104', '76631,13722', 1, 'D', ''),
(23, 'CALLE CASTO MENDEZ NUÑEZ, 16 (ZARAGOZA)', '971', '18900', '16', '6636501', '76656,13704', 1, 'D', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(24, 'CALLE CASTO MENDEZ NUÑEZ, 16 (ZARAGOZA)', '971', '18900', '16', '6636501', '76656,13704', 1, 'D', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(25, 'CALLE CASTO MENDEZ NUÑEZ, 36 (ZARAGOZA)', '1038', '18900', '36', '6736202', '76721,13660', 1, 'D', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(26, 'CALLE CASTO MENDEZ NUÑEZ, 36 (ZARAGOZA)', '1038', '18900', '36', '6736202', '76721,13660', 1, 'D', 'MODIFICACION DE LICENCIA'),
(27, 'CALLE CASTO MENDEZ NUÑEZ, 38 (ZARAGOZA)', '1037', '18900', '38', '6736203', '76736,13656', 1, 'D', ''),
(28, 'CALLE SANTA CRUZ, 7 (ZARAGOZA)', '1474', '29340', '7', '6637905', '76697,13731', 1, 'D', 'Tiene local y sótano'),
(29, 'CALLE SANTA CRUZ, 11 (ZARAGOZA)', '1062', '29340', '11', '6738108', '76702,13757', 1, 'D', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(30, 'CALLE SANTA CRUZ, 13-15 (ZARAGOZA)', '1156', '29340', '13-15', '6738107', '76713,13769', 1, 'D', ''),
(31, 'CALLE CONTAMINA, 18 (ZARAGOZA)', '918', '8220', '18', '6538803', '76552,13822', 1, 'C', 'antes era \" KARMA\"'),
(32, 'CALLE FRANCISCO LOSCOS, 4 (ZARAGOZA)', '1105', '17260', '4', '6639111', '76584,13906', 1, 'C', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(33, 'CALLE MAESTRO LUNA, 5 (ZARAGOZA)', '907', '17480', '5', '6538303', '76530,13879', 1, 'C', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(34, 'CALLE MAESTRO LUNA, 10 (ZARAGOZA)', '927', '17480', '10', '6538914', '76555,13874', 1, 'C', 'LICENCIA EMBARGADA POR AGENCIA TRIBUTARIA EXPTE. 656910/05 y 680427/05'),
(35, 'CALLE MANIFESTACION, 5-7 (ZARAGOZA)', '931', '17980', '5-7', '6539301', '76506,14007', 1, 'C', 'AFORO 72 PERSONAS.\nDISPONE DE COCINA.'),
(36, 'CALLE MANIFESTACION, 13 (ZARAGOZA)', '19628', '17980', '13', '6639201', '76540,13979', 1, 'C', ''),
(37, 'CALLE MANIFESTACION, 15 (ZARAGOZA)', '1016', '17980', '15', '6639202', '76552,13972', 1, 'C', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(38, 'CALLE MANIFESTACION, 23 (ZARAGOZA)', '1017', '17980', '23', '6639205', '76577,13959', 1, 'C', ''),
(39, 'CALLE MANIFESTACION, 38 (ZARAGOZA)', '1013', '17980', '38', '6639102', '76600,13899', 1, 'C', 'TIENE OTRA ENTRADA POR LA CALLE SANTA ISABEL'),
(40, 'CALLE OLMO, 5-7 (ZARAGOZA)', '1180', '21140', '5-7', '6439810', '76428,13922', 1, 'C', 'DECLARAR LA CADUCUDAD DE LA LICENCIA'),
(41, 'CALLE OLMO, 9 (ZARAGOZA)', '870', '21140', '9', '6439809', '76439,13917', 1, 'C', ''),
(42, 'CALLE OLMO, 9 (ZARAGOZA)', '870', '21140', '9', '6439809', '76439,13917', 1, 'C', 'Modificado horario según Acuerdo Municipal 23-05-06'),
(43, 'CALLE SANTA CRUZ, 13-15 (ZARAGOZA)', '1156', '29340', '13-15', '6738107', '76713,13769', 1, 'D', 'AMPLIACION DE ACTIVIDAD DE BAR'),
(44, 'CALLE OLMO, 14 (ZARAGOZA)', '1162', '21140', '14', '6438417', '76442,13901', 1, 'C', 'La licencia urbanistica es una ampliación para equipo musical.'),
(45, 'CALLE SANTA CRUZ, 21 (ZARAGOZA)', '1065', '29340', '21', '6738105', '76733,13805', 1, 'D', ''),
(46, 'CALLE PRUDENCIO, 5 (ZARAGOZA)', '1181', '24340', '5', '6540106', '76521,14024', 1, 'C', 'Cambio de titularidad del Licencia de Apertura'),
(47, 'CALLE SANTA CRUZ, 21 (ZARAGOZA)', '1065', '29340', '21', '6738105', '76733,13805', 1, 'D', ''),
(48, 'CALLE PRUDENCIO, 7 (ZARAGOZA)', '944', '24340', '7', '6540105', '76527,14012', 1, 'C', 'ADMITIR NUEVOS PROYECTOS MATERIA INSONORIZACION ACÚSTICA'),
(49, 'CALLE PRUDENCIO, 18 (ZARAGOZA)', '1026', '24340', '18', '6639203', '76561,13966', 1, 'C', 'TIENE ENTRADA TAMBIEN POR LA C/ MANIFESTACION Nº 17');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `licencia`
--
ALTER TABLE `licencia`
  ADD PRIMARY KEY (`Expediente`),
  ADD KEY `LocalID` (`LocalID`);

--
-- Indices de la tabla `local`
--
ALTER TABLE `local`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID` (`ID`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `licencia`
--
ALTER TABLE `licencia`
  ADD CONSTRAINT `Licencia_ibfk_1` FOREIGN KEY (`LocalID`) REFERENCES `local` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
