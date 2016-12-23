package net.steppschuh.markdowngenerator.text;

public class InsertedText extends Text {

    public InsertedText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "++";
    }

}