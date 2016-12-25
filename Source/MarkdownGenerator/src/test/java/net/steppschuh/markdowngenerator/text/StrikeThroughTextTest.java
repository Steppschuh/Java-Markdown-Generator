package net.steppschuh.markdowngenerator.text;

import net.steppschuh.markdowngenerator.DummyObject;
import net.steppschuh.markdowngenerator.text.emphasis.StrikeThroughText;

import org.junit.Test;

/**
 * Created by steppschuh on 15/12/2016.
 */
public class StrikeThroughTextTest {

    @Test
    public void example1() throws Exception {
        Text text = new StrikeThroughText("I am strike-through text");
        System.out.println(text);
    }

    @Test
    public void example2() throws Exception {
        Text text = new StrikeThroughText(new DummyObject());
        System.out.println(text);
    }

}