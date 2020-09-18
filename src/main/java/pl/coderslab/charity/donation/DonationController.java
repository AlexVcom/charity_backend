package pl.coderslab.charity.donation;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class DonationController {

    private final DonationRepository donationRepo;
    private final DonationService donateService;

    @CrossOrigin
    @GetMapping("/donations")
    public ResponseEntity<DonationSummary> getSumOfQuantity() {
        DonationSummary donation = donateService.donationInfos();
        return ResponseEntity.ok(donation);
    }

    @GetMapping("/donation/{id}")
    public ResponseEntity <?> getDonation(@PathVariable Long id) {
        Optional<Donation> donation = donationRepo.findById(id);
        return ResponseEntity.ok(donation);
    }

    @PostMapping("/donations")
    public ResponseEntity <Donation>  addDonation(@RequestBody DonationRegistrationDto donationRegistrationDto ){
        return ResponseEntity.ok(donateService.saveDonation(donationRegistrationDto));
    }



}
