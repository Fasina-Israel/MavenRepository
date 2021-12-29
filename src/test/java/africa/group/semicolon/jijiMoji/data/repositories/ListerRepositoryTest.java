package africa.group.semicolon.jijiMoji.data.repositories;

import africa.group.semicolon.jijiMoji.data.models.Lister;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class ListerRepositoryTest {

    @Autowired
    private ListerRepository listerRepository;

    @Test
    public void repositorySaveTest(){
        Lister lister = new Lister();
        lister.setFullName("kim Bauer");
        lister.setEmail("kim@Bauer.com");
        lister.setLocation("Sabo");
        lister.setLocation("0987654");
        Lister savedLister = listerRepository.save(lister);
        assertEquals("kim Bauer", savedLister.getFullName());
        assertNotNull(savedLister.getId());
    }
}