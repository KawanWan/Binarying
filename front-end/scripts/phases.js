const main = document.querySelector('main');
const phases = main.querySelector('#phases');

let offSetX = 0, offSetY = 0;

function onMouseMove(event) {
    phases.style.left = (event.clientX - offSetX) + "px"
    phases.style.top = (event.clientY - offSetY) + "px"
}

function loadPhases(arraymap) {
    // define div lenght
    if (arrayMap.length !== arrayMap[arrayMap.lastIndexOf()].length) {
        throw new Error("Invalid map!! The width is not equal to height");
    }
    phases.style.height = phases.style.width = (arrayMap.length * 184) + 'px';
    
}
// ------------------------------------------------------------------------------------ //
main.addEventListener('mousedown', function(event) {
    offSetX = event.clientX - phases.getBoundingClientRect().left;
    offSetY = event.clientY - phases.getBoundingClientRect().top;

    document.addEventListener('mousemove', onMouseMove);
})

document.addEventListener('mouseup', function() {
    document.removeEventListener('mousemove', onMouseMove)
})

// 0 == 'null', 1 == 'blank', 2 == 'locked', 3 == 'unlocked', 4 == 'completed'
let arrayMap = 
[
[1, 1, 1, 1, 1],
[1, 4, 1, 3, 1],
[1, 1, 1, 1, 1],
[0, 0, 1, 2, 1],
[0, 0, 1, 1, 1]
];

loadPhases(arrayMap);
