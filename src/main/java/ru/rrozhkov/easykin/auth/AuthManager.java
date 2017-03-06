package ru.rrozhkov.easykin.auth;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.person.Sex;
import ru.rrozhkov.easykin.model.person.impl.PersonFactory;
import ru.rrozhkov.easykin.util.DateUtil;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class AuthManager {
    protected IPerson authorizedPerson;

    public AuthManager(IPerson authorizedPerson) {
        this.authorizedPerson = authorizedPerson;
    }

    public IPerson authPerson(){
        return authorizedPerson;
    }

    public static IPerson getAuthPerson(){
        return PersonFactory.create(1,"??????", "?????", "?????????????", DateUtil.parse("29.08.1985"), Sex.MALE);
    }
}
