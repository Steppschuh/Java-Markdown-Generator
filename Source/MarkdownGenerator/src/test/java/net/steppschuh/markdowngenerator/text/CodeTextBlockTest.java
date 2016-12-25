package net.steppschuh.markdowngenerator.text;

import net.steppschuh.markdowngenerator.text.code.CodeTextBlock;

import org.junit.Test;

/**
 * Created by steppschuh on 15/12/2016.
 */
public class CodeTextBlockTest {

    @Test
    public void example1() throws Exception {
        String code = "System.out.println(\"I am a code block\");";
        Text text = new CodeTextBlock(code);
        System.out.println(text);
    }

    @Test
    public void example2() throws Exception {
        String code = "// notice this new line\n" +
                "System.out.println(\"Hello\");";
        Text text = new CodeTextBlock(code, "Java");
        System.out.println(text);
    }

}