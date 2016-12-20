package ru.rrozhkov.easykin.data.impl.stat;

import java.util.Arrays;
import java.util.Date;

import ru.rrozhkov.easykin.category.Category;
import ru.rrozhkov.easykin.data.impl.CollectionDataProvider;
import ru.rrozhkov.easykin.task.ITask;
import ru.rrozhkov.easykin.task.Priority;
import ru.rrozhkov.easykin.task.Status;
import ru.rrozhkov.easykin.task.impl.TaskFactory;
import ru.rrozhkov.easykin.util.CollectionUtil;
import ru.rrozhkov.easykin.util.DateUtil;

public class StaticTaskDataProvider extends CollectionDataProvider<ITask>{
	public StaticTaskDataProvider(){
		super(CollectionUtil.copy(Arrays.asList(
		TaskFactory.createTask(
				"Жесткий диск в ноутбук Seagate Laptop Thin SSHD 4 905 руб. https://market.yandex.ru/product/9335483?hid=91033&track=tabs"
				, new Date(), DateUtil.parse("31.08.2016"), Priority.IMPOTANT_NOFAST, Category.HOME, null, Status.OPEN)
		,TaskFactory.createTask(
				"Купить зимнюю резину Cordiant"
				, new Date(), DateUtil.parse("31.08.2016"), Priority.IMPOTANT_NOFAST, Category.AUTO, null, Status.CLOSE)
		,TaskFactory.createTask(
				"Сдать 1050 на методические пособия Лешке"
				, new Date(), DateUtil.parse("31.05.2016"), Priority.IMPOTANT_FAST, Category.FAMILY, null, Status.CLOSE)
		,TaskFactory.createTask(
				"Замена тормозных шлангов"
				, new Date(), DateUtil.parse("30.05.2016"), Priority.IMPOTANT_FAST, Category.AUTO, null, Status.OPEN)
		,TaskFactory.createTask(
				"Замена тормозных колодок"
				, new Date(), DateUtil.parse("30.05.2016"), Priority.IMPOTANT_FAST, Category.AUTO, null, Status.OPEN)
		,TaskFactory.createTask(
				"Замена задних пружин"
				, new Date(), DateUtil.parse("30.05.2016"), Priority.IMPOTANT_FAST, Category.AUTO, null, Status.OPEN)
		,TaskFactory.createTask(
				"Новые гайки на колеса"
				, new Date(), DateUtil.parse("30.05.2016"), Priority.SIMPLE, Category.AUTO, null, Status.OPEN)
		,TaskFactory.createTask(
				"Оплатить пеню за транспортный налог"
				, new Date(), DateUtil.parse("30.05.2016"), Priority.IMPOTANT_NOFAST, Category.AUTO, null, Status.CLOSE)
		,TaskFactory.createTask(
				"Замена правой передней шаровой"
				, new Date(), DateUtil.parse("30.03.2016"), Priority.IMPOTANT_FAST, Category.AUTO, null, Status.CLOSE)
		,TaskFactory.createTask(
				"Замена резины 800 р"
				, new Date(), DateUtil.parse("30.03.2016"), Priority.IMPOTANT_NOFAST, Category.AUTO, null, Status.CLOSE))));
	}
}