package knight.arkham.loan.repositories;

import knight.arkham.loan.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Loan findLoanById(Long id);
}
