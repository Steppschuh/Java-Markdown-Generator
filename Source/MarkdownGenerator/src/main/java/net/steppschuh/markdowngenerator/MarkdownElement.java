package net.steppschuh.markdowngenerator;

public abstract class MarkdownElement {

    private String serialized;

    public String serialize() {
        return "Serialization not implemented";
    }

    public String getSerialized() {
        if (serialized == null) {
            serialized = serialize();
        }
        return serialized;
    }

    public void setSerialized(String serialized) {
        this.serialized = serialized;
    }

    @Override
    public String toString() {
        return getSerialized();
    }

}
