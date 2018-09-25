
A simple servlet that uses Maven, JDBC, and Jetty to say 'Hello world'

Setup The Database
------------------

First, install / make a database as described in [Official Firebird DB](Docu]https://firebirdsql.org/manual/ubusetup.html);

If you have changed any of the values in the example SQL above, edit
the file `src/main/resources/application.properties` and edit these
properties:

     
    mjjs.datasource.url=jdbc:firebirdsql://firebirddb_Host//var/lib/firebird/2.5/data/employee.fdb
    mjjs.datasource.username=SYSDBA
    mjjs.datasource.password=VerySecurePa$$w0rd!
    mjjs.datasource.driverClassName=org.firebirdsql.jdbc.FBDriver
    
    initial.sql.query= SELECT * FROM EMPLOYEE  
    initial.sql.query.field.name=FIRST_NAME

Build / Run
-----------

    mvn clean compile install jetty:run

Then navigate to 

    http://localhost:9090/mjjs/hello


If all goes well, you will see output like the following:

    Welcome to hello world!
    Reading /application.properties ...
    name=Robert
    name=Bruce
    name=Kim
    name=Leslie
    name=Phil
    name=K. J.
    name=Terri
    name=Stewart
    name=Katherine
    ...
    name=Mark
    Successfully read 42 rows from the database


Looking at the Source Code
--------------------------

* The [`pom.xml`](https://github.com/csev/maven-jetty-jdbc-servlet/blob/master/pom.xml) file controls the build process - it tells `mvn` where the source files 
are located and what output files to produce.  It also tells `mvn` to download library code
for the declared code libraries that this application "depends on".

* The [`src/main/java/mjjs/HelloServlet.java`](https://github.com/csev/maven-jetty-jdbc-servlet/blob/master/src/main/java/mjjs/HelloServlet.java) contains the source code for our Java Servlet.
If you look at the code, you will see methods for doGet() and doPost() - these methods are
called when there is a GET or POST to the application's URLs.  It defines a class called
`mjjs.HelloServlet` that is referenced in the next file.   You can debug this program by 
adding calls to `System.out.println()` and those print statements will come out on your console.

* The [`src/main/webapp/WEB-INF/web.xml`](https://github.com/csev/maven-jetty-jdbc-servlet/blob/master/src/main/webapp/WEB-INF/web.xml) file tells the servlet container ([Jetty](http://www.eclipse.org/jetty/) in this case)
which URLs are to be handed to which classes.  If you lok at this file, it has two 
sections - one defines a servlet and maps it to the java class and the other takes a URL
pattern and indicates that it needs to be sent to a particular servlet (i.e. which Java class).

    
Background Documentation to Read
--------------------------------

These are some online resources to read that explain how things in this servlet works:

* [How to Write a Hello World Servlet](http://stackoverflow.com/questions/18821227/how-to-write-hello-world-servlet-example)
* HttpServlet interface - [javax.servlet.http.HttpServlet](http://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpServlet.html)
* Request Object interface - [javax.servlet.http.HttpServletRequest](http://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpServletRequest.html)
* Response Object Interface - [javax.servlet.http.HttpServletResponse](http://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpServletResponse.html)
* [Lesson: JDBC Basics](https://docs.oracle.com/javase/tutorial/jdbc/basics/)
* Database Connection interfaces - [java.sql](http://docs.oracle.com/javase/7/docs/api/java/sql/package-summary.html)


Errors
------

If you end up with this error, 

    No plugin found for prefix 'jetty' in the current project and in the
    plugin groups [org.apache.maven.plugins, org.codehaus.mojo] available
    from the repositories


