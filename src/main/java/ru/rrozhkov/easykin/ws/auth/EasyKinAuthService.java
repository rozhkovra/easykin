package ru.rrozhkov.easykin.ws.auth;

import ru.rrozhkov.easykin.auth.AuthManager;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by rrozhkov on 2/28/2017.
 */
@WebService(serviceName="EasyKinAuth", portName="EasyKinAuthPort", targetNamespace="http://rrozhkov.ru/easykin/auth")
public class EasyKinAuthService {

    @WebMethod
    public int auth(String user, String pass) {
        AuthManager authManager = AuthManager.instance();
        if(authManager.signIn(user, pass))
            return 1;
        return -1;
    }

}
