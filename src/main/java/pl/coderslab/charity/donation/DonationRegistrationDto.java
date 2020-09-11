package pl.coderslab.charity.donation;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryRegistrationDto;
import pl.coderslab.charity.institution.Institution;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

//@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonationRegistrationDto {

    private Long id;
    private Integer quantity;
    private List<CategoryRegistrationDto> categories;
    private Long institutionId;

    private String street;
    private String city;
    private String zipCode;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate pickupDate;
    private LocalTime pickupTime;
    private String pickUpComment;
}
