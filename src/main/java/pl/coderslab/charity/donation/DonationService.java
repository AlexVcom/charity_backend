package pl.coderslab.charity.donation;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

//@Data
@Service
@RequiredArgsConstructor
public class DonationService {

    private final DonationRepository donationRepo;
    private final ModelMapper modelMapper;
    private final DonationFactory donationFactory;

    public DonationSummary donationInfos(){
        return DonationSummary.builder()
                .donationCounter(donationRepo.donationCount())
                .donationSumQuantity(donationRepo.quantityCount())
                .build();
    }


    public Optional<DonationRegistrationDto> findByDonationId(Long id){
        return donationRepo.findById(id)
                .stream()
                .map(d->modelMapper.map(d,DonationRegistrationDto.class))
                .findFirst();
    }

    @Transactional
    public Donation saveDonation(DonationRegistrationDto donationRegistrationDto){
        Donation donation = donationFactory.create(donationRegistrationDto);
        return donationRepo.save(donation);
    }





}
