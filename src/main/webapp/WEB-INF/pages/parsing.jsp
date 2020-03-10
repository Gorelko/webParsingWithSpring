<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"
         isELIgnored="false" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>

    <meta charset="utf-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<%--    <%@page import="my.parsing.app.servlet.ParsingServletJava" %>--%>

    <title>Web-parsing</title>

    <link rel="stylesheet" href="http://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>
    <link rel="stylesheet" href="http://bootstraptema.ru/plugins/font-awesome/4-4-0/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css"
          integrity="sha384-3AB7yXWz4OeoZcPbieVW64vVXEwADiYyAEhwilzWsLw+9FgqpyjjStpPnpBO8o8S" crossorigin="anonymous">


    <style language="css" type="text/css">
        <%@include file="/WEB-INF/css/parsing.css"%>
    </style>


    <script language="JavaScript" type="text/javascript">
        <%@include file="/WEB-INF/scripts/parsing.js"%>
    </script>


    <script src="https://npmcdn.com/particlesjs@2.2.2/dist/particles.min.js"></script>


</head>
<body>

<canvas class="background"></canvas>

<br>

<div class="container">
    <div class="row">



        <div class="col-md-1 col-sm-1 col-md-offset-1">
            <div>
                <div class="service-content">

                    <a href="main" class="btn btn-default">MAIN</a>

                </div>
            </div>
        </div>

        <div class="col-md-3 col-sm-3 col-md-offset-3">
            <div>
                <div class="service-content">

                    <a href="analysisCross" class="btn btn-default">CROSS</a>

                </div>
            </div>
        </div>

        <div class="col-md-1 col-sm-1 col-md-offset-1">
            <div>
                <div class="service-content">

                    <a href="analysisPrice" class="btn btn-default">ANALYSIS</a>

                </div>
            </div>
        </div>

    </div>
</div>

<br>

<div class="container">
    <div class="row">




        <div class="col-md-10 col-sm-10 col-md-offset-1">
            <div class="serviceBox">
                <div class="service-content">


                    <div class="service-icon">
                        <i class="fa fa-rocket"></i>
                    </div>
                    <div class="service-content">
                        <h3>Web parsing</h3>
                        <p>Для парсинга информации заполните поля указанные ниже (почту заполнять по желанию). Процесс
                            парсинга может занимать 30-120 сек для одной позиции в зависимости от объёма информации (вся
                            информация записывается в БД). Пример файла для парсинга можно посмотреть <a
                                    href="https://yadi.sk/d/El5rPeiyb_6yEw" target="_blank">ДЛЯ САЙТА AMTEL</a> и <a
                                    href="https://yadi.sk/d/LqnvTpF6g9eGrg" target="_blank">ДЛЯ САЙТА EMEX</a>. Данный
                            парсинг позволяет скачивать информацию где требуется авторизация.</p>
                    </div>


                    <table border="1" align="center">

                        <form method="post" action="parsing" enctype="multipart/form-data">
                            <tr>
                                <td>Загрузите файл в формате csv для последующей обрабоки</td>
                                <td><input type="file" name="file"/></td>
                                <td><input type="submit" value="Upload"/>
                            </tr>
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        </form>

                        <form name="formIndex" method="post" action="startparsing">
                            <tr>
                                <td>Выберите файл загруженный ранее на сервер для парсинга</td>
                                <td colspan="2">
                                    <select class="selectpicker" name="arrUploadsFiles" id='arrUploadsFiles'>
                                        <c:forEach var="arrUploadsFiles" items="${arrUploadsFiles}">
                                            <option><c:out value="${arrUploadsFiles}"/></option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>Выберите сайт для парсинга</td>
                                <td colspan="2">
                                    <select name="siteSelect" id='siteSelect' onchange="showNames(this.value)"
                                            width="50">
                                        <option selected disabled hidden style='display: none' value=''></option>
                                        <option value="Amtel">Amtel</option>
                                        <option value="Emex">Emex</option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>Введите почту для оповещения окончания парсинга (по желанию)</td>
                                <td colspan="2">
                                    <input type="email" name="email" id="email"/>
                                </td>
                            </tr>


                            <tr>
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                <td align="center" colspan="3"><input type="submit" value="Запустить парсинг"
                                                                      align="center" onclick="showresult()"></td>

                                <form method="post" action="parsing" id="form1">
                                    <div id="777" hidden="hidden"></div>
                                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                </form>

                            </tr>
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        </form>
                    </table>


                </div>
            </div>
        </div>


    </div><!-- ./row -->
</div>


</body>
</html>
