package com.levinine.codenine.gateway.services.books;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "library-service")
public interface BookClient {

    @GetMapping(path = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    List<BookDto> getAll(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "limit", required = false) Integer limit
    );

    @GetMapping(path = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    BookDto getById(@PathVariable(name = "id") Long id);
}
