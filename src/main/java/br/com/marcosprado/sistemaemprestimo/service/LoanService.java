package br.com.marcosprado.sistemaemprestimo.service;

import br.com.marcosprado.sistemaemprestimo.domain.Customer;
import br.com.marcosprado.sistemaemprestimo.domain.loan.Consignment;
import br.com.marcosprado.sistemaemprestimo.domain.loan.Guaranteed;
import br.com.marcosprado.sistemaemprestimo.domain.loan.Loan;
import br.com.marcosprado.sistemaemprestimo.domain.loan.Personal;
import br.com.marcosprado.sistemaemprestimo.dtos.CustomerLoanRequest;
import br.com.marcosprado.sistemaemprestimo.dtos.CustomerLoanResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    public CustomerLoanResponse checkEligibility(CustomerLoanRequest request) {
        List<Loan> loans = List.of(new Personal(), new Consignment(), new Guaranteed());
        Customer customer = new Customer(
                request.age(), request.cpf(), request.name(), request.income(), request.location());
        List<Loan> eligibleLoans = loans.stream()
                .filter(loan -> loan.isEligible(customer))
                .toList();

        CustomerLoanResponse response = new CustomerLoanResponse(request.name(), eligibleLoans);
        return response;
    }
}
