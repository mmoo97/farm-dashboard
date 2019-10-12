# Farm Dashboard
This is the repo for Term project–Design and Implementation-Part 1.

## How to run the code:
Running the code should be straight forward.

* You will need `Java 12` to compile and run this project. If you do not already have `Java`, please go ahead and install `openjdk-12`. Normal distributions of `Java 12` should be fine, but I've only tested it using `openjdk-12`.
* While inside the root directory, you can run the command, `./gradlew build`. (`gradlew.bat build`) If you make any changes to the code, you will need to rebuild the project for them to take effect.
* Once the project is built, you can run the project by running the command, `./gradlew run`. If there is no valid build, this will build the project before running it.
* At any point, you can use `ctrl-c` to terminate the program from the command line.
* There is a `.gitignore` which should ignore most temp files made by `Gradle` and `Java`. When you are ready to deploy code, the command: `./gradlew clean` should be run to clear any cached or temp files that could be system specific.
## Gradle Clarifications:
What Gradle builds and runs is based on a file called `build.gradle`. It will be helpful to look at the contents of the file to understand what is going on.Specifically, there is a section that tells `Java` which class to treat as the `MainClass`. This is found on line 38, and currently points to `HelloWorld.java`.

```java
mainClassName = 'farm.dashboard.HelloWorld'

// Define the main class for the application
application {
    mainClassName = mainClassName
}
```

There are other parts of this that deal with `JavaFX` as a plugin. I won't go into detail about those. Just trust that it will work. :smiley:

## Project Structure
This project conforms to both the Naming and the layout conventions for `Java` production development. In case you are not familiar with the layout, here is the project in the early stages.

```bash
.
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── README.md
├── settings.gradle
└── src
    ├── main
    │   ├── java
    │   │   └── farm
    │   │       └── dashboard
    │   │           ├── App.java
    │   │           └── HelloWorld.java
    │   └── resources
    └── test
        ├── java
        │   └── farm
        │       └── dashboard
        │           └── AppTest.java
        └── resources

13 directories, 10 files
```
You will notice that the project is named `farm-dashboard`, but the package is referred to in the `Java` files as `farm.dashboard`. This is `Java's` naming convention. You will need to have `package farm.dashboard;` as the very first line of every `java` file in your program.

## Additional Resources:
[This article](https://thecodinginterface.com/blog/javafx-with-gradle-and-eclipse-java-components/) is a pretty good intro to coding with `JavaFX`. His project layout is almost identical to ours because he is using `Gradle` as his build tool. This could be really helpful.
