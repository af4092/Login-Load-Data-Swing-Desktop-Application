# Login-Load-Data-Swing-Desktop-Application
This desktop application shows the login process and loading the data from database

![image](https://user-images.githubusercontent.com/24220136/223287669-af34fd7d-7635-4454-b724-7d02d21e0c28.png)

![image](https://user-images.githubusercontent.com/24220136/223287701-7dfd2f44-3732-4115-8960-800fd9f44e02.png)

--------------------

## JDBC is the Java API for accessing relational database.

The Java API for developing Java database applications is called JDBC. JDBC is the trademarked name of a Java API that supports Java programs that access relational databases. JDBC is not an acronym, but it is often thought to stand for Java Database Connectivity. 

JDBC provides Java programmers with a uniform interface for accessing and manipulating relational databases. Using the JDBC API, applications written in the Java programming language can execute SQL statements, retrieve results, present data in a user-friendly interface, and propagate changes back to the database. The JDBC API can also be used to interact with multiple data sources in a distributed, heterogeneous environment.

![image](https://github.com/af4092/Login-Load-Data/assets/24220136/95edfd62-ded5-4da3-9b41-afe332c6d5bb)

The JDBC API is a Java application program interface to generic SQL databases that enables Java developers to develop DBMS-independent Java applications using a uniform interface.

![image](https://github.com/af4092/Login-Load-Data/assets/24220136/a9e05456-954e-4c74-b9b2-d0e8d5864d8a)

![image](https://github.com/af4092/Login-Load-Data/assets/24220136/644bc12b-8e94-4492-9d20-f320d263353d)

Following is a complete example that demonstrates connecting to a database, executing a simple query, and processing the query result with JDBC. The program connects to a local MySQL database and displays the students whose last name is Smith.

```
 1 import java.sql.*;
 2
 3 public class SimpleJdbc {
 4 public static void main(String[] args)
 5 throws SQLException, ClassNotFoundException {
 6 // Load the JDBC driver
 7 Class.forName("com.mysql.jdbc.Driver");
 8 System.out.println("Driver loaded");
 9
10 // Connect to a database
11 Connection connection = DriverManager.getConnection
12 ("jdbc:mysql://localhost/javabook" , "scott", "tiger");
13 System.out.println("Database connected");
14
15 // Create a statement
16 Statement statement = connection.createStatement();
17
18 // Execute a statement
19 ResultSet resultSet = statement.executeQuery
20 ("select firstName, mi, lastName from Student where lastName "
21 + " = 'Smith'");
22
23 // Iterate through the result and print the student names
24 while (resultSet.next())
25 System.out.println(resultSet.getString(1) + "\t" +
26 resultSet.getString(2) + "\t" + resultSet.getString(3));
27
28 // Close the connection
29 connection.close();
30 }
31 }
```
