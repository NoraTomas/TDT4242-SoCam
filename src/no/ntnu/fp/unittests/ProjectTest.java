package no.ntnu.fp.unittests;

import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Project;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    private Project project;
    private Person personOne;
    private Person personTwo;
    private Person personThree;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        project = new Project();
        personOne = new Person(1);
        personTwo = new Person(5);
        personThree = new Person(-3);

        project.addPerson(personOne);
        project.addPerson(personTwo);
        project.addPerson(personThree);

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getLargestCustId_returns_largest_id() {
        Assert.assertEquals(project.getLargestCustId(), 5);
    }
}