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
        <%@include file="/WEB-INF/css/edit.css"%>
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

        <div class="col-md-12 col-sm-12">
            <div class="text-right">
                <form action="/logout" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <input class="button2" type="submit" value="Sign Out"/>
                </form>
            </div>
        </div>

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

                    <a href="analysisPrice" class="btn btn-default">AMALYSIS</a>

                </div>
            </div>
        </div>

    </div>
</div>

<br>

<form method="post" action="edit">

    <br>

    <div class="container">
        <div class="row">


            <div class="panel panel-default serviceBox">

                <div class="panel-heading service-content">


                    <p>

                        <input type="submit" value="Сохранить отредактированные данные" align="center">

                    </p>


                </div>


                <table width="100%" border="1" class="table-fixed" class="simple-little-table">

                    <thead>

                    <tr>
                        <th class="col-xs-1">Бренд</th>
                        <th class="col-xs-1">Артикул бренда</th>
                        <th class="col-xs-1">Бренд аналог</th>
                        <th class="col-xs-1">Артикул аналога</th>
                        <th class="col-xs-1">Описание</th>
                        <th class="col-xs-1">Количество</th>
                        <th class="col-xs-1">Цена</th>
                        <th class="col-xs-1">Склад</th>
                        <th class="col-xs-1">Дата парсинга</th>

                    </tr>


                    </thead>

                    <tbody class="simple-little-table">


                        <c:forEach var="parsingResultsById" items="${parsingResultsById}">
                            <tr>
                                <td  class="col-xs-1">
                                    ${parsingResultsById.getBrend1()}
                                </td>
                                <td  class="col-xs-1">
                                    ${parsingResultsById.getArticle_brend1()}
                                </td>
                                <td  class="col-xs-1">
                                    ${parsingResultsById.getBrend2()}
                                </td>
                                <td  class="col-xs-1">
                                    ${parsingResultsById.getArticle_brend2()}
                                </td>
                                <td  class="col-xs-1">
                                    ${parsingResultsById.getDescription_art()}
                                </td>
                                <td  class="col-xs-1">
                                    ${parsingResultsById.getCount_dirty()}
                                </td>
                                <td  class="col-xs-1">
                                    ${parsingResultsById.getPrice_dirty()}
                                </td>
                                <td class="col-xs-1">
                                    ${parsingResultsById.getStock()}
                                </td>
                                <td  class="col-xs-1">
                                    ${parsingResultsById.getDate_swap()}
                                </td>

                            </tr>
                                <br>
                            <tr>
                                <td  class="col-xs-1">
                                    <p><textarea rows="10" cols="10" name="editBrend1">${parsingResultsById.getBrend1()}</textarea></p>
                                </td>
                                <td  class="col-xs-1">
                                    <p><textarea rows="10" cols="10" name="editArtBrend1">${parsingResultsById.getArticle_brend1()}</textarea></p>
                                </td>
                                <td  class="col-xs-1">
                                    <p><textarea rows="10" cols="10" name="editBrend2">${parsingResultsById.getBrend2()}</textarea></p>
                                </td>
                                <td  class="col-xs-1">
                                    <p><textarea rows="10" cols="10" name="editArtBrend2">${parsingResultsById.getArticle_brend2()}</textarea></p>
                                </td>
                                <td  class="col-xs-1">
                                    <p><textarea rows="10" cols="10" name="editDescription">${parsingResultsById.getDescription_art()}</textarea></p>
                                </td>
                                <td  class="col-xs-1">
                                    <p><textarea rows="10" cols="10" name="editCount">${parsingResultsById.getCount_dirty()}</textarea></p>
                                </td>
                                <td  class="col-xs-1">
                                    <p><textarea rows="10" cols="10" name="editPrice">${parsingResultsById.getPrice_dirty()}</textarea></p>
                                </td>
                                <td  class="col-xs-1">
                                    <p><textarea rows="10" cols="10" name="editStock">${parsingResultsById.getStock()}</textarea></p>
                                </td>
                                <td  class="col-xs-1">

                                    <p><textarea rows="10" cols="10" name="editDate">${parsingResultsById.getDate_swap()}</textarea></p>
                                </td>

                            </tr>

                            <input type="hidden" class="form-control" type="text" name="editId" size="1"
                                   value="${parsingResultsById.getId()}"
                                   readonly>


                        </c:forEach>


                    </tbody>

                </table>


            </div>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
</form>

</body>
</html>





















