<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="com.technoglitz.domain.CurrentUser" -->
<#-- @ftlvariable name="ter" type="com.technoglitz.domain.ManagerDeciForm" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Travel Expense details</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>
<form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<#if currentUser?? && (currentUser.role == "MANAGER") >
<h1>Request to decide </h1>
    <div>
        <label>Make Decision </label>
        <select name="manStat" id="manStat" required>
    <#list ter.manStatus as man>
	    <option value="${man}" selected>${man}</option>
    </#list>
	    <input type="hidden" name="terId" value="${ter.terId}"/>
	    <input type="hidden" name="manId" value="${currentUser.id}"/>
    <button type="submit">Submit</button>
</#if>
</form>
</body>
</html>