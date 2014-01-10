<r:require modules="application" />
<!doctype html>
<html lang="en" ng-app="phonecat">
<head>
    <meta charset="utf-8">
    <title>Google Phone Gallery</title>
    <r:layoutResources/>
</head>
<body>

<div ng-view></div>
<script type="text/ng-template" id="phone-detail.html">
    <g:render template="/partials/phoneDetail" />
</script>

<script type="text/ng-template" id="phone-list.html">
    <g:render template="/partials/phoneList" />
</script>

<r:layoutResources />
</body>
</html>
