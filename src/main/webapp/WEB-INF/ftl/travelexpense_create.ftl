<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.technoglitz.domain.TravelExpenseCreateForm" -->
<#-- @ftlvariable name="currentUser" type="com.technoglitz.domain.CurrentUser" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create a new user</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>Create a new user</h1>

<form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="hidden" name="userId" value="${currentUser.id}"/>
    <input type="hidden" name="status" value="DRAFT"/>

    <div>
        <label for="purpose">Puropse of the Travel</label>
        <input type="text" name="purpose" id="purpose" required autofocus/>
    </div>
    <div>
        <label for="startDate">Start Date in dd/mm/yyy format</label>
        <input type="text" name="startDate" id="startDate" required/>
    </div>
    <div>
        <label for="endDate">End Date in dd/mm/yyyy format</label>
        <input type="text" name="endDate" id="endDate" required/>
    </div>
    <div>
        <label for="modeOfTravel">Mode Of Travel</label>
        <select name="modeOfTravel" id="modeOfTravel" required>
            <option <#if form.modeOfTravel == 'AIR'>selected</#if>>AIR</option>
            <option <#if form.modeOfTravel == 'RAIL'>selected</#if>>RAIL</option>
            <option <#if form.modeOfTravel == 'ROAD'>selected</#if>>ROAD</option>
        </select>
    </div>
    <div>
        <label for="cost">Travel Mode Cost*</label>
        <input type="text" name="cost" id="cost" required/>
    </div>
    <div>
        <label for="costFromHomeToAirport">Cost From Home To Airport*</label>
        <input type="text" name="costFromHomeToAirport" id="costFromHomeToAirport" required/>
    </div>
    <div>
        <label for="costFromAirportToAccomodation">Cost From Airport To Accomodation*</label>
        <input type="text" name="costFromAirportToAccomodation" id="costFromAirportToAccomodation" required/>
    </div>
            <div>
        <label for="costOfHotelAccomodation">Cost Of Hotel Accomodation*</label>
        <input type="text" name="costOfHotelAccomodation" id="costOfHotelAccomodation" required/>
    </div>
    <div>
        <label for="costOfLocalConvayance">Cost Of Local Convayance*</label>
        <input type="text" name="costOfLocalConvayance" id="costOfLocalConvayance" required/>
    </div>
    <div>
    	<label>* Enter values in 123ABC format where 123 refer to number of digits and ABC refers to a valid currency code</label>
    	
    </div>
    <button type="submit">Save</button>
</form>

<@spring.bind "form" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>

</body>
</html>