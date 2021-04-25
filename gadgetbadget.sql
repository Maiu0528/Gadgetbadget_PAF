-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 08:35 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gadgetbadget`
--

-- --------------------------------------------------------

--
-- Table structure for table `buyer`
--

CREATE TABLE `buyer` (
  `id` int(11) NOT NULL,
  `buyer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buyer`
--

INSERT INTO `buyer` (`id`, `buyer_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `method` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL,
  `amount` double NOT NULL,
  `date` date NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payment_id`, `user_id`, `method`, `status`, `amount`, `date`, `description`) VALUES
(1, 10, 'have to pay', '1', 200, '2021-04-21', 'good '),
(2, 2, 'dsasd', 'dsasd', 27, '2021-04-13', 'sdfgasdf'),
(6, 2, 'cash2', '1', 2700, '2021-04-13', 'bad'),
(7, 3, '2', '6', 200, '2021-04-13', 'goooddd'),
(8, 3, '2', '9', 300, '2021-04-13', ' very goooddd'),
(9, 3, 'paid', '9', 300, '2021-04-13', ' very goooddd'),
(12, 7, '2', '1', 100, '2021-04-13', 'verygoodd'),
(14, 5, 'paid', '1', 700, '2021-04-13', 'sad '),
(15, 5, 'paid', '1', 700, '2021-04-13', 'saddddlifeee '),
(18, 2, 'paid', '1', 700, '2021-04-13', 'miuu '),
(19, 7, 'paid', '9', 800, '2021-09-13', 'yabiiii '),
(28, 7, 'paid', '9', 28000, '2021-09-13', 'nothing ');

-- --------------------------------------------------------

--
-- Table structure for table `payment_buyer`
--

CREATE TABLE `payment_buyer` (
  `payment_card_id` int(11) NOT NULL,
  `credit_card_no` varchar(25) NOT NULL,
  `card_type` varchar(30) NOT NULL,
  `buyer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `first_name` varchar(150) NOT NULL,
  `last_name` varchar(150) NOT NULL,
  `date_of_birth` date NOT NULL,
  `address` varchar(250) NOT NULL,
  `telephone_no` varchar(10) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `user_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `date_of_birth`, `address`, `telephone_no`, `username`, `password`, `email`, `user_type`) VALUES
(1, 'Joseph', 'Mathew', '1985-10-01', 'No 111,\r\nFirst Chapel Lane,\r\nColombia', '0123456789', 'joseph_mathew', '123', 'joseph_mathew@hotmail.com', 'buyer'),
(2, 'Ahamed', 'Satheej', '1996-08-16', '123', '0123456787', 'satheej619', '123', 'satheej619@gamil.com', 'researcher');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buyer`
--
ALTER TABLE `buyer`
  ADD PRIMARY KEY (`id`,`buyer_id`),
  ADD KEY `fk_buyer_user_id` (`buyer_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`,`user_id`),
  ADD KEY `fk_user_id` (`user_id`);

--
-- Indexes for table `payment_buyer`
--
ALTER TABLE `payment_buyer`
  ADD PRIMARY KEY (`payment_card_id`),
  ADD KEY `fk_buyer_payment` (`buyer_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`,`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buyer`
--
ALTER TABLE `buyer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `payment_buyer`
--
ALTER TABLE `payment_buyer`
  MODIFY `payment_card_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `buyer`
--
ALTER TABLE `buyer`
  ADD CONSTRAINT `fk_buyer_user_id` FOREIGN KEY (`buyer_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
