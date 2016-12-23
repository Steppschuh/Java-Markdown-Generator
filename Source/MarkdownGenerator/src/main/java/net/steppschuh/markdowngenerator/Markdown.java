package net.steppschuh.markdowngenerator;

import net.steppschuh.markdowngenerator.text.BoldText;
import net.steppschuh.markdowngenerator.text.CodeText;
import net.steppschuh.markdowngenerator.text.CodeTextBlock;
import net.steppschuh.markdowngenerator.text.Heading;
import net.steppschuh.markdowngenerator.text.ItalicText;
import net.steppschuh.markdowngenerator.text.Text;

/**
 * Created by steppschuh on 23/12/2016.
 */

public abstract class Markdown {

    public static class Builder {

        private Builder parentBuilder;
        private MarkdownCascadable parentCascadable;

        private StringBuilder markdownStringBuilder;

        public Builder() {
            markdownStringBuilder = new StringBuilder();
        }

        private Builder(Builder parentBuilder, MarkdownCascadable parentCascadable) {
            this();
            this.parentBuilder = parentBuilder;
            this.parentCascadable = parentCascadable;
            append(parentCascadable.getPredecessor());
        }

        public Builder begin(MarkdownCascadable markdownCascadable) {
            return new Builder(this, markdownCascadable);
        }

        public Builder end() {
            if (parentBuilder == null || parentCascadable == null) {
                return this;
            }
            append(parentCascadable.getSuccessor());
            parentBuilder.append(this);
            return parentBuilder;
        }

        public Builder append(Object value) {
            markdownStringBuilder.append(value);
            return this;
        }

        public Builder append(MarkdownSerializable value) {
            try {
                // serialize object to markdown element
                return append(value.toMarkdownElement().getSerialized());
            } catch (MarkdownSerializationException e) {
                // use default string representation
                return append(value);
            }
        }

        public Builder newParagraph() {
            return newLines(2);
        }

        public Builder newLine() {
            return newLines(1);
        }

        public Builder newLines(int count) {
            for (int i = 0; i < count; i++) {
                append(System.lineSeparator());
            }
            return this;
        }

        @Override
        public String toString() {
            return markdownStringBuilder.toString();
        }

    }

    // Heading

    public static Text heading(String value, int level) {
        return new Heading(value, level);
    }

    public static Text heading(String value) {
        return heading(value, 1);
    }

    public static Text subHeading(String value) {
        return heading(value, 2);
    }

    // Emphasis

    public static Text text(String value) {
        return new Text(value);
    }

    public static BoldText bold(String value) {
        return new BoldText(value);
    }

    public static ItalicText italic(String value) {
        return new ItalicText(value);
    }


    // Code

    public static CodeText code(String value) {
        return new CodeText(value);
    }

    public static CodeTextBlock codeBlock(String value, String language) {
        return new CodeTextBlock(value, language);
    }

    public static CodeTextBlock codeBlock(String language) {
        return codeBlock(null, language);
    }

}
