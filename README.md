# Farm Dashboard
This is the repo for Term project–Design and Implementation-Part 1.

## How to run the code:
Running the code should be straight forward.

* You will need `Java 12` to compile and run this project. If you do not already have `Java`, please go ahead and install `openjdk-12`. Normal distributions of `Java 12` should be fine, but I've only tested it using `openjdk-12`.
* While inside the root directory, you can run the command, `./gradlew build`. (`gradlew.bat build`) If you make any changes to the code, you will need to rebuild the project for them to take effect.
* Once the project is built, you can run the project by running the command, `./gradlew run`. If there is no valid build, this will build the project before running it.
* At any point, you can use `ctrl-c` to terminate the program from the command line.

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
