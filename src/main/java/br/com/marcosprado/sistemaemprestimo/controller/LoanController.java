package br.com.marcosprado.sistemaemprestimo.controller;

import br.com.marcosprado.sistemaemprestimo.dtos.CustomerLoanRequest;
import br.com.marcosprado.sistemaemprestimo.dtos.CustomerLoanResponse;
import br.com.marcosprado.sistemaemprestimo.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/customer-loans")
    public ResponseEntity<CustomerLoanResponse> getCustomerLoans(@RequestBody CustomerLoanRequest request) {
        return ResponseEntity.ok(loanService.checkEligibility(request));
    }
}
