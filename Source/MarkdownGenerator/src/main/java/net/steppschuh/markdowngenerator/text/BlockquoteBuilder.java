package net.steppschuh.markdowngenerator.text;

import net.steppschuh.markdowngenerator.MarkdownBuilder;

/**
 * Created by Stephan on 12/25/2016.
 */

public class BlockQuoteBuilder extends MarkdownBuilder<BlockQuoteBuilder, BlockQuote> {

    public BlockQuoteBuilder() {
        super();
    }

    public BlockQuoteBuilder(MarkdownBuilder parentBuilder) {
        super(parentBuilder);
    }

    @Override
    protected BlockQuoteBuilder getBuilder() {
        return this;
    }

    @Override
    protected BlockQuote createMarkdownElement() {
        return new BlockQuote("");
    }

    @Override
    public BlockQuoteBuilder append(Object value) {
        markdownElement.setValue(new StringBuilder()
                .append(markdownElement.getValue())
                .append(value)
                .toString());
        return this;
    }

}
