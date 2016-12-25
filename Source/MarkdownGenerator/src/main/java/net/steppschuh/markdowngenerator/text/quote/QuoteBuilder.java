package net.steppschuh.markdowngenerator.text.quote;

import net.steppschuh.markdowngenerator.MarkdownBuilder;

/**
 * Created by Stephan on 12/25/2016.
 */

public class QuoteBuilder extends MarkdownBuilder<QuoteBuilder, Quote> {

    public QuoteBuilder() {
        super();
    }

    public QuoteBuilder(MarkdownBuilder parentBuilder) {
        super(parentBuilder);
    }

    @Override
    protected QuoteBuilder getBuilder() {
        return this;
    }

    @Override
    protected Quote createMarkdownElement() {
        return new Quote("");
    }

    @Override
    public QuoteBuilder append(Object value) {
        markdownElement.setValue(new StringBuilder()
                .append(markdownElement.getValue())
                .append(value)
                .toString());
        return this;
    }

}
