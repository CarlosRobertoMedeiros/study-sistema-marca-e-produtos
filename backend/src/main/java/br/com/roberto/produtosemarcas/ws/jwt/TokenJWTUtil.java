package br.com.roberto.produtosemarcas.ws.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.inject.Inject;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class TokenJWTUtil {


    private static KeyGenerator keyGenerator = new KeyGenerator();

    public static String gerarToken(String usuario, List<String> roles){

        Key key = keyGenerator.generateKey();

        String jwtToken = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,key)
                .setHeaderParam("typ","JWT")
                .setSubject(usuario)
                .setIssuer("Carlos Roberto Medeiros de Lima")
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(30L)))
                .claim("roles",roles)
                .compact();
        return jwtToken;
    }

    private static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


}
