package net.steppschuh.markdowngenerator.progress;

import net.steppschuh.markdowngenerator.MarkdownElement;
import net.steppschuh.markdowngenerator.MarkdownSerializationException;
import net.steppschuh.markdowngenerator.util.StringUtil;

/**
 * Created by Stephan on 12/18/2016.
 */

public class ProgressBar extends MarkdownElement {

    public static final int LENGTH_SMALL = 15;
    public static final int LENGTH_NORMAL = 20;
    public static final int LENGTH_LARGE = 50;

    public static final char OPENING_CHAR_DEFAULT = '[';
    public static final char CLOSING_CHAR_DEFAULT = ']';

    public static final char FILL_CHAR_DEFAULT = '=';
    public static final char EMPTY_CHAR_DEFAULT = '-';

    private char openingChar = OPENING_CHAR_DEFAULT;
    private char closingChar = CLOSING_CHAR_DEFAULT;

    private char fillChar = FILL_CHAR_DEFAULT;
    private char emptyChar = EMPTY_CHAR_DEFAULT;

    private int length = LENGTH_NORMAL;
    private boolean appendValue = false;
    private boolean appendPercentage = false;

    private double value;
    private double minimumValue = 0;
    private double maximumValue = 1;

    public ProgressBar(double value) {
        this.value = value;
    }

    public ProgressBar(double value, int length) {
        this.value = value;
        this.length = length;
    }

    private void trimValue() {
        value = Math.max(minimumValue, Math.min(maximumValue, value));
    }

    @Override
    public String serialize() throws MarkdownSerializationException {
        trimValue();
        StringBuilder sb = new StringBuilder().append(openingChar);
        int filledCharsCount = calculateFilledCharsCount(value, minimumValue, maximumValue, length);
        for (int charIndex = 0; charIndex < length; charIndex++) {
            sb.append((charIndex < filledCharsCount) ? fillChar : emptyChar);
        }
        sb.append(closingChar);
        if (appendValue) {
            String readableValue = getReadableValue(value);
            readableValue = StringUtil.fillUpRightAligned(readableValue, " ", 7);
            sb.append(" ").append(readableValue);
        }
        if (appendPercentage) {
            String readablePercentage = getReadablePercentage(value, minimumValue, maximumValue);
            readablePercentage = StringUtil.fillUpRightAligned(readablePercentage, " ", 4);
            sb.append(" (").append(readablePercentage).append(")");
        }
        return sb.toString();
    }

    public static int calculateFilledCharsCount(double value, double minimumValue, double maximumValue, int length) {
        try {
            return (int) Math.round((length * value) / (maximumValue - minimumValue));
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    public static String getReadableValue(double value) {
        if (value >= 1 || value == 0) {
            return String.valueOf(value);
        } else {
            return String.format("%.4f", value);
        }
    }

    public static String getReadablePercentage(double value, double minimumValue, double maximumValue) {
        int percentage = calculateFilledCharsCount(value, minimumValue, maximumValue, 100);
        return percentage + "%";
    }

    public char getOpeningChar() {
        return openingChar;
    }

    public void setOpeningChar(char openingChar) {
        this.openingChar = openingChar;
        invalidateSerialized();
    }

    public char getClosingChar() {
        return closingChar;
    }

    public void setClosingChar(char closingChar) {
        this.closingChar = closingChar;
        invalidateSerialized();
    }

    public char getFillChar() {
        return fillChar;
    }

    public void setFillChar(char fillChar) {
        this.fillChar = fillChar;
        invalidateSerialized();
    }

    public char getEmptyChar() {
        return emptyChar;
    }

    public void setEmptyChar(char emptyChar) {
        this.emptyChar = emptyChar;
        invalidateSerialized();
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
        invalidateSerialized();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
        invalidateSerialized();
    }

    public double getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(double minimumValue) {
        this.minimumValue = minimumValue;
        invalidateSerialized();
    }

    public double getMaximumValue() {
        return maximumValue;
    }

    public void setMaximumValue(double maximumValue) {
        this.maximumValue = maximumValue;
        invalidateSerialized();
    }

    public boolean isAppendingValue() {
        return appendValue;
    }

    public void setAppendValue(boolean appendValue) {
        this.appendValue = appendValue;
    }

    public boolean isAppendingPercentage() {
        return appendPercentage;
    }

    public void setAppendPercentage(boolean appendPercentage) {
        this.appendPercentage = appendPercentage;
        invalidateSerialized();
    }
}
