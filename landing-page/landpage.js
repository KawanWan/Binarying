document.addEventListener("DOMContentLoaded", function () {
    const content = document.querySelector('.content');
    const contentText = document.querySelector('.content-text');
    const buttons = document.querySelectorAll('.page-button');

    const pagesContent = {
        1: {
            title: "Se aprofunde em tecnologias de uma forma divertida e intuitiva!",
            text: "Inscreva-se para receber atualizações e mais detalhes da plataforma",
            buttons: [
                { href: "#Inscreva-se", text: "Inscreva-se", class: "botao-branco" },
                { href: "#InicieJa", text: "Inicie Já", class: "inicie-ja" }
            ]
        },
        2: {
            title: "Aprenda sobre as melhores tecnologias disponíveis!",
            text: "Exercicios desenvolvidos por estudantes e profissionais experientes.",
            buttons: [
                { href: "#Tecnologias", text: "Ver Tecnologias", class: "botao-branco" },
                { href: "#Contato", text: "Entre em Contato", class: "botao-branco" }
            ]
        },
        3: {
            title: "Junte-se à nossa comunidade de desenvolvedores!",
            text: "Participe de fóruns e eventos para expandir seus conhecimentos.",
            buttons: [
                { href: "#Comunidade", text: "Nossa Comunidade", class: "botao-branco" },
                { href: "#Eventos", text: "Próximos Eventos", class: "botao-branco" }
            ]
        }
    };

    function updateContent(pageContent) {
        contentText.innerHTML = `
            <h2><strong>${pageContent.title}</strong></h2>
            <p>${pageContent.text}</p>
            <div class="content-buttons">
                ${pageContent.buttons.map(button => `
                    <a href="${button.href}" class="link ${button.class}">
                        <strong>${button.text}</strong>
                    </a>
                `).join('')}
            </div>
        `;

        addDynamicButtonEvents();
    }

    function addDynamicButtonEvents() {
        const newButtons = contentText.querySelectorAll('.content-buttons .link');
        newButtons.forEach(newButton => {
            newButton.addEventListener('click', function (event) {
                if (this.textContent.trim() === "Ver Tecnologias") {
                    content.innerHTML = `
                    <div class="content-text">
                        <p class="message-balloon">
                            A plataforma Binarying foi
                            pensada e desenvolvida para
                            fornecer a você que pretende
                            iniciar a jornada em programação
                            e outras tecnologias, uma maneira
                            diversificada e gamificada de estudar!
                        </p>

                        <img src="imgs/Bin.svg" alt="">
                    </div>

                    <div class="main2">
                        <h2>Veja algumas tecnologias</h2>
                        <div>
                            <a class="tecnologias">
                                <img src="imgs/botao-java.png" alt="">
                            </a>
                            <a class="tecnologias">
                                <img src="imgs/botao-html.png" alt="">
                            </a>
                        </div>
                    </div>
                `;
                }
            });
        });
    }

    buttons.forEach(button => {
        button.addEventListener('click', function () {
            const page = this.getAttribute('data-page');
            const content = pagesContent[page];
            if (content) {
                updateContent(content);
            }
        });
    });

    addDynamicButtonEvents();
});
