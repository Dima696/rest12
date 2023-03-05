package ru.netology.springbootdemoap2.controllerAut;

import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import ru.netology.springbootdemoap2.exception.InvalidCredentials;
import ru.netology.springbootdemoap2.exception.UnauthorizedUser;

import java.util.Arrays;


@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> getAuthoritiesHandler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> userAuthoritiesHandler(UnauthorizedUser e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
//  @ExceptionHandler(ConstraintViolationException.class )
//  protected ResponseEntity<String> ConstraintViolationException(ConstraintViolationException ex ) {
//      return new ResponseEntity <>( ex . getMessage (),  HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler
//    protected ResponseEntity < String >  allHandler ( RuntimeException ex) {
//        Logger log = LoggerFactory.getLogger(UnauthorizedUser.class );
//        Arrays.stream(ex . getStackTrace ()). forEach ( l  ->  log . error ( String . valueOf ( l )));
//        return new ResponseEntity <>( ex . getMessage (),  HttpStatus .INTERNAL_SERVER_ERROR);
//
//    }

}


