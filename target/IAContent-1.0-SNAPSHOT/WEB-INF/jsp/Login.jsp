<%--
  Created by IntelliJ IDEA.
  User: tantely
  Date: 2023-05-06
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Login</title>
    <!-- Simple bar CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/simplebar.css">
    <!-- Fonts CSS -->
    <link href="https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <!-- Icons CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/feather.css">
    <!-- Date Range Picker CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/daterangepicker.css">
    <!-- App CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/app-light.css" id="lightTheme">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/app-dark.css" id="darkTheme" disabled>
</head>
<body class="light ">
<div class="wrapper vh-100">
    <div class="row align-items-center h-100">
        <form class="col-lg-3 col-md-4 col-10 mx-auto text-center" method="post" action="<%= request.getContextPath() %>/login">
            <h1 class="h6 mb-3">Login</h1>
            <div class="form-group">
                <label for="inputEmail" class="sr-only">Email address</label>
                <input type="text" name="mail" id="inputEmail" class="form-control form-control-lg" value="Andry" placeholder="Nom" required="" autofocus="">
            </div>
            <div class="form-group">
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" name="pwd" id="inputPassword" value="Admin" class="form-control form-control-lg" placeholder="Password" required="">
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
        </form>
        <% if (request.getAttribute("error") != null) { %>
            <%= request.getAttribute("error") %>
        <% } %>
    </div>
</div>
<script src="<%= request.getContextPath() %>/assets/js/jquery.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/popper.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/moment.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/simplebar.min.js"></script>
<script src='<%= request.getContextPath() %>/assets/js/daterangepicker.js'></script>
<script src='<%= request.getContextPath() %>/assets/js/jquery.stickOnScroll.js'></script>
<script src="<%= request.getContextPath() %>/assets/js/tinycolor-min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/config.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/apps.js"></script>
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-56159088-1"></script>
<script>
    window.dataLayer = window.dataLayer || [];

    function gtag()
    {
        dataLayer.push(arguments);
    }
    gtag('js', new Date());
    gtag('config', 'UA-56159088-1');
</script>
</body>
</html>
</body>
</html>

