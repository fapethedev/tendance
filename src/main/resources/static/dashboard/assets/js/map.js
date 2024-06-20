
/**
 * Créer une carte avec leaflet.
 *
 * @param div_id L'identifiant de l'élément HTML dans lequel la carte sera affichée.
 * @param default_pos_lat La latitude
 * @param default_pos_lng Lon longitude
 * @param zoom_level Le niveau de zoom.
 * @constructor
 */
var IMap = function(div_id, default_pos_lat, default_pos_lng, zoom_level)
{
   this.map = L.map(div_id, {
       center: [default_pos_lat, default_pos_lng],
       zoom : zoom_level
   }) ;

   this.layerGroup = new L.LayerGroup().addTo(this.map);
   this.geocodeService = L.esri.Geocoding.geocodeService({
       apikey: "AAPK3e6fdcd1ef9649018ad72de085545026fteEZ7IGPw-aHOBHLRBzwcabeywk28vXulGzrsd-SHfoO1RaNWOme_UQTlsIIyOv"
   });

   this.addTile = function (layer_url, options)
   {
        L.tileLayer(layer_url, options).addTo(this.map) ;
        return this ;
   } ;

    /**
     * Ajouter un champ de recherche à la carte.
     * @param callback Méthode à appeler sur le résultat de la recherche.
     */
   this.addSearchControl = function (callback)
   {
       var searchControl = new L.esri.Geocoding.geosearch({
           providers: [L.esri.Geocoding.arcgisOnlineProvider({
               apikey: "AAPK3e6fdcd1ef9649018ad72de085545026fteEZ7IGPw-aHOBHLRBzwcabeywk28vXulGzrsd-SHfoO1RaNWOme_UQTlsIIyOv"
           })]
       }).addTo(this.map);

       searchControl.on('results', (data) => {
           this.layerGroup.clearLayers();
           for (var i = data.results.length - 1; i >= 0; i--)
           {
               var marker = L.marker(data.results[i].latlng).bindPopup(data.results[i].text) ;
               this.layerGroup.addLayer(marker);
               marker.openPopup() ;
               if(callback !== 'undefined' && callback !== null) {
                   callback(data.results[i]) ;
               }
           }
       });

       return this ;
   } ;

    /**
     * Ajouter un point de marquage sur la carte.
     *
     * @param lat La latitude
     * @param lng La longitude
     * @param text Le text du marqueur
     * @return {IMap}
     */
   this.addMarker = function(lat, lng, text)
   {
       let marker = L.marker([lat, lng]).bindPopup(text) ;
       this.layerGroup.addLayer(marker);
       marker.openPopup() ;

       return this ;
   } ;

    /**
     * Activer le bouton 'localiser moi'
     * @warning Ne fonctionne pas avec précision, ne pas utiliser avec l'activation
     * de la localisation au click.
     * @param callback Méthode à appeler sur le résultat de la recherche.
     * @deprecated
     */
   this.enableGeolocationButton = function (callback)
   {
       var geolocationBtn = L.control({position: "topright"}) ;
       geolocationBtn.onAdd = (mapReference) =>
       {
           var button = L.DomUtil.create('button', 'btn btn-default btn-sm') ;
           button.innerHTML = "Localiser moi !" ;
           button.type = "button" ;
           button.title = "Gélocalisation" ;
           // Action du clic sur le bouton
           button.onclick = () =>
           {
               this.layerGroup.clearLayers() ;

               mapReference.locate() ;
               mapReference.on('locationfound', (locationEvent) =>
               {
                   var circleRadius = locationEvent.accuracy / 20 ;
                   var circleCoord = locationEvent.latlng ;
                   var marker = L.marker(locationEvent.latlng).bindPopup("Vous êtes quelque part ici !");
                   this.layerGroup.addLayer(marker);
                   this.layerGroup.addLayer(L.circle(circleCoord, circleRadius));
                   marker.openPopup() ;
                   mapReference.setView(circleCoord, 16) ;

                   if(callback !== 'undefined' && callback !== null) {
                       callback(locationEvent) ;
                   }
               }) ;

               mapReference.on('locationerror', () =>
               {
                   swal({
                       text :"Il n'est pas possible de vous géolocaliser pour le moment, votre navigateur bloque peut être cette opération !",
                       button:"fermer",
                       icon:"warning"
                   })
               })
           } ;
           return button ;
       } ;
       geolocationBtn.addTo(this.map) ;

       return this ;
   } ;

    /**
     * Trouver l'adresse correspondante à une coordonée (point)
     * @param latlng Un tableau contenant des coordonnées de latitude et de longitude.
     * @param callback Méthode à appeler sur le résultat.
     */
   this.coordsToAddress = function(latlng, callback)
   {
       this.geocodeService.reverse().latlng(latlng).run((error, result) =>
       {
           this.layerGroup.clearLayers() ;
           var marker = L.marker(result.latlng).addTo(this.map).bindPopup(result.address.Match_addr) ;
           this.layerGroup.addLayer(marker) ;
           marker.openPopup();

           if(callback !== 'undefined' && callback !== null) {
               callback(result) ;
           }
       });
   } ;

    /**
     * Activer la localisation au click sur la map.
     * @warning Ne pas utiliser avec le bouton de géolocalisatio.
     * @param callback Méthode à appeler sur le résultat du click.
     */
   this.mouseLocation = function (callback)
   {
      this.map.on('click', (e)=>
      {
          this.coordsToAddress(e.latlng, callback) ;
      }) ;

      return this ;
   } ;

   L.control.scale().addTo(this.map);
} ;