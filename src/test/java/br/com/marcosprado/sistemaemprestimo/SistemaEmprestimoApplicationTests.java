package br.com.marcosprado.sistemaemprestimo;

import br.com.marcosprado.sistemaemprestimo.domain.Customer;
import br.com.marcosprado.sistemaemprestimo.domain.LoanType;
import br.com.marcosprado.sistemaemprestimo.domain.loan.Loan;
import br.com.marcosprado.sistemaemprestimo.service.LoanService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class SistemaEmprestimoApplicationTests {

    public LoanService loanService = new LoanService();

    @Test
    void loanPersonalTestNeedReturnTrueWhenIncomeIsThreeThousand() {
        Customer customer = new Customer(
                31,
                "259.985.547-14",
                "Marcos",
                3000.00,
                "RJ"
        );
        List<Loan> loans = loanService.checkEligibility(customer);
        assertEquals(LoanType.PERSONAL, loans.getFirst().getLoanType());
    }

    @Test
    void loanPersonalTestNeedReturnTrueWhenCustomerIsUnderThirtyAndLocationIsSP() {
        Customer customer = new Customer(
                29,
                "259.985.547-14",
                "Marcos",
                3000.00,
                "SP"
        );
        List<Loan> loans = loanService.checkEligibility(customer);
        assertEquals(LoanType.PERSONAL, loans.getFirst().getLoanType());
    }

    @Test
    void loanPersonalTestNeedReturnTrueWhenIncomeIsLessThanThreeThousand() {
        Customer customer = new Customer(
                31,
                "259.985.547-14",
                "Marcos",
                2999.99,
                "RJ"
        );
        List<Loan> loans = loanService.checkEligibility(customer);
        assertEquals(LoanType.PERSONAL, loans.getFirst().getLoanType());
    }

    @Test
    void loanPersonalTestNeedReturnFalseWhenIncomeIsGreaterThanFiveThousand() {
        Customer customer = new Customer(
                34,
                "259.985.547-14",
                "Marcos",
                6000.01,
                "RJ"
        );
        List<Loan> loans = loanService.checkEligibility(customer);
        assertNull(loans.getFirst());
    }

    @Test
    void needReturnAConsignmentLoanWhenIncomeIsGreaterThanFiveThousand() {
        Customer customer = new Customer(
                34,
                "259.985.547-14",
                "Marcos",
                6000.01,
                "RJ"
        );
        List<Loan> loans = loanService.checkEligibility(customer);
        assertEquals(LoanType.CONSIGNMENT, loans.get(1).getLoanType());
    }
}
