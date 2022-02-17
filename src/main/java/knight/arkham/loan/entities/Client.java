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
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String lastName;
    private String direction;
    private String phoneNumber;
    private String age;
    private Date loanStartDate;
    private Date loanEndDate;
    private int loanQuantity;
    private float loanTerms;
    private float loanInterest;


    public Client(String name, String lastName, String direction, String phoneNumber, String age, Date loanStartDate, Date loanEndDate, int loanQuantity, float loanTerms, float loanInterest) {
        this.name = name;
        this.lastName = lastName;
        this.direction = direction;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.loanStartDate = loanStartDate;
        this.loanEndDate = loanEndDate;
        this.loanQuantity = loanQuantity;
        this.loanTerms = loanTerms;
        this.loanInterest = loanInterest;
    }
}
