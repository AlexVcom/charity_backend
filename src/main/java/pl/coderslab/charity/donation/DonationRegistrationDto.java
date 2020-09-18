package pl.coderslab.charity.donation;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonationRegistrationDto {

    private Integer quantity;
    private Long categoriesId;
    private Long institutionId;

    private String street;
    private String city;
    private String zipCode;
//  @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate pickupDate;
    private LocalTime pickupTime;
    private String pickUpComment;
}
