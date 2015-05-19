-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2015 at 11:25 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bigearth`
--

-- --------------------------------------------------------

--
-- Table structure for table `input`
--

CREATE TABLE IF NOT EXISTS `input` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `task_id` int(10) unsigned NOT NULL,
  `file_name` text COLLATE utf8_bin NOT NULL,
  `is_available` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `task_id` (`task_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=2 ;

--
-- Dumping data for table `input`
--

INSERT INTO `input` (`id`, `task_id`, `file_name`, `is_available`) VALUES
(1, 456, 'poooooo', 0);

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE IF NOT EXISTS `task` (
  `id` int(10) unsigned NOT NULL,
  `workflow_id` int(10) unsigned NOT NULL,
  `vm_id` int(10) unsigned DEFAULT NULL,
  `command_line` text COLLATE utf8_bin NOT NULL,
  `status` set('waiting','running','error','completed') COLLATE utf8_bin NOT NULL DEFAULT 'waiting',
  `same_vm_as` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_2` (`id`),
  KEY `id` (`id`),
  KEY `workflow_id` (`workflow_id`),
  KEY `id_3` (`id`),
  KEY `id_4` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`id`, `workflow_id`, `vm_id`, `command_line`, `status`, `same_vm_as`) VALUES
(456, 28, NULL, 'oooo3oo', 'running', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `workflow`
--

CREATE TABLE IF NOT EXISTS `workflow` (
  `wid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin NOT NULL,
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` set('running','error','completed') COLLATE utf8_bin NOT NULL DEFAULT 'running',
  PRIMARY KEY (`wid`),
  UNIQUE KEY `title` (`title`),
  KEY `wid` (`wid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=33 ;

--
-- Dumping data for table `workflow`
--

INSERT INTO `workflow` (`wid`, `user_id`, `title`, `start_time`, `status`) VALUES
(20, NULL, 'pppp211', '2015-05-08 21:00:00', 'running'),
(21, NULL, 'pppp132', '2015-05-08 21:00:00', 'running'),
(23, NULL, 'pppp139', '2015-05-08 21:00:00', 'running'),
(28, NULL, 'pppp2112332', '2015-05-13 21:00:00', 'running');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `input`
--
ALTER TABLE `input`
  ADD CONSTRAINT `input_ibfk_1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `task_ibfk_1` FOREIGN KEY (`workflow_id`) REFERENCES `workflow` (`wid`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
