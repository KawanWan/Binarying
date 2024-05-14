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

INSERT INTO exercise(question, answers, correctAnswerIndex, code_example, phase_id)
VALUES ('O que este programa deve imprimir?', 'HELLO WORLD! | Hello World! | Hello, World! | HelloWorld', 3, 'public class HelloWorld {
                        public static void main(String[] args) {
                            System.out.println("Hello, World!");
                        }
                    }    ', 1),
        ('Qual será a saída deste programa?', '10 | 15 | 25 | 20', 2, 'public class Main {
                        public static void main(String[] args) {
                            int a = 10;
                            int b = 15;
                            System.out.println(a + b);
                        }
                    }', 1),
        ('O que será impresso na tela?', '2.0 | 2 | 2.5 | 3.0', 0, 'public class Main {
                        public static void main(String[] args) {
                            double a = 5;
                            double b = 2;
                            System.out.println(a / b);
                        }
                    }', 1),
        ('Qual será o resultado da execução deste programa?', '5 | 6 | 15 | 16', 1, 'public class Main {
                        public static void main(String[] args) {
                            int x = 5;
                            int y = ++x;
                            System.out.println(y);
                        }
                    }', 1),
        ('Qual é a saída do programa?', 'true | false | null | 0', 1, 'public class Main {
                        public static void main(String[] args) {
                            boolean a = false;
                            System.out.println(a);
                        }
                    }', 1),
        ('O que este programa imprime?', '1 | 10 | 1.0 | 10.0', 3, 'public class Main {
                        public static void main(String[] args) {
                            double x = 10.0;
                            System.out.println(x);
                        }
                    }', 1),
        ('Qual será a saída do programa?', '123 | 1 | 12 | 3', 2, 'public class Main {
                        public static void main(String[] args) {
                            int x = 12;
                            System.out.println(x);
                        }
                    }', 1),
        ('O que será impresso?', '20 | 30 | 40 | 50', 1, 'public class Main {
                        public static void main(String[] args) {
                            int a = 10;
                            int b = 20;
                            int c = a + b;
                            System.out.println(c);
                        }
                    }', 1),
        ('Qual será a saída deste programa?', '1 | 2 | 3 | 4', 2, 'public class Main {
                        public static void main(String[] args) {
                            int a = 1;
                            int b = 2;
                            int c = 3;
                            System.out.println(c);
                        }
                    }', 1),
        ('O que este programa deve imprimir?', 'Hello | World | Hello World | Hello, World', 2, 'public class Main {
                        public static void main(String[] args) {
                            System.out.print("Hello");
                            System.out.print(" World");
                        }
                    }', 1),
        ('O que será impresso pelo programa?', '10 | 20 | 30 | 40', 0, 'public class Main {
                        public static void main(String[] args) {
                            int x = 10;
                            System.out.println(x);
                        }
                    }', 1);
