package net.steppschuh.markdowngenerator.util;

import net.steppschuh.markdowngenerator.table.Table;

/**
 * Created by steppschuh on 15/12/2016.
 */

public abstract class StringUtil {

    public static String fillUpAligned(String value, String fill, int length, int alignment) {
        switch (alignment) {
            case Table.ALIGN_RIGHT: {
                return fillUpRightAligned(value, fill, length);
            }
            case Table.ALIGN_CENTER: {
                return fillUpCenterAligned(value, fill, length);
            }
            default: {
                return fillUpLeftAligned(value, fill, length);
            }
        }
    }

    public static String fillUpLeftAligned(String value, String fill, int length) {
        if (value.length() >= length) {
            return value;
        }
        while (value.length() < length) {
            value += fill;
        }
        return value;
    }

    public static String fillUpRightAligned(String value, String fill, int length) {
        if (value.length() >= length) {
            return value;
        }
        while (value.length() < length) {
            value = fill + value;
        }
        return value;
    }

    public static String fillUpCenterAligned(String value, String fill, int length) {
        if (value.length() >= length) {
            return value;
        }
        boolean left = true;
        while (value.length() < length) {
            if (left) {
                value = fillUpLeftAligned(value, fill, value.length() + 1);
            } else {
                value = fillUpRightAligned(value, fill, value.length() + 1);
            }
            left = !left;
        }
        return value;
    }

    public static String surroundValueWith(String value, String surrounding) {
        return surrounding + value + surrounding;
    }

}
