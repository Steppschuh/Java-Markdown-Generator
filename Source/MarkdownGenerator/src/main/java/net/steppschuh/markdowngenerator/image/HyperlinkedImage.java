package net.steppschuh.markdowngenerator.image;

import net.steppschuh.markdowngenerator.MarkdownSerializationException;

public class HyperlinkedImage extends Image {

    private String hyperlink;
    private String tooltip;

    public HyperlinkedImage(Object text, String url, /*@Nullable*/ String hyperlink,/*@Nullable*/ String tooltip) {
        super(text, url);
        this.hyperlink = hyperlink;
        this.tooltip = tooltip;
    }

    public HyperlinkedImage(String url, /*@Nullable*/ String hyperlink, /*@Nullable*/ String tooltip) {
        super(url);
        this.hyperlink = hyperlink;
        this.tooltip = tooltip;
    }

    @Override public String serialize() throws MarkdownSerializationException {
        if (hyperlink != null)
            if (tooltip != null)
                return "[![" + getText() + "](" + getUrl() + " \"" + tooltip.replace("\"", "\\\"") + "\")](" + hyperlink + ")";
            else
                return "[![" + getText() + "](" + getUrl() + ")](" + hyperlink + ")";
        if (tooltip == null)
            return super.serialize();
        else
            return "![" + getText() + "](" + getUrl() + "\"" + tooltip.replace("\"", "\\\"") + "\")";
    }
}
