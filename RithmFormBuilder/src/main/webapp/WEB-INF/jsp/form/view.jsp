<%@ include file="/WEB-INF/jsp/init.jsp" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
 
<portlet:defineObjects />
 
<portlet:renderURL var="renderURL">
    <portlet:param name="action" value="showForm"/>
</portlet:renderURL>
 
<h3> Spring Form Submission Demo</h3>
 
<br/><br/>
 
<a href="<%=renderURL.toString()%>">Go to Form Page</a>