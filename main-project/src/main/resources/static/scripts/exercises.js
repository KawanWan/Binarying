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

load();

function load() {
    document.title = title;
    fetch('http://localhost:8080/api/exercise/random/1')
        .then(response => response.json())
        .then(data => loadExercises(data, 0))
}

function loadExercises(exercises, index) {
    exercisesJson = exercises;
    answersJson = exercises[index].answers.split(" | ");
    question.innerText = exercises[index].question;
    figure.innerHTML = `<pre><code class="language-java">${exercises[index].codeExample}</code></pre>`
    for(let i = 0; i < btns.length; i++) {
        btns[i].innerHTML = answersJson[i];
        btns[i].addEventListener("click", createClickListener(i))
    }

}

function createClickListener(index) {
    return function() {
        progress(index, exercisesJson[index].correctAnswerIndex);
    }
}

function progress(index, right_answer) {
    
    if (index == right_answer) {
        const computedStyle = getComputedStyle(progressBar);
        let width = parseInt(computedStyle.getPropertyValue('--width')) || 0;
        if (width <= 10) {
            progressBar.style.setProperty('--width', width + 1);
            loadExercises(exercisesJson, index + 1);
        }

        if (width == 10) {
            window.history.back();
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