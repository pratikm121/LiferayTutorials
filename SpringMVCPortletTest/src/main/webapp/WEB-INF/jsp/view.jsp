<%@ include file="/WEB-INF/jsp/init.jsp" %>

<strong>
	<liferay-ui:message key="Welcome to Spring MVC Portlet Example" />
</strong>

<p>
	<b>Hello </b> <c:out value="${myName}"/>
	<b>Your Email is= </b> <c:out value="${myParams}"/>
	<b>Your Jaan is= </b> <c:out value="${myJaan}"/>
	
</p>

<aui:button-row>
	<portlet:renderURL var="anotherViewURL">
		<portlet:param name="action" value="anotherView" />
	</portlet:renderURL>
	
	<portlet:actionURL var="myActionURL">
		<portlet:param name="action" value="myAction" />
	</portlet:actionURL>

	<aui:button href="<%= anotherViewURL %>" value="View Me" />
	<aui:button href="<%= myActionURL %>" value="Watch Me in Action!!!" />
</aui:button-row>

