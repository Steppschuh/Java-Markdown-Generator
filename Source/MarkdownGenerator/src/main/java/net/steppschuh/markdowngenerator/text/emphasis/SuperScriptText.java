package net.steppschuh.markdowngenerator.text.emphasis;

import net.steppschuh.markdowngenerator.text.Text;

public class SuperScriptText extends Text {

    public SuperScriptText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "^";
    }

}