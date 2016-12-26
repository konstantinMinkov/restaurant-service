angular.module('restaurant-service').factory('User', [
    'Http', 'Storage', 'Redirect',
    function(Http, Storage, Redirect) {
        return {
            create: function (user) {
                return Http.post('/api/users/new', user).then(function (response) {
                    Redirect.to('/');
                });
            },
            login: function (user) {
                return Http.post('/api/auth/login', user).then(function (response) {
                    Storage.save('username', user.login);
                    Redirect.to('/');
                });
            },
            isAuthenticated: function () {
                return Storage.exists('username');
            },
            logout: function () {
                Http.get('/api/auth/logout').then(function (response) {
                    Storage.remove('username');
                    Redirect.to('/');
                });
            },
            getUsername: function () {
                return Storage.get('username');
            }
        }
    }
]);