INSERT INTO book (id, name, year_published) VALUES
(1, 'The Castle', 1926),
(2, 'Crime and Punishment', 1866),
(3, '1984', 1949),
(4, 'The Science of Living', 1930),
(5, 'The Fear of Freedom', 1956);


INSERT INTO book_loan (id, book_id, library_card_id, reserve_date, due_date, return_date) VALUES
(1, 2, '333-444', '2024-04-02', '2024-06-02', '2024-05-02'),
(2, 4, '111-222', '2024-04-12', '2024-06-12', '2024-05-04'),
(3, 1, '555-666', '2024-04-25', '2024-06-25', '2024-05-07'),
(4, 5, '555-666', '2024-05-01', '2024-07-01', null),
(5, 4, '333-444', '2024-05-11', '2024-07-11', null),
(6, 3, '111-222', '2024-05-12', '2024-07-12', null),
(7, 2, '111-222', '2024-05-12', '2024-07-12', null);
