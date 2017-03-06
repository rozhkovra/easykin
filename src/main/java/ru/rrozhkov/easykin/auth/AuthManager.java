package ru.rrozhkov.easykin.auth;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.person.Sex;
import ru.rrozhkov.easykin.model.person.impl.PersonFactory;
import ru.rrozhkov.easykin.util.DateUtil;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class AuthManager {
    protected IPerson signedPerson;

    public AuthManager() {
    }

    public IPerson signedPerson(){
        return signedPerson;
    }

    public boolean signIn(String user, String pass){
        //todo add authorize person by user/pass pair
        this.signedPerson = getAuthPerson();
        return isSignedIn();
    }

    public void signOut(){
        this.signedPerson = null;
    }

    public boolean isSignedIn(){
        return this.signedPerson != null;
    }

    public static IPerson getAuthPerson(){
        return PersonFactory.create(1,"??????", "?????", "?????????????", DateUtil.parse("29.08.1985"), Sex.MALE);
    }
}
