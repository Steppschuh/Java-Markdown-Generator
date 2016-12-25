package net.steppschuh.markdowngenerator;

import net.steppschuh.markdowngenerator.image.Image;
import net.steppschuh.markdowngenerator.link.Link;
import net.steppschuh.markdowngenerator.progress.ProgressBar;
import net.steppschuh.markdowngenerator.rule.HorizontalRule;
import net.steppschuh.markdowngenerator.text.emphasis.BoldText;
import net.steppschuh.markdowngenerator.text.code.CodeText;
import net.steppschuh.markdowngenerator.text.code.CodeTextBlock;
import net.steppschuh.markdowngenerator.text.heading.Heading;
import net.steppschuh.markdowngenerator.text.emphasis.ItalicText;
import net.steppschuh.markdowngenerator.text.quote.Quote;
import net.steppschuh.markdowngenerator.text.emphasis.StrikeThroughText;
import net.steppschuh.markdowngenerator.text.Text;

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

    public static CodeText code(String value) {
        return new CodeText(value);
    }

    public static CodeTextBlock codeBlock(String value, String language) {
        return new CodeTextBlock(value, language);
    }

    public static CodeTextBlock codeBlock(String language) {
        return codeBlock(null, language);
    }

}
