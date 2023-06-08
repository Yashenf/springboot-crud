package com.yashe.pos.HelloPos.advice;

import com.yashe.pos.HelloPos.execption.EntryNotFoundException;
import com.yashe.pos.HelloPos.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponse> handleClassNotFoundException(EntryNotFoundException exception){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        404,exception.getMessage()+"was occurred!",exception
                ), HttpStatus.NOT_FOUND
        );
    }
}
