angular.module('restaurant-service').factory('Storage', [
    '$window',
    function($window) {
        return {
            save: function (key, value) {
                $window.localStorage.setItem(key, value);
            },
            get: function (key) {
                return $window.localStorage.getItem(key);
            },
            exists: function (key) {
                return $window.localStorage.getItem(key) !== null;
            },
            remove: function (key) {
                return $window.localStorage.removeItem(key);
            }
        }
    }
]);
