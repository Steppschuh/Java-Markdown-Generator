# Java Markdown Generator
Java library to generate beautiful markdown.

![Screenshot](https://github.com/Steppschuh/Java-Markdown-Generator/blob/dev/Media/code_table_output.png)

# Usage

## Integration

### Gradle
```groovy
repositories {
    maven {
        url  "http://dl.bintray.com/steppschuh/Markdown-Generator"
    }
}
dependencies {
    compile 'net.steppschuh.markdowngenerator:markdowngenerator:1.1'
}
```

### Maven
```xml
<dependency>
  <groupId>net.steppschuh.markdowngenerator</groupId>
  <artifactId>markdowngenerator</artifactId>
  <version>1.1</version>
  <type>pom</type>
</dependency>
```

### JAR
You can download the latest .jar files from [GitHub](https://github.com/Steppschuh/Java-Markdown-Generator/releases) or [Bintray](https://bintray.com/steppschuh/Markdown-Generator/Markdown-Generator/).

## Examples

### Emphasis
```java
@Test
public void example() throws Exception {
    StringBuilder sb = new StringBuilder()
            .append(new Text("I am normal")).append("\n")
            .append(new BoldText("I am bold")).append("\n")
            .append(new ItalicText("I am italic")).append("\n")
            .append(new StrikeThroughText("I am strike-through"));

    System.out.println(sb.toString());
}
```
**Output:**
```
I am normal
**I am bold**
_I am italic_
~~I am strike-through~~
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
### Code
```java
@Test
public void example() throws Exception {
    String code = "// notice this new line\n" +
            "System.out.println(\"Hello\");";
    Text text = new CodeTextBlock(code, "Java");
    System.out.println(text);
}
```
**Output:**
```
    ```Java
    // notice this new line
    System.out.println("Hello");
    ```
```
