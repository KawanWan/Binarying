DROP TABLE IF EXISTS admin, student, universe, world, phase, exercise, student_progress;

/*CREATE TABLE IF NOT EXISTS admin (
    id INT PRIMARY KEY,
    username VARCHAR(200) NOT NULL,
    password VARCHAR(64) NOT NULL
); */

CREATE TABLE student (
    id SERIAL PRIMARY KEY,
    username VARCHAR(200) NOT NULL,
    password VARCHAR(64) NOT NULL,
    exp INT DEFAULT 0,
    life INT DEFAULT 5,
    isAdventure BOOLEAN NOT NULL,
    difficulty VARCHAR(20) NOT NULL,
    progress INT[] DEFAULT '{}'
);


CREATE TABLE universe (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(200),
    description TEXT,
    colors VARCHAR(20),
    icon VARCHAR(30)
);

CREATE TABLE world (
    id SERIAL PRIMARY KEY,
    name VARCHAR(150),
    description TEXT,
    universe_id INT,
    FOREIGN KEY (universe_id) REFERENCES universe(id)
);

CREATE TABLE phase (
    id SERIAL PRIMARY KEY,
    name VARCHAR(150),
    description TEXT,
    concept VARCHAR(50),
    difficulty VARCHAR(20),
    x INT,
    y INT,
    world_id INT,
    FOREIGN KEY(world_id) REFERENCES world(id)
);

CREATE TABLE exercise (
    id SERIAL PRIMARY KEY,
    concept VARCHAR(50),
    exerciseType VARCHAR(30),
    difficulty VARCHAR(20),
    question TEXT NOT NULL,
    answers TEXT NOT NULL,
    correct_answer_index INT NOT NULL,
    code_example TEXT, 
    phase_id INT,
    FOREIGN KEY (phase_id) REFERENCES phase(id)
);

CREATE TABLE student_progress (
    id_phase INT NOT NULL,
    id_student INT NOT NULL,
    hours_spent TIMESTAMP,
    FOREIGN KEY (id_phase) REFERENCES phase(id),
    FOREIGN KEY (id_student) REFERENCES student(id)
);



