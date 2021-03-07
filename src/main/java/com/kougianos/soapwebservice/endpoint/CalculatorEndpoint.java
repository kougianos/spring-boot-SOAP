package com.kougianos.soapwebservice.endpoint;

import calculator_soap.Add;
import calculator_soap.AddResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class CalculatorEndpoint {
    private static final String NAMESPACE_URI = "calculator-soap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Add")
    @ResponsePayload
    public AddResponse getCountry(@RequestPayload Add request) {
        AddResponse response = new AddResponse();
        response.setAddResult(request.getIntA() + request.getIntB());

        return response;
    }
}
