ALTER TABLE visit ADD COLUMN visit_time TIME;

UPDATE visit
SET visit_time = '10:00:00'
WHERE veterinarian_id = 1;

UPDATE visit
SET visit_time = '11:30:00'
WHERE veterinarian_id = 2;

UPDATE visit
SET visit_time = '09:45:00'
WHERE veterinarian_id = 3;
