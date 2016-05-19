ALTER TABLE `reviewDB`.`project`
ADD COLUMN `number` VARCHAR(45) NULL COMMENT '' AFTER `user_id`,
ADD COLUMN `department` CHAR(32) NULL COMMENT '' AFTER `name`;

ALTER TABLE `reviewDB`.`expert`
ADD COLUMN `discipline_category` CHAR(32) NULL COMMENT '' AFTER `email`;
