package ru.rrozhkov.easykin.db.impl;

import ru.rrozhkov.easykin.FilesSettings;
import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.category.convert.CategoryInsertConverter;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.person.impl.convert.PersonInsertConverter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by rrozhkov on 6/23/2017.
 */
public class DumpManager {
    public static final String STORAGE = "F:/temp/EasyKin";

    public static void dump(MasterDataContext masterDataContext){
        StringBuilder builder = new StringBuilder();
        CategoryInsertConverter converter = new CategoryInsertConverter();
        for (ICategory category : masterDataContext.categories())
            builder.append(converter.convert(category)+";");
        PersonInsertConverter pConverter = new PersonInsertConverter();
        for (IPerson person : masterDataContext.persons())
            builder.append(pConverter.convert(person)+";");
        writeDump(builder.toString());
    }
    public static void writeDump(String s){
        File sdcard = new File(STORAGE);
        File dumpFile = new File(sdcard, FilesSettings.EASYKIN_DUMP);
        FileOutputStream outputStream;

        try {
            if(!dumpFile.exists()) {
                dumpFile.mkdirs();
                dumpFile.createNewFile();
            }

            outputStream = new FileOutputStream(dumpFile);
            outputStream.write(s.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
