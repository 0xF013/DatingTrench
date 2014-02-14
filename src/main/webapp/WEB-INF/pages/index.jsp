<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: elvis
  Date: 2/7/14
  Time: 6:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">

    <script src="//code.jquery.com/jquery-2.1.0.min.js"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/assets/css/style.css" />">

    <title></title>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">DatingTrench</a>
        </div>
        <div class="navbar-collapse collapse">
            <form class="navbar-form navbar-right" role="form" name='f' action='/j_spring_security_check' method='POST'>
                <div class="form-group">
                    <input type="text" placeholder="Email" class="form-control" name='j_username' value=''>
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Password" class="form-control" name='j_password'>
                </div>
                <button type="submit" class="btn btn-success">
                    <spring:message code="index.signIn"/>
                </button>
            </form>
        </div>
        <!--/.navbar-collapse -->
    </div>
</div>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <c:if test="${invalidCredentials}">
        <div class="row">
                <p class="bg-danger">
                    <spring:message code="index.invalidLogin"/>
                </p>
            </div>
        </c:if>
        <div class="row">
            <div class="col-md-7">
            feed here
            </div>
            <div class="col-md-5">
                <form:form role="form" class="" method="post" action="/registration/plain"
                           modelAttribute="registrationForm">
                    <div class="form-group">
                        <form:label path="gender">
                            <spring:message code="registrationForm.labels.gender"/>:
                        </form:label>
                        <form:radiobuttons path="gender"/>
                        <form:errors path="gender"/>
                    </div>
                    <div class="form-group">
                        <form:label path="name">
                            <spring:message code="registrationForm.labels.rename"/>:
                        </form:label>
                        <form:input path="name" class="form-control"/>
                        <form:errors path="name"/>
                    </div>
                    <div class="form-group">
                        <form:label path="email">
                            <spring:message code="registrationForm.labels.email"/>:
                        </form:label>
                        <form:input path="email" class="form-control"/>
                        <form:errors path="email"/>
                    </div>
                    <div class="form-group">
                        <form:label path="password">
                            <spring:message code="registrationForm.labels.password"/>:
                        </form:label>
                        <form:password path="password" class="form-control"/>
                        <form:errors path="password"/>
                    </div>

                    <div class="form-group">
                        <form:label path="day">
                            <spring:message code="registrationForm.labels.dob"/>:
                        </form:label>
                        <form:select path="day" class="form-control">
                            <c:forEach begin="1" end="31" varStatus="loop">
                                <c:choose>
                                    <c:when test="${registrationForm.day == loop.index}">
                                        <option value="${loop.index}" selected="selected">${loop.index}</option>
                                        .
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${loop.index}">${loop.index}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </form:select>
                        <form:select path="month" class="form-control">
                            <c:forEach begin="1" end="12" varStatus="loop">
                                <c:choose>
                                    <c:when test="${registrationForm.month == loop.index}">
                                        <option value="${loop.index}" selected="selected">${loop.index}</option>
                                        .
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${loop.index}">${loop.index}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </form:select>

                        <form:select path="year" class="form-control">
                            <c:forEach var="year" items="${years}">
                                <c:choose>
                                    <c:when test="${registrationForm.year == year}">
                                        <option value="${year}" selected="selected">${year}</option>
                                        .
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${year}">${year}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </form:select>
                        <form:errors path="dob"/>
                    </div>

                    <div class="form-group">
                        <input type="submit" value="<spring:message code="registrationForm.labels.submit" />"/>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-4">
            <h2>Heading</h2>

            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                euismod. Donec sed odio dui. </p>

            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>Heading</h2>

            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
                condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis
                euismod. Donec sed odio dui. </p>

            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>Heading</h2>

            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula
                porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                fermentum massa justo sit amet risus.</p>

            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
    </div>

    <hr>

    <footer>
        <p>&copy; Company 2014</p>
    </footer>
</div>
<!-- /container -->

</body>
</html>
