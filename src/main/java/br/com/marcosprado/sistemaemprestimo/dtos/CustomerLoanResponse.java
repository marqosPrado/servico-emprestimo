package br.com.marcosprado.sistemaemprestimo.dtos;

import br.com.marcosprado.sistemaemprestimo.domain.Loan;

import java.util.List;

public record CustomerLoanResponse(String name, List<Loan> loans) {
}
