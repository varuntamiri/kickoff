<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="ter" type="com.technoglitz.domain.FinDeciForm" -->
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
<#if currentUser?? && (currentUser.role == "FINANCE") >
<h1>Finance Desicion</h1>
    <div>
        <label>Pick Decision</label>
        <select name="finStat" id="finStatus" required>   
    <#list ter.finStatus as man>
	    <option value="${man}" selected>${man}</option>
    </#list>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="hidden" name="ter.id" value="${ter.id}"/>
    <button type="submit">Submit</button>
</#if>
</form>
</body>
</html>