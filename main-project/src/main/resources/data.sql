INSERT INTO universe(name, description, colors, icon)
VALUES ('Java', 'Aprenda java e conceitos de orientação a objetos!', '#fff,#5382a1', 'fa-brands fa-java'), ('JavaScript', '', '#323330, #F0DB4F', 'fa-brands fa-js');

INSERT INTO world(name, description, universe_id) 
VALUES ('Hello, Java!', 'Aprenda a sintaxe básica da linguagem java!', 1),
    ('JVM', 'Se aprofunde em conceitos mais avançados de java, como Memory Management, JVM, Garbage Collector...', 1),
    ('Spring', '', 1),
    ('Coffe', '', 1);

INSERT INTO phase(name, description, concept, difficulty, x, y, world_id)
VALUES ('Sintaxe Básica', 'Aprenda a base da linguagem', 'syntax', 'TRAINEE', 1,1 ,1),
    ('Dados e Variáveis', 'Aprenda sobre os tipos de dados em java', 'data-types, variables', 'TRAINEE', 1,3 ,1),
    ('Condicionais', 'Aprenda sobre as estruturas de condição', 'conditional', 'TRAINEE', 3,3 ,1);
