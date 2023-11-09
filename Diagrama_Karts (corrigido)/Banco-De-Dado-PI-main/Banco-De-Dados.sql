DROP DATABASE IF EXISTS diagrama_karts;

CREATE DATABASE IF NOT EXISTS diagrama_karts;

USE diagrama_karts;

-- -----------------------------------------------------
-- Table `fornecedor`
-- -----------------------------------------------------
CREATE Table IF NOT EXISTS `fornecedor` (
  `cnpj` BIGINT(14) NOT NULL,
  `nome_empresa` VARCHAR(80) NOT NULL,
  `cep` BIGINT(8) NOT NULL,
  `telefone` BIGINT(13) NOT NULL,
  PRIMARY KEY (`cnpj`) 
);

-- -----------------------------------------------------
-- Table `karts`
-- -----------------------------------------------------
CREATE Table IF NOT EXISTS `karts` (
  `id_kart` INT NOT NULL AUTO_INCREMENT,
  `cor` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `ano` INT(4) NOT NULL,
  `quantidade` INT(3) NOT NULL,
  `data_entrada` DATE NOT NULL,
  `preco` FLOAT NOT NULL,
  `fornecedor_cnpj` BIGINT(14) NOT NULL,
  PRIMARY KEY (`id_kart`),
  CONSTRAINT `fk_karts_fornecedor` FOREIGN KEY (`fornecedor_cnpj`) REFERENCES `fornecedor` (`cnpj`) ON DELETE CASCADE
);

-- -----------------------------------------------------
-- Table `funcionarios`
-- -----------------------------------------------------
CREATE Table IF NOT EXISTS `funcionarios` (
  
  `cpf` BIGINT(11) NOT NULL PRIMARY KEY,
  `nome_completo` VARCHAR(80) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `cargo` VARCHAR(80) NOT NULL
);
-- -----------------------------------------------------
-- Table `clientes`
-- -----------------------------------------------------
CREATE Table IF NOT EXISTS `clientes` (

  `cpf` BIGINT(11) NOT NULL PRIMARY KEY,
  `nome_completo` VARCHAR(80) NOT NULL,
  `data_nascimento` DATETIME NOT NULL,
  `cnpj` BIGINT(14) NULL,
  `telefone` BIGINT(13) NOT NULL

);
-- -----------------------------------------------------
-- Table `vendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendas` (
  `venda_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `valor_total` FLOAT NOT NULL,
  `data_venda` DATE NOT NULL ,
  `funcionarios_cpf` BIGINT(11) NOT NULL,
  `karts_id_kart` INT NOT NULL,
  CONSTRAINT `fk_vendas_funcionarios1` FOREIGN KEY (`funcionarios_cpf`) REFERENCES `funcionarios` (`cpf`) ON DELETE CASCADE,
  CONSTRAINT `fk_vendas_karts1` FOREIGN KEY (`karts_id_kart`) REFERENCES `karts` (`id_kart`) ON DELETE CASCADE
);

-- Inserções na tabela fornecedor
INSERT INTO `fornecedor` (`cnpj`, `nome_empresa`, `cep`, `telefone`)
VALUES
  (12345678901234, 'Fornecedor A', 12345678, 9876543210),
  (23456789012345, 'Fornecedor B', 23456789, 8765432109),
  (34567890123456, 'Fornecedor C', 34567890, 7654321098),
  (45678901234567, 'Fornecedor D', 45678901, 6543210987),
  (56789012345678, 'Fornecedor E', 56789012, 5432109876),
  (67890123456789, 'Fornecedor F', 67890123, 4321098765),
  (78901234567890, 'Fornecedor G', 78901234, 3210987654);

-- Inserções na tabela karts
INSERT INTO `karts` (`id_kart`, `cor`, `modelo`, `marca`, `ano`, `quantidade`, `data_entrada`, `preco`, `fornecedor_cnpj`)
VALUES
  (1, 'Vermelho', 'Modelo A', 'Marca X', 2023, 5, '2023-09-28', 5000.00, 12345678901234),
  (2, 'Azul', 'Modelo B', 'Marca Y', 2022, 8, '2023-09-28', 5500.00, 23456789012345),
  (3, 'Verde', 'Modelo C', 'Marca Z', 2023, 3, '2023-09-28', 5200.00, 34567890123456),
  (4, 'Amarelo', 'Modelo D', 'Marca X', 2021, 6, '2023-09-28', 4800.00, 45678901234567),
  (5, 'Vermelho', 'Modelo E', 'Marca Y', 2022, 7, '2023-09-28', 5100.00, 56789012345678),
  (6, 'Azul', 'Modelo F', 'Marca Z', 2023, 4, '2023-09-28', 5400.00, 67890123456789),
  (7, 'Verde', 'Modelo G', 'Marca X', 2021, 5, '2023-09-28', 4900.00, 78901234567890);

-- Inserções na tabela funcionarios
INSERT INTO `funcionarios` (`cpf`, `nome_completo`, `data_nascimento`, `cargo`)
VALUES
  (12345678900, 'Funcionario 1', '1990-01-15', 'Gerente'),
  (23456789001, 'Funcionario 2', '1992-05-20', 'Vendedor'),
  (34567890102, 'Funcionario 3', '1985-11-10', 'Atendente'),
  (45678901203, 'Funcionario 4', '1994-08-05', 'Gerente'),
  (56789012304, 'Funcionario 5', '1988-03-25', 'Vendedor'),
  (22222222222, 'x', '1988-03-25', 'Vendedor');

-- Inserções na tabela clientes
INSERT INTO `clientes` ( `nome_completo`, `data_nascimento`, `cnpj`, `cpf`, `telefone`)
VALUES
  ( 'Cliente A', '1990-03-12', NULL, 12345678901, 9876543211),
  ( 'Cliente B', '1992-07-18', NULL, 23456789012, 8765432102),
  ( 'Cliente C', '1985-12-25', NULL, 34567890123, 7654321093),
  ( 'Cliente D', '1994-09-30', NULL, 45678901234, 6543210984);

-- Inserções na tabela vendas
INSERT INTO `vendas` ( `data_venda`, `funcionarios_cpf`, `valor_total`, `karts_id_kart`)
VALUES
  ( '2023-09-27', 12345678900, 5000.00, 1),
  ( '2023-09-28', 23456789001, 5500.00, 2),
  ('2023-09-29', 34567890102, 5200.00, 3),
  ( '2023-09-30', 45678901203,4800.00, 4);
