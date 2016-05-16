ALTER TABLE `reviewDB`.`project`
ADD COLUMN `number` VARCHAR(45) NULL COMMENT '' AFTER `user_id`,
ADD COLUMN `department` CHAR(32) NULL COMMENT '' AFTER `name`;
