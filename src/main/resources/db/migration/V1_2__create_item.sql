CREATE TABLE item
(
    item_id       uuid PRIMARY KEY,
    name          varchar,
    cost          float,
    quantity      integer,
    serial_number varchar,
    producer      varchar,
    type_id       uuid,
    FOREIGN KEY (type_id) REFERENCES type (type_id) ON DELETE SET NULL
);

INSERT INTO item VALUES ('f93ded2f-97c9-42f5-bbb4-5b029f2474ff', 'MacBook Air 13', 120000, 5000, '3jhUI23423sd', 'Apple', '4cf3dbaf-5a65-4b88-9670-556a8b06684a');
INSERT INTO item VALUES ('4cf3dbaf-5a65-4b88-9670-556a8b06684a', 'MacBook Pro 13', 160000, 5000, '3ghUI23427sl', 'Apple', '4cf3dbaf-5a65-4b88-9670-556a8b06684a');
INSERT INTO item VALUES ('f93ded2f-97c9-42f5-bbb4-5b029f2474fe', 'MacBook Pro 14', 180000, 5000, '3oqUI23345ut', 'Apple', '4cf3dbaf-5a65-4b88-9670-556a8b06684a');
INSERT INTO item VALUES ('1a2d9bfb-780f-4b1d-abbe-655a19b4f64e', 'Kingston A400', 5000, 1000, '6lwNH34523pz', 'Kingston', '1a2d9bfb-780f-4b1d-abbe-655a19b4f64e');