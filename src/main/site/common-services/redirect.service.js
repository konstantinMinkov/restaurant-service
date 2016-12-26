angular.module('restaurant-service').factory('Redirect', [
    '$location',
    function($location) {
        return {
            to: function (path) {
                $location.path(path);
            }
        }
    }
]);
