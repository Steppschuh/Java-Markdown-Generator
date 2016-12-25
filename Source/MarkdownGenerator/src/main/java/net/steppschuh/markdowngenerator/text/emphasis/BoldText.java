package net.steppschuh.markdowngenerator.text.emphasis;

import net.steppschuh.markdowngenerator.text.Text;

public class BoldText extends Text {

    public BoldText(Object value) {
        super(value);
    }

    @Override
    public String getPredecessor() {
        return "**";
    }

}
