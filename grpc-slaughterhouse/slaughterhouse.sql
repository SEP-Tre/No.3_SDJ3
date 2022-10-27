DROP SCHEMA IF EXISTS slaughterhouse CASCADE ;
CREATE SCHEMA IF NOT EXISTS slaughterhouse;
SET SCHEMA 'slaughterhouse';

CREATE TABLE IF NOT EXISTS part
(
    part_id   SERIAL PRIMARY KEY,
    animal_id int,
    part_name char(40),
    weight    float
);

CREATE TABLE IF NOT EXISTS tray
(
    tray_id         int,
    part_id         int,
    part_name       char(32),
    weight_capacity float,

    PRIMARY KEY (tray_id, part_id),
    FOREIGN KEY (part_id) REFERENCES part (part_id)
);

CREATE TABLE IF NOT EXISTS product
(
    product_id SERIAL PRIMARY KEY,
    tray_id    int,
    type       char(50)
);

CREATE VIEW product_trace AS
SELECT product_id,
       type,
       product.tray_id,
       t.part_name,
       t.part_id,
       p.animal_id,
       p.weight

       FROM product
INNER JOIN tray t ON product.tray_id = t.tray_id
INNER JOIN part p ON p.part_id = t.part_id;


INSERT INTO part (animal_id, part_name, weight)
VALUES (1, 'leg', 1.5),
       (1, 'shank', 3.1),
       (1, 'ribs', 4.3),
       (2, 'ribeye', 0.7),
       (2, 't-bone', 2.4),
       (2, 'shank', 2.1),
       (3, 'ribs', 2.2),
       (3, 'ribeye', 1.5),
       (3, 'leg', 4.2);

INSERT INTO tray (tray_id, part_id, part_name, weight_capacity)
VALUES (0, 1, 'leg', 50),
       (0, 9, 'leg', 50),
       (1, 2, 'shank', 50),
       (1, 6, 'shank', 50),
       (2, 3, 'ribs', 60),
       (2, 7, 'ribs', 60),
       (3, 4, 'ribeye', 75),
       (3, 8, 'ribeye', 75);

INSERT INTO product (tray_id, type)
VALUES (0, 'tasty leg'),
       (0, 'tzaziki leg dip'),
       (1, 'slow roasted shank'),
       (1, 'bbq marinated shank'),
       (2, 'south carolina style ribs'),
       (2, 'kansas city ribs'),
       (3, '5A ribeye'),
       (3, 'black angus ribeye');

SELECT *
FROM product_trace;

SELECT *
FROM product_trace
WHERE animal_id = 1;

SELECT *
FROM product_trace
WHERE product_id = 1;



