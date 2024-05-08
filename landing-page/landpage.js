document.addEventListener("DOMContentLoaded", function () {
    const header = document.querySelector('header');
    const savedState = localStorage.getItem('headerState');

    if (savedState) {
        header.innerHTML = savedState;
    }

    header.addEventListener('click', function (event) {
        if (event.target.classList.contains('link')) {
            event.preventDefault(); // Evita que o link redirecione
            const linkText = event.target.innerText.trim();

            if (linkText === 'Cursos') {
                const newState = `
                    <div class="header1">
                        <h1>Cursos</h1>
                        <img src="imgs/cursos.jpeg">
                    </div>
                    <div class="header2">
                        <p>Descrição dos cursos...</p>
                        
                        <a href="#Inicio" class="link">Inicio</a>
                        <a href="#SobreNós" class="link">Sobre Nós</a>
                    </div>
                `;

                header.innerHTML = newState;
                localStorage.setItem('headerState', newState);
            } else if (linkText === 'Inicio') {
                const newState = `
                    <div class="header1">
                        <h1>Binarying</h1>
                        <img src="imgs/inicio-landing-page.jpeg">
                    </div>
                    <div class="header2">
                        <p>
                            Binarying é uma plataforma que promove o ensino voltado principalmente à prática de programação. Nossa
                            proposta é ajudar estudantes a terem melhor entendimento das tecnologias que estão estudando ou desejam
                            estudar, por meio de exercícios gamificados, que irão estimular e consolidar o entendimento.
                        </p>

                        <a href="#Cursos" class="link">Cursos</a>
                        <a href="#SobreNós" class="link">Sobre Nós</a>
                    </div>
                `;

                header.innerHTML = newState;
                localStorage.setItem('headerState', newState);
            } else if (linkText === 'Sobre Nós') {
                const newState = `
                    <div class="header1">
                        <h1>Binarying</h1>
                        <img src="imgs/sobre-nos.jpeg">
                    </div>
                    <div class="header2">
                        <p>
                            Percebe-se a grande dificuldade que muitos estudantes têm de entender certos conceitos na programação, muitas vezes, por falta de prática consistente, com isso, surgiu a ideia do nosso projeto: Servir como ferramenta auxiliar de aprendizado para todos aqueles interessados em melhorar seu entendimento e aprimorar suas habilidades na programação.
                        </p>
                        <h2>Objetivos</h2>
                        <p>
                            Nosso projeto contribuirá para a melhor compreensão do que os estudantes precisam para melhor se engajarem em seu aprendizado. A ideia é enxergar a importância da integração do aprendizado e diversão para alcançar um melhor aproveitamento de estudo aos alunos. 
                            <br>
                            Por meio da prática constante e interface intuitiva, buscaremos pesquisar a melhor forma de tornar a prática na programação eficiente, utilizando aspectos de jogos como: Nível de experiência (EXP), Dificuldade e progressão dinâmica (Dificultar ou facilitar de acordo com o desempenho do estudante).
                        </p>

                        <a href="#Inicio" class="link">Inicio</a>
                        <a href="#Cursos" class="link">Cursos</a>
                    </div>
                `;

                header.innerHTML = newState;
                localStorage.setItem('headerState', newState);
            }
        }
    });
});
