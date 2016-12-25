angular.module('restaurant-service').factory('User', [
    '$http', 'Token',
    function($http, Token) {
        return {
            create: function (user) {
                return $http.post('/api/users/new', user);
            },
            login: function (login, password) {
                return $http.post('/api/auth/login', {
                    login: login,
                    password: password
                }).then(function (responce) {
                    Token.save(responce.data.token);
                })
            },
            isAuthenticated: function () {
                return Token.exists();
            }
        }
    }
]);