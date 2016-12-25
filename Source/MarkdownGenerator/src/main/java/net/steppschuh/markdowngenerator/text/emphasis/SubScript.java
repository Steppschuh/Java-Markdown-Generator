package net.steppschuh.markdowngenerator.text.emphasis;

import net.steppschuh.markdowngenerator.text.Text;

public class SubScript extends Text {

    public SubScript(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "~";
    }

}