angular.module('restaurant-service').factory('Products', [
    'Http',
    function(Http) {
        return {
            loadAll: function () {
                return Http.get('/api/products');
            }
        }
    }
]);
