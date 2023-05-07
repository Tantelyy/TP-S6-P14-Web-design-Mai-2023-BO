<%@ page import="java.util.List" %>
<%@ page import="com.project.iacontent.model.Contents" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<%--
  Created by IntelliJ IDEA.
  User: tantely
  Date: 2023-05-06
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>


<%
    List<Contents> contents = (List<Contents>) request.getAttribute("contents");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Tiny Dashboard - A Bootstrap Dashboard Template</title>
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
<body class="vertical  light  ">
<div class="wrapper">
    <nav class="topnav navbar navbar-light">
        <button type="button" class="navbar-toggler text-muted mt-2 p-0 mr-3 collapseSidebar">
            <i class="fe fe-menu navbar-toggler-icon"></i>
        </button>
        <ul class="nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-muted pr-0" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="avatar avatar-sm mt-2">
                Admin
              </span>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="<%= request.getContextPath() %>/signUp">Deconnexion</a>
                </div>
            </li>
        </ul>
    </nav>
    <aside class="sidebar-left border-right bg-white shadow" id="leftSidebar" data-simplebar>
        <a href="#" class="btn collapseSidebar toggle-btn d-lg-none text-muted ml-2 mt-3" data-toggle="toggle">
            <i class="fe fe-x"><span class="sr-only"></span></i>
        </a>
        <nav class="vertnav navbar navbar-light">
            <!-- nav bar -->
            <div class="w-100 mb-4 d-flex">
                <a class="navbar-brand mx-auto mt-2 flex-fill text-center">
                    <svg version="1.1" id="logo" class="navbar-brand-img brand-sm" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 120 120" xml:space="preserve">
                <g>
                    <polygon class="st0" points="78,105 15,105 24,87 87,87 	" />
                    <polygon class="st0" points="96,69 33,69 42,51 105,51 	" />
                    <polygon class="st0" points="78,33 15,33 24,15 87,15 	" />
                </g>
              </svg>
                </a>
            </div>
            <ul class="navbar-nav flex-fill w-100 mb-2">
                <li class="nav-item w-100">
                    <a class="nav-link" href="<%= request.getContextPath() %>/contents">
                        <i class="fe fe-grid fe-16"></i>
                        <span class="ml-3 item-text">Contenus</span>
                    </a>
                </li>
            </ul>
        </nav>
    </aside>
    <main role="main" class="main-content">
        <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-md-12">
                    <div class="row align-items-center my-3">
                        <div class="col">
                            <h2 class="page-title">Contenus</h2>
                        </div>
                        <div class="col-auto">
                            <a href="<%= request.getContextPath() %>/newContents"><button type="button" class="btn btn-lg btn-primary"><span class="fe fe-plus fe-16 mr-3"></span>Nouveau</button></a>
                        </div>
                    </div>
                    <div class="file-container border-top">
                        <div class="mt-4">
                            <div class="row my-4">
                                <% for (Contents content: contents) { %>
                                <div class="col-md-4">
                                    <div class="card shadow text-center mb-4">
                                        <div class="card-body">
                                            <div class="header">
                                                <h4 class="title"><%= content.getTitle() %></h4>
                                            </div>
                                        </div> <!-- .card-body -->

                                        <div class="card-footer bg-transparent border-0 fname">
                                            <strong><span class="dot dot-md bg-success mr-2"></span><%= content.getAdmin().getMail() %></strong>
                                            <br />
                                            <strong>Le <fmt:formatDate type = "both" value = "<%= content.getDateHour() %>" /></strong>
                                            <div class="row mt-3">
                                                <div class="col-6">
                                                    <a href="<%= request.getContextPath() %>/modifyContent/<%= content.getId() %>"><button class="btn btn-success">Modifier</button></a>
                                                </div>
                                                <div class="col-6">
                                                    <a href="<%= request.getContextPath() %>/deleteContent/<%= content.getId() %>"><button class="btn btn-danger">Supprimer</button></a>
                                                </div>

                                            </div>
                                        </div> <!-- .card-footer -->
                                    </div> <!-- .card -->
                                </div> <!-- .col -->
                                <% } %>
                            </div> <!-- .row -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main> <!-- main -->
</div> <!-- .wrapper -->

<script src="<%= request.getContextPath() %>/assets/js/jquery.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/popper.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/moment.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/simplebar.min.js"></script>
<script src='<%= request.getContextPath() %>/assets/js/daterangepicker.js'></script>
<script src='<%= request.getContextPath() %>/assets/js/jquery.stickOnScroll.js'></script>
<script src="<%= request.getContextPath() %>/assets/js/tinycolor-min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/config.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/d3.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/topojson.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/datamaps.all.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/datamaps-zoomto.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/datamaps.custom.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/Chart.min.js"></script>
<script>
    /* defind global options */
    Chart.defaults.global.defaultFontFamily = base.defaultFontFamily;
    Chart.defaults.global.defaultFontColor = colors.mutedColor;
</script>
<script src="<%= request.getContextPath() %>/assets/js/gauge.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/jquery.sparkline.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/apexcharts.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/apexcharts.custom.js"></script>
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
