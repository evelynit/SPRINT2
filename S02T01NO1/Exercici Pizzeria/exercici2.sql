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
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `idCliente` INT NOT NULL,
  `Nombre` VARCHAR(255) NOT NULL,
  `Apellidos` VARCHAR(255) NOT NULL,
  `Direccion` VARCHAR(255) NOT NULL,
  `CodigoPostal` VARCHAR(10) NOT NULL,
  `Localidad` VARCHAR(255) NOT NULL,
  `Provincia` VARCHAR(255) NOT NULL,
  `Telefono` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tienda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Tienda` (
  `idTienda` INT NOT NULL,
  `Direccion` VARCHAR(255) NOT NULL,
  `CodigoPostal` VARCHAR(10) NOT NULL,
  `Localidad` VARCHAR(255) NOT NULL,
  `Provincia` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idTienda`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Empleado` (
  `idEmpleado` INT NOT NULL,
  `Nomber` VARCHAR(255) NOT NULL,
  `Apellidos` VARCHAR(255) NOT NULL,
  `NIF` VARCHAR(10) NOT NULL,
  `Telefono` VARCHAR(20) NOT NULL,
  `Puesto` ENUM('Cocinero/a', 'Repartidor/A') NOT NULL,
  `Tienda_idTienda` INT NOT NULL,
  PRIMARY KEY (`idEmpleado`, `Tienda_idTienda`),
  INDEX `fk_Empleado_Tienda1_idx` (`Tienda_idTienda` ASC) VISIBLE,
  CONSTRAINT `fk_Empleado_Tienda1`
    FOREIGN KEY (`Tienda_idTienda`)
    REFERENCES `mydb`.`Tienda` (`idTienda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pedido` (
  `idPedido` INT NOT NULL,
  `FechaHora` DATETIME NOT NULL,
  `ModoEntrega` ENUM('Reparti a Domicilio', 'Recoger en tienda') NOT NULL,
  `PrecioTotal` DECIMAL(9,2) NOT NULL,
  `FechaHoraEntrega` DATETIME NULL,
  `Cliente_idCliente` INT NOT NULL,
  `Tienda_idTienda` INT NOT NULL,
  `Empleado_idEmpleado` INT NOT NULL,
  PRIMARY KEY (`idPedido`, `Cliente_idCliente`, `Tienda_idTienda`, `Empleado_idEmpleado`),
  INDEX `fk_Pedido_Cliente1_idx` (`Cliente_idCliente` ASC) VISIBLE,
  INDEX `fk_Pedido_Tienda1_idx` (`Tienda_idTienda` ASC) VISIBLE,
  INDEX `fk_Pedido_Empleado1_idx` (`Empleado_idEmpleado` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Tienda1`
    FOREIGN KEY (`Tienda_idTienda`)
    REFERENCES `mydb`.`Tienda` (`idTienda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Empleado1`
    FOREIGN KEY (`Empleado_idEmpleado`)
    REFERENCES `mydb`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Categoria` (
  `idCategoria` INT NOT NULL,
  `Nombre` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Producto` (
  `idProducto` INT NOT NULL,
  `Nombre` VARCHAR(255) NOT NULL,
  `Descripcion` TEXT NOT NULL,
  `Imagen` VARCHAR(255) NOT NULL,
  `Precio` DECIMAL(9,2) NOT NULL,
  `Categoria_idCategoria` INT NOT NULL,
  PRIMARY KEY (`idProducto`, `Categoria_idCategoria`),
  INDEX `fk_Producto_Categoria1_idx` (`Categoria_idCategoria` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES `mydb`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pedido_has_Producto1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pedido_has_Producto1` (
  `Pedido_idPedido` INT NOT NULL,
  `Producto_idProducto` INT NOT NULL,
  `Cantidad` INT NOT NULL,
  PRIMARY KEY (`Pedido_idPedido`, `Producto_idProducto`),
  INDEX `fk_Pedido_has_Producto1_Producto1_idx` (`Producto_idProducto` ASC) VISIBLE,
  INDEX `fk_Pedido_has_Producto1_Pedido_idx` (`Pedido_idPedido` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_has_Producto1_Pedido`
    FOREIGN KEY (`Pedido_idPedido`)
    REFERENCES `mydb`.`Pedido` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_has_Producto1_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `mydb`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
