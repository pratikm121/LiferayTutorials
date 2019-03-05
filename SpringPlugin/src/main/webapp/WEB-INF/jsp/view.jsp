<%@ include file="/WEB-INF/jsp/init.jsp" %>

<c:set var="employee" value="${employee}"/>
<c:set var="employeeName" value="${employeeName}"/>
<c:set var="emp" value="${emp}"/>

<body>
	<div class="jumbotron jumbotron-fluid">
	  <div class="container">
	    <h1>Bootstrap Tutorial</h1>      
	    <p>Bootstrap is the most popular HTML, CSS, and JS framework for developing responsive, mobile-first projects on the web.</p>
	  </div>
	</div>

<div class="container">

      <c:if test="${empty employee}">
		    No Data Received.
	  </c:if>
	  <c:if test="${not empty employee}">
		    Below are the data for the employee <br>
		    ${employee}<br>
		    ${employeeName} 
	  </c:if>
	  
	  <c:if test="${empty emp}">
		    No Data Received.
	  </c:if>
	  <c:if test="${not empty emp}">
		    Below are the data for the employee  ${emp.firstName} ${emp.lastName}<br>
		    Employee Number = ${emp.employeeNumber}<br>
	  </c:if>
	  
	  <div class="container">
  <h2>Striped Rows</h2>
  <p>The .table-striped class adds zebra-stripes to a table:</p>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
      </tr>
    </tbody>
  </table>
</div>
   </body>
   