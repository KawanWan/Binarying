const progressBar = document.getElementsByClassName('progress-bar')[0]
const life = document.getElementById("user-life")
const answers = document.querySelector(".answers")

const btns = answers.querySelectorAll('button')

btns.forEach(function(btn) {
    btn.addEventListener("click", function(event) {
        progress(Array.from(btns).indexOf(btn))
    })
})

function progress(index) {
    const right_answer = Math.floor(Math.random() * (btns.length - 0) + 0)
    if (index === right_answer) {
        const computedStyle = getComputedStyle(progressBar)
        let width = parseInt(computedStyle.getPropertyValue('--width')) || 0;
        if (width <= 10) {
            progressBar.style.setProperty('--width', width + 1)
        }

        if (width == 10) {
            window.location.href = "phases.html"
        }
    } else {
        const heart = life.querySelector('i');
        heart.classList.add('fa-bounce')
        
        let lifes = parseInt(life.querySelector('p').innerHTML)
        lifes--
        life.querySelector('p').innerHTML = lifes

        setTimeout(() => {
            heart.classList.remove('fa-bounce')
        }, 1000)

        if (lifes === 0) {
            window.location.href = "phases.html"
        }
    }
}