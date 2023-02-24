CREATE TABLE property_value_item
(
    property_value_item_id uuid PRIMARY KEY,
    item_id uuid,
    property_value_id  uuid,
    FOREIGN KEY (property_value_id) REFERENCES property_value (property_value_id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES item (item_id) ON DELETE CASCADE,
    UNIQUE (item_id, property_value_id)
);

INSERT INTO property_value_item VALUES ('4054a892-e55c-4cef-b6ca-d94375a28976', 'f93ded2f-97c9-42f5-bbb4-5b029f2474ff', '74651542-8037-4593-9485-445fe19dcc21');
INSERT INTO property_value_item VALUES ('42ba372c-54c9-4f68-8725-90c87f53c689', '4cf3dbaf-5a65-4b88-9670-556a8b06684a', '74651542-8037-4593-9485-445fe19dcc21');
INSERT INTO property_value_item VALUES ('5daf03c1-abe1-4c08-88b4-ad8d85cef18b', 'f93ded2f-97c9-42f5-bbb4-5b029f2474fe', '17a221f2-3b64-443c-9183-b8930c61de17');
