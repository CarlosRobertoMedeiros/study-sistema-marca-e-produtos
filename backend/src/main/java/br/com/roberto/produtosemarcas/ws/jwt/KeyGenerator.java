package br.com.roberto.produtosemarcas.ws.jwt;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class KeyGenerator {

    public Key generateKey(){
        String keyString = "07800fd646026c8c4aea9dcaf64102b37c4fe6193c81f304d9caa56bd39db5a3";//Carlos Roberto Medeiros de Lima //Encode SHA256
        Key key = new SecretKeySpec(keyString.getBytes(),0,keyString.getBytes().length,"HmacSHA256");
        return key;
    }

}
