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

var myChart;

const defaultData = {
    labels: [
        'Risparmio CO2',
        'Praticità',
        'Riciclabilità',
        'Convenienza al Km',
        'Sicurezza'
    ],
    datasets: [{
        label: 'Auto Elettrica',
        data: [0, 0, 0, 0, 0],
        backgroundColor: [
            'rgb(255, 99, 132)',
            'rgb(75, 192, 192)',
            'rgb(255, 205, 86)',
            'rgb(201, 203, 207)',
            'rgb(54, 162, 235)'
        ]
    }]
};
const defaultConfig = {
    type: 'bar',
    data: defaultData,
    options: {}
};

myChart = new Chart(
    document.getElementById('myChart'),
    defaultConfig
);

const carData = {
    labels: [
        'Risparmio CO2',
        'Praticità',
        'Riciclabilità',
        'Convenienza al Km',
        'Sicurezza'
    ],
    datasets: [{
        label: 'Auto Elettrica',
        data: [5, 10, 3, 5, 10],
        backgroundColor: [
            'rgb(255, 99, 132)',
            'rgb(75, 192, 192)',
            'rgb(255, 205, 86)',
            'rgb(201, 203, 207)',
            'rgb(54, 162, 235)'
        ]
    }]
};
const carConfig = {
    type: 'bar',
    data: carData,
    options: { borderWidth: '1' }
};

// carCard.onclick = function () {
//     if (myChart) {
//         myChart.destroy();
//     }
//     myChart = new Chart(
//         document.getElementById('myChart'),
//         carConfig
//     );
// }

const scooterData = {
    labels: [
        'Risparmio CO2',
        'Praticità',
        'Riciclabilità',
        'Convenienza al Km',
        'Sicurezza'
    ],
    datasets: [{
        label: 'Monopattino Elettrico',
        data: [8, 7, 7, 8, 3],
        backgroundColor: [
            'rgb(255, 99, 132)',
            'rgb(75, 192, 192)',
            'rgb(255, 205, 86)',
            'rgb(201, 203, 207)',
            'rgb(54, 162, 235)'
        ]
    }]
};
const scooterConfig = {
    type: 'bar',
    data: scooterData,
    options: {borderWidth: '1' }
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
        'Risparmio CO2',
        'Praticità',
        'Riciclabilità',
        'Convenienza al Km',
        'Sicurezza'
    ],
    datasets: [{
        label: 'Monopattino Elettrico',
        data: [10, 8, 10, 10, 5],
        backgroundColor: [
            'rgb(255, 99, 132)',
            'rgb(75, 192, 192)',
            'rgb(255, 205, 86)',
            'rgb(201, 203, 207)',
            'rgb(54, 162, 235)'
        ]
    }]
};
const bikeConfig = {
    type: 'bar',
    data: bikeData,
    options: { borderWidth: '1'}
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
