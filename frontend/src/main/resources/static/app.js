$(document).ready(function () {
    // Execute this code when the document is ready

    // Use AJAX to fetch data from the API
    $.ajax({
        url: "/api/forecasts",
        type: "GET",
        success: function (data) {
            // Handle the successful response
            displayData(data);
        },
        error: function () {
            // Handle errors
            console.error("Failed to fetch data from the API");
        }
    });

    function updateFirstDay(data) {
        var item = data[0];
        return '<div class="today forecast">\n' +
            '<div class="forecast-header">\n' +
            '<div class="day">' + item.dayOfWeek + '</div>\n' +
            '<div class="date">' + item.formattedDate + '</div>\n' +
            '</div> <!-- .forecast-header -->\n' +
            '<div class="forecast-content">\n' +
            '<div class="location" id="locationID"></div>\n' +
            '<div class="location" id="locationPhenomenon"></div>\n' +
            '<div class="degree">\n' +
            '<div class="num1">' + item.tempmax + '<sup>o</sup>C</div>\n' +
            '<small>' + item.tempmin + '<sup>o</sup>C</small>\n' +
            '</div>\n' +
            '<div class="day" id="placePhenomenon">' + item.phenomenon + '</div>\n' +
            '</div>\n' +
            '</div>';
    }

    function displayData(data) {
        var dataContainer = $("#data-container");
        dataContainer.empty();

        var firstDay = updateFirstDay(data);
        dataContainer.append(firstDay);

        for (var i = 1; i < data.length; i++) {
            var item = data[i];
            var newForecastDiv = $('<div class="forecast">');
            var newHeaderDiv = $('<div class="forecast-header">');
            var dayDiv = $('<div class="day">').text(item.dayOfWeek);
            newHeaderDiv.append(dayDiv);

            var newContentDiv = $('<div class="forecast-content">');

            var degreeDiv = $('<div class="degree">').text(item.tempmax + '°C');
            var smallDegreeDiv = $('<small>').text(item.tempmin + '°');
            newContentDiv.append(degreeDiv, smallDegreeDiv);
            newForecastDiv.append(newHeaderDiv, newContentDiv);

            dataContainer.append(newForecastDiv);
        }
    }
});

function searchWeather() {
    var searchElement = document.getElementById("search-input");
    $.ajax({
        url: "/api/forecastsByPlace/" + searchElement.value,
        type: "GET",
        success: function (data) {
            // Handle the successful response
            console.log("data", data);

            var locationID = document.getElementById("locationID");
            locationID.innerHTML = "Current Temprature in " + data.name + ": " + data.temp + "°C";

            var locationPhenomenon = document.getElementById("locationPhenomenon");
            locationPhenomenon.innerHTML = "Phenomenon: " + data.phenomenon;

        },
        error: function () {
            // Handle errors
            console.error("Failed to fetch data from the API");
        }
    });
}
