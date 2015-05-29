<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<header>
</header>
<body>
<div>
<form:form commandName="searchCompare">
	<table>
		<tr>
			<td>formula1:</td>
			<td><form:input path="formula1"/></td>
			<td><form:errors path="formula1"></form:errors>
		</tr>
		<tr>
			<td>formula2:</td>
			<td><form:input path="formula2"/></td>
			<td><form:errors path="formula2"></form:errors>
		</tr>
		<tr>
			<input type="submit" value="search"/>
		</tr>
		
	</table>
</form:form>
</div>
<div>
<div>
	<head>section1</head>
	<div>
		"${searchCompare.formula1}"
	</div>
</div>
<div>
	section2
</div>
	"${searchCompare.formula2}"
</div>

</body>
</html>