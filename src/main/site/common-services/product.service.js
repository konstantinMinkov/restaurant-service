angular.module('restaurant-service').factory('Products', [
    'Http',
    function(Http) {
        return {
            loadAll: function () {
                var promise = Http.get('/api/products');
                return promise;
            }
        }
    }
]);
