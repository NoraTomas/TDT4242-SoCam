import no.ntnu.fp.model.SimpleEcu;
import no.ntnu.fp.model.Software;
import org.junit.Assert;

public class SoftwareTest {

    private Software softwareOne;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        softwareOne = new Software(3, 5, "url");
    }

    @org.junit.jupiter.api.Test
    void getSwVersion_returns_software_version(){
        Assert.assertEquals(3, softwareOne.getSwVersion());
    }

    @org.junit.jupiter.api.Test
    void setSwVersion_sets_software_version(){
        softwareOne.setSwVersion(9);
        Assert.assertEquals(9, softwareOne.getSwVersion());
    }

    @org.junit.jupiter.api.Test
    void getMinorVersion_returns_minor_version(){
        Assert.assertEquals(5, softwareOne.getMinorVersion());
    }

    @org.junit.jupiter.api.Test
    void setMinorVersion_sets_minor_version(){
        softwareOne.setMinorVersion(10);
        Assert.assertEquals(10, softwareOne.getMinorVersion());
    }

    @org.junit.jupiter.api.Test
    void getURL_returns_URl(){
        Assert.assertEquals("url", softwareOne.getUrl());
    }

    @org.junit.jupiter.api.Test
    void setURL_changes_URl(){
        softwareOne.setUrl("NewUrl");
        Assert.assertEquals("NewUrl", softwareOne.getUrl());
    }





    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
}
