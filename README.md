# LiferayTutorials
Liferay repo for basic tutorials and hands on.


# SpringMVCPortletTest
This project is an example of creating multiple Spring MVC Controller setup in a single plugin project.
Important thing to note is that you need to follow project structure in exact same way as created above. Following are some basic thumb rules provided :- 

# Thumb rule
To Add additional spring mvc portlet in single plugin

 1. Add new controller. Make sure you choose new java package
 2. Add portlet jsp. Make sure you add inside new folder
 3. Add portlet specific application context file. In this file, you need to set parent path of JSP to viewResolver bean.
 4. Update Liferay specific configuration files
      portlet.xml
      Add new portlet entry (with correct portlet name)
      Make sure you give correct path of portlet specific application context file (that you created in #3 above) in init param
      liferay-portlet.xml
      Add new portlet entry (with correct portlet name)
      liferay-display.xml
      Add new portlet entry with id as it’s name defined in portlet.xml

  5. It’s always good idea to split your work in multiple spring controller instead just put all your methods in one big controller. 
     In this scenario, you no need to create new Maven Spring MVC Portlet. 
     Just add additional controllers in same package.

And this is done. Express your thoughts in comment section to make this topic more interesting.

# Summing Up
Spring MVC is one of the most popular framework to create portlet in liferay.
Spring MVC portlet will have multiple controllers.
mapping of controller and JSP is defined in application context file.
Path of application context file is configured in portlet.xml file.
To add new portlet, you need to create separate controller package, jsp folder, application context path and have to made separate portlet entry in portlet.xml, liferay-portlet.xml and liferay-display.xml files.

# Reference taken from 
http://www.opensource-techblog.com/2017/08/maven-spring-mvc-portlet.html


