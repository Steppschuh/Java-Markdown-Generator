package net.steppschuh.markdowngenerator.text;

public class CodeText extends Text {

    public CodeText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "`";
    }

}
