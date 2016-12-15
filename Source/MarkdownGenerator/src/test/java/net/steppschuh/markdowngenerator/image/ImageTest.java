package net.steppschuh.markdowngenerator.image;

import org.junit.Test;

/**
 * Created by steppschuh on 15/12/2016.
 */
public class ImageTest {

    @Test
    public void example1() throws Exception {
        String text = "I am an image";
        String url = "https://dummyimage.com/300";
        Image image = new Image(text, url);
        System.out.println(image);
    }

    @Test
    public void example2() throws Exception {
        String url = "https://dummyimage.com/300";
        Image image = new Image(url);
        System.out.println(image);
    }

}