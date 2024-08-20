<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users List</title>
</head>
<body>
<h1>Users List</h1>
<ul>
    {{#for user in users}}
    <li>{{user.getName()}} ({{user.getEmail()}})</li>
    {{/for}}
</ul>
<a href="/">Back to Home</a>
</body>
</html>
