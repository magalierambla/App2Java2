-- -----------------------------------------------------
-- Table mydb.profile
-- -----------------------------------------------------
DROP TABLE IF EXISTS profile ;

CREATE TABLE IF NOT EXISTS profile (
  id INT NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NULL,
  description VARCHAR(45) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table mydb.user
-- -----------------------------------------------------
DROP TABLE IF EXISTS user ;

CREATE TABLE IF NOT EXISTS user (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nom VARCHAR(100) NULL,
  prenom VARCHAR(45) NULL,
  login VARCHAR(100),
  created_date DATETIME NULL,
  last_modified_date DATETIME NULL,
  pseudo VARCHAR(45) NULL,
  sexe VARCHAR(45) NULL,
  type_compte VARCHAR(45) NULL,
  photo VARCHAR(45) NULL,
  password VARCHAR(100),
  date_naissance VARCHAR(45) NULL,
  profile_id INT,
  CONSTRAINT fk_profile_in_user FOREIGN KEY (profile_id) REFERENCES profile (id),
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table mydb.porte_project
-- -----------------------------------------------------
DROP TABLE IF EXISTS porte_project ;

CREATE TABLE IF NOT EXISTS porte_project (
  id INT NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table mydb.project_category
-- -----------------------------------------------------
DROP TABLE IF EXISTS project_category ;

CREATE TABLE IF NOT EXISTS project_category (
  id INT NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table mydb.project
-- -----------------------------------------------------
DROP TABLE IF EXISTS project ;

CREATE TABLE IF NOT EXISTS project (
  id INT NOT NULL AUTO_INCREMENT,
  created_date DATETIME NULL,
  last_modified_date DATETIME NULL,
  description TEXT(500) NULL,
  montant_minimum DECIMAL NULL,
  date_limite_collecte VARCHAR(45) NULL,
  contre_partie_project VARCHAR(45) NULL,
  affiche_project VARCHAR(45) NULL,
  valid_project VARCHAR(45) NULL,
  token VARCHAR(45) NULL,
  total_fonds VARCHAR(45) NULL,
  total_hearts VARCHAR(45) NULL,
  total_like VARCHAR(45) NULL,
  total_dislike VARCHAR(45) NULL,
  total_vues VARCHAR(45) NULL,
  statut_project VARCHAR(45) NULL,
  porte_project_id INT NULL,
  project_category_id INT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_project_porte_project
    FOREIGN KEY (porte_project_id)
    REFERENCES porte_project (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_project_project_category1
    FOREIGN KEY (project_category_id)
    REFERENCES project_category (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table mydb.user_project_favoris
-- -----------------------------------------------------
DROP TABLE IF EXISTS user_project_favoris ;

CREATE TABLE IF NOT EXISTS user_project_favoris (
  id INT NOT NULL AUTO_INCREMENT,
  created_date DATETIME NULL,
  last_modified_date DATETIME NULL,
  project_id INT NOT NULL,
  user_id INT NOT NULL,
  PRIMARY KEY (id, user_id),
  CONSTRAINT fk_user_project_favoris_project1
    FOREIGN KEY (project_id)
    REFERENCES project (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_user_project_favoris_user1
    FOREIGN KEY (user_id)
    REFERENCES user (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table mydb.commentaires
-- -----------------------------------------------------
DROP TABLE IF EXISTS commentaires ;

CREATE TABLE IF NOT EXISTS commentaires (
  id INT NOT NULL AUTO_INCREMENT,
  project_id INT NOT NULL,
  user_id INT NOT NULL,
  titre VARCHAR(45) NULL,
  description VARCHAR(45) NULL,
  photos VARCHAR(45) NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_commentaires_project1
    FOREIGN KEY (project_id)
    REFERENCES project (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_commentaires_user1
    FOREIGN KEY (user_id)
    REFERENCES user (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table mydb.hearts_project
-- -----------------------------------------------------
DROP TABLE IF EXISTS hearts_project ;

CREATE TABLE IF NOT EXISTS hearts_project (
  id INT NOT NULL AUTO_INCREMENT,
  project_id INT NOT NULL,
  user_id INT NOT NULL,
  PRIMARY KEY (id, project_id, user_id),
  CONSTRAINT fk_hearts_project_project1
    FOREIGN KEY (project_id)
    REFERENCES project (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_hearts_project_user1
    FOREIGN KEY (user_id)
    REFERENCES user (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table mydb.news_project
-- -----------------------------------------------------
DROP TABLE IF EXISTS news_project ;

CREATE TABLE IF NOT EXISTS news_project (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  project_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_news_project_user1
    FOREIGN KEY (user_id)
    REFERENCES user (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_news_project_project1
    FOREIGN KEY (project_id)
    REFERENCES project (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;
