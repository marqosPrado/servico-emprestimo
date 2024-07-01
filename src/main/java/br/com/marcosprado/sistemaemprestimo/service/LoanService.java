package br.com.marcosprado.sistemaemprestimo.service;

import br.com.marcosprado.sistemaemprestimo.domain.Customer;
import br.com.marcosprado.sistemaemprestimo.domain.loan.Loan;
import br.com.marcosprado.sistemaemprestimo.domain.loan.Personal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    public List<Loan> checkEligibility(Customer customer) {
        List<Loan> loans = List.of(new Personal());
        return loans.stream()
                .map(loan -> loan.isEligible(customer) ? loan : null)
                .toList();
    }
}
