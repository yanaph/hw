CREATE TABLE `customer` (
                            `login` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                            `firstName` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                            `lastName` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                            `dateOfBirth` DATE NULL DEFAULT NULL,
                            `country` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin1_swedish_ci',
                            `sex` ENUM('male','female') NOT NULL DEFAULT 'male' COLLATE 'latin1_swedish_ci'
)
    COMMENT='customers\' info'
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
