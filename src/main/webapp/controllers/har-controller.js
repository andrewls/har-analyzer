/**
 * Created by andrew on 8/3/16.
 */
angular.module('harAnalyzer.controllers', ['harAnalyzer.services'])
.controller('HarCtrl', function($scope, ApiService) {
    console.log("In the har controller");
    var har = this;
    har.Math = window.Math; // angular apparently doesn't like using the window math functions in databindings, so we have to inject it here
    har.json = ''

    har.submit = function() {
        console.log("In the submit function");
        if (har.json) {
            har.loading = true;
            ApiService.analyzeHarJson(har.json).then(function(response) {
                har.analysis = response.data;
                console.log("Analysis was set to", response.data);
                har.loading = false;
            }, function() {
                alert("There was an error posting the data!");
                har.loading = false;
            });
        }
        else if (har.file) {
            har.loading = true;
            ApiService.analyzeHarFile(har.file).then(function(response) {
                console.log("Har file was analyzed, response:", response.data);
                har.analysis = response.data;
                har.loading = false;
            }, function() {
                alert("There was an error posting the HAR file!");
                har.loading = false;
            })
        }
        else {
            alert("You must either paste json in or upload a valid HAR file");
        }
    };

    har.clearResults = function() {
        console.log("Clearing results");
        har.analysis = null;
    };

    har.clearFiles = function() {
        console.log("Clearing files");
        har.clearResults();
        $scope.$broadcast('file-input-should-clear');
    };

    har.clearJson = function() {
        console.log("Clearing json");
        har.clearResults();
        har.json = '';
    };

    har.fileInputChanged = function(file) {
        console.log("File input changed.");
        har.clearJson();
        har.file = file;
    }
});