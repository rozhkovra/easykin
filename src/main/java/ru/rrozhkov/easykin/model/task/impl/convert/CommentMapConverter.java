package ru.rrozhkov.easykin.model.task.impl.convert;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.util.DateUtil;
import ru.rrozhkov.lib.convert.IConverter;

import java.util.HashMap;
import java.util.Map;

public class CommentMapConverter implements IConverter<IComment, Map<String, Object>> {

	public Map<String, Object> convert(IComment comment) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", comment.getId());
		map.put("text", comment.getText());
		map.put("createdate", DateUtil.formatSql(comment.getDate()));
		map.put("taskid", comment.getTaskId());
		return map;
	}

}