$(".navbar").removeClass("shadow-3-strong");
$(".navbar").addClass("shadow-0");

document.addEventListener("scroll", function () {
    if (window.pageYOffset == 0) {
        $(".navbar").addClass("shadow-0");
        $(".navbar").removeClass("shadow-3-strong");
    } else {
        $(".navbar").addClass("shadow-3-strong");
        $(".navbar").removeClass("shadow-0");
    }
});

const teslaData = {
    labels: [
        'Emissioni CO2 al km',
        'Costo rifornimento per 100km',
        'Potenza in kW',
    ],
    datasets: [{
        label: 'Renault Clio',
        data: [534, 312, 100],
        backgroundColor: [
            'rgb(255, 212, 128)',
            'rgb(93, 176, 127)',
            'rgb(247, 116, 139)',
        ]
    }, {
        label: 'Tesla Model S',
        data: [100, 100, 600],
        backgroundColor: [
            'rgb(255,169,0)',
            'rgb(0, 183, 74)',
            'rgb(249, 49, 84)',
        ]
    }

]
};
const teslaConfig = {
    type: 'bar',
    data: teslaData,
    options: { borderWidth: '1' }
};

teslaCard.onclick = function () {
    if (myChart) {
        myChart.destroy();
    }
    myChart = new Chart(
        document.getElementById('myChart'),
        teslaConfig
    );
}

// Carica valore di default
var myChart = new Chart(
    document.getElementById('myChart'),
    teslaConfig
);

const bmwData = {
    labels: [
        'Emissioni CO2 al km',
        'Costo rifornimento per 100km',
        'Potenza in kW'
    ],
    datasets: [{
        label: 'Renault Clio',
        data: [207, 850, 100],
        backgroundColor: [
            'rgb(255, 212, 128)',
            'rgb(93, 176, 127)',
            'rgb(247, 116, 139)',
        ]
    }, {
        label: 'BMW i3',
        data: [100, 100, 162],
        backgroundColor: [
            'rgb(255,169,0)',
            'rgb(0, 183, 74)',
            'rgb(249, 49, 84)',
        ]
    }]
};
const bmwConfig = {
    type: 'bar',
    data: bmwData,
    options: { borderWidth: '1' }
};

bmwCard.onclick = function () {
    if (myChart) {
        myChart.destroy();
    }
    myChart = new Chart(
        document.getElementById('myChart'),
        bmwConfig
    );
}

const fiatData = {
    labels: [
        'Emissioni CO2 al km',
        'Costo rifornimento per 100km',
        'Potenza in kW'
    ],
    datasets: [{
        label: 'Renault Clio',
        data: [1000, 947, 100],
        backgroundColor: [
            'rgb(255, 212, 128)',
            'rgb(93, 176, 127)',
            'rgb(247, 116, 139)',
        ]
    }, {
        label: 'FIAT 500-e',
        data: [100, 100, 117],
        backgroundColor: [
            'rgb(255,169,0)',
            'rgb(0, 183, 74)',
            'rgb(249, 49, 84)',
        ]
    }]
};
const fiatConfig = {
    type: 'bar',
    data: fiatData,
    options: { borderWidth: '1' }
};

fiatCard.onclick = function () {
    if (myChart) {
        myChart.destroy();
    }
    myChart = new Chart(
        document.getElementById('myChart'),
        fiatConfig
    );
}

const scooterData = {
    labels: [
        'Emissioni CO2 al km',
        'Costo rifornimento per 100km',
        'Potenza in kW'
    ],
    datasets: [{
        label: 'Renault Clio',
        data: [139, 12.50, 74],
        backgroundColor: [
            'rgb(255, 212, 128)',
            'rgb(93, 176, 127)',
            'rgb(247, 116, 139)',
        ]
    }, {
        label: 'Monopattino Elettrico',
        data: [9.1, 0.24, 0.6],
        backgroundColor: [
            'rgb(255,169,0)',
            'rgb(0, 183, 74)',
            'rgb(249, 49, 84)',
        ]
    }]
};
const scooterConfig = {
    type: 'bar',
    data: scooterData,
    options: { borderWidth: '1' }
};

scooterCard.onclick = function () {
    if (myChart) {
        myChart.destroy();
    }
    myChart = new Chart(
        document.getElementById('myChart'),
        scooterConfig
    );
}

const bikeData = {
    labels: [
        'Emissioni CO2 al km',
        'Costo rifornimento per 100km',
        'Potenza in kW'
    ],
    datasets: [{
        label: 'Renault Clio',
        data: [139, 12.50, 74],
        backgroundColor: [
            'rgb(255, 212, 128)',
            'rgb(93, 176, 127)',
            'rgb(247, 116, 139)',
        ]
    }, {
        label: 'Bicicletta Elettrica',
        data: [4.55, 0.12, 0.3],
        backgroundColor: [
            'rgb(255,169,0)',
            'rgb(0, 183, 74)',
            'rgb(249, 49, 84)',
        ]
    }]
};

const bikeConfig = {
    type: 'bar',
    data: bikeData,
    options: { borderWidth: '1' }
};

bikeCard.onclick = function () {
    if (myChart) {
        myChart.destroy();
    }
    myChart = new Chart(
        document.getElementById('myChart'),
        bikeConfig
    );
}
