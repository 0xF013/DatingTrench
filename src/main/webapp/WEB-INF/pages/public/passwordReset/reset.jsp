<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1><spring:message code="activation.resetPassword.header"/></h1>

<c:if test="${emailNotFound}">
    <div class="row">
        <p class="bg-danger">
            <spring:message code="activation.resetPassword.emailNotFound"/>
        </p>
    </div>
</c:if>
<form:form method="post" action="/public/password_reset/reset" commandName="form">

    <div class="form-group">
        <form:label path="email"><spring:message code="activation.resetPassword.form.email"/></form:label>
        <form:input path="email" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="<spring:message code="activation.resetPassword.form.submit" />"/>
    </div>

</form:form>