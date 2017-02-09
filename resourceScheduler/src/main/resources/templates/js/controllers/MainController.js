angular.module('resourceApp').controller('MainController', function ($scope) {
    $scope.title = "Resource Scheduler";

    var acc = document.getElementsByClassName("accordion");
    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].onclick = function () {
			/* Toggle between adding and removing the "active" class,
			to highlight the button that controls the panel */
            this.classList.toggle("active");

            /* Toggle between hiding and showing the active panel */
            var panel = this.nextElementSibling;
            if (panel.style.display === "block") {
                panel.style.display = "none";
            } else {
                panel.style.display = "block";
            }
        }
    }
    var image = new ol.style.Circle({
        radius: 5,
        fill: null,
        stroke: new ol.style.Stroke({ color: 'red', width: 1 })
    });

    var styleFunction = function (feature) {
        var properties = feature.getProperties();
        var type = feature.getGeometry().getType();
        if (type === 'Circle') {
            return new ol.style.Style({
                stroke: new ol.style.Stroke({
                    color: 'red',
                    width: 2
                }),
                fill: new ol.style.Fill({
                    color: 'rgba(255,0,0,0.2)'
                })
            })
        } else {
            var colour = 'green';
            var desk = false;
            if (properties.deskName === 'Layout_Desk') {
                colour = 'rgba(9,20,147,0.2)'
            } else if (properties.deskName === 'Layout') {
                colour = 'rgba(40,160,228,0.8)'
            } else {
                desk = true;
                if (properties.status === 'Booked') {
                    colour = 'red';
                }
            }
            return new ol.style.Style({
                stroke: new ol.style.Stroke({
                    color: colour,
                    width: 3
                }),
                fill: new ol.style.Fill({
                    color: colour
                }),
                text: new ol.style.Text({
                    font: '10px Arial,sans-serif',
                    fill: new ol.style.Fill({ color: '#000' }),
                    text: desk ? properties.deskName : ""
                })
            })
        }
    };

    var geojsonObject = {
        'type': 'FeatureCollection',
        'crs': {
            'type': 'name',
            'properties': {
                'name': 'EPSG:3857'
            }
        },
        'features': [
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'Layout'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-62e6, -15e6], [-63e6, -15e6], [-63e6, -10e6], [-62e6, -10e6], [-62e6, -6e6], [-63e6, -6e6], [-63e6, -1e6], [-62e6, -1e6], [-62e6, 1e6], [-38e6, 1e6], [-38e6, -10e6], [-33e6, -10e6], [-33e6, 1e6], [-3e6, 1e6], [-3e6, -1e6], [-2e6, -1e6], [-2e6, -6e6], [-3e6, -6e6], [-3e6, -10e6], [-2e6, -10e6], [-2e6, -15e6], [-3e6, -15e6], [-3e6, -20e6], [-62e6, -20e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'Layout_Desk'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-25e6, -6e6], [-4e6, -6e6], [-4e6, -10e6], [-25e6, -10e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'Layout_Desk'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-25e6, -15e6], [-4e6, -15e6], [-4e6, -19e6], [-25e6, -19e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'Layout_Desk'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-61e6, -15e6], [-40e6, -15e6], [-40e6, -19e6], [-61e6, -19e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC1',
                    'deskProperties': 'Telephone, Space for 4'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-36e6, -15e6], [-33e6, -15e6], [-33e6, -19e6], [-36e6, -19e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC48',
                    'status': 'Available',
                    'deskProperties': 'Telephone'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-46e6, -17.5e6], [-41e6, -17.5e6], [-41e6, -18.5e6], [-46e6, -18.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC47',
                    'status': 'Available',
                    'deskProperties': 'Telephone'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-53e6, -17.5e6], [-48e6, -17.5e6], [-48e6, -18.5e6], [-53e6, -18.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC46',
                    'status': 'Available',
                    'deskProperties': 'Telephone'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-60e6, -17.5e6], [-55e6, -17.5e6], [-55e6, -18.5e6], [-60e6, -18.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC45',
                    'status': 'Available',
                    'deskProperties': 'Telephone'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-60e6, -15.5e6], [-55e6, -15.5e6], [-55e6, -16.5e6], [-60e6, -16.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC44',
                    'status': 'Available',
                    'deskProperties': 'Telephone'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-53e6, -15.5e6], [-48e6, -15.5e6], [-48e6, -16.5e6], [-53e6, -16.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC43',
                    'status': 'Available',
                    'deskProperties': 'Telephone'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-46e6, -15.5e6], [-41e6, -15.5e6], [-41e6, -16.5e6], [-46e6, -16.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC42',
                    'status': 'Available',
                    'deskProperties': 'Telephone, USB Keyboard'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-24e6, -6.5e6], [-19e6, -6.5e6], [-19e6, -7.5e6], [-24e6, -7.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC41',
                    'status': 'Booked',
                    'deskProperties': 'Telephone, Monitor, USB Keyboard'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-17e6, -6.5e6], [-12e6, -6.5e6], [-12e6, -7.5e6], [-17e6, -7.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC40',
                    'status': 'Booked',
                    'deskProperties': 'Telephone, Monitor'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-10e6, -6.5e6], [-5e6, -6.5e6], [-5e6, -7.5e6], [-10e6, -7.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC39',
                    'status': 'Available',
                    'deskProperties': 'Telephone, Monitor'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-24e6, -8.5e6], [-19e6, -8.5e6], [-19e6, -9.5e6], [-24e6, -9.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC38',
                    'status': 'Booked',
                    'deskProperties': 'Telephone, Monitor, USB Keyboard'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-17e6, -8.5e6], [-12e6, -8.5e6], [-12e6, -9.5e6], [-17e6, -9.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC37',
                    'status': 'Booked',
                    'deskProperties': 'Telephone'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-10e6, -8.5e6], [-5e6, -8.5e6], [-5e6, -9.5e6], [-10e6, -9.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC36',
                    'status': 'Available',
                    'deskProperties': 'Telephone'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-24e6, -15.5e6], [-19e6, -15.5e6], [-19e6, -16.5e6], [-24e6, -16.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC35',
                    'status': 'Available',
                    'deskProperties': 'Telephone'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-17e6, -15.5e6], [-12e6, -15.5e6], [-12e6, -16.5e6], [-17e6, -16.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC34',
                    'status': 'Available',
                    'deskProperties': 'Telephone'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-10e6, -15.5e6], [-5e6, -15.5e6], [-5e6, -16.5e6], [-10e6, -16.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC33',
                    'status': 'Booked',
                    'deskProperties': 'Telephone'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-10e6, -17.5e6], [-5e6, -17.5e6], [-5e6, -18.5e6], [-10e6, -18.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC32',
                    'status': 'Booked',
                    'deskProperties': 'Telephone'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-17e6, -17.5e6], [-12e6, -17.5e6], [-12e6, -18.5e6], [-17e6, -18.5e6]]]
                }
            },
            {
                'type': 'Feature',
                'properties': {
                    'deskName': 'HC31',
                    'status': 'Booked',
                    'deskProperties': 'Telephone'
                },
                'geometry': {
                    'type': 'Polygon',
                    'coordinates': [[[-24e6, -17.5e6], [-19e6, -17.5e6], [-19e6, -18.5e6], [-24e6, -18.5e6]]]
                }
            }
        ]
    };

    var vectorSource = new ol.source.Vector({
        wrapX: false,
        features: (new ol.format.GeoJSON()).readFeatures(geojsonObject)
    });

    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-20e6, -3e6], 2.5e6))); //Arch Seat

    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-60e6, -12e6], 1.5e6)));	//DiningTable 1
    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-60e6, -14.1e6], 0.4e6))); //Seat1
    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-57.9e6, -12.2e6], 0.4e6))); //Seat2
    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-62.1e6, -12e6], 0.4e6))); //Seat3
    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-60e6, -9.9e6], 0.4e6))); //Seat4

    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-55e6, -10e6], 1.5e6)));	//DiningTable 2
    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-55e6, -12.2e6], 0.4e6))); //Seat1
    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-55e6, -7.9e6], 0.4e6))); //Seat2
    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-57.1e6, -10e6], 0.4e6))); //Seat3
    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-52.9e6, -10e6], 0.4e6))); //Seat4

    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-59e6, -7e6], 1.5e6))); //DiningTable 3
    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-60e6, -5.2e6], 0.4e6))); //Seat1
    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-60.7e6, -8.1e6], 0.4e6))); //Seat2
    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-57.2e6, -6e6], 0.4e6))); //Seat3
    vectorSource.addFeature(new ol.Feature(new ol.geom.Circle([-57.9e6, -8.8e6], 0.4e6))); //Seat4

    var vectorLayer = new ol.layer.Vector({
        source: vectorSource,
        style: styleFunction
    });

    var map = new ol.Map({
        layers: [
            vectorLayer
        ],
        target: 'map',
        controls: ol.control.defaults({
            attributionOptions: ({
                collapsible: false
            })
        }),
        view: new ol.View({
            center: [-25e6, -10e6],
            zoom: 2
        })
    });

    map.on("click", function (e) {
        map.forEachFeatureAtPixel(e.pixel, function (feature, layer) {
            var properties = feature.getProperties();
            var coordinate = feature.getGeometry().getCoordinates();
            try {
                if (!properties.deskName.includes("Layout")) {
                    acc[1].classList.toggle("active", true);
                    var panel = acc[1].nextElementSibling;
                    panel.style.display = "block";

                    feature.getProperties().status = "Booked";
                    $scope.deskName = "Desk " + properties.deskName;
                    $scope.deskProperties = properties.deskProperties;   
                    $scope.$apply();                
                }
            } catch (e) {
                console.log("Not a desk");
            }
        })
    });
}
);
