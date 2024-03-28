CREATE TABLE books (
    id             BIGINT       NOT NULL AUTO_INCREMENT,
    title          VARCHAR(100) NOT NULL,
    year_published INTEGER      NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO books (id, title, year_published) VALUES 
(1, 'Orlovi rano lete', 1957),
(2, 'Emil i detektivi', 1929),
(3, 'A song of Ice and Fire', 1996);

CREATE TABLE users (
    id         BIGINT      NOT NULL AUTO_INCREMENT,
    username   VARCHAR(30) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_roles (
    id      BIGINT      NOT NULL AUTO_INCREMENT,
    user_id BIGINT      NOT NULL,
    `role`  VARCHAR(10) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_user_roles_user FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO users (id, username, `password`) VALUES (1, 'admin', '$2a$10$wY6FEvLulqE7i9Gs9Znb8.5Slnq66fLe8yK/4Z9podbqvCeQEvf/u');
INSERT INTO user_roles (id, user_id, `role`) VALUES (1, 1, 'ADMIN');