/**
 * Created by andrew on 8/3/16.
 */
angular.module('harAnalyzer.directives', [])
    .directive('fileUploader', function() {
        return {
            template: '<label class="file-input-label" for="file-input">{{file ? file.name : "No Files Selected" }}</label><input id="file-input" class="file-input" type="file"/>',
            restrict: 'E',
            scope: {
                fileInputChanged: '=',
                file: '='
            },
            controller: function($scope) {
                console.log("Initializing directive");
                $scope.fileChanged = function() {
                    console.log("Directive file changed function called");
                    var inputBox = document.getElementById('file-input');
                    if (inputBox.files && inputBox.files.length) {
                        console.log("File input changed!");
                        $scope.file = inputBox.files[0];
                        $scope.fileInputChanged($scope.file);
                        $scope.$apply(); // trigger digest cycle so file name updates.
                    }

                }

                // we'll manually register a change event handler for the file input value - that way we don't have to
                // deal with the headache of requiring ng-change and ng-model to use in the directive
                document.getElementById('file-input').addEventListener('change', function() {
                    console.log("Event listener for change event called");
                    $scope.fileChanged();
                });

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

                    // reset the file object on the scope as well
                    $scope.file = null;
                });
            }
        }
    });