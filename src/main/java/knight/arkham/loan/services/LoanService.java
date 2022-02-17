package knight.arkham.loan.services;

import knight.arkham.loan.entities.Loan;
import knight.arkham.loan.repositories.LoanRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }


    public List<Loan> getAllLoans() {

        return loanRepository.findAll();
    }


    public Loan getLoanById(long loanId) {

        return loanRepository.findLoanById(loanId);
    }


    public List<Loan> saveLoan(Loan loan) {

        loanRepository.save(loan);

        return loanRepository.findAll();
    }


    public void saveAllLoans(List<Loan> loans) {

        loanRepository.saveAll(loans);
    }


    public List<Loan> updateLoan(Loan updatedLoan) {

        var actualLoan = loanRepository.findLoanById(updatedLoan.getId());

        actualLoan.setLoanInterest(updatedLoan.getLoanInterest());
        actualLoan.setLoanQuantity(updatedLoan.getLoanQuantity());
        actualLoan.setLoanTerms(updatedLoan.getLoanTerms());
        actualLoan.setLoanStartDate(updatedLoan.getLoanStartDate());
        actualLoan.setLoanEndDate(updatedLoan.getLoanEndDate());

        loanRepository.save(actualLoan);

        return loanRepository.findAll();
    }


    public void deleteLoanById(long loanId){

        try {

            loanRepository.deleteById(loanId);
        }catch (Exception exception){

            System.out.println(exception.getMessage());
        }
    }
}
