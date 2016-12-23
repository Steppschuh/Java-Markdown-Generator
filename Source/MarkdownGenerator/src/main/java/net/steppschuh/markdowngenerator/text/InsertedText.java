package net.steppschuh.markdowngenerator.text;

public class InsertedText extends Text {

    public InsertedText(Object value) {
        super(value);
    }

    @Override
    protected String getPredecessor() {
        return "++";
    }

    @Override
    protected String getSuccessor() {
        return getPredecessor();
    }

}