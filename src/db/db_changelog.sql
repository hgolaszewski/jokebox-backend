--liquibase formatted sql;

--changeset hubert:1

CREATE TABLE Category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL UNIQUE,
    requestparam VARCHAR(64) NOT NULL UNIQUE,
    address VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE Joke (
    id INT PRIMARY KEY AUTO_INCREMENT,
    category_id INT NOT NULL,
    content MEDIUMTEXT NOT NULL,
    CONSTRAINT FOREIGN KEY (category_id) REFERENCES Category(id)
);

--changeset hubert:2

INSERT INTO Category (id, name, requestparam, address) VALUES (1, 'Alkohol', 'alkohol', 'http://alkohol.dowcipy.pl');
INSERT INTO Category (id, name, requestparam, address) VALUES (2, 'Apteka', 'apteka', 'http://apteka.dowcipy.pl');
INSERT INTO Category (id, name, requestparam, address) VALUES (3, 'Baca', 'baca', 'http://o-bacy.dowcipy.pl');
INSERT INTO Category (id, name, requestparam, address) VALUES (4, 'Dresiarze', 'dresiarze', 'http://dresiarze.dowcipy.pl');
INSERT INTO Category (id, name, requestparam, address) VALUES (5, 'Kobiety', 'kobiety', 'http://kobiety.dowcipy.pl');
INSERT INTO Category (id, name, requestparam, address) VALUES (6, 'Mężczyźni', 'mezczyzni', 'http://mezczyzni.dowcipy.pl');
INSERT INTO Category (id, name, requestparam, address) VALUES (7, 'Putin', 'putin', 'http://putin.dowcipy.pl');
INSERT INTO Category (id, name, requestparam, address) VALUES (8, 'Jasiu', 'o-jasiu', 'http://o-jasiu.dowcipy.pl');

--changeset hubert:3

INSERT INTO Category (id, name, requestparam, address) VALUES (9, 'Dzieci', 'dzieci', 'http://dzieci.dowcipy.pl');
INSERT INTO Category (id, name, requestparam, address) VALUES (10, 'Lotto', 'lotto', 'http://lotto.dowcipy.pl');
INSERT INTO Category (id, name, requestparam, address) VALUES (11, 'Zajączek', 'zajaczek', 'http://zajaczek.dowcipy.pl');
INSERT INTO Category (id, name, requestparam, address) VALUES (12, 'Chuck Norris', 'chuck', 'http://chuck-norris.dowcipy.pl');

--changeset hubert:4

INSERT INTO Category (id, name, requestparam, address) VALUES (13, 'Naukowcy', 'naukowcy', 'http://naukowcy.dowcipy.pl');
INSERT INTO Category (id, name, requestparam, address) VALUES (14, 'Puchatek', 'puchatek', 'http://kubus-puchatek.dowcipy.pl');
INSERT INTO Category (id, name, requestparam, address) VALUES (15, 'Stalin', 'stalin', 'http://stalin.dowcipy.pl');
INSERT INTO Category (id, name, requestparam, address) VALUES (16, 'Zoo', 'zoo', 'http://zoo.dowcipy.pl');