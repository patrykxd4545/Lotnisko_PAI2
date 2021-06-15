package com.airline.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WebSecurityConfigTest {

    @Test
    void passwordEncoder() {
            WebSecurityConfig webSecurityConfig = new WebSecurityConfig();
            webSecurityConfig.userDetailsService();
            Assertions.assertEquals(null, webSecurityConfig.userDetailsService());
    }
}
