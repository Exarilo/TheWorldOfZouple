ALTER TABLE Joueur
	ADD CONSTRAINT Pk_Joueur PRIMARY KEY (IdJoueur),
	ADD CONSTRAINT Fk1_Joueur FOREIGN KEY (IdArmes) REFERENCES Armes (IdArmes),
	ADD CONSTRAINT Fk2_Joueur FOREIGN KEY (IdArmures) REFERENCES Armures (IdArmures);

ALTER TABLE Monstre
	ADD CONSTRAINT Pk_Monstre PRIMARY KEY (IdMonstre),
	ADD CONSTRAINT Fk1_Monstre FOREIGN KEY (IdArmes) REFERENCES Armes (IdArmes),
	ADD CONSTRAINT Fk2_Monstre FOREIGN KEY (IdArmures) REFERENCES Armures (IdArmures);