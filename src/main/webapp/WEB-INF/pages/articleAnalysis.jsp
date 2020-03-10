<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"
         isELIgnored="false" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>

<html>
<head>
    <title>Position analysis</title>


    <script src="https://npmcdn.com/particlesjs@2.2.2/dist/particles.min.js"></script>

    <style language="css" type="text/css">
        <%@include file="/WEB-INF/css/analysisArticle.css"%>
    </style>

    <script language="JavaScript" type="text/javascript">
        <%@include file="/WEB-INF/scripts/analysisArticle.js"%>
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


        <div class="col-md-1 col-sm-1 col-md-offset-5">
            <div>
                <div class="service-content">

                    <a href="analysisPrice" class="btn btn-default">RETURN PRICE ANALYSIS</a>

                </div>
            </div>
        </div>
    </div>
</div>


<form method="post" action="articleanalysis">


    <br>

    <div class="container">
        <div class="row">


            <div class="panel panel-default serviceBox">
                <div class="panel-heading service-content">
                    <p>

                        <input type="submit" value="Загрузить данные/Обновить страницу" align="center">
                        Номер текущей страницы: <input type="text" align="center" value="${numberPage}"
                                                       readonly="readonly" size="1">
                        Укажите номер необходимой страницы:
                        <select class="selectpicker" name="listCountPage" id="listCountPage">
                            <c:forEach var="listCountPage" items="${listCountPage}">
                                <option><c:out value="${listCountPage}"/></option>
                            </c:forEach>
                        </select>
                    </p>
                    <p>
                        Выбранный артикул: <input type="text" align="center" name="article"
                                                  id="article" value="${article}"
                                                  readonly="readonly" size="4">

                        <input type="hidden" class="form-control" type="text" name="articleId" size="1" value="${articleId}"  readonly>
                        &nbsp;
                        Введите новую цену: <input style="background-color:#FBEFEF" type="text" id="enterPriceNew"
                                                   name="enterPriceNew" size="4">
                    </p>
                </div>

                <table width="100%" border="1" class="table-fixed">

                    <thead>

                    <tr>
                        <th class="col-xs-1">Бренд аналог</th>
                        <th class="col-xs-1">Артикул аналога</th>
                        <th class="col-xs-1">Описание</th>
                        <th class="col-xs-1">Количество</th>
                        <th class="col-xs-1">Цена</th>
                        <th class="col-xs-1">Склад</th>
                        <th class="col-xs-1">Дата парсинга</th>
                    </tr>

                    <tr>


                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="selectpicker" name="outDataBrend2" id="outDataBrend2">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="outDataBrend2" items="${outDataBrend2}">
                                    <option><c:out value="${outDataBrend2}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterBrend2Select" name="filterBrend2Select" style="width:90%" type="text"
                                   align="center" value="${filterBrend2Select}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="selectpicker" name="outDataArticleBrend2" id="outDataArticleBrend2">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="outDataArticleBrend2" items="${outDataArticleBrend2}">
                                    <option><c:out value="${outDataArticleBrend2}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterArtBrend2Select" name="filterArtBrend2Select" style="width:90%" type="text"
                                   align="center" value="${filterArtBrend2Select}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="selectpicker" name="outDataDescription" id="outDataDescription">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="outDataDescription" items="${outDataDescription}">
                                    <option><c:out value="${outDataDescription}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterDescriptionSelect" name="filterDescriptionSelect" style="width:90%"
                                   type="text" align="center" value="${filterDescriptionSelect}" readonly="readonly"
                                   size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="selectpicker" name="outDataCountDirty" id="outDataCountDirty">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="outDataCountDirty" items="${outDataCountDirty}">
                                    <option><c:out value="${outDataCountDirty}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterCountArtSelect" name="filterCountArtSelect" style="width:90%" type="text"
                                   align="center" value="${filterCountArtSelect}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="selectpicker" name="outDataPrice" id="outDataPrice">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="outDataPrice" items="${outDataPrice}">
                                    <option><c:out value="${outDataPrice}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterPriceSelect" name="filterPriceSelect" style="width:90%" type="text"
                                   align="center" value="${filterPriceSelect}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="selectpicker" name="outDataStock" id="outDataStock">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="outDataStock" items="${outDataStock}">
                                    <option><c:out value="${outDataStock}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterStockSelect" name="filterStockSelect" style="width:90%" type="text"
                                   align="center" value="${filterStockSelect}" readonly="readonly" size="1">
                        </td>

                        <td class="col-xs-1">Значения фильтра:<br>
                            <select style="width:90%" class="selectpicker" name="outDataDate" id="outDataDate">
                                <option>FILTER</option>
                                <option></option>
                                <c:forEach var="outDataDate" items="${outDataDate}">
                                    <option><c:out value="${outDataDate}"/></option>
                                </c:forEach>
                            </select>
                            <br>
                            <input id="filterDateSelect" name="filterDateSelect" style="width:90%" type="text"
                                   align="center" value="${filterDateSelect}" readonly="readonly" size="1">
                        </td>



                    </tr>
                    </thead>
                    <tbody class="simple-little-table">

                        <c:forEach var="outDataAll" items="${outDataAll}">
                            <tr>
                                <td  class="col-xs-1"><c:out
                                        value="${outDataAll.getBrend2()}"/></td>
                                <td  class="col-xs-1"><c:out
                                        value="${outDataAll.getArticle_brend2()}"/></td>
                                <td  class="col-xs-1"><c:out
                                        value="${outDataAll.getDescription_art()}"/></td>
                                <td  class="col-xs-1"><c:out
                                        value="${outDataAll.getCount_dirty()}"/></td>
                                <td  class="col-xs-1"><c:out
                                        value="${outDataAll.getPrice_dirty()}"/></td>
                                <td class="col-xs-1"><c:out
                                        value="${outDataAll.getStock()}"/></td>
                                <td  class="col-xs-1"><c:out
                                        value="${outDataAll.getDate_swap()}"/></td>


                            </tr>
                        </c:forEach>



                        <c:forEach var="i" begin="1" end="15">
                            <tr>
                                <td  class="col-xs-1"></td>
                                <td  class="col-xs-1"></td>
                                <td  class="col-xs-1"></td>
                                <td  class="col-xs-1"></td>
                                <td  class="col-xs-1"></td>
                                <td  class="col-xs-1"></td>
                                <td  class="col-xs-1"></td>
                            </tr>
                        </c:forEach>


                        <tr>
                            <th class="col-xs-1">Бренд аналог</th>
                            <th class="col-xs-1">Артикул аналога</th>
                            <th class="col-xs-1">Описание</th>
                            <th class="col-xs-1">Количество</th>
                            <th class="col-xs-1">Цена</th>
                            <th class="col-xs-1">Склад</th>
                            <th class="col-xs-1">Дата парсинга</th>
                        </tr>





                    </tbody>

                </table>


            </div>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
</form>

</body>
</html>
