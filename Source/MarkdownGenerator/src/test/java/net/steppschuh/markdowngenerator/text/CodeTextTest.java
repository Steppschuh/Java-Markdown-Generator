package net.steppschuh.markdowngenerator.text;

import org.junit.Test;

/**
 * Created by steppschuh on 15/12/2016.
 */
public class CodeTextTest {

    @Test
    public void example1() throws Exception {
        Text text = new CodeText("System.out.println(\"I am code\");");
        System.out.println(text);
    }

}