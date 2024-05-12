const universeList = document.querySelector('.universe-list');

fetch('http://localhost:8080/api/universe')
    .then(response => response.json())
    .then(json => loadUniverse(json))
    .catch(error => console.error(error));

function loadUniverse(json) {
    json.forEach(universe => {
        universeList.innerHTML += `<div class="universe">
                                    <div class="icon" style="--color-theme: ${universe.colors[0]}">
                                        <i class="fa-solid fa-image"></i>
                                    </div>
                                    <p class="name">${universe.name}</p>
                                </div>`
    });
}
