package br.com.marcosprado.sistemaemprestimo.domain.loan;

import br.com.marcosprado.sistemaemprestimo.domain.Customer;
import br.com.marcosprado.sistemaemprestimo.domain.LoanType;

public class Consignment extends Loan {

    public Consignment() {
        super(0.02, LoanType.CONSIGNMENT);
    }
    @Override
    public boolean isEligible(Customer customer) {
        return customer.getIncome() >= 5000.00;
    }
}
