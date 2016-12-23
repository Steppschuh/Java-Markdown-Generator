package net.steppschuh.markdowngenerator.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by steppschuh on 15/12/2016.
 */
public class TaskListTest {

    @Test
    public void example1() throws Exception {
        List<TaskListItem> items = Arrays.asList(
                new TaskListItem("Task 1", true),
                new TaskListItem("Task 2", false),
                new TaskListItem("Task 3")
        );
        TaskList list = new TaskList(items);
        System.out.println(list);
    }

}