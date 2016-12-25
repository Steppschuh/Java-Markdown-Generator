package net.steppschuh.markdowngenerator.text.emphasis;

import net.steppschuh.markdowngenerator.text.Text;

public class ItalicText extends Text {

    public ItalicText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "_";
    }

}
