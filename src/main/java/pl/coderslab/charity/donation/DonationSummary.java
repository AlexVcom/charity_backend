package pl.coderslab.charity.donation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DonationSummary {

    private Integer donationSumQuantity;
    private Integer donationCounter;
}
