-- Create Table language
CREATE TABLE language
(
    id   BIGINT          NOT NULL AUTO_INCREMENT,
    
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Create initial languages
INSERT INTO language (id, name)
VALUES (1, 'Polish'),
       (2, 'English'),
       (3, 'French');

-- Create Table translation
CREATE TABLE translation
(
    id          BIGINT          NOT NULL AUTO_INCREMENT,
    language_id BIGINT          NOT NULL,
    `key`       VARCHAR(255) NOT NULL,
    translation TEXT         NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_LANGUAGE__TRANSLATION FOREIGN KEY (language_id) REFERENCES language (id)
);

-- Create initial translations
INSERT INTO translation (id, language_id, `key`, translation)
VALUES (1, 1, 'hello', 'Cześć'),
       (2, 2, 'hello', 'Hello'),
       (3, 3, 'hello', 'Bonjour');

