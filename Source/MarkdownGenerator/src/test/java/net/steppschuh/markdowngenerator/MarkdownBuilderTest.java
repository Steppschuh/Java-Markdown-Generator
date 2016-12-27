package net.steppschuh.markdowngenerator;

import net.steppschuh.markdowngenerator.list.ListBuilder;
import net.steppschuh.markdowngenerator.text.TextBuilder;
import net.steppschuh.markdowngenerator.text.code.CodeBlock;

import org.junit.Test;

import static net.steppschuh.markdowngenerator.Markdown.bold;
import static net.steppschuh.markdowngenerator.Markdown.italic;
import static net.steppschuh.markdowngenerator.Markdown.task;

/**
 * Created by steppschuh on 23/12/2016.
 */
public class MarkdownBuilderTest {

    @Test
    public void example1() throws Exception {
        MarkdownBuilder builder = new TextBuilder()
                .heading("Markdown Builder")
                .append("Demonstrating: ")
                .append(bold("Bold Text"))
                .newParagraph()
                .beginList()
                    .append("I should be an item")
                    .append(italic("I should be an italic item"))
                .end()
                .newParagraph()
                .beginQuote()
                    .append("I should be a quote").newLine()
                    .append("I should still be a quote")
                .end()
                .newParagraph()
                .beginCodeBlock(CodeBlock.LANGUAGE_JAVA)
                    .append("// I should be code").newLine()
                    .append("dummyMethod(this);")
                .end()
                .newParagraph()
                .append("Over.");

        System.out.println(builder.toString());
    }

    @Test
    public void example2() throws Exception {
        MarkdownBuilder builder = new ListBuilder()
                .text("Item 1")
                .bold("Item 2")
                .beginList()
                    .text("Item 2.1")
                    .bold("Item 2.2")
                    .beginList()
                        .text("Item 2.2.1")
                        .bold("Item 2.2.2")
                        .text("Item 2.2.3")
                    .end()
                    .text("Item 2.3")
                .end()
                .text("Item 3");

        System.out.println(builder.toString());
    }

    @Test
    public void example3() throws Exception {
        MarkdownBuilder builder = new TextBuilder()
                .heading("Markdown Builder")
                .text("Demonstrating: ").bold("Bold Text")
                .newParagraph()
                .quote("I should be a quote\nI should still be a quote")
                .beginQuote()
                        .text("I should be a quote").newLine()
                        .text("I should still be a quote")
                .end()
                .newParagraph()
                .code("INLINE_CODE")
                .beginCodeBlock(CodeBlock.LANGUAGE_JAVA)
                        .text("// some comment").newLine()
                        .text("dummyMethod(this);")
                .end()
                .subHeading("Lists")
                .unorderedList(
                        "I should be an item",
                        italic("I should be an italic item")
                )
                .beginList()
                        .text("I should be an item")
                        .italic("I should be an italic item")
                .end()
                .newParagraph()
                .taskList(
                        task("Task 1", true),
                        task("Task 2", false),
                        task("Task 3")
                );

        System.out.println(builder.toString());
    }

}