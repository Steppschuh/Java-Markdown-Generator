package net.steppschuh.markdowngenerator.text.code;

import net.steppschuh.markdowngenerator.text.Text;

import org.junit.Test;

/**
 * Created by steppschuh on 15/12/2016.
 */
public class CodeBlockTest {

    @Test
    public void example1() throws Exception {
        String code = "System.out.println(\"I am a code block\");";
        Text text = new CodeBlock(code);
        System.out.println(text);
    }

    @Test
    public void example2() throws Exception {
        String code = "// notice this new line\n" +
                "System.out.println(\"Hello\");";
        Text text = new CodeBlock(code, "Java");
        System.out.println(text);
    }

}