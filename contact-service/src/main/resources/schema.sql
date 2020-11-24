DROP TABLE IF EXISTS repository;
DROP TABLE IF EXISTS Contact;

CREATE TABLE Contact
(
    id           INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name         VARCHAR(250) NOT NULL,
    phone_number VARCHAR(250) NOT NULL,
    email        VARCHAR(250) NOT NULL,
    organization VARCHAR(250) DEFAULT NULL,
    github       VARCHAR(250) DEFAULT NULL,
    UNIQUE(name),
    UNIQUE(email),
    UNIQUE(github)
);

CREATE TABLE repository
(
    id              INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    repository_name VARCHAR(250) DEFAULT NULL,
    FOREIGN KEY (id) REFERENCES Contact (id) ON DELETE CASCADE
);