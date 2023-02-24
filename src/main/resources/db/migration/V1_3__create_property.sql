CREATE TABLE property
(
    property_id uuid PRIMARY KEY,
    name varchar,
    type_id  uuid,
    FOREIGN KEY (type_id) REFERENCES type (type_id) ON DELETE CASCADE
);

INSERT INTO property VALUES ('1a2d9bfb-780f-4b1d-abbe-655a19b4f64e', 'form-factor', 'f93ded2f-97c9-42f5-bbb4-5b029f2474ff');
INSERT INTO property VALUES ('f93ded2f-97c9-42f5-bbb4-5b029f2474fe', 'size', '4cf3dbaf-5a65-4b88-9670-556a8b06684a');
INSERT INTO property VALUES ('4cf3dbaf-5a65-4b88-9670-556a8b06684a', 'diagonal', 'f93ded2f-97c9-42f5-bbb4-5b029f2474fe');
INSERT INTO property VALUES ('f93ded2f-97c9-42f5-bbb4-5b029f2474ff', 'volume', '1a2d9bfb-780f-4b1d-abbe-655a19b4f64e');
