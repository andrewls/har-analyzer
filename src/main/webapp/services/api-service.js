/**
 * Created by andrew on 8/3/16.
 */
angular.module('harAnalyzer.services', [])
    .service('ApiService', ['$http', '$q', function($http, $q) {
        // normally I would use $resource instead of $http and $q, but where it's just one request, it seems like overkill
        var service = {};

        service.analyzeHarJson = function(json) {
            var deferred = $q.defer();
            $http.post('webapi/http-archive', json).then(deferred.resolve, deferred.reject);
            return deferred.promise;
        };

        service.analyzeHarFile = function(file) {
            var deferred = $q.defer();
            // Check for the various File API support.
            if (window.File && window.FileReader && window.FileList && window.Blob) {
                if (file) {
                    var reader = new FileReader();
                    reader.onload = function(event) {
                        var contents = event.target.result;
                        service.analyzeHarJson(contents).then(deferred.resolve, deferred.reject);
                    }
                    reader.readAsText(file);
                }
                else {
                    deferred.reject("You must provide a valid file to read.");
                }
            }
            else {
                deferred.reject("Your browser doesn't support the file reader API! You must support the file reader API to upload files.");
            }
            return deferred.promise;
        };

        return service;
    }]);