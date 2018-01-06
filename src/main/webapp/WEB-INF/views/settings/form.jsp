<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

            <form:form method="POST" action="/settings/form" modelAttribute="settings">

                <div class="row">
                    <div class="col-md-12">
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Общие настройки</h3>
                            </div>
                            <div class="box-body">
                                <div class="form-group">
                                    <form:label path="avatarUrl">Ссылка на аватарку</form:label>
                                    <form:input path="avatarUrl"
                                                class="form-control"
                                                placeholder="https://pp.userapi.com/c841631/v841631082/495ec/xXd54X9mwnM.jpg"
                                    />
                                </div>
                                <div class="form-group">
                                    <form:label path="paymentRegexpList">Распознавание оплат</form:label>
                                    <form:textarea path="paymentRegexpList" class="form-control"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Сохранить</button>
                        </div>
                    </div>
                </div>

            </form:form>

        </section>
        <!-- /.content -->
    </div>

    <jsp:include page="../--includes/footer.jsp"/>

    <jsp:include page="../--includes/right-control-sidebar.jsp"/>

</div>

<jsp:include page="../--includes/footer-resources.jsp"/>

</body>
</html>
