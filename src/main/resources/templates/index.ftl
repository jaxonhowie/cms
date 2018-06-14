<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Hello World!</title>
</head>
<body>
    <p>
        welcome ${userinfo.name} to freemarker!
        <br>
        Name is 11: ${userinfo.name} <br>
        Login name is :${userinfo.loginname}
    </p>
</body>
</html>