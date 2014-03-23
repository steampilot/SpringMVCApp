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
            <h1>Venues</h1>
            <form:form method="post" action="add" commandName="venue" role="form">
                <div class="form-group">
                    <form:label path="title">Title:</form:label>
                    <form:input path="title" class="form-control" placeholder="Title of this Venue"/>
                </div>
                <div class="form-group">
                    <form:label path="description">Description:</form:label>
                    <form:input path="description" class="form-control" placeholder="Description"/>
                </div>
                <div class="form-group">
                    <form:label path="address1">Address 1</form:label>
                    <form:input path="address1" class="form-control" placeholder="Address 1"/>
                </div>
                <div class="form-group">
                    <form:label path="address2">Address 2</form:label>
                    <form:input path="address2" class="form-control" placeholder="Address 2"/>
                </div>
                <div class="form-group">
                    <form:label path="zipCode">Zip Code</form:label>
                    <form:input path="zipCode" class="form-control" placeholder="Zip Code"/>
                </div>
                <div class="form-group">
                    <form:label path="city">City</form:label>
                    <form:input path="city" class="form-control" placeholder="City"/>
                </div>
                <div class="form-group">
                    <form:label path="country">Country</form:label>
                    <form:input path="country" class="form-control" placeholder="Country"/>
                </div>
                <button type="submit" class="btn btn-default">Add Venue</button>
            </form:form>

            <c:if test="${!empty venues}">
                <h3>Venues</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Address</th>
                            <th>&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${venues}" var="venue">
                            <tr>
                                <td>${venue.title}</td>
                                <td>${venue.description}</td>
                                <td>${venue.address1}
                                <c:if test="${!empty venue.address2}">
	                                , ${venue.address2},
                                </c:if>
	                            ${venue.zipCode},
	                            ${venue.city},
	                            ${venue.country}
                                </td>
                                <td>
	                                <form:form action="delete/${venue.id}" method="post"><input type="submit"
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