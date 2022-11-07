DROP SCHEMA IF EXISTS slaughterhouse CASCADE;
CREATE SCHEMA IF NOT EXISTS slaughterhouse;
SET SCHEMA 'slaughterhouse';


CREATE TABLE IF NOT EXISTS animal
(
    animal_id   SERIAL PRIMARY KEY,
    weight      float,
    animal_type varchar,
    is_converted bool
);
CREATE TABLE IF NOT EXISTS part
(
    part_id   SERIAL PRIMARY KEY,
    part_name char(40),
    weight    float,
    is_used      bool,
    animal_id int REFERENCES animal (animal_id)
);


CREATE TABLE IF NOT EXISTS tray
(
    tray_id         SERIAL PRIMARY KEY,
    weight_capacity float,
    part_name       char(40),
    is_used          bool
);

CREATE TABLE IF NOT EXISTS product
(
    product_id   SERIAL PRIMARY KEY,
    product_type char(50)
);


CREATE TABLE IF NOT EXISTS part_in_tray
(
    id SERIAL PRIMARY KEY ,
    part_id int,
    tray_id int,

    FOREIGN KEY (part_id)REFERENCES part(part_id),
    FOREIGN KEY (tray_id)REFERENCES tray(tray_id)
);

CREATE TABLE IF NOT EXISTS tray_in_product
(
    id SERIAL PRIMARY KEY,
    tray_id int,
    product_id int,

    FOREIGN KEY (tray_id) REFERENCES tray(tray_id),
    FOREIGN KEY (product_id)REFERENCES product(product_id)
);

/*

CREATE VIEW product_trace AS
SELECT
       product.product_id,
       tray.tray_id,
       part.part_id,
       part.animal_id,
       part.part_name,
       type,
       part.weight

       FROM product, tray_in_product, part_in_tray, tray, part
        WHERE product.product_id = tray_in_product.product_id
        AND tray.tray_id=tray_in_product.tray_id
        AND tray.tray_id=part_in_tray.tray_id
        AND part.part_id=part_in_tray.part_id;



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

INSERT INTO tray (tray_id, weight_capacity)
VALUES (0, 50),
       (1, 50),
       (2, 60),
       (3, 75);

INSERT INTO part_in_tray(tray_id, part_id)
VALUES (0,1),
       (0,9),
       (1,2),
       (1,6),
       (2,3),
       (2,7),
       (3,4),
       (3,8);

INSERT INTO product (type)
VALUES ('tasty leg'),
       ('tzaziki leg dip'),
       ('slow roasted shank'),
       ('bbq marinated shank'),
       ('south carolina style ribs'),
       ('kansas city ribs'),
       ('5A ribeye'),
       ('black angus ribeye');
Insert Into tray_in_product(product_id, tray_id)
VALUES (1,0),
       (2,0),
       (3,1),
       (4,1),
       (5,2),
       (6,2),
       (7,3),
       (8,3);
/*
SELECT *
FROM product_trace;

SELECT *
FROM product_trace
WHERE animal_id = 1;

SELECT *
FROM product_trace
WHERE product_id = 1;
*/
*/

