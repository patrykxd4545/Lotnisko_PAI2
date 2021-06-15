package com.airline.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ResourceNotFoundExceptionTest {


    @Test
    void sResourceNotFoundException() {
        ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException("Exception","Exception",1);
        resourceNotFoundException.getMessage();
        resourceNotFoundException.getLocalizedMessage();
        resourceNotFoundException.getCause();
        Assertions.assertEquals(null, resourceNotFoundException.getCause());
    }

}
