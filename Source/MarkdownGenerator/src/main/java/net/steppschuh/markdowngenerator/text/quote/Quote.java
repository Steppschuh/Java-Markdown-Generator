package net.steppschuh.markdowngenerator.text.quote;

import net.steppschuh.markdowngenerator.MarkdownSerializationException;
import net.steppschuh.markdowngenerator.text.Text;

/**
 * Created by steppschuh on 15/12/2016.
 */

public class Quote extends Text {

    public Quote(Object value) {
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
