package net.steppschuh.markdowngenerator;

import net.steppschuh.markdowngenerator.image.Image;
import net.steppschuh.markdowngenerator.link.Link;
import net.steppschuh.markdowngenerator.list.ListBuilder;
import net.steppschuh.markdowngenerator.list.TaskList;
import net.steppschuh.markdowngenerator.list.TaskListItem;
import net.steppschuh.markdowngenerator.list.UnorderedList;
import net.steppschuh.markdowngenerator.progress.ProgressBar;
import net.steppschuh.markdowngenerator.rule.HorizontalRule;
import net.steppschuh.markdowngenerator.text.Text;
import net.steppschuh.markdowngenerator.text.code.Code;
import net.steppschuh.markdowngenerator.text.code.CodeBlock;
import net.steppschuh.markdowngenerator.text.code.CodeBlockBuilder;
import net.steppschuh.markdowngenerator.text.emphasis.BoldText;
import net.steppschuh.markdowngenerator.text.emphasis.ItalicText;
import net.steppschuh.markdowngenerator.text.emphasis.StrikeThroughText;
import net.steppschuh.markdowngenerator.text.heading.Heading;
import net.steppschuh.markdowngenerator.text.quote.Quote;
import net.steppschuh.markdowngenerator.text.quote.QuoteBuilder;
import net.steppschuh.markdowngenerator.util.StringUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * Base class that every markdown builder extends.
 */
public abstract class MarkdownBuilder<T extends MarkdownBuilder<T, S>, S extends MarkdownElement> implements MarkdownSerializable {

    protected S markdownElement;
    protected MarkdownBuilder parentBuilder;

    public MarkdownBuilder() {
        markdownElement = createMarkdownElement();
    }

    protected MarkdownBuilder(MarkdownBuilder parentBuilder) {
        this();
        this.parentBuilder = parentBuilder;
    }

    protected abstract T getBuilder();

    protected abstract S createMarkdownElement();

    protected MarkdownBuilder begin(Class<? extends MarkdownBuilder> markdownClass) {
        try {
            Constructor constructor = markdownClass.getConstructor(MarkdownBuilder.class);
            return (MarkdownBuilder) constructor.newInstance(this);
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return getBuilder();
    }

    public MarkdownBuilder begin(MarkdownBuilder markdownBuilder) {
        markdownBuilder.setParentBuilder(this);
        return markdownBuilder;
    }

    public ListBuilder beginList() {
        return new ListBuilder(this);
    }

    public QuoteBuilder beginQuote() {
        return new QuoteBuilder(this);
    }

    public CodeBlockBuilder beginCodeBlock() {
        return beginCodeBlock(CodeBlock.LANGUAGE_UNKNOWN);
    }

    public CodeBlockBuilder beginCodeBlock(String language) {
        return new CodeBlockBuilder(this, language);
    }

    public MarkdownBuilder end() {
        if (parentBuilder == null) {
            return this;
        }
        parentBuilder.append(this);
        return parentBuilder;
    }

    // Emphasis

    public T text(Object value) {
        return append(new Text(value));
    }

    public T bold(Object value) {
        return append(new BoldText(value));
    }

    public T italic(Object value) {
        return append(new ItalicText(value));
    }

    public T strikeThrough(Object value) {
        return append(new StrikeThroughText(value));
    }

    // Heading

    public T heading(String value, int level) {
        newParagraphIfRequired();
        append(new Heading(value, level));
        return newParagraph();
    }

    public T heading(String value) {
        return heading(value, 1);
    }

    public T subHeading(String value) {
        return heading(value, 2);
    }

    // Rule

    public T rule() {
        newLinesIfRequired(1);
        append(new HorizontalRule());
        return newLine();
    }

    public T rule(int length) {
        newLinesIfRequired(1);
        append(new HorizontalRule(length));
        return newLine();
    }

    // Link

    public T link(String text, String url) {
        return append(new Link(text, url));
    }

    public T link(String url) {
        return append(new Link(url));
    }

    // Image

    public T image(String text, String url) {
        return append(new Image(text, url));
    }

    public T image(String url) {
        return append(new Image(url));
    }

    // Progress

    public T progress(double progress) {
        return append(new ProgressBar(progress));
    }

    public T progressWithLabel(double progress) {
        ProgressBar progressBar = new ProgressBar(progress);
        progressBar.setAppendPercentage(true);
        return append(progressBar);
    }

    // Quote

    public T quote(String value) {
        newParagraphIfRequired();
        append(new Quote(value));
        return newParagraph();
    }

    // Code

    public T code(Object value) {
        return append(new Code(value));
    }

    // List

    public T unorderedList(Object... items) {
        newLinesIfRequired(1);
        append(new UnorderedList(Arrays.asList(items)));
        return newParagraph();
    }

    public T taskList(TaskListItem... items) {
        newLinesIfRequired(1);
        append(new TaskList(Arrays.asList(items)));
        return newParagraph();
    }

    public abstract T append(Object value);

    public T append(MarkdownSerializable value) {
        try {
            // serialize object to markdown element
            return append(value.toMarkdownElement().getSerialized());
        } catch (MarkdownSerializationException e) {
            // use default string representation
            return append(value);
        }
    }

    public T newParagraph() {
        return newLines(2);
    }

    protected T newParagraphIfRequired() {
        if (!endsWithLineSeparators(2)) {
            newParagraph();
        }
        return getBuilder();
    }

    public T newLine() {
        return newLines(1);
    }

    public T newLines(int count) {
        for (int i = 0; i < count; i++) {
            append(System.lineSeparator());
        }
        return getBuilder();
    }

    protected T newLinesIfRequired(int count) {
        if (!endsWithLineSeparators(1)) {
            newLines(count);
        }
        return getBuilder();
    }

    protected boolean endsWithLineSeparators(int count) {
        String separators = "";
        for (int i = 0; i < count; i++) {
            separators += System.lineSeparator();
        }
        return markdownElement.getSerialized("").endsWith(separators);
    }

    @Override
    public String toString() {
        return build().getSerialized(this.getClass().getSimpleName());
    }

    @Override
    public MarkdownElement toMarkdownElement() throws MarkdownSerializationException {
        return build();
    }

    public S build() {
        return markdownElement;
    }

    public MarkdownBuilder getParentBuilder() {
        return parentBuilder;
    }

    public void setParentBuilder(MarkdownBuilder parentBuilder) {
        this.parentBuilder = parentBuilder;
    }

}
