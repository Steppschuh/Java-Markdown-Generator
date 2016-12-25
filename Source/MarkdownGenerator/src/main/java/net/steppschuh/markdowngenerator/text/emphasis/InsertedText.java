package net.steppschuh.markdowngenerator.text.emphasis;

import net.steppschuh.markdowngenerator.text.Text;

public class InsertedText extends Text {

    public InsertedText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "++";
    }

}