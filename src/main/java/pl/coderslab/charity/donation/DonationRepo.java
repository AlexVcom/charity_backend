package pl.coderslab.charity.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepo extends JpaRepository<Donation,Long> {

    @Query("select sum(d.quantity) from Donation d")
    Integer quantityCount();

    @Query("select count (d) from Donation d")
    Integer donationCount();

}
