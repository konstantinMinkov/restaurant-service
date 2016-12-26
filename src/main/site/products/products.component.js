angular.module('restaurant-service').component('products', {
    templateUrl: 'products.template.html',
    controller: ['$scope', 'Products', 'Cart',
        function ($scope, Products, Cart) {
            Products.loadAll().then(function (response) {
                $scope.products = response.data;
            });

            $scope.Cart = Cart;
        }
    ]
});
