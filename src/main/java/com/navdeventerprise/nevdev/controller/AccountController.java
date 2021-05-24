package com.navdeventerprise.nevdev.controller;

import com.navdeventerprise.nevdev.model.Account;
import com.navdeventerprise.nevdev.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @PostMapping("/account")
    public ResponseEntity<Account> create() throws IOException {
        return new ResponseEntity(accountService.create(),HttpStatus.CREATED);
    }

    @GetMapping("/account")
    public ResponseEntity<List<Account>> get(@RequestParam String title) {
        return ResponseEntity.ok(accountService.get(title));
    }

}
