package br.com.marcosprado.sistemaemprestimo.domain.loan;

import br.com.marcosprado.sistemaemprestimo.domain.Customer;
import br.com.marcosprado.sistemaemprestimo.domain.LoanType;

public abstract class Loan {
    private final LoanType loanType;
    private final Double interestRate;

    public Loan(Double interestRate, LoanType loanType){
        this.interestRate = interestRate;
        this.loanType = loanType;
    }

    public abstract boolean isEligible(Customer customer);

    public Double getInterestRate() {
        return interestRate;
    }

    public LoanType getLoanType() {
        return loanType;
    }
}
