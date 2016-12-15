package net.steppschuh.markdowngenerator.link;

import net.steppschuh.markdowngenerator.MarkdownElement;
import net.steppschuh.markdowngenerator.MarkdownSerializationException;

public class Link extends MarkdownElement {

    private Object text;
    private String url;

    public Link(Object text, String url) {
        this.text = text;
        this.url = url;
    }

    public Link(String url) {
        this(url, url);
    }

    @Override
    public String serialize() throws MarkdownSerializationException {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(text).append("]");
        sb.append("(").append(url).append(")");
        return sb.toString();
    }

    public Object getText() {
        return text;
    }

    public void setText(Object text) {
        this.text = text;
        invalidateSerialized();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        invalidateSerialized();
    }

}
