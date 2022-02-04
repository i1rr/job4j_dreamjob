<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Dream job</title>
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <ul class="nav">
            <li>
                <a class="nav-link" href="<%=request.getContextPath()%>/posts.do">Jobs</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/candidates.do">Candidates</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/post/edit.jsp">Add vacancy</a>
            </li>
            <li>
                <a class="nav-link" href="<%=request.getContextPath()%>/candidate/edit.jsp">Add candidate</a>
            </li>
            <c:if test="${user == null}">
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp"> Login</a>
                </li>
            </c:if>
            <c:if test="${user != null}">
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/logout.do"> <c:out value="${user.name}"/> | Logout</a>
                </li>
            </c:if>
        </ul>
    </div>

    <div class="row">
        <div class="card" style="width: 100%">
            <div>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Photo </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${candidates}" var="candy">
                    <tr>
                        <td>
                            <a href='<c:url value="/candidate/edit.jsp?id=${candy.id}"/>'>
                            <i class="fa fa-edit mr-3"></i>
                            </a>
                            <c:out value="${candy.name}"/>
                            <form method="post" action="<c:url value='/delete?id=${candy.id}'/>" enctype="multipart/form-data">
                                <input type="submit" name="file" value="Delete candidate" >
                            </form>
                        </td>
                        <td>
                            <img src="<c:url value='/download?name=${candy.id}.png'/>" width="100px" height="100px"/>
                            <form method="post" action="<c:url value='/upload.jsp?id=${candy.id}'/>" enctype="multipart/form-data">
                                <input type="submit" name="file" value="Add photo" >
                            </form>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>