angular.module('restaurant-service').factory('Cart', [
    'Http',
    function(Http) {
        var cart = {
            productIds: []
        };

        var addProduct = function (productId) {
            cart.productIds.push(productId);
        };

        var isEmpty = function (productId) {
            return cart.productIds.length > 0;
        };

        var size = function () {
            return cart.productIds.length;
        };

        return {
            addProduct: addProduct,
            isEmpty: isEmpty,
            size: size
        }
    }
]);
