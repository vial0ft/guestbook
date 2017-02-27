<%@	taglib	uri="http://java.sun.com/jsp/jstl/core"	prefix="c"	%>
<%@	taglib	uri="http://www.springframework.org/tags"	prefix="spring"	%>
<%@	taglib	uri="http://www.springframework.org/tags/form"	prefix="form"	%>
<%@	page	session="false"	%>
<html>
    <meta http-equiv="Content-type" content="text/html;charset=utf-8">
    <head>
        <title>Guestbook</title>
        <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
        <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
        <link href="${bootstrapCss}" rel="stylesheet" />
        <script src="${bootstrapJs}"></script>
        <style	type="text/css">
            .container {
                text-align: center;  

            }    

            .pre-scrollable {
                max-height: 300px;
                max-width: 75%;
                overflow-y: auto;
                overflow-x: hidden;
            }
            .row {
                text-align: left;
                margin: 10px;
            }
        </style>
    </head>
    <body>


        <div class="container">

            <h2>Guestbook</h2>
            <h3>Write something</h3>

            <c:if test="${!empty listAllComments}">
                <div class="pre-scrollable center-block ">
                    <c:forEach items="${listAllComments}" var="comment">

                        <div class="row">
                            <h2>${comment.userName}</h2>
                            <p>${comment.comment}<p>
                        </div>

                    </c:forEach>
                </div>
            </c:if>

            <c:url	var="addAction"	value="/addComment"></c:url>
            <div class="form-group form-group-lg"> 
            <form:form action="${addAction}" commandName = "comment">
                <form:label path="userName"> Your name</form:label><br>

                <form:input size="20" path="userName"/><br>
                <form:errors path="userName"/> <br>
                <br>
                <form:label path="comment"> Comment:</form:label><br>
                <form:textarea rows="5" cols="45" path="comment"/><br>
                <form:errors path="comment"/><br>
                <br>
                <input	type="submit" value="add"/>

            </form:form>
            </div>    
        </div>
    </body>
</html>