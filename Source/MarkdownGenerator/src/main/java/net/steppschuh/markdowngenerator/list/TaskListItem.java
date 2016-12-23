package net.steppschuh.markdowngenerator.list;

public class TaskListItem extends UnorderedListItem {

    private boolean checked;

    public TaskListItem(Object value) {
        this(value, false);
    }

    public TaskListItem(Object value, boolean checked) {
        super(value);
        this.checked = checked;
    }

    @Override
    public String getPredecessor() {
        return "- " + getCheckedIndicator(checked) + " ";
    }

    public static String getCheckedIndicator(boolean checked) {
        return checked ? "[x]" : "[ ]";
    }

}
