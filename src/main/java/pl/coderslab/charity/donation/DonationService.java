package pl.coderslab.charity.donation;


import ch.qos.logback.classic.util.CopyOnInheritThreadLocal;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryRegistrationDto;

import javax.transaction.Transactional;
import java.util.Optional;

@Data
@Service
@Transactional
@RequiredArgsConstructor
public class DonationService {

    private final DonationRepository donationRepo;
    private final ModelMapper modelMapper;

    public DonationInfos donationInfos(){
        return DonationInfos.builder()
                .donationCounter(donationRepo.donationCount())
                .donationSumQuantity(donationRepo.quantityCount())
                .build();
    }


    public Optional<DonationRegistrationDto> findByDonationId(Long id){
        Optional<DonationRegistrationDto> donationId = donationRepo.findById(id)
                .stream()
                .map(d->modelMapper.map(d,DonationRegistrationDto.class))
                .findFirst();
        return donationId;
    }

    public Donation saveDonation(DonationRegistrationDto donationRegistrationDto){
        Donation donation = modelMapper.map(donationRegistrationDto,Donation.class);
        for (CategoryRegistrationDto c : donationRegistrationDto.getCategories()){
            modelMapper.map(c, Category.class);
        }

        donationRepo.save(donation);
        return donation;
    }





}
