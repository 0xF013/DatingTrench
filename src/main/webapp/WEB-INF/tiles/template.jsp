<!DOCTYPE HTML>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <tiles:insertAttribute name="meta"/>
</head>
<body>
<div id="header">
    <tiles:insertAttribute name="header"/>
</div>
<div id="body">
    <div class="jumbotron">
        <div class="container">
            <tiles:insertAttribute name="body"/>
        </div>
    </div>
</div>
<div id="footer">
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>