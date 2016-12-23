package net.steppschuh.markdowngenerator;

/**
 * {@link MarkdownElement}s that can be wrapped around other {@link MarkdownElement}s should
 * implement this interface. This way they can be supported in the {@link Markdown} Builder.
 */
public interface MarkdownCascadable {

    /**
     * @return the string that should be added before the value
     */
    String getPredecessor();

    /**
     * @return the string that should be added after the value
     */
    String getSuccessor();

}
