package knight.arkham.loan.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String direction;
    private String phoneNumber;
    private String age;


    public Client(String name, String lastName, String direction, String phoneNumber, String age) {
        this.name = name;
        this.lastName = lastName;
        this.direction = direction;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }
}
