package com.airline.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppPropertiesTest {
    //JEDNOSTKOWEJEDNOSTKOWEJEDNOSTKOWEJEDNOSTKOWEJEDNOSTKOWEJEDNOSTKOWEJEDNOSTKOWEJEDNOSTKOWEJEDNOSTKOWE
    @Test
    void getAllToken() {
        AppProperties appProperties = new AppProperties();
        appProperties.getAuth().setTokenSecret("123456789");
        Assertions.assertEquals("123456789", appProperties.getAuth().getTokenSecret());
    }


    @Test
    void badgetAllToken() {
        AppProperties appProperties = new AppProperties();
        appProperties.getAuth().setTokenSecret("123456789");
        Assertions.assertEquals("jjjj123456789", appProperties.getAuth().getTokenSecret());
    }

    @Test
    void get() {
        int auth = 1998;
        AppProperties appProperties = new AppProperties();
        appProperties.getAuth().setTokenExpirationMsec(auth);
        Assertions.assertEquals(1998, appProperties.getAuth().getTokenExpirationMsec());
        appProperties.getAuth();
        Assertions.assertEquals(1998, appProperties.getAuth().getTokenExpirationMsec());
    }

}
