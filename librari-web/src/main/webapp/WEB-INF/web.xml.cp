<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">
    <servlet>
        <servlet-name>counter</servlet-name>
        <servlet-class>CounterServlet</servlet-class>
    </servlet>
    <servlet>
        <servlet-name>publishers-list</servlet-name>
        <servlet-class>PublisherServlet</servlet-class>
    </servlet>
    <servlet>
        <servlet-name>Faces Servlet</servlet-name>
        <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>counter</servlet-name>
        <url-pattern>/count</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>publishers-list</servlet-name>
        <url-pattern>/publishers-list</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>Faces Servlet</servlet-name>
        <url-pattern>*.xhtml</url-pattern>
    </servlet-mapping>
</web-app>
