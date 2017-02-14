package ru.rrozhkov.easykin.gui.listener;

import ru.rrozhkov.easykin.gui.Table;
import ru.rrozhkov.easykin.gui.task.TaskEditor;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by rrozhkov on 2/14/2017.
 */
public class TaskCommentOnClickListener implements ListSelectionListener {
    private TaskEditor main;
    private Table table;

    public TaskCommentOnClickListener(TaskEditor main, Table table) {
        this.main = main;
        this.table = table;
    }

    public void valueChanged(ListSelectionEvent arg0) {
        main.edit(table.getSelectedRow());
    }
}
