import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.SimpleEcu;
import org.junit.Assert;

public class SimpleEcuTest {
    private SimpleEcu simpleEcuOne;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        simpleEcuOne = new SimpleEcu(3, 5);

    }

    @org.junit.jupiter.api.Test
    void get_ecuID_returns_correct_ID(){
        Assert.assertEquals(3, simpleEcuOne.getEcuId());
    }

    @org.junit.jupiter.api.Test
    void set_ecuID_changes_ecuID(){
        simpleEcuOne.setEcuId(7);
        Assert.assertEquals(7, simpleEcuOne.getEcuId());
    }

    @org.junit.jupiter.api.Test
    void get_swID_gets_swID(){
        Assert.assertEquals(5, simpleEcuOne.getSwId());
    }

    @org.junit.jupiter.api.Test
    void set_swID_changes_swID(){
        simpleEcuOne.setSwId(10);
        Assert.assertEquals(10, simpleEcuOne.getSwId());
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
}
