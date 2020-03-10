<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"
         isELIgnored="false" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>


<html>
<head>
    <title>Price analysis</title>


    <script src="https://npmcdn.com/particlesjs@2.2.2/dist/particles.min.js"></script>


    <style language="css" type="text/css">
        <%@include file="/WEB-INF/css/analysisPrice.css"%>
    </style>

    <script language="JavaScript" type="text/javascript">
        <%@include file="/WEB-INF/scripts/analysisPrice.js"%>
    </script>


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

                    <a href="parsing" class="btn btn-default">PARSING</a>


                </div>
            </div>
        </div>

        <div class="col-md-1 col-sm-1 col-md-offset-1">
            <div>
                <div class="service-content">

                    <a href="analysisCross" class="btn btn-default">CROSS</a>

                </div>
            </div>
        </div>

    </div>
</div>

<br>

<form method="post" action="analysisPrice">

    <br>

    <div class="container">
        <div class="row">



            <div class="panel panel-default serviceBox">

                <div class="panel-heading service-content">


                    <p>

                        <input type="submit" value="Перейти на страницу/Обновить фильтры" align="center">
                        Номер текущей страницы: <input type="text" align="center" value="${numberPage}"
                                                       readonly="readonly" size="1">
                        Укажите номер необходимой страницы:
                        <select class="selectpicker" name="listCountPage" id="listCountPage">
                            <c:forEach var="listCountPage" items="${listCountPage}">
                                <option><c:out value="${listCountPage}"/></option>
                            </c:forEach>
                        </select>
                        <br>
                        <br>
                        <a href="updatePrice" style="background:#333" class="btn">Import price</a>

                    </p>


                </div>


                <table width="100%" border="1" class="table-fixed" class="simple-little-table">

                    <thead>

                    <tr>
                        <th class="col-xs-1" rowspan="2">Перейти в анализ</th>
                        <th class="col-xs-1">Артикул FENOX</th>
                        <th class="col-xs-1">Группа</th>
                        <th class="col-xs-1">Описание</th>
                        <th class="col-xs-1">Цена старая</th>
                        <th class="col-xs-1">Цена новая</th>
                    </tr>

                    <tr>
                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="selectpicker" name="listArticle" id="listArticle">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listArticle" items="${listArticle}">
                                    <option><c:out value="${listArticle}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterArticle" name="filterArticle" style="width:90%" type="text"
                                   align="center" value="${filterArticle}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="selectpicker" name="listGroup" id="listGroup">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listGroup" items="${listGroup}">
                                    <option><c:out value="${listGroup}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterGroup" name="filterGroup" style="width:90%" type="text"
                                   align="center" value="${filterGroup}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="selectpicker" name="listDescription" id="listDescription">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listDescription" items="${listDescription}">
                                    <option><c:out value="${listDescription}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterDescription" name="filterDescription" style="width:90%" type="text"
                                   align="center" value="${filterDescription}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="selectpicker" name="listOldPrice" id="listOldPrice">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listOldPrice" items="${listOldPrice}">
                                    <option><c:out value="${listOldPrice}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterOldPrice" name="filterOldPrice" style="width:90%"
                                   type="text" align="center" value="${filterOldPrice}" readonly="readonly"
                                   size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="selectpicker" name="listNewPrice" id="listNewPrice">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="listNewPrice" items="${listNewPrice}">
                                    <option><c:out value="${listNewPrice}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterNewPrice" name="filterNewPrice" style="width:90%" type="text"
                                   align="center" value="${filterNewPrice}" readonly="readonly" size="1">
                        </td>


                    </tr>
                    </thead>
                    <tbody class="simple-little-table">
                    <form method="get" action="analysisarticle">
                        <c:forEach var="outDataAll" items="${outDataAll}">
                            <tr>
                                <td class="col-xs-1">

                                    <a href='articleanalysis?article=<c:out value="${outDataAll.getArticle()}"/>&articleId=<c:out value="${outDataAll.getId()}"/>'>ПЕРЕЙТИ</a>

                                </td>
                                <td  class="col-xs-1"><c:out
                                        value="${outDataAll.getArticle()}"/></td>
                                <td  class="col-xs-1"><c:out
                                        value="${outDataAll.getGrou()}"/></td>
                                <td  class="col-xs-1"><c:out
                                        value="${outDataAll.getDescription()}"/></td>
                                <td  class="col-xs-1"><c:out
                                        value="${outDataAll.getOldPrice()}"/></td>
                                <td  class="col-xs-1"><c:out
                                        value="${outDataAll.getNewPrice()}"/></td>

                            </tr>
                        </c:forEach>


                        <c:forEach var="i" begin="1" end="15">
                            <tr>
                                <td width="10" class="col-xs-1"></td>
                                <td  class="col-xs-1"></td>
                                <td  class="col-xs-1"></td>
                                <td  class="col-xs-1"></td>
                                <td  class="col-xs-1"></td>
                                <td  class="col-xs-1"></td>

                            </tr>
                        </c:forEach>


                        <tr>
                            <th class="col-xs-1">Перейти в анализ</th>
                            <th class="col-xs-1">Артикул FENOX</th>
                            <th class="col-xs-1">Группа</th>
                            <th class="col-xs-1">Описание</th>
                            <th class="col-xs-1">Цена старая</th>
                            <th class="col-xs-1">Цена новая</th>
                        </tr>





                    </form>
                    </tbody>

                </table>


            </div>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
</form>

</body>
</html>

