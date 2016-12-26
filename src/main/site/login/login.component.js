angular.module('restaurant-service').component('login', {
    templateUrl: 'login.template.html',
    controller: ['$scope', 'User',
        function ($scope, User) {
            $scope.user = {};

            $scope.User = User;
        }
    ]
});
