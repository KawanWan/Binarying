const progressBar = document.getElementsByClassName('progress-bar')[0]

function progress() {
    const computedStyle = getComputedStyle(progressBar)
    const width = parseInt(computedStyle.getPropertyValue('--width')) || 0;
    if (width <= 10) {
        progressBar.style.setProperty('--width', width + 1)
    } else {
        // Fase concluída
    }
}