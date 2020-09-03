package pl.coderslab.charity.donation;

import lombok.Data;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Integer quantity;

    @ManyToMany
    @JoinColumn
    private List<Category> categories;

    @ManyToOne
    private Institution institution;

    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickupDate;
    private LocalTime pickupTime;
    private String pickUpComment;



    /**
     *   ------- liqubase -> dodać + pom +
     * - id
     * - quantity (liczba worków) (Integer)
     * - categories (lista obiektów typu `Category`), pamiętaj o odpowiedniej adnotacji
     * - institution (obiekt typu `Institution`), pamiętaj o odpowiedniej adnotacji.
     * - street (String)
     * - city (String)
     * - zipCode (String)
     * - pickUpDate (LocalDate)
     * - pickUpTime (LocalTime)
     * - pickUpComment (String)
     *
     * */
}