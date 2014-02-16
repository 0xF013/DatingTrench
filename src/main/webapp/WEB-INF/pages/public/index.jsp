<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form:form role="form" class="" method="post" action="/public/registration/plain"
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


