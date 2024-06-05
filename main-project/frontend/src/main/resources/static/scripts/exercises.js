const progressBar = document.getElementsByClassName('progress-bar')[0];
const life = document.querySelector('#user-life');
const question = document.querySelector('#question');
const answers = document.querySelector('.answers');
const figure = document.querySelector('.figure');
const urlParams = new URLSearchParams(window.location.search);
const title = urlParams.get('phaseName');
const id = urlParams.get('phaseId');

const btns = answers.querySelectorAll('button');

let exercisesJson;
let actualExercise = 0;
let correct;

load();

function load() {
    document.title = title;
    for (let i = 0; i < btns.length; i++) {
        btns[i].addEventListener("click", function (event) {
            progress(i, correct)
        })
    }
    fetch('https://binarying-backend-back.azuremicroservices.io/api/exercise/random/1')
        .then(response => response.json())
        .then(data => loadExercises(data, actualExercise))
}

function loadExercises(exercises, index) {
    if (index == 10) {
        document.querySelector(".correctAnswer").innerHTML = `
            <nav>Binarying</nav>
            <main>
                <h1>Parabéns! Você completou o primeiro exercicio do Ato 1!</h1><br>
                <p>+ 245XP</p>

                <button class="btnProsseguir">Prosseguir</button>
            </main>
        `;

        document.querySelector(".btnProsseguir").addEventListener("click", () => { window.history.back(); })
    }
    exercisesJson = exercises;
    answersJson = exercises[index].answers.split(" | ");
    correct = exercises[index].correctAnswerIndex;
    question.innerText = exercises[index].question;
    figure.innerHTML = `<pre><code class="language-java">${exercises[index].codeExample}</code></pre>`
    for (let i = 0; i < btns.length; i++) {
        btns[i].innerHTML = answersJson[i];
    }

}

function progress(index, right_answer) {

    if (index == right_answer) {
        const computedStyle = getComputedStyle(progressBar);
        let width = parseInt(computedStyle.getPropertyValue('--width')) || 0;
        if (width <= 10) {
            document.querySelector(".correctAnswer").innerHTML = `
                <section class="correctAnswer">
                    <main>
                        <h1>Você acertou o exercício!</h1><br>
                        <p>resposta correta:</p>
        
                        <div class="btnCorrect">
                            <button>${answersJson[correct]}</button>
        
                            <div class="next-button">
                                <button>
                                    <i class="fa-solid fa-arrow-right"></i>
                                </button>
                            </div>
                        </div>
                    </main>
                </section>
            `;

            document.querySelector(".next-button button").addEventListener("click", () => { close() })

            document.querySelector(".correctAnswer").style.zIndex = 1000;

            progressBar.style.setProperty('--width', width + 1);
            actualExercise++;
            loadExercises(exercisesJson, actualExercise);
        }
    } else {
        const heart = life.querySelector('i');
        heart.classList.add('fa-bounce')

        let lifes = parseInt(life.querySelector('p').innerHTML) - 1;
        life.querySelector('p').innerHTML = lifes;

        setTimeout(() => {
            heart.classList.remove('fa-bounce')
        }, 1000)

        if (lifes === 0) {
            window.history.back();
        }
    }
}

function close() {
    document.querySelector(".correctAnswer").innerHTML = "";
    document.querySelector(".correctAnswer").style.zIndex = -1000;
}