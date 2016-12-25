package net.steppschuh.markdowngenerator.text.code;

import net.steppschuh.markdowngenerator.MarkdownBuilder;
import net.steppschuh.markdowngenerator.text.quote.Quote;

/**
 * Created by Stephan on 12/25/2016.
 */

public class CodeBlockBuilder extends MarkdownBuilder<CodeBlockBuilder, CodeBlock> {

    public CodeBlockBuilder() {
        this(CodeBlock.LANGUAGE_UNKNOWN);
    }

    public CodeBlockBuilder(String language) {
        super();
        markdownElement.setLanguage(language);
    }

    public CodeBlockBuilder(MarkdownBuilder parentBuilder) {
        this(parentBuilder, CodeBlock.LANGUAGE_UNKNOWN);
    }

    public CodeBlockBuilder(MarkdownBuilder parentBuilder, String language) {
        super(parentBuilder);
        markdownElement.setLanguage(language);
    }


    @Override
    protected CodeBlockBuilder getBuilder() {
        return this;
    }

    @Override
    protected CodeBlock createMarkdownElement() {
        return new CodeBlock(CodeBlock.LANGUAGE_UNKNOWN);
    }

    @Override
    public CodeBlockBuilder append(Object value) {
        markdownElement.setValue(new StringBuilder()
                .append(markdownElement.getValue())
                .append(value)
                .toString());
        return this;
    }

}
