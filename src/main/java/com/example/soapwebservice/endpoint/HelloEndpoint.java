package com.example.soapwebservice.endpoint;

import com.example.soapwebservice.repository.CountryRepository;
import countries_soap.GetCountryRequest;
import countries_soap.GetCountryResponse;
import hello_soap.GetHelloRequest;
import hello_soap.GetHelloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;



@Endpoint
public class HelloEndpoint {
    private static final String NAMESPACE_URI = "hello-soap";

    private CountryRepository countryRepository;

    @Autowired
    public HelloEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHelloRequest")
    @ResponsePayload
    public GetHelloResponse getCountry(@RequestPayload GetHelloRequest request) {
        GetHelloResponse response = new GetHelloResponse();
        response.setResponse("Hello " + request.getName());

        return response;
    }
}
