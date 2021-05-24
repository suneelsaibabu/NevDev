package com.navdeventerprise.nevdev.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.navdeventerprise.nevdev.data.entity.AccountEntity;
import com.navdeventerprise.nevdev.data.repository.AccountRepository;
import com.navdeventerprise.nevdev.exception.DataNotFoundException;
import com.navdeventerprise.nevdev.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccountService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final String ACCOUNT_JSON = "classpath:static/Accounts.json";

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository repo) {
        this.accountRepository = repo;

    }

    public List<Account> get(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Please specify account's title!");
        }
        List<AccountEntity> entity = accountRepository.findByAccountTitle(title);
        if (entity == null || entity.isEmpty()) {
            throw new DataNotFoundException("data not present");
        }
        return entity.stream().map(AccountEntity::getAccount).collect(Collectors.toList());
    }

    @Transactional
    public Account create() throws IOException {
        Account request = getAccountFromFile();
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccount(request);
        accountEntity = accountRepository.save(accountEntity);
        return accountEntity.getAccount();
    }

    private Account getAccountFromFile() throws IOException {

        return MAPPER.readValue(ResourceUtils.getFile(ACCOUNT_JSON), Account.class);

    }

}
