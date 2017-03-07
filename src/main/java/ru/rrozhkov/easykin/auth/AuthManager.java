package ru.rrozhkov.easykin.auth;

import ru.rrozhkov.easykin.gui.auth.AuthWindow;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.person.Sex;
import ru.rrozhkov.easykin.model.person.impl.PersonFactory;
import ru.rrozhkov.easykin.util.DateUtil;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class AuthManager {
    protected IPerson signedPerson;

    protected AuthManager() {
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
        return PersonFactory.create(1,"Рожков", "Роман", "Александрович", DateUtil.parse("29.08.1985"), Sex.MALE);
    }

    public static AuthManager auth(){
        AuthManager authManager = new AuthManager();
        final AuthWindow window = new AuthWindow(authManager);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                window.setVisible(true);
            }
        });
        while(!window.isFinished()){
        }
        return authManager;
    }
}
