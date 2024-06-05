const universeList = document.querySelector('.universe-list');

fetch('https://binarying-backend-back.azuremicroservices.io/api/universe')
    .then(response => response.json())
    .then(json => loadUniverse(json))
    .catch(error => console.error(error));

function loadUniverse(json) {
    json.forEach(universe => {
        universeList.innerHTML += `<a class="universe" href="pages/worlds.html?universe_id=${universe.id}&universe_name=${universe.name}">
                                    <div class="icon" style="--color-icon: ${universe.colors[0]}; --color-theme: ${universe.colors[1]}">
                                        <i class="${universe.icon} fa-fw"></i>
                                    </div>
                                    <p class="name">${universe.name}</p>
                                </a>`
    });
}
