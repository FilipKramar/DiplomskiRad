CREATE TABLE veterinarian (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    surname VARCHAR(20) NOT NULL,
    oib CHAR(11) UNIQUE NOT NULL,
    password VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    veterinaryclinic VARCHAR(40) NOT NULL,
    yearsofexperience INT
);

INSERT INTO veterinarian (name, surname, oib, password, email, veterinaryclinic, yearsofexperience)
VALUES
('Emma', 'Williams', '12345678901', 'password123', 'emma.williams@example.com', 'Happy Pets Clinic', 10),
('Jane', 'Smith', '10987654321', 'securepass', 'jane.smith@example.com', 'Healthy Animals Clinic', 5),
('Charlie', 'Davis', '99887766554', 'charliepwd', 'charlie.davis@example.com', 'Vet Solutions', 3);


CREATE TABLE prescriptions (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    dosage VARCHAR(50) NOT NULL,
    instructions VARCHAR(100),
    expirationdate DATE NOT NULL
);

CREATE TABLE therapies (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    description VARCHAR(100) NOT NULL,
    type VARCHAR(50),
    price DECIMAL(10, 2),
    materials VARCHAR(100)
);

CREATE TABLE visit (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    veterinarian_id BIGINT NOT NULL,
    pet_id BIGINT NOT NULL,
    prescriptions_id BIGINT,
    therapies_id BIGINT,
    visit_date DATE NOT NULL,
    reason VARCHAR(100),
    max_price DECIMAL(10, 2),
    FOREIGN KEY (veterinarian_id) REFERENCES veterinarian(id),
    FOREIGN KEY (pet_id) REFERENCES pets(id),
    FOREIGN KEY (prescriptions_id) REFERENCES prescriptions(id),
    FOREIGN KEY (therapies_id) REFERENCES therapies(id)
);

INSERT INTO pets (name, species, breed, microchipNumber, user_id)
VALUES
('Buddy', 'Dog', 'Golden Retriever', '1234567890', 1),
('Whiskers', 'Cat', 'Siamese', '1234337890', 2),
('Rocky', 'Dog', 'Boxer', '9876543210', 1);

INSERT INTO prescriptions (name, dosage, instructions, expirationdate)
VALUES
('Medication A', '10mg', 'Take once daily with food', '2024-12-31'),
('Medication B', '5mg', 'Take twice daily', '2024-11-30');

INSERT INTO therapies (description, type, price, materials)
VALUES
('Physical Therapy for injured leg', 'Rehabilitation', 50.00, 'Exercise equipment, bandages'),
('Behavioral Therapy for anxiety', 'Training', 40.00, 'Toys, treats');

INSERT INTO visit (veterinarian_id, pet_id, prescriptions_id, therapies_id, visit_date, reason, max_price)
VALUES
(1, 1, 1, NULL, '2024-06-01', 'Annual check-up and vaccination', 35.00),
(2, 2, NULL, 1, '2024-06-02', 'Physical therapy session for injured leg', 50.00),
(3, 3, 2, NULL, '2024-06-03', 'Follow-up visit for medication adjustment', 40.00);
