package ru.rrozhkov.easykin.context;

/**
 * Created by rrozhkov on 3/21/2017.
 */
public class EasyKinContext implements IContext {
    private MasterDataContext masterDataContext;
    private FilterContext filterContext;

    public MasterDataContext masterData(){
        if(masterDataContext==null){
            masterDataContext = new MasterDataContext();
        }
        return masterDataContext;
    }

    public FilterContext filterContext() {
        if(filterContext==null){
            filterContext = new FilterContext();
        }
        return filterContext;
    }

    public void init() {
        masterData().init();
        filterContext().init();
    }
}
