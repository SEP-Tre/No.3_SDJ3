CREATE SCHEMA IF NOT EXISTS slaughterhouse;
SET SCHEMA 'slaughterhouse';

CREATE TABLE IF NOT EXISTS part(
    part_id SERIAL PRIMARY KEY,
    animal_id int,
    part_name char(40),
    weight float
);

CREATE TABLE IF NOT EXISTS tray(
    tray_id SERIAL PRIMARY KEY,
    part_id int,
    part_name char(32),
    weight_capacity float,

    FOREIGN KEY (part_id) REFERENCES part(part_id)
);

CREATE TABLE IF NOT EXISTS product(
    product_id SERIAL PRIMARY KEY,
    tray_id int,
    type char(50),

    FOREIGN KEY (tray_id) REFERENCES tray(tray_id)
);

CREATE VIEW product_trace AS
    SELECT *
    FROM part, tray, product
    JOIN tray t on product.tray_id = t.tray_id
    JOIN slaughterhouse.part p ON p.part_id = t.part_id;


