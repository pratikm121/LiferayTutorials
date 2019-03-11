<%@ include file="/WEB-INF/jsp/init.jsp" %>
<portlet:actionURL var="submitFormURL" name="handleCustomer"/>

<form:form name="formData" method="post" modelAttribute="formData" action="<%=submitFormURL.toString() %>">
  <div class="form-group">
    <label for="firstName">First Name</label> 
    <input id="firstName" name="firstName" placeholder="First Name" type="text" required="required" class="form-control">
  </div>
  <div class="form-group">
    <label for="lastName">Last Name</label> 
    <input id="lastName" name="lastName" placeholder="Last Name" type="text" required="required" class="form-control">
  </div>
  <div class="form-group">
    <label for="initials">Initials</label> 
    <input id="initials" name="initials" placeholder="Initials" type="text" class="form-control">
  </div>
  <div class="form-group">
    <label for="personalEmailId">Personal Email Id</label> 
    <input id="personalEmailId" name="personalEmailId" placeholder="Personal Email Id" type="text" required="required" class="form-control">
  </div>
  <div class="form-group">
    <label for="officeEmailId">Office Email Id</label> 
    <input id="officeEmailId" name="officeEmailId" placeholder="Office Email Id" type="text" class="form-control" required="required">
  </div>
  <div class="form-group">
    <label for="jobDescription">Job Description</label> 
    <input id="jobDescription" name="jobDescription" placeholder="Designation" type="text" class="form-control" required="required">
  </div>
  <div class="form-group">
    <label for="dob">Date of Birth</label> 
    <input id="dob" name="dob" placeholder="Date of birth" type="date" class="form-control" aria-describedby="dobHelpBlock" required="required"> 
    <span id="dobHelpBlock" class="form-text text-muted">Please enter the date in yyyy-mm-dd format</span>
  </div>
  <div class="form-group">
    <label for="doj">Date of joining</label> 
    <input id="doj" name="doj" placeholder="Date of joining" type="date" class="form-control" aria-describedby="dojHelpBlock" required="required"> 
    <span id="dojHelpBlock" class="form-text text-muted">Please enter the date in yyyy-mm-dd format</span>
  </div>
  <div class="form-group">
    <label>Gender</label> 
    <div>
      <div class="custom-control custom-radio custom-control-inline">
        <input name="gender" id="gender_0" type="radio" required="required" class="custom-control-input" value="Male"> 
        <label for="gender_0" class="custom-control-label">Male</label>
      </div>
      <div class="custom-control custom-radio custom-control-inline">
        <input name="gender" id="gender_1" type="radio" required="required" class="custom-control-input" value="Female"> 
        <label for="gender_1" class="custom-control-label">Female</label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <label for="text">Personal Mobile</label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">+31</div>
      </div> 
      <input id="text" name="text" type="text" class="form-control">
    </div>
  </div>  
  <div class="form-group">    
    <button name="submit" type="submit" id = "submit" class="btn btn-primary">Submit</button>
  </div>
</form:form>

<script>
$(document).ready(function(){

});
</script>