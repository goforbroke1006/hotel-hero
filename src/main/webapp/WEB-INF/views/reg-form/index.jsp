<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | General Form Elements</title>
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

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                General Form Elements
                <small>Preview</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Миграционный учет</a></li>
                <li class="active">Форма регистрации</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <form:form method="POST" modelAttribute="person">

                <div class="row">
                    <div class="col-md-6">
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Гость</h3>
                            </div>

                            <div class="box-body">
                                <div class="form-group">
                                    <form:label path="lastName">Фамилия</form:label>
                                    <form:input path="lastName" class="form-control" placeholder="Смит"
                                                minlength="2" required="required"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="firstName">Имя (отчество)</form:label>
                                    <form:input path="firstName" class="form-control" placeholder="Джон"
                                                minlength="2" required="required"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="nationality">Национальность</form:label>
                                    <form:input path="nationality" class="form-control" placeholder="Зимбабвэ"
                                                minlength="2" required="required"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="birthday">Дата рождения:</form:label>

                                    <div class="input-group date">
                                        <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                                            <%--<fmt:formatDate value="${person.birthday}" var="birthdayStr"
                                                            pattern="dd.mm.yyyy"/>--%>
                                            <form:input path="birthday"
                                                        class="form-control pull-right datepicker"
                                                        required="required"/>
                                        <%--<form:input type="text" path="birthday"
                                                    class="form-control pull-right datepicker"
                                                    value="<fmt:formatDate value='${person.birthday}' pattern='MM-dd-yyyy' />"/>--%>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="radio">
                                        <form:label path="gender"><form:radiobutton path="gender" value="male"/>Мужчина</form:label>
                                    </div>
                                    <div class="radio">
                                        <form:label path="gender"><form:radiobutton path="gender" value="female"/>Женщина</form:label>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Место рождения</h3>
                            </div>
                            <div class="box-body">
                                <div class="form-group">
                                    <form:label path="placeOfBirth.county">Страна</form:label>
                                    <form:input path="placeOfBirth.county" class="form-control"
                                                placeholder="Китай"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="placeOfBirth.city">Город</form:label>
                                    <form:input path="placeOfBirth.city" class="form-control"
                                                placeholder="Пекин"/>
                                </div>

                            </div>
                        </div>

                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Документ, подтверждающий личность</h3>
                            </div>
                            <div class="box-body">
                                <jsp:include page="../--includes/identityDocument-form-part.jsp"/>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Вид и реквизиты документа, подтверждающего право на пребывание
                                    (проживание)</h3>
                            </div>
                            <div class="box-body">
                                <div class="form-group">
                                    <form:label path="stayConfirmingDocument.type">Type</form:label>
                                    <form:select path="stayConfirmingDocument.type" class="form-control">
                                        <form:options items="${stayConfirmingDocumentTypes}"/>
                                    </form:select>
                                </div>
                                <div class="form-group">
                                    <form:label path="stayConfirmingDocument.series">Series</form:label>
                                    <form:input path="stayConfirmingDocument.series" class="form-control"
                                                placeholder="1234"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="stayConfirmingDocument.identifier">Identifier</form:label>
                                    <form:input path="stayConfirmingDocument.identifier" class="form-control"
                                                placeholder="123456"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="stayConfirmingDocument.dateOfIssueDate">Issue date:</form:label>
                                    <div class="input-group date">
                                        <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                                        <form:input path="stayConfirmingDocument.dateOfIssueDate"
                                                    class="form-control pull-left datepicker"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <form:label
                                            path="stayConfirmingDocument.validityTillDate">Validity till:</form:label>
                                    <div class="input-group date">
                                        <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                                        <form:input path="stayConfirmingDocument.validityTillDate"
                                                    class="form-control pull-right datepicker"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="box box-info">
                            <div class="box-header with-border">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Дополнительная информация</h3>
                                </div>

                                <div class="box-body">
                                    <div class="form-group">
                                        <form:label path="purpose">Цель въезда</form:label>
                                        <form:select path="purpose" class="form-control">
                                            <%--<option>Business trip</option>--%>
                                            <%--<option selected>Туризм</option>--%>
                                            <%--<option>Business</option>--%>
                                            <%--<option>Learning</option>--%>
                                            <%--<option>Работа</option>--%>
                                            <%--<option>Частный визит</option>--%>
                                            <%--<option>Transit</option>--%>
                                            <%--<option>Humanitarian</option>--%>
                                            <%--<option>Another</option>--%>

                                            <form:options items="${personPurposes}"/>
                                        </form:select>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="arrivalDate">Дата прибытия:</form:label>
                                        <div class="input-group date">
                                            <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                                            <form:input path="arrivalDate" class="form-control pull-left datepicker"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="durationOfStay">Проживает до:</form:label>
                                        <div class="input-group date">
                                            <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                                            <form:input path="durationOfStay"
                                                        class="form-control pull-left datepicker"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Миграционная карта</h3>
                            </div>

                            <div class="box-body">
                                <div class="form-group">
                                    <form:label path="migrationCard.series">Серия</form:label>
                                    <form:input path="migrationCard.series" class="form-control" placeholder="4671"
                                                required="required" minlength="2" maxlength="4"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="migrationCard.number">Номер</form:label>
                                    <form:input path="migrationCard.number" class="form-control" placeholder="1234567"
                                                required="required" minlength="7" maxlength="7"/>
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
    </div>

    <jsp:include page="../--includes/footer.jsp"/>

    <jsp:include page="../--includes/right-control-sidebar.jsp"/>

</div>

<script src="/AdminLTE-2.4.2/bower_components/jquery/dist/jquery.min.js"></script>
<script src="/AdminLTE-2.4.2/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="/AdminLTE-2.4.2/bower_components/fastclick/lib/fastclick.js"></script>
<script src="/AdminLTE-2.4.2/dist/js/adminlte.min.js"></script>
<script src="/AdminLTE-2.4.2/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

<%--<script>
     $(function () {
         $('.datepicker').datepicker({
             // format: 'yyyy-mm-dd',
             format: 'dd.mm.yyyy',
 //            format: 'U',
             autoclose: true
         });
     });
</script>--%>

</body>
</html>
