package knight.arkham.loan.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Loan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date loanStartDate;
    private Date loanEndDate;
    private int loanQuantity;
    private float loanTerms;
    private float loanInterest;


    public Loan(Date loanStartDate, Date loanEndDate, int loanQuantity, float loanTerms, float loanInterest) {
        this.loanStartDate = loanStartDate;
        this.loanEndDate = loanEndDate;
        this.loanQuantity = loanQuantity;
        this.loanTerms = loanTerms;
        this.loanInterest = loanInterest;
    }
}
