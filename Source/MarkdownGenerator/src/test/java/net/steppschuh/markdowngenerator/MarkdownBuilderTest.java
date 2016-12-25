package net.steppschuh.markdowngenerator;

import net.steppschuh.markdowngenerator.list.ListBuilder;
import net.steppschuh.markdowngenerator.text.TextBuilder;

import org.junit.Test;

import static net.steppschuh.markdowngenerator.Markdown.bold;
import static net.steppschuh.markdowngenerator.Markdown.italic;

/**
 * Created by steppschuh on 23/12/2016.
 */
public class MarkdownBuilderTest {

    @Test
    public void example1() throws Exception {
        MarkdownBuilder builder = new TextBuilder()
                .append("Demonstrating: ")
                .append(bold("Bold Text"))
                .newParagraph()
                .beginList()
                    .append("I should be an item")
                    .append(italic("I should be an italic item"))
                .end()
                .newParagraph()
                .beginBlockQuote()
                    .append("I should be a quote")
                    .newLine()
                    .append("I should still be a quote")
                .end()
                .newParagraph()
                .append("Over.");

        System.out.println(builder.toString());
    }

    @Test
    public void example2() throws Exception {
        MarkdownBuilder builder = new ListBuilder()
                .append("Item 1")
                .append(bold("Item 2"))
                .beginList()
                    .append("Item 2.1")
                    .append(bold("Item 2.2"))
                    .beginList()
                        .append("Item 2.2.1")
                        .append(bold("Item 2.2.2"))
                        .append("Item 2.2.3")
                    .end()
                    .append("Item 2.3")
                .end()
                .append("Item 3");

        System.out.println(builder.toString());
    }

}