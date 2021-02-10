package net.steppschuh.markdowngenerator.text.code;

import net.steppschuh.markdowngenerator.text.Text;

public class CodeBlock extends Text {

    public static final String LANGUAGE_UNKNOWN = "";
    public static final String LANGUAGE_JAVA = "java";
    public static final String LANGUAGE_MARKDOWN = "markdown";

    private String language = LANGUAGE_UNKNOWN;

    public CodeBlock(Object value) {
        this(value, "");
    }

    public CodeBlock(Object value, String language) {
        super(value);
        this.language = language;
    }

    @Override
    public String getPredecessor() {
        return "```" + language + System.lineSeparator();
    }

    @Override
    public String getSuccessor() {
        return System.lineSeparator() + "```";
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
        invalidateSerialized();
    }
}
