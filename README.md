# Login-Load-Data-Swing-Desktop-Application
This desktop application shows the login process and loading the data from database

## [Java JDBC API](https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/)

- The Java Database Connectivity (JDBC) API provides universal data access from the Java programming language. Using the JDBC API, you can access virtually any data source, from relational databases to spreadsheets and flat files. JDBC technology also provides a common base on which tools and alternate interfaces can be built.
- The JDBC API is comprised of two packages:
  - java.sql
  - javax.sql

## JDBC is the Java API for accessing relational database.

- The Java API for developing Java database applications is called JDBC. JDBC is the trademarked name of a Java API that supports Java programs that access relational databases. JDBC is not an acronym, but it is often thought to stand for Java Database Connectivity. 

- JDBC provides Java programmers with a uniform interface for accessing and manipulating relational databases. Using the JDBC API, applications written in the Java programming language can execute SQL statements, retrieve results, present data in a user-friendly interface, and propagate changes back to the database. The JDBC API can also be used to interact with multiple data sources in a distributed, heterogeneous environment.

![image](https://github.com/af4092/Login-Load-Data/assets/24220136/95edfd62-ded5-4da3-9b41-afe332c6d5bb)

- The JDBC API is a Java application program interface to generic SQL databases that enables Java developers to develop DBMS-independent Java applications using a uniform interface.

![image](https://github.com/af4092/Login-Load-Data/assets/24220136/a9e05456-954e-4c74-b9b2-d0e8d5864d8a)

![image](https://github.com/af4092/Login-Load-Data/assets/24220136/644bc12b-8e94-4492-9d20-f320d263353d)

--------------------

## [Implementation](https://github.com/af4092/Login-Load-Data-Swing-Desktop-Application/tree/main/Login/src)

- Following is a complete example that demonstrates connecting to a database, executing a simple query, and processing the query result with JDBC. The program connects to a local MySQL database and displays the students whose last name is Smith.

- Demo Run, which shows the main Login view. In the UI User name and Password is entered, and if Username and Password matches window displays "Login Successful" message, otherwise it displays "Wrong Password" message:

![image](https://user-images.githubusercontent.com/24220136/223287669-af34fd7d-7635-4454-b724-7d02d21e0c28.png)

- After successful login, on the left side of the Window we can save new information with the following parameters: Id, Name, Country Code, District and Population to DB table (MySQL). With `Clear` button we can easily clear any data from the DB and `Logout` button logouts to the main window. `Exit` button exits from the application.

![image](https://user-images.githubusercontent.com/24220136/223287701-7dfd2f44-3732-4115-8960-800fd9f44e02.png)

- `Login.java` code explanation:
  
  - Program imports necessary classes for `GUI components`, database connectivity, and image handling.

  - The code declares a public class named Login that extends the JFrame class. It represents the login form window.

  - The main method serves as the entry point of the program. It creates an instance of the Login class and makes it visible on the screen.

  - The constructor of the Login class initializes the frame properties such as title, size, and layout. It creates a panel (`JPanel`) named contentPane and sets it as the content pane of the frame.

  - Various GUI components are declared and initialized, including labels, text fields, buttons, and password fields. These components represent the elements of the login form.

  - An action listener is added to the "Login" button (`btnLogin`). When the button is clicked, the code inside the actionPerformed method is executed, handling the login functionality.

  - The code establishes a connection to a `MySQL` database using `JDBC`. It loads the MySQL driver, creates a connection, and a statement for executing SQL queries. It constructs a SQL query to check if the entered username and password match any records in the database. If a match is found, it displays a success message using JOptionPane.showMessageDialog(). Otherwise, it displays a "Wrong password" message.

  - Image objects are created from image files to set icons for the login button and a label in the GUI.

- `EmployeeInfo.java` code explanation:

  - The code imports necessary classes for GUI components, database connectivity, and table handling.

  - The main method serves as the entry point of the program. It creates an instance of the EmployeeInfo class and makes it visible on the screen.

  - The constructor of the EmployeeInfo class initializes the frame properties such as size and layout. It creates a panel (JPanel) named contentPane and sets it as the content pane of the frame.

  - Various GUI components are declared and initialized, including labels, buttons, a table, and text fields. These components represent the elements of the employee information management system.

  - An action listener is added to the `Logout` button (btnLogout). When the button is clicked, the code inside the actionPerformed method is executed, handling the logout functionality. It disposes of the current frame and creates a new instance of the Login class to display the login form.

  - The code creates a scroll pane and a table to display the employee information. It also creates buttons for loading data, clearing the table, saving data, and exiting the application.

  - When the `Load Data` button (btnLoad) is clicked, the code establishes a connection to a MySQL database using JDBC. It executes a SELECT query to fetch data from the "city" table and populates the table component with the retrieved data using a DefaultTableModel.

  - When the `Save` button (btnSave) is clicked, the code establishes a connection to the database and prepares an INSERT query to add a new employee record to the "city" table. The text field values entered by the user are used as parameters for the query.

  - The `Clear` button (btnClear) clears the table by setting a new empty DefaultTableModel.

  - The `Exit` button (btnExit) terminates the application by calling `System.exit()`.

- The following Java code demonstrates a simple `JDBC` (Java Database Connectivity) program. 

  - The code imports the necessary classes for JDBC and SQL operations.

  - The main method serves as the entry point of the program.

  - The code loads the JDBC driver by calling Class.forName(`com.mysql.jdbc.Driver`). This step is necessary to load the driver class for the specific database you are connecting to. In this case, it loads the MySQL JDBC driver.

  - It establishes a connection to a MySQL database using DriverManager.getConnection. The connection URL specifies the database location (jdbc:mysql://localhost/javabook), the username (scott), and the password (tiger).

  - After successfully connecting to the database, it prints "Database connected" to the console.

  - A Statement object is created using the connection. The statement is used to execute SQL queries on the database.

  - The code executes a SELECT query using the executeQuery method of the statement. The query retrieves the columns firstName, mi, and lastName from the Student table where the lastName is equal to "Smith".

  - The ResultSet object holds the result of the executed query. It represents a set of rows retrieved from the database.

  - The code iterates through the result set using a while loop and retrieves the values of the columns for each row. It then prints the student names (values of firstName, mi, and lastName) to the console.

  - Finally, the code closes the database connection using connection.close().
    
```
 import java.sql.*;
 
 public class SimpleJdbc {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
  // Load the JDBC driver
  Class.forName("com.mysql.jdbc.Driver");
  System.out.println("Driver loaded");
 
 // Connect to a database
 Connection connection = DriverManager.getConnection
 ("jdbc:mysql://localhost/javabook" , "scott", "tiger");
 System.out.println("Database connected");

// Create a statement
Statement statement = connection.createStatement();

// Execute a statement
ResultSet resultSet = statement.executeQuery
("select firstName, mi, lastName from Student where lastName " + " = 'Smith'");

// Iterate through the result and print the student names
while (resultSet.next())
  System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));

// Close the connection
 connection.close();
      }
}
```
