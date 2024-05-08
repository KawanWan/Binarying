const main = document.querySelector('main');
const world = main.querySelector('#world');

let offSetX = 0, offSetY = 0;

main.addEventListener('mousedown', function(event) {
    offSetX = event.clientX - world.getBoundingClientRect().left;
    offSetY = event.clientY - world.getBoundingClientRect().top;

    document.addEventListener('mousemove', onMouseMove);
})

document.addEventListener('mouseup', function() {
    document.removeEventListener('mousemove', onMouseMove)
})

function onMouseMove(event) {
    world.style.left = (event.clientX - offSetX) + "px"
    world.style.top = (event.clientY - offSetY) + "px"
}
