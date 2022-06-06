### Tech stack:

* Java 11
* Apache Maven
* Selenide
* JUnit 5
* AssertJ

### To run tests:

1. Clone this repository:

```
https://github.com/natalia-iukhimenko/play-tests.git
```

2. Check Java version or install if it is not Java 11

```
javac -version
```

3. Check Maven version or install if it is missing

```
mvn -version
```

4. Navigate to project directory and execute the following command:

```
mvn clean test
```

5. By default, tests are executed in Chrome browser (supported values: chrome, firefox, ie, opera, edge). To change it
   to Firefox:

```
mvn clean test -Dselenide.browser=firefox
```

6. To execute tests in headless mode:

```
mvn clean test -Dselenide.headless=true
```