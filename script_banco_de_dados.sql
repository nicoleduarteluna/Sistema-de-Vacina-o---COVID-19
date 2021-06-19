CREATE DATABASE `projeto`;

CREATE TABLE `cidadao` (
  `cpf` varchar(14) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `dtNascimento` date DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `telefone` varchar(25) DEFAULT NULL,
  `endereco` varchar(170) DEFAULT NULL,
  `id_cidadao` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_cidadao`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `vacina` (
  `id_vacina` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `fabricante` varchar(75) DEFAULT NULL,
  `qtde_doses` int DEFAULT NULL,
  `intervalo_doses` int DEFAULT NULL,
  `validade` date DEFAULT NULL,
  `eficacia` int DEFAULT NULL,
  PRIMARY KEY (`id_vacina`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `carteira_vacinacao` (
  `id_carteira_vacinacao` int NOT NULL AUTO_INCREMENT,
  `id_cidadao` int NOT NULL,
  `id_vacina` int NOT NULL,
  `primeira_dose` date DEFAULT NULL,
  `segunda_dose` date DEFAULT NULL,
  PRIMARY KEY (`id_carteira_vacinacao`),
  UNIQUE KEY `id_cidadao_UNIQUE` (`id_cidadao`),
  KEY `fk_id_vacina` (`id_vacina`),
  KEY `fk_id_cidadao` (`id_cidadao`),
  CONSTRAINT `fk_id_cidadao` FOREIGN KEY (`id_cidadao`) REFERENCES `cidadao` (`id_cidadao`),
  CONSTRAINT `fk_id_vacina` FOREIGN KEY (`id_vacina`) REFERENCES `vacina` (`id_vacina`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



