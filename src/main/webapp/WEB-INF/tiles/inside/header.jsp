<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
            <a class="" href="/public/activation/resend"><spring:message code="index.resendActivationCode"/></a>
            <a class="" href="/public/password_reset/reset"><spring:message code="index.resetPassword"/></a>
        </div>
        <div class="navbar-collapse collapse">

            <a href="/logout"><spring:message code="inside.logout" /> </a>
        </div>
        <!--/.navbar-collapse -->
    </div>
</div>