package net.steppschuh.markdowngenerator;

import net.steppschuh.markdowngenerator.list.ListBuilder;
import net.steppschuh.markdowngenerator.text.code.CodeBlock;
import net.steppschuh.markdowngenerator.text.code.CodeBlockBuilder;
import net.steppschuh.markdowngenerator.text.quote.QuoteBuilder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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

    public T newLine() {
        return newLines(1);
    }

    public T newLines(int count) {
        for (int i = 0; i < count; i++) {
            append(System.lineSeparator());
        }
        return getBuilder();
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
