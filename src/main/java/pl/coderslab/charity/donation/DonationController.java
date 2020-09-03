package pl.coderslab.charity.donation;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class DonationController {


    private final DonationRepo donationRepo;
    private final DonationService donateService;
    private final ObjectMapper objectMapper;


    @GetMapping("/donation/quantity")
    public ResponseEntity<?> getSumOfQuantity() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(donationRepo.quantityCount()));
//        return ResponseEntity.ok(donateService.countDetails());
    }

    @GetMapping("/donations/count")
    public ResponseEntity<?> getSumOfDonations() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(donationRepo.donationCount()));
    }


}
