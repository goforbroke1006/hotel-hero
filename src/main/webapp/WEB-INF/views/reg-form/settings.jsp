<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
                <li><a href="#">Forms</a></li>
                <li class="active">General Elements</li>
            </ol>
        </section>

        <!-- Main content -->
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

    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.4.0
        </div>
        <strong>Copyright &copy; 2014-2016 <a href="https://adminlte.io">Almsaeed Studio</a>.</strong>
        All rights reserved.
    </footer>

    <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
            <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
            <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
            <!-- Home tab content -->
            <div class="tab-pane" id="control-sidebar-home-tab">
                <h3 class="control-sidebar-heading">Recent Activity</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript:void(0)">
                            <i class="menu-icon fa fa-birthday-cake bg-red"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                                <p>Will be 23 on April 24th</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <i class="menu-icon fa fa-user bg-yellow"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>

                                <p>New phone +1(800)555-1234</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>

                                <p>nora@example.com</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <i class="menu-icon fa fa-file-code-o bg-green"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>

                                <p>Execution time 5 seconds</p>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->

                <h3 class="control-sidebar-heading">Tasks Progress</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript:void(0)">
                            <h4 class="control-sidebar-subheading">
                                Custom Template Design
                                <span class="label label-danger pull-right">70%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <h4 class="control-sidebar-subheading">
                                Update Resume
                                <span class="label label-success pull-right">95%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-success" style="width: 95%"></div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <h4 class="control-sidebar-subheading">
                                Laravel Integration
                                <span class="label label-warning pull-right">50%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <h4 class="control-sidebar-subheading">
                                Back End Framework
                                <span class="label label-primary pull-right">68%</span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->

            </div>
            <!-- /.tab-pane -->
            <!-- Stats tab content -->
            <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
            <!-- /.tab-pane -->
            <!-- Settings tab content -->
            <div class="tab-pane" id="control-sidebar-settings-tab">
                <form method="post">
                    <h3 class="control-sidebar-heading">General Settings</h3>

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Report panel usage
                            <input type="checkbox" class="pull-right" checked>
                        </label>

                        <p>
                            Some information about this general settings option
                        </p>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Allow mail redirect
                            <input type="checkbox" class="pull-right" checked>
                        </label>

                        <p>
                            Other sets of options are available
                        </p>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Expose author name in posts
                            <input type="checkbox" class="pull-right" checked>
                        </label>

                        <p>
                            Allow the user to show his name in blog posts
                        </p>
                    </div>
                    <!-- /.form-group -->

                    <h3 class="control-sidebar-heading">Chat Settings</h3>

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Show me as online
                            <input type="checkbox" class="pull-right" checked>
                        </label>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Turn off notifications
                            <input type="checkbox" class="pull-right">
                        </label>
                    </div>
                    <!-- /.form-group -->

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Delete chat history
                            <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
                        </label>
                    </div>
                    <!-- /.form-group -->
                </form>
            </div>
            <!-- /.tab-pane -->
        </div>
    </aside>

    <div class="control-sidebar-bg"></div>
</div>

<script src="/AdminLTE-2.4.2/bower_components/jquery/dist/jquery.min.js"></script>
<script src="/AdminLTE-2.4.2/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="/AdminLTE-2.4.2/bower_components/fastclick/lib/fastclick.js"></script>
<script src="/AdminLTE-2.4.2/dist/js/adminlte.min.js"></script>
<script src="/AdminLTE-2.4.2/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

<script>
    $(function () {
        $('.datepicker').datepicker({
            format: 'yyyy-mm-dd',
//            format: 'U',
            autoclose: true
        });
    });
</script>

</body>
</html>
