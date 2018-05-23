'use strict'

angular.module('myApp').controller('UserController', ['$scope', 'UserService',
function($scope, UserService) {
    var self = this;
    //  model-user
    self.user = {userId: null, name: "", age:"", salary: ""};
    self.users=[];

    fetchAllUsers();

    //fetchAllUser
    function fetchAllUsers(){
        UserService.fetchAllUsers()
            .then(
                function(d) {
                    self.users = d;
                    console.log(self.users);
                },
                function(errResponse){
                    console.error('Error while fetching Users');
                });
    }

    //



}]);
