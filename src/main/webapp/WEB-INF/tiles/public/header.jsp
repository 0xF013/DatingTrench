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
            <a class="" href="/activation/resend"><spring:message code="index.resendActivationCode"/></a>
            <a class="" href="/password_reset/reset"><spring:message code="index.resetPassword"/></a>
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