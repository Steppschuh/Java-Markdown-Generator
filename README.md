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
    Text text;
    text = new Text("I am normal text");
    System.out.println(text);

    text = new BoldText("I am bold text");
    System.out.println(text);

    text = new ItalicText("I am italic text");
    System.out.println(text);

    text = new StrikeThroughText("I am strike-through text");
    System.out.println(text);
}
```
Output:
```
I am normal text
**I am bold text**
_I am italic text_
~~I am strike-through text~~
```

### Tables

### Images

### Code

