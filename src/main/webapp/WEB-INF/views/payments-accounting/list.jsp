<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Dashboard
                <small>Control panel</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Dashboard</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">Новые оплаты в чате</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <table class="table table-bordered">
                        <tr>
                            <th>ID</th>
                            <th>Текст сообщения</th>
                            <th>Операции</th>
                        </tr>
                        <c:forEach items="${unsentLogs}" var="log">
                            <tr>
                                <td>${log.vkontakteMessageId}</td>
                                <td>${log.messageText}</td>
                                <td>
                                    <a href="/payments-accounting/log/${log.vkontakteMessageId}/approve"
                                       class="btn btn-success js_approve_move_to_ddengi"
                                       title="Будет перемещенно в &quot;Дребеденьги&quot;">Одобрить</a>
                                    <a href="/payments-accounting/log/${log.vkontakteMessageId}/reject"
                                       class="btn btn-danger">Отклонить</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <!-- /.box-body -->
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

            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">Оплаты в DrebeDengi</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <table class="table table-bordered">
                        <tr>
                            <th>ID</th>
                            <th>Информация</th>
                        </tr>
                        <c:forEach items="${records.items}" var="item">
                            <tr>
                                <td>${item.key}</td>
                                <td>
                                    <ul>
                                        <c:forEach items="${item.value}" var="prop">
                                            <li>
                                                <b>${prop.key}</b> - ${prop.value}
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <!-- /.box-body -->
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

        </section>
        <!-- /.content -->
    </div>

    <jsp:include page="../--includes/footer.jsp"/>

    <jsp:include page="../--includes/right-control-sidebar.jsp"/>

</div>

<jsp:include page="../--includes/footer-resources.jsp"/>

<script>
    $(function () {
        $('.js_approve_move_to_ddengi').click(function () {
            var $btn = $(this);
            $.get($btn.attr('href')).success(function () {
                alert('Строка успешно перемещена в Дребеденьги');
                $btn.closest('tr').remove();
            });
        });
    });
</script>

</body>
</html>
