package br.com.marcosprado.sistemaemprestimo.domain.loan;

import br.com.marcosprado.sistemaemprestimo.domain.Customer;
import br.com.marcosprado.sistemaemprestimo.domain.LoanType;

public class Personal extends Loan {

    public Personal() {
        super(0.04, LoanType.PERSONAL);
    }

    @Override
    public boolean isEligible(Customer customer) {
        if (customer.getIncome() <= 3000.00) {
            return true;
        } else if (customer.getIncome() > 3000.00 && customer.getIncome() <= 5000.00) {
            return customer.getAge() < 30 && customer.getLocation().equals("SP");
        }
        return false;
    }
}
