package com.example.splitting.monolith.clients;

import com.example.splitting.monolith.dtos.ErrorDto;
import com.example.splitting.monolith.exceptions.NotFoundException;
import com.example.splitting.monolith.exceptions.ResourceAlreadyTakenException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;

public class FeignErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        ErrorDto err;
        try (var is = response.body().asInputStream()) {
            ObjectMapper om = new ObjectMapper();
            err = om.readValue(is, ErrorDto.class);
        } catch (IOException ex) {
            return new Exception(ex.getMessage());
        }
        return switch (response.status()) {
            case 404 -> new NotFoundException(err.message());
            case 409 -> new ResourceAlreadyTakenException(err.message());
            default -> errorDecoder.decode(methodKey, response);
        };
    }
}
