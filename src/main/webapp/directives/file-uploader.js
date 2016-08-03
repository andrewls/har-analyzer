/**
 * Created by andrew on 8/3/16.
 */
angular.module('harAnalyzer.directives', [])
    .directive('fileUploader', function() {
        return {
            template: '<label class="file-input-label">{{file ? file.name : "No Files Selected" }}</label><input id="file-input" class="file-input" type="file" />',
            restrict: 'E',
            scope: {
                fileInputChanged: '='
            },
            controller: function($scope) {
                $scope.fileChanged = function() {
                    var inputBox = document.getElementById('file-input');
                    if (inputBox.files && inputBox.files.length) {
                        console.log("File input changed!");
                        $scope.file = inputBox.files[0];
                        $scope.fileInputChanged($scope.file);
                    }

                }

                // There's probably a better way to allow the controller to signal that this should
                // be cleared, but this was the fastest way, which counts for a lot at 3AM, and it's
                //also pretty clean.
                $scope.$on('file-input-should-clear', function() {
                    console.log("Clearing file input");
                    // get the necessary elements to clear it
                    var form = document.createElement('form');
                    var fileInput = document.getElementById('file-input');
                    var parentNode = fileInput.parentNode;
                    var ref = fileInput.nextSibling;

                    // reset the form to clear the value
                    form.appendChild(fileInput);
                    form.reset();

                    // reinsert the element into the dom where it was
                    parentNode.insertBefore(fileInput, ref);
                });
            }
        }
    });