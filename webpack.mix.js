let mix = require('laravel-mix')

mix.copyDirectory("node_modules/leaflet/dist", "src/main/resources/static/dashboard/assets/libs/leaflet/dist")
mix.copyDirectory("node_modules/esri-leaflet/dist", "src/main/resources/static/dashboard/assets/libs/esri-leaflet/dist")
mix.copyDirectory("node_modules/esri-leaflet-geocoder/dist", "src/main/resources/static/dashboard/assets/libs/esri-leaflet-geocoder/dist")