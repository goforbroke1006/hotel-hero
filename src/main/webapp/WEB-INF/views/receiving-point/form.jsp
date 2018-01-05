<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Dashboard</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="/AdminLTE-2.4.2/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/AdminLTE-2.4.2/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="/AdminLTE-2.4.2/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/AdminLTE-2.4.2/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="/AdminLTE-2.4.2/dist/css/skins/_all-skins.min.css">
    <!-- Morris chart -->
    <link rel="stylesheet" href="/AdminLTE-2.4.2/bower_components/morris.js/morris.css">
    <!-- jvectormap -->
    <link rel="stylesheet" href="/AdminLTE-2.4.2/bower_components/jvectormap/jquery-jvectormap.css">
    <!-- Date Picker -->
    <link rel="stylesheet"
          href="/AdminLTE-2.4.2/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="/AdminLTE-2.4.2/bower_components/bootstrap-daterangepicker/daterangepicker.css">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="/AdminLTE-2.4.2/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
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
            <form:form method="POST" action="/receiving-point/form/save" modelAttribute="point">

                <div class="row">
                    <div class="col-md-12">
                        <div class="box-body">
                            <div class="form-group">
                                <form:label path="title">Название записи</form:label>
                                <form:input path="title" class="form-control" placeholder="Smith"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">СВЕДЕНИЯ О МЕСТЕ ПРЕБЫВАНИЯ</h3>
                            </div>

                            <div class="box-body">
                                <div class="form-group">
                                    <form:label path="placeAddress.county">Страна</form:label>
                                    <form:input path="placeAddress.county" class="form-control"
                                                placeholder="Китай"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="placeAddress.city">Город</form:label>
                                    <form:input path="placeAddress.city" class="form-control"
                                                placeholder="Пекин"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="placeAddress.street">Улица</form:label>
                                    <form:input path="placeAddress.street" class="form-control"
                                                placeholder="Пекин"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="placeAddress.house">Дом</form:label>
                                    <form:input path="placeAddress.house" class="form-control"
                                                placeholder="Пекин"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="placeAddress.unit">Корпус</form:label>
                                    <form:input path="placeAddress.unit" class="form-control"
                                                placeholder="Пекин"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="placeAddress.building">Строение</form:label>
                                    <form:input path="placeAddress.building" class="form-control"
                                                placeholder="Пекин"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="placeAddress.flat">Квартира</form:label>
                                    <form:input path="placeAddress.flat" class="form-control"
                                                placeholder="Пекин"/>
                                </div>
                            </div>
                        </div>

                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">СВЕДЕНИЯ О ПРИНИМАЮЩЕЙ СТОРОНЕ (личность)</h3>
                            </div>

                            <div class="box-body">
                                <div class="form-group">
                                    <form:label path="lastName">Фамилия</form:label>
                                    <form:input path="lastName" class="form-control" placeholder="Smith"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="firstName">Имя (и отчество если есть)</form:label>
                                    <form:input path="firstName" class="form-control" placeholder="John"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="birthday">Дата рождения</form:label>
                                    <form:input path="birthday"
                                                class="form-control pull-right datepicker"
                                                required="required"/>
                                </div>
                            </div>
                        </div>

                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">СВЕДЕНИЯ О ПРИНИМАЮЩЕЙ СТОРОНЕ (дополнительно)</h3>
                            </div>

                            <div class="box-body">
                                <div class="form-group">
                                    <form:label path="organizationName">Наименование организации</form:label>
                                    <form:input path="organizationName" class="form-control" placeholder="ООО Дичь"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="actualAddress">Фактический адрес</form:label>
                                    <form:input path="actualAddress" class="form-control" placeholder="Florida, Saint Petersburg"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="tin">ИНН</form:label>
                                    <form:input path="tin" class="form-control" placeholder="123123123123"
                                                maxlength="12" pattern="([\d]{,12})"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">СВЕДЕНИЯ О ПРИНИМАЮЩЕЙ СТОРОНЕ (адрес)</h3>
                            </div>

                            <div class="box-body">
                                <div class="form-group">
                                    <form:label path="personAddress.county">Страна</form:label>
                                    <form:input path="personAddress.county" class="form-control"
                                                placeholder="Китай"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="personAddress.city">Город</form:label>
                                    <form:input path="personAddress.city" class="form-control"
                                                placeholder="Пекин"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="personAddress.street">Улица</form:label>
                                    <form:input path="personAddress.street" class="form-control"
                                                placeholder="Пекин"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="personAddress.house">Дом</form:label>
                                    <form:input path="personAddress.house" class="form-control"
                                                placeholder="Пекин"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="personAddress.unit">Корпус</form:label>
                                    <form:input path="personAddress.unit" class="form-control"
                                                placeholder="Пекин"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="personAddress.building">Строение</form:label>
                                    <form:input path="personAddress.building" class="form-control"
                                                placeholder="Пекин"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="personAddress.flat">Квартира</form:label>
                                    <form:input path="personAddress.flat" class="form-control"
                                                placeholder="Пекин"/>
                                </div>
                            </div>
                        </div>

                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">СВЕДЕНИЯ О ПРИНИМАЮЩЕЙ СТОРОНЕ (документ)</h3>
                            </div>
                            <div class="box-body">
                                <jsp:include page="../--includes/identityDocument-form-part.jsp"/>
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

    </div>

    <jsp:include page="../--includes/footer.jsp"/>

    <jsp:include page="../--includes/right-control-sidebar.jsp"/>

</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="/AdminLTE-2.4.2/bower_components/jquery/dist/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="/AdminLTE-2.4.2/bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script src="/AdminLTE-2.4.2/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="/AdminLTE-2.4.2/bower_components/raphael/raphael.min.js"></script>
<script src="/AdminLTE-2.4.2/bower_components/morris.js/morris.min.js"></script>
<!-- Sparkline -->
<script src="/AdminLTE-2.4.2/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="/AdminLTE-2.4.2/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/AdminLTE-2.4.2/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="/AdminLTE-2.4.2/bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="/AdminLTE-2.4.2/bower_components/moment/min/moment.min.js"></script>
<script src="/AdminLTE-2.4.2/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="/AdminLTE-2.4.2/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="/AdminLTE-2.4.2/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="/AdminLTE-2.4.2/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/AdminLTE-2.4.2/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/AdminLTE-2.4.2/dist/js/adminlte.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="/AdminLTE-2.4.2/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/AdminLTE-2.4.2/dist/js/demo.js"></script>
</body>
</html>