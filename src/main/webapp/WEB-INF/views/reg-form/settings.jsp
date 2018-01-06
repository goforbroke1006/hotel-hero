<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | General Form Elements</title>
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
                General Form Elements
                <small>Preview</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Forms</a></li>
                <li class="active">General Elements</li>
            </ol>
        </section>

        <section class="content">
            <form role="form" method="post">
                <div class="row">
                    <div class="col-md-6">
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Гость</h3>
                            </div>

                            <div class="box-body">
                                <div class="form-group">
                                    <label for="person_lastName">Фамилия</label>
                                    <input type="text" class="form-control" name="lastName"
                                           id="person_lastName"
                                           placeholder="Smith">
                                </div>
                                <div class="form-group">
                                    <label for="person_firstName">Имя (и отчество если есть)</label>
                                    <input type="text" class="form-control" name="firstName"
                                           id="person_firstName"
                                           placeholder="John">
                                </div>
                                <div class="form-group">
                                    <label for="person_nationality">Национальность</label>
                                    <input type="text" class="form-control" name="nationality"
                                           id="person_nationality"
                                           placeholder="Nationality">
                                </div>
                                <div class="form-group">
                                    <label for="person_birthday">Дата рождения:</label>

                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right datepicker" name="birthday"
                                               id="person_birthday">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="gender" id="person_gender_male"
                                                   value="male"
                                                   checked>Мужчина</label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="gender" id="person_gender_female"
                                                   value="female">Женщина</label>
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
                                    <label for="person_lastName">Страна</label>
                                    <input type="text" class="form-control"
                                           name="placeOfBirth.county"
                                           id="person_placeOfBirth_county"
                                           placeholder="United States of America">
                                </div>
                                <div class="form-group">
                                    <label for="person_lastName">Город</label>
                                    <input type="text" class="form-control"
                                           name="placeOfBirth.city"
                                           id="person_placeOfBirth_city"
                                           placeholder="New York">
                                </div>

                            </div>
                        </div>

                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Документ, подтверждающий личность</h3>
                            </div>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="person_identityDocument_type">Тип</label>
                                    <select class="form-control" name="identityDocument.type"
                                            id="person_identityDocument_type">
                                        <option selected>Паспорт</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="person_identityDocument_series">Серия</label>
                                    <input type="text" class="form-control"
                                           name="identityDocument.series"
                                           id="person_identityDocument_series"
                                           placeholder="1234">
                                </div>
                                <div class="form-group">
                                    <label for="person_lastName">Номер</label>
                                    <input type="text" class="form-control"
                                           name="identityDocument.identifier"
                                           id="person_identityDocument_identifier"
                                           placeholder="123456">
                                </div>

                                <div class="form-group">
                                    <label for="person_identityDocument_dateOfIssueDate">Дата выдачи:</label>

                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-left datepicker"
                                               name="identityDocument.dateOfIssueDate"
                                               id="person_identityDocument_dateOfIssueDate">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="person_identityDocument_validityTillDate">Действителен до:</label>

                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right datepicker"
                                               name="identityDocument.validityTillDate"
                                               id="person_identityDocument_validityTillDate">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">Right to stay confirming document</h3>
                            </div>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="person_stayConfirmingDocument_type">Type</label>
                                    <select class="form-control"
                                            name="stayConfirmingDocument.type"
                                            id="person_stayConfirmingDocument_type">
                                        <option selected>Passport</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="person_stayConfirmingDocument_series">Series</label>
                                    <input type="text" class="form-control"
                                           name="stayConfirmingDocument.series"
                                           id="person_stayConfirmingDocument_series"
                                           placeholder="123456">
                                </div>
                                <div class="form-group">
                                    <label for="person_stayConfirmingDocument_identifier">Identifier</label>
                                    <input type="text" class="form-control"
                                           name="stayConfirmingDocument.identifier"
                                           id="person_stayConfirmingDocument_identifier"
                                           placeholder="123456">
                                </div>
                                <div class="form-group">
                                    <label for="person_stayConfirmingDocument_dateOfIssueDate">Issue date:</label>

                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-left datepicker"
                                               name="stayConfirmingDocument.dateOfIssueDate"
                                               id="person_stayConfirmingDocument_dateOfIssueDate">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="person_stayConfirmingDocument_validityTillDate">Validity till:</label>

                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right datepicker"
                                               name="stayConfirmingDocument.validityTillDate"
                                               id="person_stayConfirmingDocument_validityTillDate">
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
                                        <label for="person_purpose">Цель въезда</label>
                                        <select class="form-control" name="purpose"
                                                id="person_purpose">
                                            <option>Business trip</option>
                                            <option selected>Туризм</option>
                                            <option>Business</option>
                                            <option>Learning</option>
                                            <option>Работа</option>
                                            <option>Частный визит</option>
                                            <option>Transit</option>
                                            <option>Humanitarian</option>
                                            <option>Another</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="person_arrivalDate">Дата прибытия:</label>

                                        <div class="input-group date">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                            <input type="text" class="form-control pull-left datepicker"
                                                   name="arrivalDate"
                                                   id="person_arrivalDate">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="person_durationOfStay">Проживает до:</label>

                                        <div class="input-group date">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                            <input type="text" class="form-control pull-left datepicker"
                                                   name="durationOfStay"
                                                   id="person_durationOfStay">
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
                                    <label for="person_migrationCard_series">Серия</label>
                                    <input type="text" class="form-control"
                                           name="migrationCard.series"
                                           id="person_migrationCard_series"
                                           placeholder="4671">
                                </div>
                                <div class="form-group">
                                    <label for="person_migrationCard_number">Номер</label>
                                    <input type="text" class="form-control"
                                           name="migrationCard.number"
                                           id="person_migrationCard_number"
                                           placeholder="123456">
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
            </form>
        </section>
    </div>

    <jsp:include page="../--includes/footer.jsp"/>

    <jsp:include page="../--includes/right-control-sidebar.jsp"/>

</div>

<jsp:include page="../--includes/footer-resources.jsp"/>

</body>
</html>
