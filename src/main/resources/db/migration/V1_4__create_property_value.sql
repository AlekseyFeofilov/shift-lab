CREATE TABLE property_value
(
    property_value_id  uuid PRIMARY KEY,
    "value"    varchar,
    property_id uuid,
    FOREIGN KEY (property_id) REFERENCES property (property_id) ON DELETE CASCADE
);

INSERT INTO property_value VALUES ('1f2c00f0-9e20-436e-a6a8-55eb36dbdc50', 'десктопы', '1a2d9bfb-780f-4b1d-abbe-655a19b4f64e');
INSERT INTO property_value VALUES ('4c1f2900-311f-4ccd-bf78-a722f3f0bf85', 'неттопы', '1a2d9bfb-780f-4b1d-abbe-655a19b4f64e');
INSERT INTO property_value VALUES ('021c2016-1332-429a-aff5-570401494f04', 'моноблоки', '1a2d9bfb-780f-4b1d-abbe-655a19b4f64e');
INSERT INTO property_value VALUES ('74651542-8037-4593-9485-445fe19dcc21', '13 дюймов', 'f93ded2f-97c9-42f5-bbb4-5b029f2474fe');
INSERT INTO property_value VALUES ('17a221f2-3b64-443c-9183-b8930c61de17', '14 дюймов', 'f93ded2f-97c9-42f5-bbb4-5b029f2474fe');
INSERT INTO property_value VALUES ('840d631e-bdb6-41dd-bf5e-ac0846f0c3a6', '15 дюймов', 'f93ded2f-97c9-42f5-bbb4-5b029f2474fe');
INSERT INTO property_value VALUES ('f408f45e-e336-4b20-a041-141b47dcb482', '17 дюймов', 'f93ded2f-97c9-42f5-bbb4-5b029f2474fe');
INSERT INTO property_value VALUES ('4cf3dbaf-5a65-4b88-9670-556a8b06684a', 'diagonal', '4cf3dbaf-5a65-4b88-9670-556a8b06684a');
INSERT INTO property_value VALUES ('f93ded2f-97c9-42f5-bbb4-5b029f2474ff', 'volume', 'f93ded2f-97c9-42f5-bbb4-5b029f2474ff');

