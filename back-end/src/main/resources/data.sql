INSERT INTO universe(name, description, colors, icon) VALUES ('Java', 'Aprenda java e conceitos de orientação a objetos!', '#fff,#5382a1', 'fa-brands fa-java'), ('JavaScript', '', '#323330, #F0DB4F', 'fa-brands fa-js');

INSERT INTO world(name, description, universe_id) 
VALUES ('Hello, Java!', 'Aprenda a sintaxe básica da linguagem java!', 1),
    ('JVM', 'Se aprofunde em conceitos mais avançados de java, como Memory Management, JVM, Garbage Collector...', 1),
    ('Spring', '', 1),
    ('Coffe', '', 1);