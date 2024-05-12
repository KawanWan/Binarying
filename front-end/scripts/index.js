const universeList = document.querySelector('.universe-list');

fetch('http://localhost:8080/api/universe')
    .then(response => response.json())
    .then(json => loadUniverse(json))
    .catch(error => console.error(error));

function loadUniverse(json) {
    json.forEach(universe => {
        universeList.innerHTML += `<a class="universe" href="pages/worlds.html?universe=${universe.id}">
                                    <div class="icon" style="--color-icon: ${universe.colors[0]}; --color-theme: ${universe.colors[1]}">
                                        <i class="${universe.icon} fa-fw"></i>
                                    </div>
                                    <p class="name">${universe.name}</p>
                                </a>`
    });
}
