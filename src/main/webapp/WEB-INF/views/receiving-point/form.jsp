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

<jsp:include page="../--includes/footer-resources.jsp"/>

</body>
</html>