INSERT INTO profile
VALUES (1, 'ADMIN', 'Administrateur application');

INSERT INTO user(id, nom, prenom)
VALUES (1, 'RAMBLA', 'Magalie');

INSERT INTO user(id, nom, prenom)
VALUES (2, 'DION', 'Céline');

INSERT INTO project_category
VALUES (1L, 'bio');

INSERT INTO project(nom, description, montant_minimum, date_limite_collecte, valid_project)
VALUES ('Commerce Bio', 'Boutique en ligne', 200.00, TO_DATE('01/01/2020', 'DD/MM/YYYY'), 'VALIDE');




