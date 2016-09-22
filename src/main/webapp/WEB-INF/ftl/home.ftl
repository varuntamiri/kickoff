<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="com.technoglitz.domain.CurrentUser" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home page</title>
</head>
<body>
<nav role="navigation">
    <ul>
    <#if !currentUser??>
        <li><a href="/login">Log in</a></li>
    </#if>
    <#if currentUser??>
        <li>
            <form action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">Log out</button>
            </form>
        </li>
        <li><a href="/user/${currentUser.id}">View myself</a></li>
        <#if (currentUser.role == "EMPLOYEE") >
        <li><a href="/ter/create">Create Travel Expense Report</li>
        <li><a href="/ters/${currentUser.id}">View Travel Expense Reports</li>
        </#if>
        <#if (currentUser.role == "MANAGER") >
        <li><a href="/ters/man/${currentUser.id}">View Travel Expense Reports</li>
        </#if>
        <#if (currentUser.role == "FINANCE") >
        <li><a href="/ters/fin">View Travel Expense Reports</li>
        </#if>

    </#if>
    <#if currentUser?? && (currentUser.role == "MANAGER") >
        <li><a href="/user/create">Create a new user</a></li>
        <li><a href="/users">View all users</a></li>
    </#if>
    </ul>
</nav>
</body>
</html>