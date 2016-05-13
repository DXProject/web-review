CREATE TABLE `reviewDB`.`sequence_factory` (
  `sequence` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `type` VARCHAR(45) NULL COMMENT '当前用了的seq',
  PRIMARY KEY (`sequence`)  COMMENT '');

ALTER TABLE `reviewDB`.`rules`
ADD COLUMN `number` VARCHAR(45) NULL COMMENT '' AFTER `id`;

ALTER TABLE `reviewDB`.`announcement`
CHANGE COLUMN `backup_three` `number` VARCHAR(45) NULL DEFAULT NULL COMMENT '' AFTER `id`;

