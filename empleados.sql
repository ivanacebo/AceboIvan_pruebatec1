-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-03-2024 a las 09:11:37
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empleados`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `ID` int(11) NOT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `BORRADO` tinyint(1) DEFAULT 0,
  `CARGO` varchar(255) DEFAULT NULL,
  `FECHAINICIO` date DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `SALARIO` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`ID`, `APELLIDO`, `BORRADO`, `CARGO`, `FECHAINICIO`, `NOMBRE`, `SALARIO`) VALUES
(1, 'Acebo', 0, 'Administrador', '1993-09-27', 'Ivan', 3251),
(2, 'Gómez', 0, 'Gerente', '1995-08-25', 'Laura', 3800),
(3, 'Rodríguez', 1, 'Analista', '2000-11-12', 'Carlos', 3200),
(4, 'Hernández', 0, 'Desarrollador', '2005-06-30', 'Sofía', 3100),
(5, 'Fernández', 0, 'Diseñador', '2010-09-18', 'Javier', 2700),
(6, 'Díaz', 1, 'Analista', '2015-12-04', 'Elena', 3300),
(7, 'Pérez', 0, 'Desarrollador', '2019-03-22', 'Alejandro', 2900),
(8, 'García', 0, 'Gerente', '2002-04-17', 'Carmen', 4000),
(9, 'Martínez', 0, 'Desarrollador', '2008-07-08', 'Diego', 2800),
(10, 'López', 0, 'Analista', '2012-10-29', 'Patricia', 3100),
(11, 'Sánchez', 0, 'Diseñador', '2017-01-14', 'Marcos', 2600),
(12, 'Gómez', 1, 'Desarrollador', '2020-05-03', 'Lucía', 2950),
(13, 'Acebo', 1, 'Administrador', '1993-12-27', 'Ivan', 2500),
(14, 'Hernández', 0, 'Analista', '2008-07-22', 'Laura', 2700),
(15, 'Ruiz', 0, 'Desarrollador', '2005-09-14', 'Carlos', 3100),
(16, 'Gómez', 0, 'Analista', '2007-12-30', 'Sofía', 2900),
(17, 'Fernández', 1, 'Diseñador', '2010-03-18', 'David', 2600),
(18, 'Pérez', 0, 'Desarrollador', '2006-11-05', 'Marta', 3200),
(19, 'García', 0, 'Analista', '2009-05-09', 'Daniel', 2800),
(20, 'Martínez', 0, 'Desarrollador', '2012-08-11', 'Elena', 3250),
(21, 'López', 1, 'Analista', '2011-02-27', 'Javier', 3000),
(22, 'Sánchez', 0, 'Desarrollador', '2013-06-03', 'Paula', 3100),
(23, 'Rodríguez', 1, 'Analista', '2014-09-19', 'Alejandro', 2900),
(24, 'Gonzalez', 0, 'Desarrollador', '2007-12-30', 'Jacobo', 2850),
(25, 'González', 0, 'Desarrollador', '1998-06-18', 'Ángel', 3650),
(26, 'González', 0, 'Desarrollador', '1999-09-15', 'Rosarua', 3750);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
