package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class DonationInfos {

    private Integer donationSumQuantity;
    private Integer donationCounter;
}
