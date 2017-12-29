<%@page contentType="text/html" pageEncoding="UTF-8" %>

<a href="#" class="dropdown-toggle" data-toggle="dropdown">
    <img src="/AdminLTE-2.4.2/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
    <span class="hidden-xs">${username}</span>
</a>
<ul class="dropdown-menu">
    <!-- User image -->
    <li class="user-header">
        <img src="/AdminLTE-2.4.2/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

        <p>
            ${username} - Web Developer
            <small>Member since Nov. 2012</small>
        </p>
    </li>
    <!-- Menu Body -->
    <li class="user-body">
        <div class="row">
            <div class="col-xs-4 text-center">
                <a href="#">Followers</a>
            </div>
            <div class="col-xs-4 text-center">
                <a href="#">Sales</a>
            </div>
            <div class="col-xs-4 text-center">
                <a href="#">Friends</a>
            </div>
        </div>
        <!-- /.row -->
    </li>
    <!-- Menu Footer-->
    <li class="user-footer">
        <div class="pull-left">
            <a href="#" class="btn btn-default btn-flat">Profile</a>
        </div>
        <div class="pull-right">
            <a href="#" class="btn btn-default btn-flat">Sign out</a>
        </div>
    </li>
</ul>