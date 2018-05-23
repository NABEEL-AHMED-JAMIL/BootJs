<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en" ng-app="myApp">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"/>
         <link href="<c:url value='/static/css/index.css' />" rel="stylesheet"/>
        <title>"${title}"</title>
    </head>
    <body>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <div ng-controller="UserController as ctrl" ng-cloak class="ng-cloak">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <%--will-come-home-page--%>
                <a class="navbar-brand" href="#/">Ad-MaxIm</a>
                <%--button--%>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <%--sub-menu--%>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                    <%--fetch all line from the back-end--%>
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0 ">
                        <%--used the jsp loop--%>
                        <c:forEach var="menu" items="${menus}">
                            <li class="nav-item active">
                                <a class="nav-link" href="${menu.value.getUrl()}">${menu.value.getPage()}<span class="sr-only">(current)</span></a>
                            </li>
                        </c:forEach>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
            <%--sub-view-here--%>
            <%--Body Section--%>
            <div class="row" style="margin-right: 0px;">
                <div class="col-8">
                </div>
                <div class="col-4">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Salary</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr ng-repeat="u in ctrl.users">
                            <th scope="row"><span ng-bind="u.userId"></span></th>
                            <td><span ng-bind="u.name"></span></td>
                            <td><span ng-bind="u.salary"></span></td>
                        </tr>
                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="2" style="text-align: right;"><b>Sum</b></td>
                            <td>$180</td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>

        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
        <script src="<c:url value='/static/js/app.js' />"></script>
        <script src="<c:url value='/static/js/service/userService.js' />"></script>
        <script src="<c:url value='/static/js/controller/userController.js' />"></script>
    </body>

</html>