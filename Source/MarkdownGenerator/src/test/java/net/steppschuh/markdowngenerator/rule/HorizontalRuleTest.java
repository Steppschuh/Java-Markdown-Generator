package net.steppschuh.markdowngenerator.rule;

import org.junit.Test;

/**
 * Created by steppschuh on 16/12/2016.
 */
public class HorizontalRuleTest {

    @Test
    public void example1() throws Exception {
        HorizontalRule horizontalRule = new HorizontalRule();
        System.out.println(horizontalRule);
    }

    @Test
    public void example2() throws Exception {
        HorizontalRule horizontalRule = new HorizontalRule(20, HorizontalRule.ASTERISK);
        System.out.println(horizontalRule);
    }

}