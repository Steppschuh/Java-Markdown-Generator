package net.steppschuh.markdowngenerator;

/**
 * Base class that every markdown element extends.
 */
public abstract class MarkdownElement implements MarkdownSerializable {

    private String serialized;

    /**
     * Attempts to generate a String representing this markdown element.
     *
     * @return Markdown as String
     * @throws MarkdownSerializationException If unable to generate a markdown String
     */
    public abstract String serialize() throws MarkdownSerializationException;

    /**
     * Returns the result of {@link MarkdownElement#getSerialized()} or the specified fallback if a
     * {@link MarkdownSerializationException} occurred.
     *
     * @param fallback String to return if serialization fails
     * @return Markdown as String or specified fallback
     */
    public String getSerialized(String fallback) {
        try {
            return getSerialized();
        } catch (MarkdownSerializationException e) {
            return fallback;
        }
    }

    /**
     * Calls {@link MarkdownElement#serialize()} or directly returns its last result from {@link
     * MarkdownElement#serialized}.
     *
     * @return Markdown as String
     * @throws MarkdownSerializationException If unable to generate a markdown String
     */
    public String getSerialized() throws MarkdownSerializationException {
        if (serialized == null) {
            serialized = serialize();
        }
        return serialized;
    }

    public void setSerialized(String serialized) {
        this.serialized = serialized;
    }

    /**
     * Sets {@link MarkdownElement#serialized} to null. The next call to {@link
     * MarkdownElement#getSerialized()} fill invoke a fresh serialization.
     */
    public void invalidateSerialized() {
        setSerialized(null);
    }

    @Override
    public MarkdownElement toMarkdownElement() throws MarkdownSerializationException {
        return this;
    }

    @Override
    public String toString() {
        return getSerialized(this.getClass().getSimpleName());
    }

}
