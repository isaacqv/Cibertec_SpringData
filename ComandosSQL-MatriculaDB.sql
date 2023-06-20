CREATE SCHEMA `matricula` ;

CREATE TABLE `matricula`.`usuario` (
`usuario` VARCHAR(10) NOT NULL,
`clave` VARCHAR(10) NOT NULL,
`nomCompleto` VARCHAR(50) NOT NULL,
PRIMARY KEY (`usuario`),
UNIQUE INDEX `codigo_UNIQUE` (`usuario` ASC) VISIBLE);

INSERT INTO `matricula`.`usuario` (`usuario`, `clave`, `nomCompleto`) VALUES ('user', '12345', 'Usuario desde BD');
INSERT INTO `matricula`.`usuario` (`usuario`, `clave`, `nomCompleto`) VALUES ('yaddif', '654321', 'Yaddif Medina');
INSERT INTO `matricula`.`usuario` (`usuario`, `clave`, `nomCompleto`) VALUES ('carmen', 'll99ii', 'Carmen Rios');

ALTER TABLE `matricula`.`usuario` ADD COLUMN `foto` mediumblob NULL AFTER `nomCompleto`;


SELECT * FROM `matricula`.`usuario`;

/* --- 16/06/2023 --- */

CREATE TABLE `matricula`.`curso` (
                                     `idcurso` INT NOT NULL AUTO_INCREMENT,
                                     `nomcurso` VARCHAR(40) NOT NULL,
                                     `fechaInicio` DATE NULL,
                                     `alumnosMin` INT NOT NULL,
                                     `alumnosAct` INT NULL,
                                     `estado` INT NOT NULL,
                                     PRIMARY KEY (`idcurso`));

INSERT INTO `matricula`.`curso` (`nomcurso`,`fechaInicio`,`alumnosMin`,`alumnosAct`,`estado`)
VALUES ('Java Web', '2022-01-15', 10, 0, 0);
INSERT INTO `matricula`.`curso` (`nomcurso`,`fechaInicio`,`alumnosMin`,`alumnosAct`,`estado`)
VALUES ('Java Fundamentos', '2022-02-01', 10, 5, 1);
INSERT INTO `matricula`.`curso` (`nomcurso`,`fechaInicio`,`alumnosMin`,`alumnosAct`,`estado`)
VALUES ('Java Web Services', '2022-02-01', 10, 10, 2);
INSERT INTO `matricula`.`curso` (`nomcurso`,`fechaInicio`,`alumnosMin`,`alumnosAct`,`estado`)
VALUES ('PHP básico', '2022-01-15', 8, 0, 0);
INSERT INTO `matricula`.`curso` (`nomcurso`,`fechaInicio`,`alumnosMin`,`alumnosAct`,`estado`)
VALUES ('PHP avanzado', '2022-01-15', 5, 3, 1);
INSERT INTO `matricula`.`curso` (`nomcurso`,`fechaInicio`,`alumnosMin`,`alumnosAct`,`estado`)
VALUES ('MySQL administrador', '2022-01-22', 8, 0, 0);
INSERT INTO `matricula`.`curso` (`nomcurso`,`fechaInicio`,`alumnosMin`,`alumnosAct`,`estado`)
VALUES ('MySQL operativo', '2022-01-22', 10, 10, 2);
INSERT INTO `matricula`.`curso` (`nomcurso`,`fechaInicio`,`alumnosMin`,`alumnosAct`,`estado`)
VALUES ('Angular', '2022-02-15', 10, 0, 0);
INSERT INTO `matricula`.`curso` (`nomcurso`,`fechaInicio`,`alumnosMin`,`alumnosAct`,`estado`)
VALUES ('NodeJS', '2022-02-15', 10, 2, 1);
INSERT INTO `matricula`.`curso` (`nomcurso`,`fechaInicio`,`alumnosMin`,`alumnosAct`,`estado`)
VALUES ('NodeJS avanzado', '2022-02-10', 8, 1, 1);


USE `matricula`;
DROP procedure IF EXISTS `Curso_Por_Nombre`;
DELIMITER $$
USE `matricula`$$
CREATE PROCEDURE `Curso_Por_Nombre` (IN _nombre VARCHAR(50))
BEGIN
    SELECT * FROM curso WHERE nomCurso like CONCAT('%', _nombre , '%');
END$$
DELIMITER ;


SELECT * FROM `curso`;

/* --- 19/06/2023 --- */

CREATE TABLE `matricula`.`matricula` (
`idmatricula` INT NOT NULL AUTO_INCREMENT,
`fechaMat` DATE NOT NULL,
`usuario` VARCHAR(10) NOT NULL,
`idcurso` INT NOT NULL,
`estado` INT NULL COMMENT '0 - Inscrito\n1 - Pagado',
PRIMARY KEY (`idmatricula`),
INDEX `FK_Usuario_idx` (`usuario` ASC) VISIBLE,
INDEX `FK_curso_idx` (`idcurso` ASC) VISIBLE,
CONSTRAINT `FK_Usuario`
FOREIGN KEY (`usuario`)
REFERENCES `matricula`.`usuario` (`usuario`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `FK_curso`
FOREIGN KEY (`idcurso`)
REFERENCES `matricula`.`curso` (`idcurso`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);

CREATE TABLE `matricula`.`auditoria` (
`idauditoria` INT NOT NULL AUTO_INCREMENT,
`fechahora` DATETIME NOT NULL,
`usuario` VARCHAR(10) NOT NULL,
`operacion` VARCHAR(50) NOT NULL,
PRIMARY KEY (`idauditoria`),
INDEX `FK_usuario_auditoria_idx` (`usuario` ASC) VISIBLE,
CONSTRAINT `FK_usuario_auditoria`
FOREIGN KEY (`usuario`)
REFERENCES `matricula`.`usuario` (`usuario`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);

