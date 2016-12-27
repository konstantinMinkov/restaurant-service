angular.module('restaurant-service').factory('Backoff', [
    function () {
        return function (start, end) {
            this.current = start;
            this.max = end;
            this.getDelay = function () {
                var randomDelay = Math.random() * 0.1 * this.current;
                var current = this.current + randomDelay;
                var next = this.current * 2;
                if (next <= this.max) {
                    this.current = next;
                }
                return current;
            }
        }
    }
]);

