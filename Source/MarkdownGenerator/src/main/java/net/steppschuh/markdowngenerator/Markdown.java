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

//Methods declared by this class are the ones you as developer will call within your code to make use of.

public abstract class Markdown {

    // Headings emphasize code with the respective heading style chosen, headings will also automatically generate a divider below them.

    public static Heading heading(String value, int level) {
        return new Heading(value, level);
    }

    public static Heading heading(String value) {
        return heading(value, 1);
    }

    public static Heading subHeading(String value) {
        return heading(value, 2);
    }

    // Rules, act as lines to separate code or text

    public static HorizontalRule rule() {
        return new HorizontalRule();
    }

    public static HorizontalRule rule(int length) {
        return new HorizontalRule(length);
    }

    // The 4 methods below define the style of text, as regular, boldened, italic, or strike through

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

    // The 2 methods below will generate hyperlinks

    public static Link link(String text, String url) {
        return new Link(text, url);
    }

    public static Link link(String url) {
        return new Link(url);
    }

    // Image methods allow the developer to declare an image in markdown and for it to display properly in a markdown document.

    public static Image image(String text, String url) {
        return new Image(text, url);
    }

    public static Image image(String url) {
        return new Image(url);
    }

    // Implementation of progress bars.

    public static ProgressBar progress(double progress) {
        return new ProgressBar(progress);
    }

    public static ProgressBar progressWithLabel(double progress) {
        ProgressBar progressBar = new ProgressBar(progress);
        progressBar.setAppendPercentage(true);
        return progressBar;
    }

    // Quote, used for quoting text

    public static Quote quote(String value) {
        return new Quote(value);
    }

    // Code methods below are used to peoperly identify code blocks within a markdown document

    public static Code code(String value) {
        return new Code(value);
    }

    public static CodeBlock codeBlock(String value, String language) {
        return new CodeBlock(value, language);
    }

    public static CodeBlock codeBlock(String language) {
        return codeBlock(null, language);
    }

    // List methods below provide ability to generate unordered istds as well as task lists.

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
