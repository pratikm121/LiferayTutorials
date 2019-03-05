<%@ include file="/init.jsp" %>

<portlet:defineObjects />
<portlet:resourceURL var="testAjaxResourceUrl" id = "testAjaxResourceUrlId"></portlet:resourceURL>
<portlet:resourceURL var="formSubmitUrl" id = "formSubmitUrlId"></portlet:resourceURL>

<div id="targetId">
  <button type="submit" >Target Button <span ></span></button>
</div>

 <!-- OUR FORM class="form-group" class="form-control" class="btn btn-success" class="fa fa-arrow-right"-->
    <form action="" method="POST" class="form-group">

        <!-- NAME -->
        <div id="name-group" >
            <label for="name">Name</label>
            <input type="text" class="form-control" name="name" placeholder="Henry Pym">
            <!-- errors will go here -->
        </div>

        <!-- EMAIL -->
        <div id="email-group" >
            <label for="email">Email</label>
            <input type="text" class="form-control" name="email" placeholder="rudd@avengers.com">
            <!-- errors will go here -->
        </div>

        <!-- SUPERHERO ALIAS -->
        <div id="superhero-group">
            <label for="superheroAlias">Superhero Alias</label>
            <input type="text" class="form-control" name="superheroAlias" placeholder="Ant Man">
            <!-- errors will go here -->
        </div>

        <button type="submit" class="btn btn-success">Submit <span class="fa fa-arrow-right"></span></button>

    </form>
    
<script type="text/javascript">

 $(document).ready(function() {
	
	 alert( "loadedd" );
	 
	// process the form
	    $('form').submit(function(event) {

	        // get the form data
	        // there are many ways to get this data using jQuery (you can use the class or id also)
	        

	        // process the form
	        $.ajax({
	            type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
	            url			: '${formSubmitUrl}', // the url where we want to POST
	            data: {
	            	   <portlet:namespace />name: $('input[name=name]').val(),
	            	   <portlet:namespace />email: $('input[name=email]').val(),
	               },
	               success: function(responseData) {
	                   alert(responseData.output);
	                   
	               }
	        })
	            // using the done promise callback
	            .done(function(data) {

	                // log data to the console so we can see
	                console.log(data); 

	                // here we will handle errors and validation messages
	            });

	        // stop the form from submitting the normal way and refreshing the page
	        event.preventDefault();
	    });
	 
	 
	 
	
	$( "#targetId" ).click(function() {
		console.log( "Handler for .click() called." );
		  $.ajax({
			  type: "POST",
			  url: '${testAjaxResourceUrl}',
			  data: {
           	   <portlet:namespace />sampleParam: 'value2',
              },
              success: function(responseData) {
                  alert(responseData.jsonResponse);
                  
              }
			});
		  
	});

});   

</script>