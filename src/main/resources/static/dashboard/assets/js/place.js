$(document).ready(() => {
        const togoCoord = {
            latitude: 6.4067,
            longitude: 1.8951
        };

        const map = new IMap('map', togoCoord.latitude, togoCoord.longitude, 10);
        map.addTile('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
        });

        // ajouter le champ de recherche
        map.addSearchControl((result) => {
            document.getElementById("address-input").value = result.properties["LongLabel"];
            document.getElementById("city-input").value = result.properties["City"];
            document.getElementById("country-input").value = result.properties["Country"];
            document.getElementById("latlng-input").value = result["latlng"]['lat'] + "," + result["latlng"]['lng'];
            document.getElementById("region-input").value = result.properties["Region"];
        });
        // ajouter la localisation au click
        map.mouseLocation((result) => {
            document.getElementById("place").value = result.address["LongLabel"];
            document.getElementById("fplace").value = result.address["LongLabel"]
        });
    }
)