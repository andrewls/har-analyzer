/**
 * Created by andrew on 8/3/16.
 */
angular.module('harAnalyzer.controllers', ['harAnalyzer.services'])
.controller('HarCtrl', function($scope, ApiService) {
    var har = this;
    har.json = ''

    har.submit = function() {
        if (har.json) {
            ApiService.analyzeHarJson(har.json).then(function(response) {
                har.analysis = response.data;
                console.log("Analysis was set to", response.data);
            }, function() {
                alert("There was an error posting the data!");
            });
        }
        else if (har.file) {
            ApiService.analyzeHarFile(har.file).then(function(response) {
                har.analysis = response.data;
            }, function() {
                alert("There was an error posting the HAR file!");
            })
        }
        else {
            alert("You must either paste json in or upload a valid HAR file");
        }
    };

    har.clearResults = function() {
        har.analysis = null;
    };

    har.clearFiles = function() {
        har.clearResults();
        $scope.$broadcast('file-input-should-clear');
    };

    har.clearJson = function() {
        har.clearResults();
        har.json = '';
    };

    har.fileInputChanged = function(file) {
        har.file = file;
    }
});