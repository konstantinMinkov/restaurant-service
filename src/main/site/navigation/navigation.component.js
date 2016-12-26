angular.module('restaurant-service').component('navigation', {
    templateUrl: 'navigation.template.html',
    controller: ['$scope', 'Redirect', 'User',
        function ($scope, Redirect, User) {
            $scope.Redirect = Redirect;
            $scope.User = User;
        }
    ]
});
