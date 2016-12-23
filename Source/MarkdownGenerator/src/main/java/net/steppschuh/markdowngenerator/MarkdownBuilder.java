package net.steppschuh.markdowngenerator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by steppschuh on 23/12/2016.
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

    public MarkdownBuilder begin(Class<? extends MarkdownBuilder> markdownClass) {
        try {
            Constructor constructor = markdownClass.getConstructor(MarkdownBuilder.class);
            return (MarkdownBuilder) constructor.newInstance(this);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return getBuilder();
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
        return markdownElement.getSerialized(this.getClass().getSimpleName());
    }

    @Override
    public MarkdownElement toMarkdownElement() throws MarkdownSerializationException {
        return markdownElement;
    }

}
