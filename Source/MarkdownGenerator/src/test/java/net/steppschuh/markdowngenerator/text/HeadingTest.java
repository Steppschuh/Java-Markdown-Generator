package net.steppschuh.markdowngenerator.text;

import org.junit.Test;

/**
 * Created by steppschuh on 16/12/2016.
 */
public class HeadingTest {

    @Test
    public void example1() throws Exception {
        Text text = new Heading("I am a heading");
        System.out.println(text);
    }

    @Test
    public void example2() throws Exception {
        for (int level = Heading.MINIMUM_LEVEL; level <= Heading.MAXIMUM_LEVEL; level++) {
            Text text = new Heading("I am a heading with level " + level, level);
            System.out.println(text);
        }
    }

}