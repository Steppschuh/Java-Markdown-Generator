package net.steppschuh.markdowngenerator.text;

import net.steppschuh.markdowngenerator.MarkdownSerializationException;

/**
 * Created by steppschuh on 15/12/2016.
 */

public class Blockquote extends Text {

    public Blockquote(Object value) {
        super(value);
    }

    @Override
    public String serialize() throws MarkdownSerializationException {
        if (value == null) {
            throw new MarkdownSerializationException("Value is null");
        }
        StringBuilder sb = new StringBuilder();
        String lines[] = value.toString().split("\\r?\\n");
        for (int lineIndex = 0; lineIndex < lines.length; lineIndex++) {
            sb.append("> ").append(lines[lineIndex]);
            if (lineIndex < lines.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
