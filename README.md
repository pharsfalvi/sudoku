# Sudoku validator

Validates a csv file and reports an error message if it is not a valid solution for a 9x9 Sudoku game.

In case the validation is successful it exits with zero, otherwise it exits with one and shows an error on the console.
### Installation


Uncompress the distributed package into any destination folder.
Linux/Mac
```
tar xvf validate.tar
```
On Windows right-click the file, choose Extract All and unzip the file.


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
For references check the official [Gradle documentation](https://docs.gradle.org/7.3.3/userguide/userguide.html)
