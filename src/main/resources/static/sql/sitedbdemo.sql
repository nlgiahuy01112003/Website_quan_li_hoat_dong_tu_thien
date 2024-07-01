-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 30, 2024 at 09:51 PM
-- Server version: 8.2.0
-- PHP Version: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sitedbdemo`
--

-- --------------------------------------------------------

--
-- Table structure for table `projet`
--

DROP TABLE IF EXISTS `projet`;
CREATE TABLE IF NOT EXISTS `projet` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` varchar(255) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  `created_by` bigint NOT NULL,
  `total_amount` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK66eb818odleuhy65go4twll01` (`created_by`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `projet`
--

INSERT INTO `projet` (`id`, `amount`, `content`, `created_on`, `photo_url`, `title`, `updated_on`, `created_by`, `total_amount`) VALUES
(1, '9043', 'Helping provide access to education for underprivileged children in Cambodia to secure a better future.', '2024-05-28 18:38:18.000000', 'asia-2929645_1920.webp', 'Supporting Education in Cambodia', '2024-05-28 18:39:19.000000', 7, '10000'),
(2, '4000', 'Providing humanitarian aid to support victims of conflict and crisis in Ukraine.', '2024-05-30 01:48:57.620103', 'ukraine.jpg', 'Emergency Relief in Ukraine', '2024-05-30 01:48:57.621102', 6, '8956'),
(3, '3950', 'Providing essential medical supplies and support to those in need in Palestine.', '2024-05-28 19:54:04.000000', 'palestine.webp', 'Medical Aid for Palestine', '2024-05-28 19:54:56.000000', 7, '4500'),
(4, '1000', 'Supporting reconstruction efforts and community development initiatives in Haiti.', '2024-05-30 01:50:21.760365', 'haiti.webp', 'Construction for Haiti', '2024-05-30 01:50:21.762330', 6, '2600'),
(10, '14000', 'Conflit armé complexe dans la région des Grands Lacs en Afrique centrale, incluant la République démocratique du Congo, le Rwanda et l\'Ouganda. Les combats ont provoqué des déplacements massifs de population, des violences sexuelles systématiques et la conscription forcée d\'enfants soldats.', '2024-05-30 21:43:38.265409', 'rdc-congo-e.jpg', ' Congo ', '2024-05-30 21:43:38.267410', 6, '20000'),
(11, '0', 'Massacre systématique des Tutsis et des Hutus modérés par le gouvernement hutu extrémiste. Les enfants ont été des victimes directes de la violence, et beaucoup sont devenus orphelins.', '2024-05-30 18:11:55.077480', 'rwanda.jpg', 'Génocide du Rwanda ', '2024-05-30 18:11:55.077480', 7, '50000'),
(12, '30000', 'Conflit civil complexe impliquant le gouvernement syrien, des groupes rebelles, des organisations terroristes et des interventions étrangères. Les enfants syriens sont gravement affectés par la guerre, avec des millions déplacés et des milliers recrutés comme enfants soldats.', '2024-05-30 18:12:42.674333', 'syrie.jpg', 'Guerre civile en Syrie ', '2024-05-30 18:12:42.674333', 18, '60000'),
(13, '1800', 'Description : Conflit entre le gouvernement yéménite et les rebelles Houthis, entraînant une crise humanitaire majeure. Les enfants souffrent de malnutrition aiguë, de maladies et de manque d\'accès à l\'éducation.', '2024-05-30 18:14:08.254184', '870x489_z5b1.jpg', 'Guerre civile au Yémen ', '2024-05-30 18:14:08.254184', 6, '4000'),
(14, '15000', 'Guerre civile au Darfour, impliquant le gouvernement soudanais et divers groupes rebelles. Les enfants sont victimes de violences, de déplacements forcés et de conscription comme enfants soldats.\r\n', '2024-05-30 18:15:31.668369', 'conflit-soudan.jpg', 'Conflit au Darfour, Soudan ', '2024-05-30 18:15:31.668369', 19, '20000'),
(15, '0', 'Conflit prolongé impliquant le gouvernement somalien, des milices locales et des groupes islamistes radicaux comme Al-Shabaab. Les enfants souffrent de malnutrition, de maladies et de recrutements forcés.', '2024-05-30 18:17:19.978346', 'somalieee.jpg', 'Guerre civile en Somalie ', '2024-05-30 18:17:19.978346', 19, '30000');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `username`) VALUES
(6, 'chuck@outlook.fr', '$2a$10$YeMCJnQV/fcNGs5lRoobBOWWyOkqBAVZVULGFL3TOR1tZ6MZ/uNt.', 'Chuck'),
(7, 'neil@outlook.fr', '$2a$10$x8dNFjlE87ZuEl9HWPyae.kRQSgU9Zgj3LxkSL.I9zFqIPoZLJBRy', 'Neil'),
(8, 'chaaaa@outlook.fr', '$2a$10$okCAP01Ihqf0R5j5M/6qDufMhoCzrziqcHA54N5JvIj3t3tWhApe2', 'Charlot'),
(9, '2040acdaee927@crosemont.qc.ca', '$2a$10$ix54ipXfRSkMtJUwJV6U..ThOAVE6fn.Y.f.ygs3TXY2eWdkQ.oOK', 'niceree'),
(10, 'john.doe@example.com', '$2a$10$l9WwI.kTJeDC5we.zYGMj.zxSjxvUf1yGYyzG/Iy5dYQzVs4iJmL2', 'john'),
(11, 'sonia@outlook.fr', '$2a$10$P8N7a8ytT.N8Xexgy.h36eXY2t.daVUx3XqyCATTKNmIacqyuBiVe', 'sonia'),
(12, '205aaa0927@gmail.com', '$2a$10$f5EbK82vVMHEV1zbtoeibeENXPq41fZD6RDJtLfPmjHMnu8S5ZmUq', 'mama'),
(13, '205092ssss7@crosemont.qc.ca', '$2a$10$CTx/8DDcz9lFKrI072yelOZE0FyNrpSBp4EVMsij3S/ONn/2BRSle', 'dada'),
(14, 'josssshn.doe@example.com', '$2a$10$U1nJC/I61CImz4vmyvuvVOhd10f7rMzmazUoMtojWQOrqvfKQdHwu', 'job'),
(15, '1aaaa23soleil@outlook.fr', '$2a$10$3o917BnpsrkPmIjSikDzRuxvjI30xH2qSX9vA.N20BEWhfBa0Hm7.', 'aaa'),
(16, '123ssasasoleil@outlook.fr', '$2a$10$.aRXFNhnnUNLPQLsb7ZJUOA5dny26J3ZmjIpvyee1gECt3kAJdnCK', 'sasa'),
(17, 'ryantharmbypillai04@outlook.com', '$2a$10$fWcsWERG3bl2SrKEa2bP3OEWc97i.pHLTM/r8wjUkv9v0fQmZ4gPe', 'rrrrr'),
(18, 'tedekeu@outlook.fr', '$2a$10$9GHsrSA7agZpusITu3p1SOiwT9e9hEqUCHcP51gLZfjOSc3K1ilrG', 'teddy'),
(19, 'karless@outlook.fr', '$2a$10$IxNsWNz6w8uTvHL0c/EnqORwtQ0LTU3QGSnG0dBnD/FP8YefGe73K', 'karless'),
(20, 'ilias@gmail.com', '$2a$10$gFsgCkLlABP8XrJ6WOhWO.oyLYAQ4Jw72xB1CdoKGwzeClnW1VEiO', 'ilias');

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(6, 1),
(7, 2),
(8, 2),
(9, 2),
(13, 1),
(16, 2),
(17, 2),
(18, 2),
(19, 2),
(20, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `FK66eb818odleuhy65go4twll01` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`);

--
-- Constraints for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
