-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ShopDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ShopDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ShopDB` DEFAULT CHARACTER SET utf8 ;
USE `ShopDB` ;

-- -----------------------------------------------------
-- Table `ShopDB`.`prodtbl`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ShopDB`.`prodtbl` (
  `prodName` CHAR(10) NOT NULL,
  `groupName` CHAR(10) NOT NULL,
  `price` INT NOT NULL,
  `save` SMALLINT NOT NULL,
  PRIMARY KEY (`prodName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ShopDB`.`usertbl`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ShopDB`.`usertbl` (
  `userid` CHAR(8) NOT NULL,
  `name` VARCHAR(16) NOT NULL,
  `birthYear` INT NOT NULL,
  `addr` VARCHAR(4) NOT NULL,
  `mobile1` CHAR(3) NOT NULL,
  `mobile2` CHAR(8) NOT NULL,
  `mDate` DATE NOT NULL,
  `usertblcol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ShopDB`.`ordertbl`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ShopDB`.`ordertbl` (
  `name` INT NOT NULL,
  `prodtbl_prodName` CHAR(10) NOT NULL,
  `usertbl_userid` CHAR(8) NOT NULL,
  `groupName` CHAR(10) NOT NULL,
  `orderAmount` INT NOT NULL,
  `price` SMALLINT NOT NULL,
  `orderDate` DATETIME NOT NULL,
  PRIMARY KEY (`name`),
  INDEX `fk_prodtbl_has_usertbl_usertbl1_idx` (`usertbl_userid` ASC) VISIBLE,
  INDEX `fk_prodtbl_has_usertbl_prodtbl_idx` (`prodtbl_prodName` ASC) VISIBLE,
  CONSTRAINT `fk_prodtbl_has_usertbl_prodtbl`
    FOREIGN KEY (`prodtbl_prodName`)
    REFERENCES `ShopDB`.`prodtbl` (`prodName`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_prodtbl_has_usertbl_usertbl1`
    FOREIGN KEY (`usertbl_userid`)
    REFERENCES `ShopDB`.`usertbl` (`userid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
