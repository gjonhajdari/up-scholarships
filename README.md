# UP Scholarships

Desktop app for applying for and managing scholarships for the University of Prishtina. Project project build with JavaFX and MySQL.

## Getting Started

Clone the repository
```bash
git clone https://www.github.com/gjonhajdari/up-scholarships
cd up-scholarships
```

Access the MySQL CLI and run the following scripts

```bash
mysql -u root -p < src/main/db-structure.sql
mysql -u root -p < src/main/db-testData.sql
```

Replace `root` with your MySQL username if you have it configured differently. You will be prompted to enter your password (if you don't have one just hit enter).

Alternatively you can open the scripts and run them in your favorite MySQL GUI.

## Dependencies

| Name                                                               | Version |
|------------------------------------------------------------------- |---------|
| [Java](https://www.oracle.com/java/technologies/downloads/#java22) | 22      |
| [MySQL](https://www.mysql.com/downloads/)                          | 8.3.0   |

## Contributors

University team project for the Software Engineering course at the [University of Prishtina](https://fiek.uni-pr.edu).

<a href="https://github.com/gjonhajdari/up-scholarships/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=gjonhajdari/up-scholarships" />
</a>

Made with [contrib.rocks](https://contrib.rocks).