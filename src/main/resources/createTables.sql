/**
 * Author:  ralew
 * Created: 06.12.2020
 */

/*
 * Script for deleting tables from DB.
 */

DROP TABLE IF EXISTS `skynet_cd`.`material`;
DROP TABLE IF EXISTS `skynet_cd`.`report`;
DROP TABLE IF EXISTS `skynet_cd`.`task`;
DROP TABLE IF EXISTS `skynet_cd`.`user`;
DROP TABLE IF EXISTS `skynet_cd`.`position`;

/*
 * Script for created tables in DB.
 */

CREATE TABLE `skynet_cd`.`position` (
  `id_position` BIGINT NOT NULL AUTO_INCREMENT,
  `position_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_position`),
  UNIQUE INDEX `id_position_UNIQUE` (`id_position` ASC) VISIBLE);

CREATE TABLE `skynet_cd`.`user` (
  `id_user` BIGINT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `second_name` VARCHAR(45) NOT NULL,
  `patronymic` VARCHAR(45) NOT NULL,
  `id_position` BIGINT NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `id_users_UNIQUE` (`id_user` ASC) VISIBLE,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,
  INDEX `position_key_idx` (`id_position` ASC) VISIBLE,
  CONSTRAINT `position_key`
    FOREIGN KEY (`id_position`)
    REFERENCES `skynet_cd`.`position` (`id_position`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `skynet_cd`.`task` (
  `id_task` BIGINT NOT NULL AUTO_INCREMENT,
  `task_address` VARCHAR(255) NOT NULL,
  `id_user_executor_task` BIGINT NOT NULL,
  `id_user_creator_task` BIGINT NOT NULL,
  `task_status` VARCHAR(45) NOT NULL,
  `task_date` DATETIME NOT NULL,
  PRIMARY KEY (`id_task`),
  UNIQUE INDEX `id_task_UNIQUE` (`id_task` ASC) VISIBLE,
  INDEX `id_user_executor_idx` (`id_user_executor_task` ASC) VISIBLE,
  INDEX `id_user_creator_idx` (`id_user_creator_task` ASC) VISIBLE,
  CONSTRAINT `id_user_executor_key`
    FOREIGN KEY (`id_user_executor_task`)
    REFERENCES `skynet_cd`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_user_creator_key`
    FOREIGN KEY (`id_user_creator_task`)
    REFERENCES `skynet_cd`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `skynet_cd`.`material` (
  `id_material` BIGINT NOT NULL AUTO_INCREMENT,
  `material_name` VARCHAR(45) NOT NULL,
  `material_issued` INT NOT NULL,
  `material_received` INT NOT NULL,
  `id_task` BIGINT NOT NULL,
  PRIMARY KEY (`id_material`),
  UNIQUE INDEX `id_material_UNIQUE` (`id_material` ASC) VISIBLE,
  INDEX `id_task_key_idx` (`id_task` ASC) VISIBLE,
  CONSTRAINT `id_task_mat_key`
    FOREIGN KEY (`id_task`)
    REFERENCES `skynet_cd`.`task` (`id_task`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `skynet_cd`.`report` (
  `id_report` BIGINT NOT NULL AUTO_INCREMENT,
  `report_address` VARCHAR(255) NOT NULL,
  `report_date` DATETIME NOT NULL,
  `report_apartment_quantity` INT NULL DEFAULT NULL,
  `report_box_position` VARCHAR(255) NULL DEFAULT NULL,
  `report_point_energy` VARCHAR(255) NULL DEFAULT NULL,
  `report_note` VARCHAR(255) NULL DEFAULT NULL,
  `id_task` BIGINT NOT NULL,
  PRIMARY KEY (`id_report`),
  UNIQUE INDEX `id_report_UNIQUE` (`id_report` ASC) VISIBLE,
  INDEX `id_task_key_idx` (`id_task` ASC) VISIBLE,
  UNIQUE INDEX `id_task_UNIQUE` (`id_task` ASC) VISIBLE,
  CONSTRAINT `id_task_key`
    FOREIGN KEY (`id_task`)
    REFERENCES `skynet_cd`.`task` (`id_task`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



