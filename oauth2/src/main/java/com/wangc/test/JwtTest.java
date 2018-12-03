package com.wangc.test;

import org.junit.jupiter.api.Test;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;

/**
 * @author: gnehcgnaw
 * @date: 2018-12-02 16:05
 */
public class JwtTest {
    @Test
    public void test(){
        String token="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NDM3ODA5OTMsInVzZXJfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiYWRt" +
                "aW4iXSwianRpIjoiMTg4NDJlYjUtOTI2Zi00MTJlLWEwNTUtZTQzMjQ1MjAwNzFlIiwiY2xpZW50X2lkIjoiY2xpZW50Iiwic2NvcGUiOlsiYXBwIl19.Iwz" +
                "RkgkJFGhv0kA0PAMZUx3Z7OEavdxmhBZCBf5dHr3rqkQ-hURjsVEB0uR5LnInP1IeGvFp2x8Vv5qNJEbzkKsAgDQMdvLLPIrKgM1vGQ0Nev-8LnolUG2dzaEFVKZCC" +
                "8Fk2rGd42gtK0pc89zd4Wuj_pTpMKXs0ks-Ux_BlSvWEqp0wlp0mOxrT6hVj-4QHlREIGLer528eJi1wmRDlz_-5f6AswCUPdSAqLDBYrYHhRimRnuNeMVo3EIzxyJtpcD" +
                "w_Fz5k74O6JdRYBWLuYDe0WpnJhbvElEOIe1y1LlGRxO-1rc2GHz6shriVHoxODPOWN6DwDbOf37KXzi2Jg";
        Jwt jwt = JwtHelper.decode(token);
        System.out.println(jwt.toString());
    }
}
