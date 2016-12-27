angular.module('restaurant-service').factory('Http', [
    '$q', '$http', 'Backoff',
    function($q, $http, Backoff) {
        return {
            get: function (url) {
                var defered = $q.defer();
                var backoff = new Backoff(2000, 35000);
                function doGet(url) {
                    $http.get(url)
                        .then(function (body) {
                            defered.resolve(body);
                        })
                        .catch(function (body) {
                            if (body.status < 100) {
                                setTimeout(
                                    function () {
                                        doPost(url, data);
                                    }, backoff.getDelay()
                                );
                            } else {
                                defered.reject(body);
                            }
                        });
                }
                doGet(url);
                return defered.promise;
            },
            post: function (url, data) {
                var defered = $q.defer();
                var backoff = new Backoff(2000, 35000);
                function doPost(url, data) {
                    $http.post(url, data)
                         .then(function (body) {
                             defered.resolve(body);
                         })
                         .catch(function (body) {
                             if (body.status < 100) {
                                 var delay = backoff.getDelay();
                                 console.log(delay);
                                 setTimeout(
                                     function () {
                                         doPost(url, data);
                                     }, delay
                                 );
                             } else {
                                 defered.reject(body);
                             }
                         });
                }
                doPost(url, data);
                return defered.promise;
            }
        }
    }
]);
