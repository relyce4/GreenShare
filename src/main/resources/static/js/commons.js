function searchCoordinates(string) {
    var coordinates;
    $.ajax({
        url: location.protocol + '//nominatim.openstreetmap.org/search?format=json&q=' + string,
        success: function (data) {
            coordinates = `${data[0].boundingbox[0]};${data[0].boundingbox[2]}`;
        },
        async: false
    });
    return coordinates
}

function getOngoingRents(rentList) {
    if (!$.isEmptyObject(rentList)) {
        return rentList.filter(rent => rent.endTime == null);
    }
    return null;
}

function getRentsByUser(rentList, userId) {
    return rentList.filter(rent => rent.user.id == userId);
}

function getOngoingRentsByUser(rentList, userId) {
    if (!$.isEmptyObject(rentList)) {
        return getOngoingRents(rentList).filter(rent => rent.user.id == userId);
    }
    return null;
}

function getAvailableVehicles(rentList, vehicleList) {
    if (!$.isEmptyObject(rentList)) {
        var ongoingRents = getOngoingRents(rentList);

        return vehicleList.filter(function (vehicle) {
            return !ongoingRents.find(function (rent) {
                return vehicle.id == rent.vehicle.id;
            });
        });
    }

    return null;
}

function getUserVehicles(rentList, userId) {
    var userOngoingRentList = getOngoingRentsByUser(rentList, userId);
    var userVehicleList = [];
    for (const key in userOngoingRentList) {
        if (userOngoingRentList[key].user.id == userId) {
            userVehicleList.push(userOngoingRentList[key].vehicle);
        }
    }
    return userVehicleList;
}
