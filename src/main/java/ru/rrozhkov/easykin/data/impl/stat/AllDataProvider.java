package ru.rrozhkov.easykin.data.impl.stat;

import java.util.HashMap;
import java.util.Map;

import ru.rrozhkov.easykin.category.Category;
import ru.rrozhkov.easykin.data.ICollectionDataProvider;
import ru.rrozhkov.easykin.data.impl.PaymentDataProvider;

public class AllDataProvider {
	public static Map<Category, ICollectionDataProvider> providers = new HashMap<Category, ICollectionDataProvider>(){{		
		put(Category.FAMILY, new StaticPersonDataProvider());
        put(Category.AUTO, new StaticServiceHistoryDataProvider());
        put(Category.CHILD, new StaticChildDataProvider());
        put(Category.PAYMENT, new PaymentDataProvider(new StaticAutoServiceDataProvider()));	
        put(Category.TASK, new StaticTaskDataProvider());
        put(Category.HOME, new StaticHomeTaskDataProvider());
        put(Category.WORK, new StaticWorkTaskDataProvider());
        put(Category.SERVICE, new StaticServiceDataProvider());
	}};
	
	public static void put(Category category, ICollectionDataProvider provider){
		providers.put(category, provider);
	}
	public static ICollectionDataProvider get(Category category){
		return providers.get(category);
	}
}