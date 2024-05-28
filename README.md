# UP Scholarships

Desktop app for applying for and managing scholarships for the University of Prishtina. Project build with JavaFX and MySQL.

## Getting Started

Clone the repository
```bash
git clone https://www.github.com/gjonhajdari/up-scholarships
cd up-scholarships/src
```

### Set Up the Database

Open your terminal and access the MySQL CLI to run the database scripts

```bash
mysql -u root -p < src/main/db-structure.sql
mysql -u root -p < src/main/db-testData.sql
```

Replace `root` with your MySQL username if you have it configured differently. You will be prompted to enter your password (if you don't have one just hit enter).

Alternatively you can open the scripts and run them in your favorite MySQL GUI.

### Configure Database Connection

If your MySQL environment is configured differently, you can change the connection details in the `ConnectionUtil.java` file. If it isn't, you can skip this step.
```java
// File: ConnectionUtil.java

public class ConnectionUtil {
  // ...
  private static String URL = "jdbc:mysql://localhost:[port]/scholarships";
  private static String USER = [username];
  private static String PASSWORD = [password];
  // ...
}
```

### Add all student accounts

The `db-testData.sql` script adds a few student accounts to the database. You can add the rest by running the `Migration.java` file. It creates accounts using the student data from the `students.csv` file.

After that you can uncomment the remaining `insert_application_random()` calls in the `db-testData.sql` script and run it again.


## Dependencies

| Name                                                               | Version |
|------------------------------------------------------------------- |---------|
| [Java](https://www.oracle.com/java/technologies/downloads/#java22) | 22      |
| [MySQL](https://www.mysql.com/downloads/)                          | 8.3.0   |

## Contributors

University team project for the Human-Computer Interaction course at the [University of Prishtina](https://fiek.uni-pr.edu).

<a href="https://github.com/gjonhajdari/up-scholarships/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=gjonhajdari/up-scholarships" />
</a>

Made with [contrib.rocks](https://contrib.rocks).
