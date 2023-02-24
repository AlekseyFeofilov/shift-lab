CREATE TABLE Type
(
    type_id uuid PRIMARY KEY,
    name   varchar
);

INSERT INTO type (type_id, name) VALUES ('f93ded2f-97c9-42f5-bbb4-5b029f2474ff', 'Настольные компьютеры');
INSERT INTO type (type_id, name) VALUES ('4cf3dbaf-5a65-4b88-9670-556a8b06684a', 'Ноутбуки');
INSERT INTO type (type_id, name) VALUES ('f93ded2f-97c9-42f5-bbb4-5b029f2474fe', 'Мониторы');
INSERT INTO type (type_id, name) VALUES ('1a2d9bfb-780f-4b1d-abbe-655a19b4f64e', 'Жесткие диски');