package pl.coderslab.charity.donation;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.institution.InstitutionRepository;

import java.util.Optional;

@Slf4j
@CrossOrigin
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class DonationController {


    private final DonationRepository donationRepo;
    private final DonationService donateService;
    private final ObjectMapper objectMapper;
    private final InstitutionRepository institutionRepository;



    @GetMapping("/donations")
    public ResponseEntity<?> getSumOfQuantity() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(donateService.donationInfos()));
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity getDonation(@PathVariable long id) throws JsonProcessingException {
//        donationRepo.findById(id);
        return ResponseEntity.ok(objectMapper.writeValueAsString(donationRepo.findById(id)));
    }



    @PostMapping("/donations")
    public ResponseEntity addDonation(@RequestBody DonationRegistrationDto donationRegistrationDto ){
//        Optional<DonationRegistrationDto> donationsFromDb = donateService.findByDonationId(donationRegistrationDto.getId());
//        if (donationsFromDb.isPresent()){
//            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
//        }
        donateService.saveDonation(donationRegistrationDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }



}
