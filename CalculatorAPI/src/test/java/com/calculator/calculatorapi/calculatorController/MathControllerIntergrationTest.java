package com.calculator.calculatorapi.calculatorController;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = MathControllerTestConfig.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class MathControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void doMath_success() throws JSONException {
//        final String url = "/api/math";
//        final String body = "{\"operand1\":1,\"operand2\":2,\"operation\":\"+\"}";
//        final String expectedResult = "{\"result\":3.0}";
//        final String result = restTemplate.postForObject(url, body, String.class);
//        JSONAssert.assertEquals(expectedResult, result, false);
    }
}