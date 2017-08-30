<#-- @ftlvariable name="currentUser" type="eu.kielczewski.example.domain.CurrentUser" -->
<#-- @ftlvariable name="ters" type="java.util.List<com.technoglitz.domain.TravelExpenseReport>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List of Users</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <#if (currentUser.role == "EMPLOYEE") >
        <li><a href="/ter/create">Create Travel Expense Report</a></li>
        </#if>
    </ul>
</nav>

<h1>List of Travel Expense Reports</h1>

<table>
    <thead>
    <tr>
        <th>Status</th>
        <th>StartDate</th>
        <th>Purpose</th>
    </tr>
    </thead>
    <tbody>
    <#list ters as ter>
    <tr>
      <#if (currentUser.role == "EMPLOYEE")>
      <#if (ter.status == "DRAFT")>
        <td><a href="/ter/${ter.id}">${ter.status}</a></td>
        <#else>
        <td>${ter.status}</td>
        </#if>
      </#if>
      <#if (currentUser.role == "MANAGER") >
        <td><a href="/ter/man/${ter.id}">${ter.status}</a></td>
       </#if>
      <#if (currentUser.role == "FINANCE") >
        <td><a href="/ter/fin/${ter.id}">${ter.status}</a></td>
       </#if>
       
        <td>${ter.startDate}</td>
        <td>${ter.purpose}</td>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>