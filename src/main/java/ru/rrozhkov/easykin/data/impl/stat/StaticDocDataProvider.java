package ru.rrozhkov.easykin.data.impl.stat;

import ru.rrozhkov.easykin.model.doc.DocFactory;
import ru.rrozhkov.easykin.model.doc.IDoc;
import ru.rrozhkov.easykin.model.person.Sex;
import ru.rrozhkov.easykin.model.person.impl.PersonFactory;
import ru.rrozhkov.easykin.util.DateUtil;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.data.impl.CollectionDataProvider;

import java.util.Arrays;

/**
 * Created by rrozhkov on 3/13/2017.
 */
public class StaticDocDataProvider extends CollectionDataProvider<IDoc> {
    public StaticDocDataProvider() {
        super(CollectionUtil.copy(Arrays.asList(
                DocFactory.createPassport(
                        PersonFactory.create(1,"Рожков","Роман","Александрович", DateUtil.parse("29.08.1985"), Sex.MALE)
                        , "236554"
                        , "5205"
                        , "УВД Ленинского АО г.Омска"
                        , DateUtil.parse("30.09.2005")
                        , null
                ))));
    }
}
