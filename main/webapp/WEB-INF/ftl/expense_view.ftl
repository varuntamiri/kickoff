<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="ter" type="java.util.List<com.technoglitz.domain.ManagerForm>" -->
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
<#if currentUser?? && (currentUser.role == "EMPLOYEE") >
<h1>Select a manager </h1>
    <div>
        <label>Pick Manager</label>
        <select name="manId" id="manId" required>   
    <#list ter as man>
    <option value="${man.manId}" selected>${man.email}</option>
    <input type="hidden" name="terId" value="${man.terId}"/>
    </#list>
    <button type="submit">Submit</button>
</#if>
</form>
</body>
</html>