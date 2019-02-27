<%@ include file="/jsp/init.jsp" %>

<strong>
	<liferay-ui:message key="Welcome to Spring MVC Portlet Example" />
</strong>


<b>State Change By Ajax</b> <br>
Country:
<select id="country" name="country">
<option value="select">Select Country</option>
<option value="india">India</option>
<option value="usa">USA</option>
</select>

<br><br>
State:
<select id="state" name="state">
</select>


<aui:button-row>
	<portlet:renderURL var="anotherViewURL">
		<portlet:param name="action" value="anotherView" />
	</portlet:renderURL>
	
	<portlet:actionURL var="myActionURL">
		<portlet:param name="action" value="myAction" />
	</portlet:actionURL>
	
	<portlet:resourceURL id="myRestCallId" var="myRestCall" >
	</portlet:resourceURL>

	<aui:button href="<%=anotherViewURL%>" value="View Me" />
	<aui:button href="<%=myActionURL%>" value="Watch Me in Action!!!" />
</aui:button-row>

<br />

<script>
$(document).ready(function(){
	
	$( "#country" ).change(function() {
		alert('CountryID ='+$("#country").val());
		  $.ajax({
		        url: "${myRestCall}" ,
		        type: 'POST',
		        datatype:'json',
		        data: { 
		        	<portlet:namespace/>mycountry: $("#country").val() 
			      },
		            success: function(data){
		            var content= JSON.parse(data);
		            $('#state').html('');// to clear the previous option
		            $.each(content, function(i, state) {
		            	 $('#state').append($('<option>').text(state.name).attr('value', state.stateId));
		            });
		        }
		    });
	  }); 
	});
</script>
