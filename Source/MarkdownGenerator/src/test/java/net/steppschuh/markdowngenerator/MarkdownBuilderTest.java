package net.steppschuh.markdowngenerator;

import org.junit.Test;

import static net.steppschuh.markdowngenerator.Markdown.bold;
import static net.steppschuh.markdowngenerator.Markdown.codeBlock;
import static net.steppschuh.markdowngenerator.Markdown.italic;

/**
 * Created by steppschuh on 23/12/2016.
 */
public class MarkdownBuilderTest {

    @Test
    public void example1() throws Exception {
        Markdown.Builder builder = new Markdown.Builder()
                .append("Demonstrating: ")
                .append(bold("Bold Text"))
                .newParagraph()
                .begin(codeBlock("java"))
                    .append("// dummy comment").newLine()
                    .append(italic("dummyMethod(this);"))
                .end()
                .newParagraph()
                .append("Over.");

        System.out.println(builder.toString());
    }

}