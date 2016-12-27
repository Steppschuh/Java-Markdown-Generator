package net.steppschuh.markdowngenerator;

import net.steppschuh.markdowngenerator.image.Image;
import net.steppschuh.markdowngenerator.link.Link;
import net.steppschuh.markdowngenerator.list.TaskList;
import net.steppschuh.markdowngenerator.list.TaskListItem;
import net.steppschuh.markdowngenerator.list.UnorderedList;
import net.steppschuh.markdowngenerator.progress.ProgressBar;
import net.steppschuh.markdowngenerator.rule.HorizontalRule;
import net.steppschuh.markdowngenerator.text.Text;
import net.steppschuh.markdowngenerator.text.code.Code;
import net.steppschuh.markdowngenerator.text.code.CodeBlock;
import net.steppschuh.markdowngenerator.text.emphasis.BoldText;
import net.steppschuh.markdowngenerator.text.emphasis.ItalicText;
import net.steppschuh.markdowngenerator.text.emphasis.StrikeThroughText;
import net.steppschuh.markdowngenerator.text.heading.Heading;
import net.steppschuh.markdowngenerator.text.quote.Quote;

import java.util.Arrays;

/**
 * Created by steppschuh on 23/12/2016.
 */

public abstract class Markdown {

    // Heading

    public static Heading heading(String value, int level) {
        return new Heading(value, level);
    }

    public static Heading heading(String value) {
        return heading(value, 1);
    }

    public static Heading subHeading(String value) {
        return heading(value, 2);
    }

    // Rule

    public static HorizontalRule rule() {
        return new HorizontalRule();
    }

    public static HorizontalRule rule(int length) {
        return new HorizontalRule(length);
    }

    // Emphasis

    public static Text text(String value) {
        return new Text(value);
    }

    public static BoldText bold(String value) {
        return new BoldText(value);
    }

    public static ItalicText italic(String value) {
        return new ItalicText(value);
    }

    public static StrikeThroughText strikeThrough(String value) {
        return new StrikeThroughText(value);
    }

    // Link

    public static Link link(String text, String url) {
        return new Link(text, url);
    }

    public static Link link(String url) {
        return new Link(url);
    }

    // Image

    public static Image image(String text, String url) {
        return new Image(text, url);
    }

    public static Image image(String url) {
        return new Image(url);
    }

    // Progress

    public static ProgressBar progress(double progress) {
        return new ProgressBar(progress);
    }

    public static ProgressBar progressWithLabel(double progress) {
        ProgressBar progressBar = new ProgressBar(progress);
        progressBar.setAppendPercentage(true);
        return progressBar;
    }

    // Quote

    public static Quote quote(String value) {
        return new Quote(value);
    }

    // Code

    public static Code code(String value) {
        return new Code(value);
    }

    public static CodeBlock codeBlock(String value, String language) {
        return new CodeBlock(value, language);
    }

    public static CodeBlock codeBlock(String language) {
        return codeBlock(null, language);
    }

    // List

    public static UnorderedList unorderedList(Object... items) {
        return new UnorderedList(Arrays.asList(items));
    }

    public static TaskList taskList(TaskListItem... items) {
        return new TaskList(Arrays.asList(items));
    }

    public static TaskListItem task(String value) {
        return new TaskListItem(value);
    }

    public static TaskListItem task(String value, boolean checked) {
        return new TaskListItem(value, checked);
    }

}
