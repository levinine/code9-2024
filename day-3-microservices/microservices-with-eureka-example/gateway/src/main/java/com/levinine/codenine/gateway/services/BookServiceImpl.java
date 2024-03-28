package com.levinine.codenine.gateway.services;

import com.levinine.codenine.gateway.services.books.BookClient;
import com.levinine.codenine.gateway.services.books.BookDto;
import feign.FeignException;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Log4j2
public class BookServiceImpl implements BookService {

    private final BookClient bookClient;

    @Autowired
    public BookServiceImpl(BookClient bookClient) {
        this.bookClient = bookClient;
    }

    @Override
    public List<BookDto> getAll(Integer page, Integer pageSize) {
        return bookClient.getAll(page, pageSize);
    }

    @Override
    public Optional<BookDto> getOneById(Long id) {
        try {
            return Optional.of(bookClient.getById(id));
        } catch (FeignException.NotFound ex) {
            return Optional.empty();
        } catch (Exception ex) {
            log.log(Level.ERROR,  ex.getMessage());
            throw ex;
        }
    }
}
