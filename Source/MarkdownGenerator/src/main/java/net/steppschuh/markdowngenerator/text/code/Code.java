package net.steppschuh.markdowngenerator.text.code;

import net.steppschuh.markdowngenerator.text.Text;

public class Code extends Text {

    public Code(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "`";
    }

}
