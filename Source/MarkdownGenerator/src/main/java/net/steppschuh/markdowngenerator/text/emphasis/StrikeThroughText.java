package net.steppschuh.markdowngenerator.text.emphasis;

import net.steppschuh.markdowngenerator.text.Text;

public class StrikeThroughText extends Text {

    public StrikeThroughText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "~~";
    }

}
