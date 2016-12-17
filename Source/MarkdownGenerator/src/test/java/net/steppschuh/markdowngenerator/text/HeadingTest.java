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

    @Test
    public void example3() throws Exception {
        StringBuilder sb = new StringBuilder()
                .append(new Heading("Heading with level 1", 1)).append("\n")
                .append(new Heading("Heading with level 2", 2)).append("\n")
                .append(new Heading("Heading with level 3", 3)).append("\n")
                .append(new Heading("Heading with level 4", 4)).append("\n")
                .append(new Heading("Heading with level 5", 5)).append("\n")
                .append(new Heading("Heading with level 6", 6));

        System.out.println(sb);
    }

}