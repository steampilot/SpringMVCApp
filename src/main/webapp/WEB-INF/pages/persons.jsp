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
            <h1>Persons</h1>
            <form:form method="post" action="add" commandName="person" role="form">
	            <div class="form-group">
		            <form:label path="firstName">First Name:</form:label>
		            <form:input path="firstName" class="form-control" placeholder="First Name"/>
	            </div>
	            <div class="form-group">
		            <form:label path="lastName">Last Name:</form:label>
		            <form:input path="lastName" class="form-control" placeholder="Last Name"/>
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
	            <div class="form-group">
		            <form:label path="email">Email:</form:label>
		            <form:input path="email" class="form-control" placeholder="Email"/>
	            </div>

                <button type="submit" class="btn btn-default">Add Person</button>
            </form:form>

            <c:if test="${!empty persons}">
                <h3>Persons</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>E-Mail</th>
                            <th>Address</th>
                            <th>&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${persons}" var="person">
                            <tr>
                                <td>${person.lastName}, ${person.firstName}</td>
                                <td>${person.email}</td>
                                <td>${person.address1}&nbsp;
                                <c:if test="${!empty person.address2}">
	                                ${person.address2}&nbsp;
                                </c:if>
	                            ${person.zipCode}&nbsp;
	                            ${person.city} &nbsp;
	                            ${person.country}
                                </td>
                                <td>
	                                <form:form action="delete/${person.id}" method="post"><input type="submit"
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