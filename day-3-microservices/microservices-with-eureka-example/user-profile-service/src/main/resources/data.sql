CREATE TABLE user_profile (
    id                 BIGINT NOT NULL AUTO_INCREMENT,
    first_name         VARCHAR(100) NOT NULL,
    last_name          VARCHAR(100) NOT NULL,
    address            VARCHAR(100) DEFAULT NULL,
    library_card_id    VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

INSERT INTO user_profile (id, first_name, last_name, address, library_card_id) VALUES
(1, 'Mike', 'Smith', 'Cemetery Lane 23', '111-222'),
(2, 'Jane', 'Johnson', 'West 81st Street', '333-444'),
(3, 'Iggy', 'Pop', '742 Evergreen Terrace', '555-666');

ALTER TABLE user_profile ALTER COLUMN id RESTART WITH 4;