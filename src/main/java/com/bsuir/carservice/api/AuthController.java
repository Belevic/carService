package com.bsuir.carservice.api;

import com.bsuir.carservice.dto.AccountDto;
import com.bsuir.carservice.dto.LoginDto;
import com.bsuir.carservice.model.Account;
import com.bsuir.carservice.repository.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AccountRepository accountRepository;

    public AuthController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        Account account = accountRepository.getAccountByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        AccountDto accountDto = new AccountDto(account.getId(), account.getRole().name());
        return ResponseEntity.ok(accountDto);
    }
}

