package net.steppschuh.markdowngenerator;

import net.steppschuh.markdowngenerator.table.TableRow;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by steppschuh on 15/12/2016.
 */

public class DummyObject implements MarkdownSerializable {

    private Object foo;
    private String bar;
    private int baz;

    public DummyObject() {
        this.foo = true;
        this.bar = "qux";
        this.baz = 1337;
    }

    public DummyObject(Object foo, String bar, int baz) {
        this.foo = foo;
        this.bar = bar;
        this.baz = baz;
    }

    public TableRow toMarkdownTableRow() {
        return new TableRow<>(Arrays.asList(
                foo, bar, baz
        ));
    }

    @Override
    public MarkdownElement toMarkdownElement() throws MarkdownSerializationException {
        return toMarkdownTableRow();
    }

    @Override
    public String toString() {
        try {
            return toMarkdownElement().toString();
        } catch (MarkdownSerializationException e) {
            return this.getClass().getSimpleName();
        }
    }

    public Object getFoo() {
        return foo;
    }

    public String getBar() {
        return bar;
    }

    public int getBaz() {
        return baz;
    }
}
