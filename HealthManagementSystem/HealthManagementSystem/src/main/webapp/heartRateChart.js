// Get the canvas element
var canvas = document.getElementById('heartRateChart');

// Define the heart rate data
var heartRateData = {
    labels: ['Day 1', 'Day 2', 'Day 3', 'Day 4', 'Day 5', 'Day 6', 'Day 7'],
    datasets: [{
        label: 'Heart Rate',
        data: [70, 72, 68, 75, 78, 80, 72],
        fill: false,
        borderColor: 'rgb(75, 192, 192)',
        tension: 0.1
    }]
};

// Create the chart
var heartRateChart = new Chart(canvas, {
    type: 'line',
    data: heartRateData
});
