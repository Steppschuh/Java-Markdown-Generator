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
        StringBuilder valueBuilder = new StringBuilder(length);
        valueBuilder.append(value);
        while (valueBuilder.length() < length) {
            valueBuilder.append(fill);
        }
        return valueBuilder.toString();
    }

    public static String fillUpRightAligned(String value, String fill, int length) {
        int valueLength = value.length();
        if (valueLength >= length) {
            return value;
        }
        StringBuilder valueBuilder = new StringBuilder(length);
        int fillLength = length - valueLength;
        while (valueBuilder.length() < fillLength) {
            valueBuilder.append(fill);
        }
        valueBuilder.append(value);
        return valueBuilder.toString();
    }

    public static String fillUpCenterAligned(String value, String fill, int length) {
        int valueLength = value.length();
        if (valueLength >= length) {
            return value;
        }
        int fillLeftCount = (length - valueLength) / 2 / fill.length();
        StringBuilder valueBuilder = new StringBuilder(length);
        for (int i=0; i<fillLeftCount; i++) {
            valueBuilder.append(fill);
        }
        valueBuilder.append(value);
        while (valueBuilder.length() < length) {
            valueBuilder.append(fill);
        }
        return valueBuilder.toString();
    }

    public static String surroundValueWith(String value, String surrounding) {
        return surrounding + value + surrounding;
    }

}
