ALTER TABLE drugs
    ALTER COLUMN method_of_taking DROP NOT NULL,
    ALTER COLUMN dosage DROP NOT NULL,
    ALTER COLUMN description_of_action DROP NOT NULL,
    ALTER COLUMN side_effects DROP NOT NULL;

ALTER TABLE appointments
    AlTER COLUMN symptoms DROP NOT NULL;
