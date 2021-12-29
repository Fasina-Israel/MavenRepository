package africa.group.semicolon.jijiMoji.data.repositories;


import africa.group.semicolon.jijiMoji.data.models.Conditions;
import africa.group.semicolon.jijiMoji.data.models.Listing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class ListingRepositoryTest {

    @Autowired
    private  ListingRepository listingRepository;

    @Test
    public void saveListingTest(){
        Listing listing = new Listing();
        listing.setConditions(Conditions.USED);
        listing.setName("G-String");
        listing.setShortDescription("London used G-String");
        listing.setLongDescription("Tokunbo used G-String");
        Listing savedListing = listingRepository.save(listing);
        assertEquals("G-String", savedListing.getName());
    }

}