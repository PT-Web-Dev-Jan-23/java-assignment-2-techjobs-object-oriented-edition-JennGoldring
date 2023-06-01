package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        String expectedName = "Product tester";
        Employer expectedEmployer = new Employer("ACME");
        Location expectedLocation = new Location("Desert");
        PositionType expectedPositionType = new PositionType("Quality control");
        CoreCompetency expectedCoreCompetency = new CoreCompetency("Persistence");

        Job job = new Job(expectedName, expectedEmployer, expectedLocation, expectedPositionType, expectedCoreCompetency);

        assertTrue(job.getId() > 0); // Check if ID is assigned
        assertEquals(expectedName, job.getName()); // Check if name is assigned correctly
        assertTrue(job.getEmployer() instanceof Employer); // Check if employer is assigned correctly
        assertTrue(job.getLocation() instanceof Location); // Check if location is assigned correctly
        assertTrue(job.getPositionType() instanceof PositionType); // Check if positionType is assigned correctly
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency); // Check if coreCompetency is assigned correctly

        assertEquals(expectedEmployer, job.getEmployer()); // Check if employer value is assigned correctly
        assertEquals(expectedLocation, job.getLocation()); // Check if location value is assigned correctly
        assertEquals(expectedPositionType, job.getPositionType()); // Check if positionType value is assigned correctly
        assertEquals(expectedCoreCompetency, job.getCoreCompetency()); // Check if coreCompetency value is assigned correctly
    }

    @Test
    public void testJobsForEquality() {
        String name = "Product tester";
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType positionType = new PositionType("Quality control");
        CoreCompetency coreCompetency = new CoreCompetency("Persistence");

        Job job1 = new Job(name, employer, location, positionType, coreCompetency);
        Job job2 = new Job(name, employer, location, positionType, coreCompetency);

        assertFalse(job1.equals(job2));
        assertFalse(job2.equals(job1));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job();
        String jobString = job.toString();
        char firstChar = jobString.charAt(0);
        char lastChar = jobString.charAt(jobString.length() - 1);

        assertEquals('\n', firstChar);
        assertEquals('\n', lastChar);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = "\n" +
                "ID: " + job.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality Control\n" +
                "Core Competency: Persistence\n" +
                "\n";
        assertEquals(expected, job.toString());
    }
}
