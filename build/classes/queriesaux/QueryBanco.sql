-- MySQL Script generated by MySQL Workbench
-- Sun Nov 18 20:34:13 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ProjetoUSJT
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ProjetoUSJT
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ProjetoUSJT` DEFAULT CHARACTER SET utf8 ;
USE `ProjetoUSJT` ;

-- -----------------------------------------------------
-- Table `ProjetoUSJT`.`Empregados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjetoUSJT`.`Empregados` (
  `idEmpregados` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL,
  `Cpf` VARCHAR(45) NULL,
  `Rg` VARCHAR(45) NULL,
  `DataNascimento` DATE NULL,
  `Cargo` VARCHAR(45) NULL,
  PRIMARY KEY (`idEmpregados`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoUSJT`.`PrestacaoConta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjetoUSJT`.`PrestacaoConta` (
  `idSolictPrestacaoConta` INT NOT NULL AUTO_INCREMENT,
  `MesRef` VARCHAR(45) NULL,
  `CartaoC` VARCHAR(45) NULL,
  `Despesas` VARCHAR(45) NULL,
  `Descricao` VARCHAR(45) NULL,
  `Adiantamento` VARCHAR(45) NULL,
  `ValorPrest` VARCHAR(45) NULL,
  `Empregados_idEmpregados` INT NOT NULL,
  PRIMARY KEY (`idSolictPrestacaoConta`),
  CONSTRAINT `fk_PrestacaoConta_Empregados1`
    FOREIGN KEY (`Empregados_idEmpregados`)
    REFERENCES `ProjetoUSJT`.`Empregados` (`idEmpregados`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoUSJT`.`Reembolso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjetoUSJT`.`Reembolso` (
  `idReembolso` INT NOT NULL AUTO_INCREMENT,
  `MesRef` VARCHAR(45) NULL,
  `ValorRembolso` VARCHAR(45) NULL,
  `Descricao` VARCHAR(45) NULL,
  `Empregados_idEmpregados` INT NOT NULL,
  PRIMARY KEY (`idReembolso`),
  CONSTRAINT `fk_Reembolso_Empregados1`
    FOREIGN KEY (`Empregados_idEmpregados`)
    REFERENCES `ProjetoUSJT`.`Empregados` (`idEmpregados`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoUSJT`.`DepartamentoContasPagar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjetoUSJT`.`DepartamentoContasPagar` (
  `idDepartamentoContaPagar` INT NOT NULL AUTO_INCREMENT,
  `PrestacaoConta_idSolictPrestacaoConta` INT NULL,
  `Reembolso_idReembolso` INT NULL,
  PRIMARY KEY (`idDepartamentoContaPagar`),
  CONSTRAINT `fk_DepartamentoContasPagar_PrestacaoConta1`
    FOREIGN KEY (`PrestacaoConta_idSolictPrestacaoConta`)
    REFERENCES `ProjetoUSJT`.`PrestacaoConta` (`idSolictPrestacaoConta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DepartamentoContasPagar_Reembolso1`
    FOREIGN KEY (`Reembolso_idReembolso`)
    REFERENCES `ProjetoUSJT`.`Reembolso` (`idReembolso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoUSJT`.`ChefeImediato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjetoUSJT`.`ChefeImediato` (
  `idChefeImediato` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idChefeImediato`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProjetoUSJT`.`StatusPedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProjetoUSJT`.`StatusPedido` (
  `idStatusPedido` INT NOT NULL AUTO_INCREMENT,
  `Resultado` VARCHAR(45) NULL,
  `Date` DATETIME NULL DEFAULT NOW(),
  `Empregados_idEmpregados` INT NOT NULL,
  `ChefeImediato_idChefeImediato` INT NOT NULL,
  `DepartamentoContasPagar_idDepartamentoContaPagar` INT NOT NULL,
  PRIMARY KEY (`idStatusPedido`),
  CONSTRAINT `fk_StatusPedido_Empregados1`
    FOREIGN KEY (`Empregados_idEmpregados`)
    REFERENCES `ProjetoUSJT`.`Empregados` (`idEmpregados`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_StatusPedido_ChefeImediato1`
    FOREIGN KEY (`ChefeImediato_idChefeImediato`)
    REFERENCES `ProjetoUSJT`.`ChefeImediato` (`idChefeImediato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_StatusPedido_DepartamentoContasPagar1`
    FOREIGN KEY (`DepartamentoContasPagar_idDepartamentoContaPagar`)
    REFERENCES `ProjetoUSJT`.`DepartamentoContasPagar` (`idDepartamentoContaPagar`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
