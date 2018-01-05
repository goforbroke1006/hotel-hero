<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="form-group">
    <form:label path="identityDocument.type">Тип</form:label>
    <form:select path="identityDocument.type" class="form-control">
        <option selected>Паспорт</option>
    </form:select>
</div>
<div class="form-group">
    <form:label path="identityDocument.series">Серия</form:label>
    <form:input path="identityDocument.series" class="form-control" placeholder="1234"/>
</div>
<div class="form-group">
    <form:label path="identityDocument.identifier">Номер</form:label>
    <form:input path="identityDocument.identifier" class="form-control"
                placeholder="11223344"/>
</div>

<div class="form-group">
    <form:label path="identityDocument.dateOfIssueDate">Дата выдачи:</form:label>
    <div class="input-group date">
        <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
        <form:input path="identityDocument.dateOfIssueDate"
                    class="form-control pull-left datepicker"/>
    </div>
</div>
<div class="form-group">
    <form:label path="identityDocument.validityTillDate">Действителен до:</form:label>
    <div class="input-group date">
        <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
        <form:input path="identityDocument.validityTillDate"
                    class="form-control pull-right datepicker"/>
    </div>
</div>
