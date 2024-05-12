const worldList = document.querySelector('.world-list');

const urlParams = new URLSearchParams(window.location.search);

load();

function load() {
    const title = urlParams.get('universe_name')
    document.title = title;
    document.querySelector('#universe-name').innerHTML = title;

    const url = 'http://localhost:8080/api/world?universeId=' + urlParams.get('universe_id');
    fetch(url).then(response => response.json())
        .then(json => loadWorlds(json))
}

function loadWorlds(json) {
    json.forEach(world => {
        worldList.innerHTML += `<div class="world-content swiper-slide">
                                    <a class="world" href="phases.html">${world.id}</a>
                                </div>`
    });

    var swiper = new Swiper("#worlds", {
        slidesPerView: 3,
        navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
        },
        pagination: {
        el: ".swiper-pagination",
        },
        mousewheel: true,
        keyboard: true,
    });
}

