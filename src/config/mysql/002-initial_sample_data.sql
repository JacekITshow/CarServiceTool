
-- Create Sample user
INSERT INTO user (login, password, first_name, surname, gender, email, phone_number, birthdate, description)
VALUES
    ('admin', '$2y$10$aZ9iT.v9m.eGd3b18u1bQ6eS4.2k3r.2zZ87868iZ27f14z65oH', 'John', 'Doe', 'Male', 'john.doe@email.com', '+1234567890', '1980-01-01', 'Administrative user'),
    ('mechanic1', '$2y$10$8v8004hF81r72f/57gI00O.Y69Yj8v4.Y8a5k25.m3414722152', 'Jane', 'Smith', 'Female', 'jane.smith@email.com', '+44123456789', '1990-02-02', 'Mechanic'),
    ('mechanic2', '$2y$10$fXs1h/g2xr838b3.2150g.a8093aP2Q2k08mY.054x0h6nXkG8e', 'Peter', 'Johnson', 'Male', 'peter.johnson@email.com', '+33123456789', '1985-03-03', 'Mechanic');

-- Create Sample role
INSERT INTO role (name)
VALUES
    ('Admin'),
    ('Mechanic');

-- Create Sample role_to_user
INSERT INTO role_to_user (user_id, role_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 2);

-- Create Sample permission
INSERT INTO permission (name)
VALUES
    ('Add user'),
    ('Edit user'),
    ('Delete user'),
    ('Create repair'),
    ('View repair'),
    ('Edit repair'),
    ('Delete repair'),
    ('Manage car'),
    ('Perform service'),
    ('Manage parts');

-- Create Sample permission_to_role
INSERT INTO permission_to_role (permission_id, role_id)
VALUES
    (1, 1),
    (2, 1),
    (3, 1),
    (4, 2),
    (5, 2),
    (6, 2),
    (7, 2),
    (8, 2),
    (9, 2),
    (10, 2);

-- Create Sample change_password
INSERT INTO change_password (user_id, hashcode, date)
VALUES
    (1, '$2y$10$3kI.k7.a02pO9j202x8s6u.b69432Yx6224891157.1114226171', '2023-10-04 12:34:56'),
    (2, '$2y$10$82xnX/26o5f0.P192i94f.m914293077843795030107782156', '2023-11-05 07:12:34');

-- Create Sample customer
INSERT INTO customer (first_name, surname, gender, email, phone_number, birthdate, description)
VALUES
    ('John', 'Doe', 'Male', 'johndoe@email.com', '1234567890', '1980-01-01', 'Regular customer'),
    ('Jane', 'Smith', 'Female', 'janesmith@email.com', '1234567891', '1985-02-02', 'Frequent customer'),
    ('Peter', 'Jones', 'Male', 'peterjones@email.com', '1234567892', '1990-03-03', 'New customer');

-- Create Sample car
INSERT INTO car (customer_id, plate, plate_country, vin, brand, model, model_code, fuel_type, year, description)
VALUES
    (1, 'ABC123', 'PL', 'WXYZ456', 'Volkswagen', 'Golf', '2018', 'Gasoline', '2020-10-04', 'Regular maintenance'),
    (2, 'DEF456', 'DE', 'MNPQ789', 'Mercedes-Benz', 'C-Class', '2016', 'Diesel', '2021-01-05', 'Engine repair'),
    (3, 'GHI789', 'FR', 'JKLM012', 'Toyota', 'Yaris', '2022', 'Electric', '2023-03-12', 'Wheel alignment');

-- Create Sample repair
INSERT INTO repair (car_id, admission_date, estimated_date, description)
VALUES
    (1, '2023-10-04 12:00:00', '2023-10-06 14:00:00', 'Oil change and air filter replacement'),
    (2, '2023-01-05 09:00:00', '2023-01-07 11:00:00', 'Engine diagnostics and repair'),
    (3, '2023-03-12 15:00:00', '2023-03-13 17:00:00', 'Tire rotation and alignment');

-- Create Sample service
INSERT INTO service (name, recommended_cost, min_cost, max_cost, description)
VALUES
    ('Oil change and filter replacement', 100, 80, 120, 'Replace engine oil and filter'),
    ('Engine diagnostics', 200, 150, 250, 'Inspect engine components and identify potential issues'),
    ('Repair', 100, 50, 150, 'Perform repairs to fix identified issues'),
    ('Tire rotation and alignment', 50, 30, 70, 'Rotate tires to ensure even wear and align wheels for optimal handling');


-- Create Sample service_to_repair
INSERT INTO service_to_repair (repair_id, service_id, cost)
VALUES
    (1, 1, 100),
    (2, 2, 200),
    (3, 3, 50),
    (3, 4, 60);

-- Create Sample parts_to_repair
INSERT INTO parts_to_repair (repair_id, name, cost, description, part_code)
VALUES
    (1, 'Engine oil', 30, 'Synthetic oil suitable for the vehicle', '12345'),
    (1, 'Air filter', 20, 'High-quality air filter to improve engine performance', '67890'),
    (2, 'Spark plugs', 50, 'Set of four spark plugs to improve engine performance', '123456'),
    (2, 'Timing belt', 100, 'New timing belt to prevent engine damage', '789012'),
    (3, 'Tire rotation', 20, 'Rotate tires to ensure even wear', '345678'),
    (3, 'Wheel alignment', 40, 'Align wheels for optimal handling', '901234');

