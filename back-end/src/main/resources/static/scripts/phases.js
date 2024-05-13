const main = document.querySelector('main');
const phases = main.querySelector('#phases');

let offSetX = 0, offSetY = 0;

function onMouseMove(event) {
    phases.style.left = (event.clientX - offSetX) + "px"
    phases.style.top = (event.clientY - offSetY) + "px"
}

function loadPhases(arraymap) {
    // define div lenght
    if (arrayMap.length !== arrayMap[arrayMap.length - 1].length) {
        throw new Error("Invalid map!! The width is not equal to height");
    }
    let size = parseFloat(phases.style.height = phases.style.width = (arrayMap.length * 184) + 'px');
    
    for (i = 0; i < arrayMap.length; i++) {
        for (j = 0; j < arrayMap[i].length; j++) {
            let block = loadBlock(arraymap, i, j, size);
            phases.innerHTML += block;
        }
    }
}

function loadBlock(map, posX, posY, divSize) {
    let img;

    const imgpath = '../imgs/assets/phases/';
    switch (map[posX][posY]) {
        case 1:
            img = imgpath + 'blank.svg';
            break;
        case 2:
            img = imgpath + 'locked.svg';
            break;
        case 3:
            img = imgpath + 'unlocked.svg';
            break;
        case 4:
            img = imgpath + 'completed.svg';
            break;
        default:
            break;
    }

    if (img) {
        let zIndex = (map.length - posX) * (map.length - posY);  
        let posLeft = ((divSize / 2 + ((-posX + posY) * 92)) - 184) + 'px';
        let posTop = (divSize - ((posX + posY) * 46) - 184) + 'px';

        return `<a href='#' style='position: absolute; z-index: ${zIndex};left: ${posLeft}; top: ${posTop}'><img src=${img} alt="Block"></a>`;
    }
    return undefined;
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
