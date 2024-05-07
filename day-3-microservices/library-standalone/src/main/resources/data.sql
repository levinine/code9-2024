INSERT INTO book (id, title, year_published, hardcover) VALUES
(1, 'The Castle', 1926, true),
(2, 'Crime and Punishment', 1866, false),
(3, '1984', 1949, false),
(4, 'The Science of Living', 1930, true),
(5, 'The Fear of Freedom', 1956, false);

INSERT INTO book_loan (id, loaner, book_id, loan_date, return_date) VALUES
(1, 'John', 2, '2024-04-01', '2024-05-10'),
(2, 'Jack', 5, '2024-05-01', '2024-05-15'),
(3, 'Jane', 1, '2024-04-30', '2024-05-16'),
(4, 'Jill', 3, '2024-05-05', '2024-05-09');
