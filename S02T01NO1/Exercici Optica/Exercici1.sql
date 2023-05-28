-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Proveedor` (
  `idProveedor` INT NOT NULL,
  `Nombre` VARCHAR(255) NOT NULL,
  `Direccion` VARCHAR(255) NOT NULL,
  `Ciudad` VARCHAR(255) NOT NULL,
  `Codigo Postal` INT NOT NULL,
  `Pais` VARCHAR(45) NOT NULL,
  `Telefono` INT NOT NULL,
  `Fax` INT NOT NULL,
  `NIF` INT NOT NULL,
  PRIMARY KEY (`idProveedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `idCliente` INT NOT NULL,
  `Nombre` VARCHAR(255) NOT NULL,
  `Direccion` VARCHAR(255) NOT NULL,
  `CodigoPostal` INT NOT NULL,
  `Telefono` INT NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `FechaRegistro` INT NOT NULL,
  `Cliente_idCliente` INT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `fk_Cliente_Cliente1_idx` (`Cliente_idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Cliente_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Empleado` (
  `idEmpleado` INT NOT NULL,
  `Nombre` VARCHAR(255) NULL,
  PRIMARY KEY (`idEmpleado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Gafas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Gafas` (
  `idGafas` INT NOT NULL,
  `Marca` VARCHAR(45) NULL,
  `Graduacion` INT NULL,
  `Montura` VARCHAR(45) NULL,
  `ColorMontura` VARCHAR(45) NULL,
  `ColorCristalIzquierdo` VARCHAR(45) NULL,
  `ColorCristalDerecho` VARCHAR(45) NULL,
  `Precio` FLOAT NULL,
  `Proveedor_idProveedor` INT NOT NULL,
  PRIMARY KEY (`idGafas`, `Proveedor_idProveedor`),
  INDEX `fk_Gafas_Proveedor1_idx` (`Proveedor_idProveedor` ASC) VISIBLE,
  CONSTRAINT `fk_Gafas_Proveedor1`
    FOREIGN KEY (`Proveedor_idProveedor`)
    REFERENCES `mydb`.`Proveedor` (`idProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Venta` (
  `idVenta` INT NOT NULL,
  `FechaCompra` DATE NULL,
  `Empleado_idEmpleado` INT NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  `Gafas_idGafas` INT NOT NULL,
  PRIMARY KEY (`idVenta`, `Empleado_idEmpleado`, `Cliente_idCliente`, `Gafas_idGafas`),
  INDEX `fk_Venta_Empleado1_idx` (`Empleado_idEmpleado` ASC) VISIBLE,
  INDEX `fk_Venta_Cliente1_idx` (`Cliente_idCliente` ASC) VISIBLE,
  INDEX `fk_Venta_Gafas1_idx` (`Gafas_idGafas` ASC) VISIBLE,
  CONSTRAINT `fk_Venta_Empleado1`
    FOREIGN KEY (`Empleado_idEmpleado`)
    REFERENCES `mydb`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Gafas1`
    FOREIGN KEY (`Gafas_idGafas`)
    REFERENCES `mydb`.`Gafas` (`idGafas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
