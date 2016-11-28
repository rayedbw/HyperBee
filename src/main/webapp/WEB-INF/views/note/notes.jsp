<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>All Notes</title>

    <script type="text/javascript">
        $(function () {
            $('#datetimepicker1').datetimepicker({
                minDate: moment()
            });
        });
    </script>

</head>

<body>

<form:form action="/user/note/save" method="post" commandName="noteCommand">
    <div class="panel panel-success">
        <div class="panel-heading clearfix">
            <h4 class="panel-title pull-left" style="padding-top: 7.5px;">Add Note</h4>

            <div class='pull-right col-sm-2' style="width: 18.20%">

                <div class='input-group date' id='datetimepicker1'>
                    <input name="dateRemindString" type="text" class="form-control"
                           placeholder="Remember Me!"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>

            </div>

        </div>
        <div class="panel-body">
            <form:input id="title" type="text" placeholder="Title" class="form-control"
                        path="title"/>
            <form:input id="description" type="text" placeholder="Description" class="form-control"
                        path="description"/>
        </div>
        <div class="panel-footer clearfix">
            <div class="btn-group pull-right">
                <button class="btn btn-warning btn-sm" type="submit">Save</button>
            </div>
        </div>
    </div>
</form:form>


<c:forEach items="${noteList}" var="item">
    <form:form action="/note/delete/${item.id}" method="post">
        <div class="panel panel-warning">
            <div class="panel-heading clearfix">
                <h4 class="panel-title pull-left" style="padding-top: 7.5px;"><strong>${item.title}</strong></h4>

                <div class="btn-group pull-right">
                    <button class="btn btn-default btn-sm" type="submit">Delete</button>
                </div>
            </div>
            <div class="panel-body">${item.description}</div>
            <div class="panel-footer clearfix">
                <div class="pull-right">
                        ${item.getRemindDateFormatted()}
                </div>
            </div>
        </div>
    </form:form>
</c:forEach>
</body>
</html>
