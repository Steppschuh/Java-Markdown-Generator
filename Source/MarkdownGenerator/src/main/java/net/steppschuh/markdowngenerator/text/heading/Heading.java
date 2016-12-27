package net.steppschuh.markdowngenerator.text.heading;

import net.steppschuh.markdowngenerator.text.Text;
import net.steppschuh.markdowngenerator.util.StringUtil;

/**
 * Created by steppschuh on 16/12/2016.
 */

public class Heading extends Text {

    public static final int MINIMUM_LEVEL = 1;
    public static final int MAXIMUM_LEVEL = 6;

    public static final char UNDERLINE_CHAR_1 = '=';
    public static final char UNDERLINE_CHAR_2 = '-';

    private int level;
    boolean underlineStyle = true;

    public Heading(Object value) {
        super(value);
        this.level = MINIMUM_LEVEL;
    }

    public Heading(Object value, int level) {
        super(value);
        this.level = level;
        trimLevel();
    }

    @Override
    public String getPredecessor() {
        if (underlineStyle && level < 3) {
            return "";
        }
        return StringUtil.fillUpRightAligned("", "#", level) + " ";
    }

    @Override
    public String getSuccessor() {
        if (underlineStyle && level < 3) {
            char underlineChar = (level == 1) ? UNDERLINE_CHAR_1 : UNDERLINE_CHAR_2;
            return "\n" + StringUtil.fillUpLeftAligned("", "" + underlineChar, value.toString().length());
        }
        return "";
    }

    private void trimLevel() {
        level = Math.min(MAXIMUM_LEVEL, Math.max(MINIMUM_LEVEL, level));
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        trimLevel();
        invalidateSerialized();
    }

    public boolean isUnderlineStyle() {
        return underlineStyle;
    }

    public void setUnderlineStyle(boolean underlineStyle) {
        this.underlineStyle = underlineStyle;
        invalidateSerialized();
    }

}
