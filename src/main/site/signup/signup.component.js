angular.module('restaurant-service').component('signup', {
    templateUrl: 'signup.template.html',
    controller: ['$scope', 'User',
        function ($scope, User) {
            $scope.user = {};

            $scope.User = User;
        }
    ]
});