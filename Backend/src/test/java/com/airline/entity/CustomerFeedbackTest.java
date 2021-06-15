package com.airline.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerFeedbackTest {


    @Test
    void firstFeedback() {
        CustomerFeedback customerFeedback = new CustomerFeedback();
        customerFeedback.setEmailFeedback("albert54@");
        customerFeedback.setFirstName("Johny");
        customerFeedback.setLastName("Travel");
        customerFeedback.setMessage("Bardzo dobrze");
        customerFeedback.setResponseMessage("+1");
        Assertions.assertEquals("albert54@", customerFeedback.getEmailFeedback());
        Assertions.assertEquals("Johny", customerFeedback.getFirstName());
        Assertions.assertEquals("Travel", customerFeedback.getLastName());
        Assertions.assertEquals("Bardzo dobrze", customerFeedback.getMessage());
        Assertions.assertEquals("+1", customerFeedback.getResponseMessage());
    }

    @Test
    void badfirstFeedback() {
        CustomerFeedback customerFeedback = new CustomerFeedback();
        customerFeedback.setEmailFeedback("albert54@");
        customerFeedback.setFirstName("Johny");
        customerFeedback.setLastName("Travel");
        customerFeedback.setMessage("Bardzo dobrze");
        customerFeedback.setResponseMessage("+1");
        Assertions.assertEquals("albert54@", customerFeedback.getEmailFeedback());
        Assertions.assertEquals("Alex", customerFeedback.getFirstName());
        Assertions.assertEquals("Travel", customerFeedback.getLastName());
        Assertions.assertEquals("Bardzo dobrze", customerFeedback.getMessage());
        Assertions.assertEquals("+1", customerFeedback.getResponseMessage());
    }
}
