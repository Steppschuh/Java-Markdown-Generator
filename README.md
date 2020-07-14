# Java Markdown Generator
[![Travis](https://img.shields.io/travis/Steppschuh/Java-Markdown-Generator.svg)](https://travis-ci.org/Steppschuh/Java-Markdown-Generator/) [![JitPack](https://img.shields.io/jitpack/v/Steppschuh/Java-Markdown-Generator.svg)](https://jitpack.io/#Steppschuh/Java-Markdown-Generator)
 [![Bintray](https://api.bintray.com/packages/steppschuh/Markdown-Generator/Markdown-Generator/images/download.svg) ](https://bintray.com/steppschuh/Markdown-Generator/Markdown-Generator/_latestVersion) [![Maven Central](https://img.shields.io/maven-central/v/net.steppschuh.markdowngenerator/markdowngenerator.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22net.steppschuh.markdowngenerator%22) [![Codecov](https://img.shields.io/codecov/c/github/Steppschuh/Java-Markdown-Generator.svg)](https://codecov.io/gh/Steppschuh/Java-Markdown-Generator)

Simple to use Java library to generate beautiful markdown.

![Screenshot](https://github.com/Steppschuh/Java-Markdown-Generator/blob/dev/Media/code_table_output.png)

# Usage

## Integration

### Gradle

You can get snapshot and release builds from [JitPack](https://jitpack.io/#Steppschuh/Java-Markdown-Generator):

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    compile 'com.github.Steppschuh:Java-Markdown-Generator:master-SNAPSHOT'
}
```

Alternatively, release builds are also available on [Bintray](https://bintray.com/steppschuh/Markdown-Generator/Markdown-Generator/):

```groovy
repositories {
    maven { url 'http://dl.bintray.com/steppschuh/Markdown-Generator' }
}
dependencies {
    compile 'net.steppschuh.markdowngenerator:markdowngenerator:1.3.2'
}
```

### Maven
```xml
<dependency>
  <groupId>net.steppschuh.markdowngenerator</groupId>
  <artifactId>markdowngenerator</artifactId>
  <version>1.3.2</version>
</dependency>
```

### JAR
You can download the latest .jar files from [GitHub](https://github.com/Steppschuh/Java-Markdown-Generator/releases) or [Bintray](https://bintray.com/steppschuh/Markdown-Generator/Markdown-Generator/).

## Examples

Most Markdown elements have static convenience methods in the `Markdown` class. You can also use their repesctive constructors, as shown below. 

### Emphasis
```java
@Test
public void example() throws Exception {
    StringBuilder sb = new StringBuilder()
            .append(new Text("I am normal")).append("\n")
            .append(new BoldText("I am bold")).append("\n")
            .append(new ItalicText("I am italic")).append("\n")
            .append(new StrikeThroughText("I am strike-through"));

    System.out.println(sb);
}
```
**Output:**
```
I am normal
**I am bold**
_I am italic_
~~I am strike-through~~
```

### Headings
```java
@Test
public void example() throws Exception {
    StringBuilder sb = new StringBuilder()
            .append(new Heading("Heading with level 1", 1)).append("\n")
            .append(new Heading("Heading with level 2", 2)).append("\n")
            .append(new Heading("Heading with level 3", 3)).append("\n")
            .append(new Heading("Heading with level 4", 4)).append("\n")
            .append(new Heading("Heading with level 5", 5)).append("\n")
            .append(new Heading("Heading with level 6", 6));

    System.out.println(sb);
}
```
**Output:**
```
Heading with level 1
====================
Heading with level 2
--------------------
### Heading with level 3
#### Heading with level 4
##### Heading with level 5
###### Heading with level 6
```

### Rules
```java
@Test
public void example() throws Exception {
    System.out.println(new HorizontalRule());
    System.out.println(new HorizontalRule(20, HorizontalRule.ASTERISK));
}
```
**Output:**
```
---
********************
```

### Images
```java
@Test
public void example() throws Exception {
    String text = "I am an image";
    String url = "https://dummyimage.com/300";
    System.out.println(new Image(text, url));
}
```
**Output:**
```
![I am an image](https://dummyimage.com/300)
```

### Lists
```java
@Test
public void example() throws Exception {
    List<Object> items = Arrays.asList(
            "Items can be anything",
            new Date(0),
            1337
    );
    System.out.println(new UnorderedList<>(items));
}
```
**Output:**
```
- Items can be anything
- Thu Jan 01 01:00:00 CET 1970
- 1337
```

### Tasks
```java
@Test
public void example() throws Exception {
    List<TaskListItem> items = Arrays.asList(
            new TaskListItem("Task 1", true),
            new TaskListItem("Task 2", false),
            new TaskListItem("Task 3")
    );
    System.out.println(new TaskList(items));
}
```
**Output:**
```
- [x] Task 1
- [ ] Task 2
- [ ] Task 3
```

### Tables
```java
@Test
public void example() throws Exception {
    Table.Builder tableBuilder = new Table.Builder()
            .withAlignments(Table.ALIGN_RIGHT, Table.ALIGN_LEFT)
            .withRowLimit(7)
            .addRow("Index", "Boolean");

    for (int i = 1; i <= 20; i++) {
        tableBuilder.addRow(i, Math.random() > 0.5);
    }

    System.out.println(tableBuilder.build());
}
```
**Output:**
```
| Index | Boolean |
| -----:| ------- |
|     1 | false   |
|     2 | true    |
|     3 | false   |
| ~~~~~ | ~~~~~~~ |
|    18 | false   |
|    19 | true    |
|    20 | false   |
```

### Code
```java
@Test
public void example() throws Exception {
    String code = "// notice this new line\n" +
            "System.out.println(\"Hello\");";
    System.out.println(new CodeBlock(code, "Java"));
}
```
**Output:**
```
    ```Java
    // notice this new line
    System.out.println("Hello");
    ```
```
