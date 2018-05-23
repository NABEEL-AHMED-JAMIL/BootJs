'use strict'

angular.module('myApp').config(function($routeProvider) {

    $routeProvider
        .when("/", {
            // "Home",
            templateUrl : "index.jsp",
        })
        // .when("/rtb.2.5", {
        //     // "RTB-2.5=>Map"
        //     templateUrl : "rtb2.5.jsp",
        //     controller : "rtb.2.5.controller"
        // })
        // .when("/geoMap", {
        //     // "Geo-Map"
        //     templateUrl : "geoMap.jsp",
        //     controller : "geoMapController"
        // }
        // .when("/adServer", {
        //     // "Ad-Server.1.0"
        //     templateUrl : "adServer.jsp",
        //     controller : "adServerController"
        // }
        // .when("/test", {
        //     // "Test"
        //     templateUrl : "test.jsp",
        //     controller : "testController"
        // });
});