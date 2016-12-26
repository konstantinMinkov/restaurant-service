angular.module('restaurant-service').factory('Http', [
    '$q', '$http', 'Backoff',
    function($q, $http, Backoff) {
        return {
            get: function (url) {
                var defered = $q.defer();
                var backoff = new Backoff(3000, 24000);
                function doGet(url) {
                    $http.get(url)
                        .then(function (body) {
                            defered.resolve(body);
                        })
                        .catch(function (body) {
                            console.log(body);
                            console.log(new Date().getSeconds());
                            if (body.status < 100) {
                                setTimeout(
                                    doGet(url), backoff.getNext()
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
                var backoff = new Backoff(3000, 24000);
                function doPost(url, data) {
                    $http.post(url, data)
                         .then(function (body) {
                             defered.resolve(body);
                         })
                         .catch(function (body) {
                             console.log(body);
                             console.log(new Date().getSeconds());
                             if (body.status < 100) {
                                 setTimeout(
                                     doPost(url, data), backoff.getNext()
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
