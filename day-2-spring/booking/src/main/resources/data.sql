CREATE TABLE property (
    id            BIGINT NOT NULL AUTO_INCREMENT,
    name          VARCHAR(100) NOT NULL,
    address       VARCHAR(100) NOT NULL,
    contact_phone VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO property (id, name, address, contact_phone) VALUES
(1, 'Paradise Hotel', 'Cemetery Lane 23', '111-222'),
(2, 'Golden Suites', 'West 81st Street', '333-444'),
(3, 'Oasis Suites', '742 Evergreen Terrace', '555-666');

ALTER TABLE property ALTER COLUMN id RESTART WITH 4;

CREATE TABLE room (
    id             BIGINT NOT NULL AUTO_INCREMENT,
    property_id    BIGINT NOT NULL,
    room_number    INT NOT NULL,
    price          DOUBLE   NOT NULL,
    status         VARCHAR(100) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (property_id) REFERENCES property(id)
);

INSERT INTO room (id, property_id, room_number, price, status) VALUES
(1, 1, 23, 100.00, 'AVAILABLE'),
(2, 2, 55, 200.00, 'AVAILABLE'),
(3, 1, 88, 100.00, 'AVAILABLE');

ALTER TABLE room ALTER COLUMN id RESTART WITH 4;