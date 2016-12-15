package net.steppschuh.markdowngenerator.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by steppschuh on 15/12/2016.
 */
public class UnorderedListTest {

    @Test
    public void example1() throws Exception {
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3");
        UnorderedList list = new UnorderedList<>(items);
        System.out.println(list);
    }

    @Test
    public void example2() throws Exception {
        List<Date> items = Arrays.asList(
                new Date(0),
                new Date(1337001337),
                new Date()
        );
        UnorderedList list = new UnorderedList<>(items);
        System.out.println(list);
    }

}