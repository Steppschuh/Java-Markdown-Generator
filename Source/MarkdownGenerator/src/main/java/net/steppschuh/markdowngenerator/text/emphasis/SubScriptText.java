package net.steppschuh.markdowngenerator.text.emphasis;

import net.steppschuh.markdowngenerator.text.Text;

public class SubScriptText extends Text {

    public SubScriptText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "~";
    }

}