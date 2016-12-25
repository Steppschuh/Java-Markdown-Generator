package net.steppschuh.markdowngenerator.text.code;

import net.steppschuh.markdowngenerator.text.Text;

public class CodeText extends Text {

    public CodeText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "`";
    }

}
