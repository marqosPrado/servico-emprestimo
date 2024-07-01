package br.com.marcosprado.sistemaemprestimo.dtos;

public record CustomerLoanRequest(Integer age,
                                  String cpf,
                                  String name,
                                  Double income,
                                  String location
) {
}
