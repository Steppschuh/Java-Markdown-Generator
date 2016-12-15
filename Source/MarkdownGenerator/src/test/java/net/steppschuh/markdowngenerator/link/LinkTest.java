package net.steppschuh.markdowngenerator.link;

import org.junit.Test;

/**
 * Created by steppschuh on 15/12/2016.
 */
public class LinkTest {

    @Test
    public void example1() throws Exception {
        String text = "I am a link";
        String url = "http://steppschuh.net";
        Link link = new Link(text, url);
        System.out.println(link);
    }

    @Test
    public void example2() throws Exception {
        String url = "http://steppschuh.net";
        Link link = new Link(url);
        System.out.println(link);
    }

}