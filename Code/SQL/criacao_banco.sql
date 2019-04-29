-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema codex
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema codex
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `codex` DEFAULT CHARACTER SET utf8 ;
USE `codex` ;

-- -----------------------------------------------------
-- Table `codex`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `codex`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome_r_s` VARCHAR(150) NOT NULL,
  `telefone` VARCHAR(15) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `codex`.`pessoa_fisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `codex`.`pessoa_fisica` (
  `cliente_id` INT NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`cliente_id`),
  INDEX `fk_pessoa_fisica_cliente1_idx` (`cliente_id` ASC) ,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) ,
  CONSTRAINT `fk_pessoa_fisica_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `codex`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `codex`.`pessoa_juridica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `codex`.`pessoa_juridica` (
  `cliente_id` INT NOT NULL,
  `nome_fantasia` VARCHAR(80) NOT NULL,
  `cnpj` VARCHAR(25) NOT NULL,
  `fornecedor` INT NULL,
  PRIMARY KEY (`cliente_id`),
  INDEX `fk_pessoa_juridica_cliente_idx` (`cliente_id` ASC) ,
  UNIQUE INDEX `cnpj_UNIQUE` (`cnpj` ASC) ,
  CONSTRAINT `fk_pessoa_juridica_cliente`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `codex`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `codex`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `codex`.`endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rua` VARCHAR(30) NOT NULL,
  `numero` INT NOT NULL,
  `complemento` VARCHAR(30) NULL,
  `cep` VARCHAR(9) NOT NULL,
  `bairro` VARCHAR(45) NULL,
  `estado` VARCHAR(2) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NULL,
  `observacao` VARCHAR(45) NULL,
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`, `cliente_id`),
  INDEX `fk_endereco_cliente1_idx` (`cliente_id` ASC) ,
  CONSTRAINT `fk_endereco_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `codex`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `codex`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `codex`.`produto` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `quantidade` INT NULL,
  `data_entrada` DATETIME NULL,
  `data_saida` DATETIME NULL,
  `valor` DOUBLE NULL,
  `custo` DOUBLE NULL,
  `descricao` VARCHAR(100) NULL,
  `qtd_minimo` INT NULL,
  `pessoa_juridica_id` INT NOT NULL,
  `pessoa_juridica_cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`, `pessoa_juridica_id`, `pessoa_juridica_cliente_id`),
  INDEX `fk_produto_pessoa_juridica1_idx` (`pessoa_juridica_id` ASC, `pessoa_juridica_cliente_id` ASC) ,
  CONSTRAINT `fk_produto_pessoa_juridica1`
    FOREIGN KEY (`pessoa_juridica_cliente_id`)
    REFERENCES `codex`.`pessoa_juridica` (`cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
