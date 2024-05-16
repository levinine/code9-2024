-- admin / admin_pass
-- some_dude / dudes_pass
INSERT INTO users (id, username, password, user_role) VALUES
(1, 'admin', '$2a$10$PFh1HCPb1NBOSE.0GixysuLYH3QrJRYBa8QWkm/gU.BBi5ej0N48O', 'ADMIN'),
(2, 'some_dude', '$2a$10$YJu5y32s7P7KGeVkmLFmfuqbgrOIXEUhSRv9gfhwptmVpeuZDFLIm', 'USER');

INSERT INTO books (id, name, author, year_published) VALUES
(1, 'Orlovi rano lete', 'Branko Ćopić', 1957),
(2, 'Emil i detektivi', 'Erik Kastner', 1929),
(3, 'Igra prestola', 'Džordž R. R. Martin', 1996),
(4, 'Buđenje levijatana', 'Džejms S. A. Kori', 2011),
(5, 'Misliti u Javi', 'Brus Ekel', 1998);