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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/**
 * Base class that every markdown builder extends. Basically capable of
 * appending stuff to a root {@link MarkdownElement}.
 */
public abstract class MarkdownBuilder<T extends MarkdownBuilder<T, S>, S extends MarkdownElement> implements MarkdownSerializable {

    /**
     * The root element that content will be appended too.
     */
    protected S markdownElement;

    /**
     * The parent markdown builder, if available. Parent builder will be set in child builders,
     * if they have been created using the {@link MarkdownBuilder#begin(MarkdownBuilder)} method.
     * If set, this will be returned in the {@link MarkdownBuilder#end()} method.
     */
    protected MarkdownBuilder parentBuilder;

    public MarkdownBuilder() {
        markdownElement = createMarkdownElement();
    }

    protected MarkdownBuilder(MarkdownBuilder parentBuilder) {
        this();
        this.parentBuilder = parentBuilder;
    }

    /**
     * Used for method chaining.
     *
     * @return the builder instance
     */
    protected abstract T getBuilder();

    /**
     * Creates the root element. Typically without any content.
     *
     * @return the root markdown element
     */
    protected abstract S createMarkdownElement();

    /**
     * All chained method calls will be called on the passed 'child' builder
     * until {@link MarkdownBuilder#end()} will be called.
     *
     * @param markdownBuilder the new builder which should be used
     * @return the passed markdown builder
     */
    public MarkdownBuilder begin(MarkdownBuilder markdownBuilder) {
        markdownBuilder.setParentBuilder(this);
        return markdownBuilder;
    }

    /**
     * If a {@link MarkdownBuilder#parentBuilder} is set (e.g. if
     * {@link MarkdownBuilder#begin(MarkdownBuilder)} was called before),
     * the current {@link MarkdownBuilder#markdownElement} will be appended
     * to the parent builder, which will also be returned.
     *
     * @return the parent builder
     */
    public MarkdownBuilder end() {
        if (parentBuilder == null) {
            return this;
        }
        parentBuilder.append(this);
        return parentBuilder;
    }

    // Emphasis

    /**
     * Appends a normal {@link Text} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param value value for the new element
     * @return the builder instance
     * @see Text#Text(Object)
     */
    public T text(Object value) {
        return append(new Text(value));
    }

    /**
     * Appends a {@link BoldText} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param value value for the new element
     * @return the builder instance
     * @see BoldText#BoldText(Object)
     */
    public T bold(Object value) {
        return append(new BoldText(value));
    }

    /**
     * Appends an {@link ItalicText} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param value value for the new element
     * @return the builder instance
     * @see ItalicText#ItalicText(Object)
     */
    public T italic(Object value) {
        return append(new ItalicText(value));
    }

    /**
     * Appends a {@link StrikeThroughText} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param value value for the new element
     * @return the builder instance
     * @see StrikeThroughText#StrikeThroughText(Object)
     */
    public T strikeThrough(Object value) {
        return append(new StrikeThroughText(value));
    }

    // Heading

    /**
     * Appends a {@link Heading} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param value value for the new element
     * @param level the heading level
     * @return the builder instance
     * @see Heading#Heading(Object, int)
     */
    public T heading(String value, int level) {
        newParagraphIfRequired();
        append(new Heading(value, level));
        return newParagraph();
    }

    /**
     * Appends a {@link Heading} element with level 1 to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param value value for the new element
     * @return the builder instance
     * @see Heading#Heading(Object, int)
     */
    public T heading(String value) {
        return heading(value, 1);
    }

    /**
     * Appends a {@link Heading} element with level 2 to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param value value for the new element
     * @return the builder instance
     * @see Heading#Heading(Object, int)
     */
    public T subHeading(String value) {
        return heading(value, 2);
    }

    // Rule

    /**
     * Appends a {@link HorizontalRule} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @return the builder instance
     * @see HorizontalRule#HorizontalRule()
     */
    public T rule() {
        newLinesIfRequired(1);
        append(new HorizontalRule());
        return newLine();
    }

    /**
     * Appends a {@link HorizontalRule} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @return the builder instance
     * @see HorizontalRule#HorizontalRule(int)
     */
    public T rule(int length) {
        newLinesIfRequired(1);
        append(new HorizontalRule(length));
        return newLine();
    }

    // Link

    /**
     * Appends a {@link Link} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param text text for the link
     * @param url  url for the link
     * @return the builder instance
     * @see Link#Link(Object, String)
     */
    public T link(String text, String url) {
        return append(new Link(text, url));
    }

    /**
     * Appends a {@link Link} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param url url for the link
     * @return the builder instance
     * @see Link#Link(String)
     */
    public T link(String url) {
        return append(new Link(url));
    }

    // Image

    /**
     * Appends an {@link Image} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param text text for the image
     * @param url  url to the image
     * @return the builder instance
     * @see Image#Image(Object, String)
     */
    public T image(String text, String url) {
        return append(new Image(text, url));
    }

    /**
     * Appends an {@link Image} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param url url to the image
     * @return the builder instance
     * @see Image#Image(String)
     */
    public T image(String url) {
        return append(new Image(url));
    }

    // Progress

    /**
     * Appends a {@link ProgressBar} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param progress progress value ranging from 0 to 1
     * @return the builder instance
     * @see ProgressBar#ProgressBar(double)
     */
    public T progress(double progress) {
        return append(new ProgressBar(progress));
    }

    /**
     * Appends a {@link ProgressBar} element with a value label to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param progress progress value ranging from 0 to 1
     * @return the builder instance
     * @see ProgressBar#ProgressBar(double)
     */
    public T progressWithLabel(double progress) {
        ProgressBar progressBar = new ProgressBar(progress);
        progressBar.setAppendPercentage(true);
        return append(progressBar);
    }

    // Quote

    /**
     * Creates a new {@link QuoteBuilder} instance.
     *
     * @return a new child builder instance
     * @see QuoteBuilder#QuoteBuilder(MarkdownBuilder)
     */
    public QuoteBuilder beginQuote() {
        newParagraphIfRequired();
        return new QuoteBuilder(this);
    }

    /**
     * Appends a {@link Quote} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param value value for the element
     * @return the builder instance
     * @see Quote#Quote(Object)
     */
    public T quote(String value) {
        newParagraphIfRequired();
        append(new Quote(value));
        return newParagraph();
    }

    // Code

    /**
     * Creates a new {@link CodeBlockBuilder} instance and sets the language.
     *
     * @param language the code language for syntax highlighting
     * @return a new child builder instance
     * @see CodeBlockBuilder#CodeBlockBuilder(MarkdownBuilder, String)
     */
    public CodeBlockBuilder beginCodeBlock(String language) {
        newParagraphIfRequired();
        return new CodeBlockBuilder(this, language);
    }

    /**
     * Creates a new {@link CodeBlockBuilder} instance.
     *
     * @return a new child builder instance
     * @see CodeBlockBuilder#CodeBlockBuilder(MarkdownBuilder)
     */
    public CodeBlockBuilder beginCodeBlock() {
        newParagraphIfRequired();
        return beginCodeBlock(CodeBlock.LANGUAGE_UNKNOWN);
    }

    /**
     * Appends a {@link Code} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param value value for the new element
     * @return the builder instance
     * @see Code#Code(Object)
     */
    public T code(Object value) {
        return append(new Code(value));
    }

    // List

    /**
     * Creates a new {@link ListBuilder} instance.
     *
     * @return a new child builder instance
     * @see ListBuilder#ListBuilder(MarkdownBuilder)
     */
    public ListBuilder beginList() {
        return new ListBuilder(this);
    }

    /**
     * Appends a {@link UnorderedList} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param items elements that should be list items
     * @return the builder instance
     * @see UnorderedList#UnorderedList(List)
     */
    public T unorderedList(Object... items) {
        newLinesIfRequired(1);
        append(new UnorderedList(Arrays.asList(items)));
        return newParagraph();
    }

    /**
     * Appends a {@link TaskList} element to the root {@link MarkdownBuilder#markdownElement}.
     *
     * @param items elements that should be task items
     * @return the builder instance
     * @see TaskList#TaskList(List)
     */
    public T taskList(TaskListItem... items) {
        newLinesIfRequired(1);
        append(new TaskList(Arrays.asList(items)));
        return newParagraph();
    }

    /**
     * Attempts to append the specified value to the existing root
     * {@link MarkdownBuilder#markdownElement}.
     *
     * @param value value to be appended
     * @return the builder instance
     */
    public abstract T append(Object value);

    /**
     * Attempts to serialize the specified value to markdown and appends
     * it to the existing root {@link MarkdownBuilder#markdownElement}.
     *
     * @param value value to be appended
     * @return the builder instance
     */
    public T append(MarkdownSerializable value) {
        try {
            // serialize object to markdown element
            return append(value.toMarkdownElement().getSerialized());
        } catch (MarkdownSerializationException e) {
            // use default string representation
            return append(value);
        }
    }

    /**
     * Appends two new lines to the existing root {@link MarkdownBuilder#markdownElement}.
     *
     * @return the builder instance
     */
    public T newParagraph() {
        return newLines(2);
    }

    /**
     * Appends two new lines to the existing root {@link MarkdownBuilder#markdownElement}
     * if it not already ends with two new lines.
     *
     * @return the builder instance
     */
    protected T newParagraphIfRequired() {
        if (!endsWithLineSeparators(2)) {
            newParagraph();
        }
        return getBuilder();
    }

    /**
     * Appends a new line to the existing root {@link MarkdownBuilder#markdownElement}.
     *
     * @return the builder instance
     */
    public T newLine() {
        return newLines(1);
    }

    /**
     * Appends a new line to the existing root {@link MarkdownBuilder#markdownElement}
     * if it not already ends with a new line.
     *
     * @return the builder instance
     */
    public T newLines(int count) {
        for (int i = 0; i < count; i++) {
            append(System.lineSeparator());
        }
        return getBuilder();
    }

    /**
     * Appends the specified number of new lines to the existing root
     * {@link MarkdownBuilder#markdownElement} if it not already ends with a new line.
     *
     * @param count number of new lines to be appended
     * @return the builder instance
     */
    protected T newLinesIfRequired(int count) {
        if (!endsWithLineSeparators(1)) {
            newLines(count);
        }
        return getBuilder();
    }

    /**
     * Checks if the root {@link MarkdownBuilder#markdownElement} ends with
     * the specified number of new lines
     *
     * @param count number of new lines
     * @return true if it ends with the specified number of new lines
     */
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

    /**
     * Returns the root {@link MarkdownBuilder#markdownElement}
     * @return {@link MarkdownBuilder#markdownElement}
     */
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
