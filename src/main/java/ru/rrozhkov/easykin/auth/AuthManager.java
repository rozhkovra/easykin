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

    protected AuthManager() {
    }

    public static AuthManager instance(){
        if(authManager==null){
            authManager = new AuthManager();
        }
        return authManager;
    }

    public IPerson signedPerson(){
        return signedPerson;
    }

    public boolean signIn(String user, String pass){
        try {
            this.signedPerson = AuthHandler.auth(user, pass);
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSignedIn();
    }

    public void signOut(){
        this.signedPerson = null;
    }

    public boolean isSignedIn(){
        return this.signedPerson != null;
    }

    public static AuthManager auth(){
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
