package net.steppschuh.markdowngenerator.text.code;

import net.steppschuh.markdowngenerator.text.Text;

import org.junit.Test;

/**
 * Created by steppschuh on 15/12/2016.
 */
public class CodeTest {

    @Test
    public void example1() throws Exception {
        Text text = new Code("System.out.println(\"I am code\");");
        System.out.println(text);
    }

}