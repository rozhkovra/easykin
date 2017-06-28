package ru.rrozhkov.easykin.auth;

import ru.rrozhkov.easykin.db.impl.AuthHandler;
import ru.rrozhkov.easykin.gui.auth.AuthWindow;
import ru.rrozhkov.easykin.model.person.IPerson;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class AuthManager {
    static AuthManager authManager = new AuthManager();
    protected IPerson signedPerson;

    public static AuthManager instance(){
        if(authManager==null){
            authManager = new AuthManager();
        }
        return authManager;
    }

    public static AuthManager auth(){
        final AuthWindow window = new AuthWindow();
        window.start();
        while(!window.isFinished()){
        }
        window.finish();
        return authManager;
    }

    protected AuthManager() {
    }

    public IPerson signedPerson(){
        return signedPerson;
    }

    public void signIn(String user, String pass){
        try {
            this.signedPerson = AuthHandler.auth(user, pass);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void signOut(){
        this.signedPerson = null;
    }

    public boolean isSignedIn(){
        return this.signedPerson != null;
    }
}
