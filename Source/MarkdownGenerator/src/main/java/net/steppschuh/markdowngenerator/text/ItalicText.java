package net.steppschuh.markdowngenerator.text;

public class ItalicText extends Text {

    public ItalicText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "_";
    }

}
