package com.calculette;


import com.calculette.controllers.CalculateRessource;
import com.calculette.models.Numbers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculateRessource.class)
public class CalculateRessourceTests {

    @Autowired
    private MockMvc mockMvc;


    //this method test the add operation of 1 + 1
    @Test
    public void addOperationTest() throws Exception{

        String jsonBody = "{\"number1\": 1, \"number2\": 1}";


        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/calculator/add").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        BigDecimal expectedResult = BigDecimal.valueOf(2);

        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());

        Assert.assertEquals(expectedResult.toString(), response.getContentAsString());
    }



    @Test
    public void substructOperationTest() throws Exception{

        String jsonBody = "{\"number1\": 1, \"number2\": 1}";


        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/calculator/subtract").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        BigDecimal expectedResult = BigDecimal.ZERO;

        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());

        Assert.assertEquals(expectedResult.toString(), response.getContentAsString());
    }

    @Test
    public void multiplyOperationTest() throws Exception{

        String jsonBody = "{\"number1\": 1, \"number2\": 1}";


        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/calculator/multiply").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        BigDecimal expectedResult = BigDecimal.ONE;

        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());

        Assert.assertEquals(expectedResult.toString(), response.getContentAsString());
    }

    @Test
    public void divideOperationTest() throws Exception{

        String jsonBody = "{\"number1\": 1, \"number2\": 1}";


        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/calculator/divide").accept(
                MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        BigDecimal expectedResult = BigDecimal.ONE;

        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());

        Assert.assertEquals(expectedResult.toString(), response.getContentAsString());
    }


}
