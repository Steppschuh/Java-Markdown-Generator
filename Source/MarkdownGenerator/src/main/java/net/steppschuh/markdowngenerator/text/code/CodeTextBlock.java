package net.steppschuh.markdowngenerator.text.code;

import net.steppschuh.markdowngenerator.text.Text;

public class CodeTextBlock extends Text {

    private String language;

    public CodeTextBlock(Object value) {
        this(value, "");
    }

    public CodeTextBlock(Object value, String language) {
        super(value);
        this.language = language;
    }

    @Override
    public String getPredecessor() {
        return "```" + language + "\n";
    }

    @Override
    public String getSuccessor() {
        return "\n```";
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
        invalidateSerialized();
    }
}
