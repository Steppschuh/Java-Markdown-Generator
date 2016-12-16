package net.steppschuh.markdowngenerator.rule;

import net.steppschuh.markdowngenerator.MarkdownElement;
import net.steppschuh.markdowngenerator.MarkdownSerializationException;
import net.steppschuh.markdowngenerator.util.StringUtil;

/**
 * Created by steppschuh on 16/12/2016.
 */

public class HorizontalRule extends MarkdownElement {

    public static final char HYPHEN = '-';
    public static final char ASTERISK = '*';
    public static final char UNDERSCORE = '_';

    public static final int MINIMUM_LENGTH = 3;

    private int length;
    private char character = HYPHEN;

    public HorizontalRule() {
        this.length = MINIMUM_LENGTH;
    }

    public HorizontalRule(int length) {
        this.length = Math.max(MINIMUM_LENGTH, length);
    }

    public HorizontalRule(int length, char character) {
        this(length);
        this.character = character;
    }

    @Override
    public String serialize() throws MarkdownSerializationException {
        return StringUtil.fillUpLeftAligned("", "" + character, length);
    }

}
