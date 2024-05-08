DROP TABLE IF EXISTS admin, student, universe, world, phase, exercise, student_progress;

CREATE TABLE IF NOT EXISTS admin (
    id INT PRIMARY KEY,
    username VARCHAR(200) NOT NULL,
    password VARCHAR(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS student (
    id INT PRIMARY KEY,
    username VARCHAR(200) NOT NULL,
    password VARCHAR(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS universe (
    id INT PRIMARY KEY,
    name VARCHAR(200),
    description TEXT
);

CREATE TABLE IF NOT EXISTS world (
    id INT PRIMARY KEY,
    name VARCHAR(150),
    description TEXT,
    universe_id INT NOT NULL,
    FOREIGN KEY (universe_id) REFERENCES universe(id)
);

CREATE TABLE IF NOT EXISTS phase (
    id INT PRIMARY KEY,
    name VARCHAR(150),
    description TEXT,
    concept_code INT,
    world_id INT NOT NULL,
    FOREIGN KEY (world_id) REFERENCES world(id)
);

CREATE TABLE IF NOT EXISTS exercise (
    id INT PRIMARY KEY,
    concept_code INT,
    question TEXT NOT NULL,
    answers VARCHAR(10000) NOT NULL,
    correct_answer VARCHAR(3000) NOT NULL
);

CREATE TABLE IF NOT EXISTS student_progress (
    id_phase INT NOT NULL,
    id_student INT NOT NULL,
    hours_spent TIMESTAMP,
    FOREIGN KEY (id_phase) REFERENCES phase(id),
    FOREIGN KEY (id_student) REFERENCES student(id)
);



