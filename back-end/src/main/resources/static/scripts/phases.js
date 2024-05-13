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
    phases.querySelectorAll('a').forEach(element => {element.draggable = false});
}

function loadBlock(map, posX, posY, divSize) {
    let img;
    let cursor = 'inherit';

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
            cursor = 'pointer';
            break;
        case 4:
            img = imgpath + 'completed.svg';
            cursor = 'pointer';
            break;
        default:
            break;
    }

    if (img) {
        let zIndex = (map.length - posX) * (map.length - posY);  
        let posLeft = ((divSize / 2 + ((-posX + posY) * 92)) - 184) + 'px';
        let posTop = (divSize - ((posX + posY) * 46) - 184) + 'px';

        const div = `<div style='position: absolute; left: ${posLeft}; top: ${posTop}; background-image: url(${img}); width: 184px; height: 184px; z-index: ${zIndex};' alt="Block" draggable=false></div>`;

        if (img === imgpath + 'blank.svg' || img === imgpath + 'locked.svg') {
            return div;
        }
        return `<a href='#' style='position: absolute; left: ${posLeft}; top: ${posTop}; cursor: ${cursor}; width: 184px; height: 92px; z-index: ${zIndex + 10};'></a>${div}`;
    }
    return '';
}
// ------------------------------------------------------------------------------------ //
main.addEventListener('mousedown', function(event) {
    offSetX = event.clientX - phases.getBoundingClientRect().left;
    offSetY = event.clientY - phases.getBoundingClientRect().top;
    main.style.cursor = 'grabbing';
    document.addEventListener('mousemove', onMouseMove);
})

document.addEventListener('mouseup', function() {
    main.style.cursor = "grab";
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
