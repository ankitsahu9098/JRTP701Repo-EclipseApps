<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${!empty empsList}">
		<h1 style="color:yello;text-align:center">Employee Report</h1>
			<table border="1" align="center" bgcolor="cyan">
				<tr style="color:red"><th>empno</th><th>emp name</th><th>Job</th><th>salary</th><th>deptno</th><th>Operations</th></tr>
				<c:forEach var="emp" items="${empsList }">
					<tr>
					<td>${emp.empno }</td>
					<td>${emp.ename }</td>
					<td>${emp.job }</td>
					<td>${emp.sal }</td>
					<td>${emp.deptno }</td>
					<td><a href="edite?eno=${emp.empno }"><img src="images/edite.png" width="30px" height="30px"></a>&nbsp;&nbsp;
					<a href="delete?eno=${emp.empno }" 
					onclick="return confirm('are u sure do u want to delete?')"><img src="images/delete.jpeg" width="30px" height="30px"></a></td>
					</tr>
				</c:forEach>
			</table>
			</c:when>
			<c:otherwise>
				<h1 style="color:red;text-align:center">Employees Not found</h1>
			</c:otherwise>
			</c:choose>
			
			<h2 style="color:green; text-align:center">${resultMsg }</h2>
			
			<center>
			<h3>${ResultMsg }</h3>
				<a href="register"><img alt="add emp icon" src="images/adduser.png" width="30px" height="30px">Add Employee</a>&nbsp;&nbsp;
				<a href="./"><img alt="home icon" src="images/home.png" width="30px" height="30px">Home</a>
			</center>