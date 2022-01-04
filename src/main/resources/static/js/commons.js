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