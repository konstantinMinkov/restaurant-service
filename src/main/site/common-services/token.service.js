angular.module('restaurant-service').factory('Token', [
    '$window',
    function($window) {
        return {
            save: function (token) {
                $window.localStorage.setItem('token', token);
            },
            get: function () {
                return $window.localStorage.getItem('token');
            },
            exists: function () {
                return $window.localStorage.getItem('token') !== null;
            }
        }
    }
]);
