<%@ include file="/init.jsp" %>
<portlet:defineObjects />
<portlet:resourceURL var="profileUrl" id = "profileUrlId"></portlet:resourceURL>


<div id="profile">
  <button type="submit" class="btn btn-success">Target<span class="fa fa-arrow-right"></span></button>
</div>

<script type="text/javascript">

 $(document).ready(function() {
	
	 $( "#profile" ).click(function() {
		    alert( "loadedd" );
			console.log( "Profile button clicked" );
			  $.ajax({
				  type: "POST",
				  url: '${profileUrl}',
				  data: {
	           	   <portlet:namespace />sampleParam: 'Got the value',
	              },
	              success: function(responseData) {
	                  console.log('got the data ='+responseData);
	              }
				});
			  
		});

});   

</script>

