angular.module('restaurant-service').config([
    '$routeProvider',
    function ($routeProvider) {
        $routeProvider
            .when('/', {
                template: '<main></main>'
            })
            .when('/login', {
                template: '<login></login>'
            })
            .when('/signup', {
                template: '<signup></signup>'
            })
            .otherwise('/');
    }
]);