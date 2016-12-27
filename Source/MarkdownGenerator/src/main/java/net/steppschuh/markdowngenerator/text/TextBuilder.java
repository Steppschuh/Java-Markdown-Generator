package net.steppschuh.markdowngenerator.text;

import net.steppschuh.markdowngenerator.MarkdownBuilder;

/**
 * Created by steppschuh on 23/12/2016.
 */

public class TextBuilder extends MarkdownBuilder<TextBuilder, Text> {

    public TextBuilder() {
    }

    public TextBuilder(MarkdownBuilder parentBuilder) {
        super(parentBuilder);
    }

    @Override
    protected TextBuilder getBuilder() {
        return this;
    }

    @Override
    protected Text createMarkdownElement() {
        return new Text("");
    }

    @Override
    public TextBuilder append(Object value) {
        StringBuilder sb = new StringBuilder();
        if (markdownElement.getValue() != null) {
            sb.append(markdownElement.getValue());
        }
        sb.append(value);
        markdownElement.setValue(sb);
        return this;
    }
}
