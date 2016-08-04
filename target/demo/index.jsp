<html>
<head>
    <title>Http Archive Analyzer</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.3.1/angular-ui-router.min.js"></script>
    <script src="directives/file-uploader.js"></script>
    <script src="services/api-service.js"></script>
    <script src="controllers/har-controller.js"></script>
    <script src="application.js"></script>
    <script src="https://use.fontawesome.com/92c0310358.js"></script>
    <link rel="stylesheet" type="text/css" href="stylesheets/har.css" />
    <link rel="stylesheet" type="text/css" href="stylesheets/file-input.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body ng-app="harAnalyzer" class="angular-app">
    <h2 class="title">Http Archive File Analyzer</h2>
    <div class="viewport" ui-view=""></div>
</body>
</html>
