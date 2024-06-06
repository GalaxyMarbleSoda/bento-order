CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    order_items TEXT NOT NULL,
    total_amount INT NOT NULL
);

ALTER TABLE `web`.`orders` 
CHARACTER SET = utf8 , COLLATE = utf8_unicode_ci ,
ADD COLUMN `remark` VARCHAR(255) NULL AFTER `total_amount`,
ADD COLUMN `ip` VARCHAR(45) NULL AFTER `remark`,
CHANGE COLUMN `order_items` `order_items` TEXT NOT NULL ;

ALTER TABLE `web`.`orders` 
ADD COLUMN `time_stamp` DATETIME NULL DEFAULT CURRENT_TIMESTAMP AFTER `ip`;
