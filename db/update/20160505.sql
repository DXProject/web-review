ALTER TABLE `reviewDB`.`base_constant`
ADD COLUMN `type` TINYINT(1) NULL COMMENT '' AFTER `remark`;

ALTER TABLE `reviewDB`.`comment`
CHANGE COLUMN `class` `rank` VARCHAR(45) NULL DEFAULT NULL COMMENT '' ;

ALTER TABLE `reviewDB`.`rules`
ADD COLUMN `type` TINYINT(1) NULL COMMENT '' AFTER `name`;

ALTER TABLE `reviewDB`.`announcement`
ADD COLUMN `type` TINYINT(1) NULL COMMENT '' AFTER `end_time`,
ADD COLUMN `status` TINYINT(4) NULL COMMENT '' AFTER `type`;