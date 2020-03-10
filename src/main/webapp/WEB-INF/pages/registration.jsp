<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Registration</title>

    <link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>
    <link rel="stylesheet" href="http://bootstraptema.ru/plugins/font-awesome/4-4-0/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css"
          integrity="sha384-3AB7yXWz4OeoZcPbieVW64vVXEwADiYyAEhwilzWsLw+9FgqpyjjStpPnpBO8o8S" crossorigin="anonymous">


    <style language="css" type="text/css">
        <%@include file="/WEB-INF/css/login.css"%>
    </style>

    <script language="JavaScript" type="text/javascript">
        <%@include file="/WEB-INF/scripts/main.js"%>
    </script>


    <script src="https://npmcdn.com/particlesjs@2.2.2/dist/particles.min.js"></script>


</head>

<body>


<canvas class="background"></canvas>

<br>

<div class="container">
    <div class="row">

        <div class="col-md-offset-3 col-md-6">
            <form action="/registration" method="post" class="form-horizontal">
                <span class="heading">РЕГИСТРАЦИЯ</span>
                <div class="form-group">
                    <input type="text" class="form-control" id="username" name="username"/>
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="password" name="password"/>
                    <i class="fa fa-lock"></i>

                </div>
                <div class="form-group">

                    <button type="submit" class="btn btn-default">Зарегистрироваться</button>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
            </form>
        </div>

    </div><!-- /.row -->
</div><!-- /.container -->

<br>



</body>
</html>