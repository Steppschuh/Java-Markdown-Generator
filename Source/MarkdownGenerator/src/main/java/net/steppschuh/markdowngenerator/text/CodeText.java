package net.steppschuh.markdowngenerator.text;

public class CodeText extends TextFormatter {

    public CodeText(Object value) {
        super(value);
    }

    @Override
    protected String getPredecessor() {
        return "`";
    }

    @Override
    protected String getSuccessor() {
        return getPredecessor();
    }

}
