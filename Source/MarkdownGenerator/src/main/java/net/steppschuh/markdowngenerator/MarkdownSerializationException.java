package net.steppschuh.markdowngenerator;

/**
 * Created by steppschuh on 15/12/2016.
 */

public class MarkdownSerializationException extends Exception {

    public MarkdownSerializationException() {
        super();
    }

    public MarkdownSerializationException(String s) {
        super(s);
    }

    public MarkdownSerializationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public MarkdownSerializationException(Throwable throwable) {
        super(throwable);
    }

}
