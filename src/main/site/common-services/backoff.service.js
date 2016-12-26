angular.module('restaurant-service').factory('Backoff', [
    function () {
        return function (start, end) {
            this.current = start;
            this.max = end;
            this.getDelay = function () {
                var next = this.current * 2;
                if (next > this.max) {
                    return this.max;
                }
                this.current = next;
                return next;
            }
        }
    }
]);

