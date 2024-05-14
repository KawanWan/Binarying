const main = document.querySelector('main');
const phases = main.querySelector('#phases');

const urlParams = new URLSearchParams(window.location.search);
let worldId = urlParams.get('world_id');

let offSetX = 0, offSetY = 0;
// ------------------------------------------------------------------------------------ //
load();

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
// ------------------------------------------------------------------------------------ //
function load() {
    const title = urlParams.get('world_name');
    document.title = title;
    document.querySelector('#title').innerHTML = title;
    
    fetch(`http://localhost:8080/api/phase/arrayMap/${worldId}`)
        .then(response => response.json())
        .then(json => loadPhases(json))
}

function onMouseMove(event) {
    phases.style.left = (event.clientX - offSetX) + "px"
    phases.style.top = (event.clientY - offSetY) + "px"
}

function loadPhases(arrayMap) {
    fetch(`http://localhost:8080/api/phase?worldId=${worldId}`)
            .then(response => response.json())
            .then(data => fill(arrayMap, data));
    // define div lenght
    /*if (arrayMap.length !== arrayMap[arrayMap.length - 1].length) {
        throw new Error("Invalid map!! The width is not equal to height");
    }*/
}

function fill(arrayMap, phasesJson) {
    let size = parseFloat(phases.style.height = phases.style.width = (arrayMap.length * 184) + 'px');
    
    for (i = 0; i < arrayMap.length; i++) {
        for (j = 0; j < arrayMap[i].length; j++) {
            let block = loadBlock(arrayMap, i, j, size, phasesJson);
            phases.innerHTML += block;
        }
    }
    phases.querySelectorAll('a').forEach(element => {element.draggable = false});
}

function loadBlock(map, posX, posY, divSize, phasesJson) {
    let img;
    let cursor = 'inherit';

    // 0 == 'null', 1 == 'blank', 2 == 'locked', 3 == 'unlocked', 4 == 'completed'
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
        let a;
        for (let i = 0; i < phasesJson.length; i++) {
            let element = phasesJson[i];
            if (element.x == posX && element.y == posY) {
                a = `exercise.html?phaseId=${element.id}&phaseName=${element.name}`;
                i = phasesJson.length;
            } else {
                a = '#';
            }
        }

        const div = `<div style='position: absolute; left: ${posLeft}; top: ${posTop}; background-image: url(${img}); width: 184px; height: 184px; z-index: ${zIndex};' alt="Block" draggable=false></div>`;

        if (img === imgpath + 'blank.svg' || img === imgpath + 'locked.svg') {
            return div;
        }
        return `<a href='${a}' style='position: absolute; left: ${posLeft}; top: ${posTop}; cursor: ${cursor}; width: 184px; height: 92px; z-index: ${zIndex + 10};'></a>${div}`;
    }
    return '';
}