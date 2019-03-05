<%@ include file="/WEB-INF/jsp/init.jsp" %>
<theme:defineObjects/>
<portlet:defineObjects />


<strong>
	<liferay-ui:message key="Welcome to Spring MVC Portlet Example" />
</strong>


<aui:button-row>
	<portlet:renderURL var="anotherViewURL">
		<portlet:param name="action" value="anotherView" />
	</portlet:renderURL>
	
	<portlet:actionURL var="myActionURL">
		<portlet:param name="action" value="myAction" />
	</portlet:actionURL>
	
	<portlet:resourceURL var="resourceURL" id = "resourceURLId"/>
	<portlet:resourceURL var="resourceURL2" id = "resourceURLId2"/>

	<aui:button href="<%= anotherViewURL %>" value="View Me" />
	<aui:button href="<%= myActionURL %>" value="Watch Me in Action!!!" />
</aui:button-row>

<div id="Submit">
  <button type="submit" id = "SubmitButton">SubmitButton<span ></span></button>
  <button type="submit" id = "SubmitButton2">SubmitButton2<span ></span></button>
  <p id="output"></p>
</div>



<script type="text/javascript">
$(document).ready(function() {	 
	 console.log( "JqueryLoaded" );
	 
	 $( "#SubmitButton" ).click(function() {
			alert( "Submit button called." );
			  $.ajax({
				  type: "POST",
				  url: '${resourceURL}',
				  data: {
	            	   <portlet:namespace />site: 'www.fg.com',
	            	   <portlet:namespace />author: 'Pratik'
	            	},
	              success: function(responseData) {
	            	  console.log(responseData);
	              }
				});
			  
		});
	 
	 $( "#SubmitButton2" ).click(function() {
			alert( "Submit button 2 called." );
			  $.ajax({
				  type: "POST",
				  url: '${resourceURL2}',
				  data: {
	            	   <portlet:namespace />site: 'www.horray.com',
	            	   <portlet:namespace />author: 'Pratik Mehta'
	            	},
	              success: function(responseData) {
	            	  $( "#output" ).append( responseData );
	            	  console.log(responseData);
	              }
				});
			  
		});
});
</script>
