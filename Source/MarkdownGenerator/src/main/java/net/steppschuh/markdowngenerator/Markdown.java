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
