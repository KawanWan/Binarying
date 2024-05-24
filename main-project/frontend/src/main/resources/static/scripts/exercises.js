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
        btns[i].addEventListener("click", function(event) {
            progress(i, correct)
        })
    }
    fetch('https://binarying-binarying.azuremicroservices.io/api/exercise/random/1')
        .then(response => response.json())
        .then(data => loadExercises(data, actualExercise))
}

function loadExercises(exercises, index) {
    if (index == 10) {
        window.location.href = '../index.html';
    }
    exercisesJson = exercises;
    answersJson = exercises[index].answers.split(" | ");
    correct = exercises[index].correctAnswerIndex;
    question.innerText = exercises[index].question;
    figure.innerHTML = `<pre><code class="language-java">${exercises[index].codeExample}</code></pre>`
    for(let i = 0; i < btns.length; i++) {
        btns[i].innerHTML = answersJson[i];
    }

}

function progress(index, right_answer) {
    
    if (index == right_answer) {
        const computedStyle = getComputedStyle(progressBar);
        let width = parseInt(computedStyle.getPropertyValue('--width')) || 0;
        if (width <= 10) {
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