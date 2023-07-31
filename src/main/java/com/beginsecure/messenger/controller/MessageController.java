package com.beginsecure.messenger.controller;

import com.beginsecure.messenger.domain.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Message API", description = "Endpoints for sending messages")
public class MessageController {

    @ApiOperation(value = "Get a hello message", notes = "Returns a hello message with the provided name.")
    @GetMapping("/hello")
    public Message startMessage(@ApiParam(value = "Name to be used in the hello message", defaultValue = "World")
                                @RequestParam(value = "name", defaultValue = "World") String name) {
        return new Message(String.format("Hello %s!", name));
    }

    @ApiOperation(value = "Get a goodbye message", notes = "Returns a goodbye message with the provided name.")
    @GetMapping("/goodbye")
    public Message endMessage(@ApiParam(value = "Name to be used in the goodbye message", defaultValue = "World")
                              @RequestParam(value = "name", defaultValue = "World") String name) {
        return new Message(String.format("See you next time %s!", name));
    }

    // Exception handler for handling Not Found (404) errors
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNotFoundException() {
        return new ResponseEntity<>("Error: Resource not found", HttpStatus.NOT_FOUND);
    }
}
