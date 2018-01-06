<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Dashboard</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <jsp:include page="../--includes/head-resources.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <jsp:include page="../--includes/main-header.jsp"/>

    <jsp:include page="../--includes/main-sidebar.jsp"/>

    <div class="content-wrapper">

        <section class="content-header">
            <h1>
                Dashboard
                <small>Control panel</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i></a></li>
                <li><a href="#">Принимающая сторона</a></li>
                <li class="active">Список сторон</li>
            </ol>
        </section>

        <section class="content">

            <div class="row">
                <div class="col-md-10"></div>
                <div class="col-md-2">
                    <div class="box box-primary">
                        <a href="/receiving-point/form/create" class="btn btn-block btn-success">Добавить</a>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">Bordered Table</h3>
                        </div>
                        <div class="box-body">
                            <table class="table table-bordered">
                                <tr>
                                    <th style="width: 10px">#</th>
                                    <th>Название</th>
                                    <th>Адрес</th>
                                    <th style="width: 40px">Операции</th>
                                </tr>
                                <c:forEach items="${list}" var="point">
                                    <tr>
                                        <td>${point.id}</td>
                                        <td>${point.title}</td>
                                        <td>
                                                ${point.placeAddress.county},&nbsp;
                                                ${point.placeAddress.city},&nbsp;
                                                ${point.placeAddress.street},&nbsp;
                                                ${point.placeAddress.house},&nbsp;
                                                ${point.placeAddress.unit},&nbsp;
                                                ${point.placeAddress.building},&nbsp;
                                                ${point.placeAddress.flat}
                                        </td>
                                        <td>
                                            <a href="/receiving-point/form/${point.id}/edit"
                                               class="btn btn-block btn-warning">Редактировать</a>
                                            <a href="/receiving-point/form/${point.id}/delete"
                                               class="btn btn-block btn-danger">Удалить</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                        <div class="box-footer clearfix">
                            <ul class="pagination pagination-sm no-margin pull-right">
                                <li><a href="#">&laquo;</a></li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">&raquo;</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </section>

    </div>

    <jsp:include page="../--includes/footer.jsp"/>

    <jsp:include page="../--includes/right-control-sidebar.jsp"/>

</div>

<jsp:include page="../--includes/footer-resources.jsp"/>

</body>
</html>