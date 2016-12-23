package ru.rrozhkov.easykin.data.impl.stat;

import java.util.HashMap;
import java.util.Map;

import ru.rrozhkov.easykin.data.ICollectionDataProvider;
import ru.rrozhkov.easykin.data.impl.PaymentDataProvider;

public class AllDataProvider {
	public static Map<Integer, ICollectionDataProvider> providers = new HashMap<Integer, ICollectionDataProvider>(){{		
		put(3, new StaticPersonDataProvider());
        put(4, new StaticServiceHistoryDataProvider());
        put(2, new StaticChildDataProvider());
        put(6, new PaymentDataProvider(new StaticAutoServiceDataProvider()));	
        put(10, new StaticServiceDataProvider());
	}};
	
	public static void put(Integer id, ICollectionDataProvider provider){
		providers.put(id, provider);
	}
	public static ICollectionDataProvider get(Integer id){
		return providers.get(id);
	}
}