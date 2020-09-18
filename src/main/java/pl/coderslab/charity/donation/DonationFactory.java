package pl.coderslab.charity.donation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class DonationFactory {

    private final InstitutionRepository institutionRepository;
    private final CategoryRepository categoryRepository;

    public Donation create (DonationRegistrationDto registrationDto){
        Institution institution = institutionRepository.findById(registrationDto.getInstitutionId())
                .orElseThrow(RuntimeException::new);

        Category category = categoryRepository.findById(registrationDto.getCategoriesId())
                .orElseThrow(RuntimeException::new);

        return  Donation.builder()
                .quantity(registrationDto.getQuantity())
                .categories(Collections.singletonList(category))
                .institution(institution)
                .street(registrationDto.getStreet())
                .city(registrationDto.getCity())
                .zipCode(registrationDto.getZipCode())
                .pickupDate(registrationDto.getPickupDate())
                .pickupTime(registrationDto.getPickupTime())
                .pickUpComment(registrationDto.getPickUpComment())
                .build();
    }
}
