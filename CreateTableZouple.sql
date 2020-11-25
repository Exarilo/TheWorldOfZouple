DROP  DATABASE IF EXISTS Zouple;
CREATE DATABASE Zouple;
USE Zouple;

CREATE TABLE Joueur 
(
	IdJoueur int (1),
	NomJ varchar(15),
	Niveau int (2),
	BasePV int (4),
	IdArmes int (2),
	IdArmures int (2)
)
ENGINE=INNODB;

CREATE TABLE Armes
(
	IdArmes int (2),
	Libelle varchar(60),
	Degats int (3)
)
ENGINE=INNODB;

CREATE TABLE Armures
(
	IdArmures int  (2),
	NomA varchar (60),
	Protection int (2)
)
ENGINE=INNODB;

CREATE TABLE Monstre
(
	IdMonstre int (2),
	NomM varchar (50), 
	BasePV int (4),
	IdArmures int (2),
	IdArmes int (2)
 )
ENGINE=INNODB;
