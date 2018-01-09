-- liquibase formatted sql
-- comment Hello World

-- changeset deepankar.sharma:PR-1-0
-- comment training data schema
CREATE TABLE `training_data_info` (
    `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `status` ENUM('ACTIVE', 'INACTIVE', 'PROCESSING', 'ERROR') NOT NULL DEFAULT 'ACTIVE',
    `info` VARCHAR(500) NULL,
    `when_created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `tlm` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
);

-- changeset deepankar.sharma:PR-1-1
-- comment training data schema
CREATE TABLE `training_data` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `info_id` INT(50) UNSIGNED NOT NULL,
  `perner` INT(10) UNSIGNED NOT NULL,
  `payperiod` INT(10) UNSIGNED NOT NULL,
  `wt01` DOUBLE NULL,
  `wt02` DOUBLE NULL,
  `wt03` DOUBLE NULL,
  `wt04` DOUBLE NULL,
  `wt05` DOUBLE NULL,
  `wt06` DOUBLE NULL,
  `wt07` DOUBLE NULL,
  `wt08` DOUBLE NULL,
  `wt09` DOUBLE NULL,
  `wt10` DOUBLE NULL,
  `wt11` DOUBLE NULL,
  `wt12` DOUBLE NULL,
  `wt13` DOUBLE NULL,
  `wt14` DOUBLE NULL,
  `wt15` DOUBLE NULL,
  `wt16` DOUBLE NULL,
  `wt17` DOUBLE NULL,
  `wt18` DOUBLE NULL,
  `wt19` DOUBLE NULL,
  `wt20` DOUBLE NULL,
  `wt21` DOUBLE NULL,
  `wt22` DOUBLE NULL,
  `wt23` DOUBLE NULL,
  `wt24` DOUBLE NULL,
  `wt25` DOUBLE NULL,
  `wt26` DOUBLE NULL,
  `wt27` DOUBLE NULL,
  `wt28` DOUBLE NULL,
  `wt29` DOUBLE NULL,
  `when_created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tlm` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_training_data_info_id`
  FOREIGN KEY (`info_id`)
  REFERENCES `training_data_info` (`id`)
);

-- changeset deepankar.sharma:PR-1-2
-- comment training data schema
CREATE TABLE `model` (
`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
`training_data_info_id` INT(10) UNSIGNED NOT NULL,
`name` VARCHAR(50) NOT NULL,
`type` ENUM('DT', 'RF') NOT NULL,
`status` ENUM('ACTIVE', 'INACTIVE') NOT NULL DEFAULT 'ACTIVE',
`file_location` VARCHAR(255) NULL,
`when_created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
`tlm` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
INDEX `fk_model_1_idx` (`training_data_info_id` ASC),
CONSTRAINT `fk_model_1`
  FOREIGN KEY (`training_data_info_id`)
  REFERENCES `training_data_info` (`id`));

-- changeset deepankar.sharma:PR-1-3
-- comment training data schema
CREATE TABLE `model_config` (
  `id` INT(10) UNSIGNED NOT NULL,
  `wt01coeff` DOUBLE NULL,
  `wt02coeff` DOUBLE NULL,
  `wt03coeff` DOUBLE NULL,
  `wt04coeff` DOUBLE NULL,
  `wt05coeff` DOUBLE NULL,
  `wt06coeff` DOUBLE NULL,
  `wt07coeff` DOUBLE NULL,
  `wt08coeff` DOUBLE NULL,
  `wt09coeff` DOUBLE NULL,
  `wt10coeff` DOUBLE NULL,
  `wt11coeff` DOUBLE NULL,
  `wt12coeff` DOUBLE NULL,
  `wt13coeff` DOUBLE NULL,
  `wt14coeff` DOUBLE NULL,
  `wt15coeff` DOUBLE NULL,
  `wt16coeff` DOUBLE NULL,
  `wt17coeff` DOUBLE NULL,
  `wt18coeff` DOUBLE NULL,
  `wt19coeff` DOUBLE NULL,
  `wt20coeff` DOUBLE NULL,
  `wt21coeff` DOUBLE NULL,
  `wt22coeff` DOUBLE NULL,
  `wt23coeff` DOUBLE NULL,
  `wt24coeff` DOUBLE NULL,
  `wt25coeff` DOUBLE NULL,
  `wt26coeff` DOUBLE NULL,
  `wt27coeff` DOUBLE NULL,
  `wt28coeff` DOUBLE NULL,
  `wt29coeff` DOUBLE NULL,
  `when_created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tlm` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
CONSTRAINT `fk_config_id`
FOREIGN KEY (`id`)
REFERENCES `model` (`id`));

-- changeset deepankar.sharma:PR-1-4
-- comment training data schema
CREATE TABLE `model_analysis` (
  `id` INT(10) UNSIGNED NOT NULL,
  `true_positive` VARCHAR(500) NULL,
  `false_negative` VARCHAR(500) NULL,
  `accuracy` VARCHAR(500) NULL,
  `score` VARCHAR(500) NULL,
  `location` VARCHAR(500) NULL,
  `when_created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tlm` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`),
CONSTRAINT `fk_analysis_id`
FOREIGN KEY (`id`)
REFERENCES `model` (`id`));

-- changeset deepankar.sharma:PR-1-5
-- comment Create API_KEY table
DROP TABLE IF EXISTS `api_key`;
CREATE TABLE `api_key` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `application_name` VARCHAR(50) NOT NULL,
  `api_key` VARCHAR(50) NOT NULL,
  `token_validity` INT(3) NOT NULL,
  `when_created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tlm` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `application_name_UNIQUE` (`application_name` ASC));

-- changeset deepankar.sharma:PR-1-6
-- comment insert the api key
INSERT INTO api_key (`application_name`, `api_key`, `token_validity`)
VALUES ("UI5 Client", "abcdefghijklmno", "30");

-- changeset deepankar.sharma:PR-1-7
-- comment insert the api key
INSERT INTO api_key (`application_name`, `api_key`, `token_validity`)
VALUES ("Predictive Training Service", "asdfghjklqwerty", "30");

