'use strict'

angular.module('myApp').factory('UserService', ['$http', '$q',
function ($http, $q) {
    // url for api-call

    var REST_SERVICE_URI = 'http://localhost:8080/bootjs/api';
    console.log(REST_SERVICE_URI);

    var factory = {
        // fetch-opereation
        fetchAllUsers: fetchAllUsers,
        fetchUserByUserId: fetchUserByUserId,
        // create-opereation
        createUser: createUser,
        updateUser: updateUser,
        //delete-opereation
        deleteAllUsers: deleteAllUsers,
        deleteUserByUserId: deleteUserByUserId
    };

    return factory;

    //===================================================
    // fetchAllUsers
    function fetchAllUsers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+'/users').
            then(
                function(response){
                    deferred.resolve(response.data);
                }, 
                function(errResponse){
                    console.log(`Error While fetcing User`);
                    deferred.reject(errResponse);
                });
        return deferred.promise;
    }

    //fetchUserByuserId
    function fetchUserByUserId(userId) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+'/user'+userId).
            then(
                function(response){
                    deferred.resolve(response.data);
                }, 
                function(errResponse){
                    console.log(`Error While fetcing User`);
                    deferred.reject(errResponse);
                });
        return deferred.promise;

    }
    //===================================================
    //createUser
    function createUser(user) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI+'/user', user).
            then(
                function(response){
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.log(`Error While Create User`);
                    deferred.reject(errResponse);
                });
        return deferred.promise;
    }

    //updateUser
    function updateUser(user, userId) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI+userId, user).
            then(
                function(response){
                    deferred.resolve(response);
                },
                function(errResponse){
                    console.log(`Error While Create User`);
                    deferred.reject(errResponse);
                });
        return deferred.promise;
    }

    //===================================================
    //deleteUser
    function deleteAllUsers(){
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI+`/user/deletes`).
            then(
                function(response){
                    deferred.resolve(response);
                },
                function(errResponse){
                    console.log(`Error While Delete User's`);
                    deferred.reject(errResponse);
                });
        return deferred.promise;
    }
    
    //deleteUserByuserId
    function deleteUserByUserId(userId){
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+'user'+userId).
            then(
                function(response){
                    deferred.resolve(response);
                },
                function(errResponse){
                    console.log(`Error While Delete User by userId` + userId);
                    deferred.reject(errResponse);
                });
        return deferred.promise;
    }
}]);
