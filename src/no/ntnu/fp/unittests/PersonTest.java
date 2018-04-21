import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Project;
import org.junit.Assert;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person linda;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        linda = new Person(8, "Linda Tan", "lindatan@gmail.com", "Downing Street",
                "London", "45qr78");

    }

    @org.junit.jupiter.api.Test
    void set_email_changes_email(){
        linda.setEmail("lindaNewMail@gmail.com");
        Assert.assertEquals("lindaNewMail@gmail.com", linda.getEmail() );
    }

    @org.junit.jupiter.api.Test
    void set_street_changes_street(){
        linda.setStreet("Time Street");
        Assert.assertEquals("Time Street", linda.getStreet());
    }

    @org.junit.jupiter.api.Test
    void set_city_changes_city(){
        linda.setCity("Trondheim");
        Assert.assertEquals("Trondheim", linda.getCity());
    }



    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
}
