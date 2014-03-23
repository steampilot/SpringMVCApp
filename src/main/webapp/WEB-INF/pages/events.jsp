<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="utf-8">
        <title>Spring MVC Application</title>

        <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="container">
            <h1>Events</h1>
            <form:form method="post" action="add" commandName="event" role="form">
                <div class="form-group">
                    <form:label path="title">Title:</form:label>
                    <form:input path="title" class="form-control" placeholder="Title of this Event"/>
                </div>
                <div class="form-group">
                    <form:label path="description">Description:</form:label>
                    <form:input path="description" class="form-control" placeholder="Description"/>
                </div>
                <div class="form-group">
                    <form:label path="beginDate">Begin Date</form:label>
                    <form:input path="beginDate" class="form-control" placeholder="Begin Date"/>
                </div>
                <div class="form-group">
                    <form:label path="endDate">End Date</form:label>
                    <form:input path="endDate" class="form-control" placeholder="End Date"/>
                </div>
                <button type="submit" class="btn btn-default">Add Event</button>
            </form:form>

            <c:if test="${!empty events}">
                <h3>Events</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Begin Date</th>
                            <th>End Date</th>
                            <th>&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${events}" var="event">
                            <tr>
                                <td>${event.title}</td>
                                <td>${event.description}</td>
                                <td>${event.beginDate}</td>
                                <td>${event.endDate}</td>
                                <td>
                                    <form:form action="delete/${event.id}" method="post"><input type="submit"
                                                                                               class="btn btn-danger btn-mini"
                                                                                               value="Delete"/>
                                    </form:form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </body>
</html>