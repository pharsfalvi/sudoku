# Sudoku validator

Validates a csv file and reports an error message if it is not a valid solution for a 9x9 Sudoku game.

In case the validation is successful it exits with zero, otherwise it exits with one and shows an error on the console.

### Usage
The filename parameter must be provided with an absolute path or a path relative to the destination folder of the installation.


Linux/Mac
```
./validate <filename> 
```

Windows
```
./validate.bat <filename> 
```


### Build

Prerequisite: Java SE 11 (LTS)

Clone this repository, go to its location in a terminal and execute:
```
./gradlew build
```

### Installation

Build the project and locate the distro files at the subfolder `validate/build/distributions` 

Unpack the distributed package into any destination folder.
* *Linux or Mac:* use the command `tar xvf validate.tar`
* *Windows:* right-click the `validate.zip` file and click Extract All.


### References
* [Sudoku on Wikipedia](https://en.wikipedia.org/wiki/Sudoku)
* [Gradle](https://docs.gradle.org/7.3.3/userguide/userguide.html) - build tool
* [JUnit Jupiter](https://junit.org/junit5/docs/current/user-guide/) - unit testing
* [PMD](https://pmd.github.io/latest/) - static source code analyzer
* [JaCoCo plugin](https://docs.gradle.org/current/userguide/jacoco_plugin.html) - java code coverage
* [System Rules](https://stefanbirkner.github.io/system-rules/) - for testing exit code


