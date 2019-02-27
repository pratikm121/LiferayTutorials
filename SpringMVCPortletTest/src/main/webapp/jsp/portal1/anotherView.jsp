<%@ include file="/jsp/init.jsp" %>

<strong>
	<liferay-ui:message key="Welcome to AnotherViewURL" />
</strong>

<portlet:actionURL var="myActionURL">
		<portlet:param name="action" value="myAction" />
</portlet:actionURL>


<aui:form name="myForm" action="<%=myActionURL%>" method="POST" >
    <aui:fieldset-group markupView="lexicon">
       <aui:fieldset label="Personal Information">
         <aui:row>
          <aui:col width="50">
              <aui:input label="First Name" name="firstName" type="text" />
          </aui:col>
          <aui:col width="50">
              <aui:input label="Last Name" name="lastName" type="text" />
          </aui:col>
         </aui:row>
         <aui:row>
          <aui:col width="50">
              <aui:input label="Username" name="username" type="text" />
          </aui:col>
          <aui:col width="50">
              <aui:input label="Email" name="email" type="email" />
          </aui:col>
         </aui:row>
       </aui:fieldset>
    </aui:fieldset-group>
    <aui:fieldset-group markupView="lexicon">
       <aui:fieldset label="Miscellaneous">
         <aui:input label="Hobbies" name="hobbies" type="textarea" />
         <aui:input label="Receive email updates" name="emailUpdates" type="checkbox" />
       </aui:fieldset>
    </aui:fieldset-group>
    <aui:button-row>
       <aui:button name="submitButton" type="submit" value="Watch Me in Action!!!" />
    </aui:button-row>
</aui:form>

