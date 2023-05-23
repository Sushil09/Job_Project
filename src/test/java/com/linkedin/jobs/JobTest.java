package com.linkedin.jobs;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class JobTest
{
    @Test
    public void testAddJob_ValidJobInformation_ReturnsTrue() {
        // Create valid job information
        String jobNumber = "12345ABC_";
        String jobTitle = "Software Engineer";
        String jobPosterName = "John Doe";
        String jobPosterAddress = "Melbourne, Victoria, Australia";
        String jobPostedDate = "2023-05-01";
        String jobExperienceLevel = "Senior";
        String jobType = "Full-time";
        String[] jobRequiredSkills = {"Java", "Spring", "SQL"};
        double jobSalary = 120000;
        String jobDescription = "Description of the job.";

        // Create a job object
        Job job = new Job(jobNumber, jobTitle, jobPosterName, jobPosterAddress, jobPostedDate, jobExperienceLevel,
                jobType, jobRequiredSkills, jobSalary, jobDescription);

        // Add the job
        boolean result = job.addJob();

        // Assert that the job was added successfully
        Assertions.assertTrue(result);
    }

    @Test
    public void testAddJob_InvalidJobInformation_ReturnsFalse() {
        // Create invalid job information
        String jobNumber = "12345ABC";
        String jobTitle = "Software Engineer";
        String jobPosterName = "John Doe";
        String jobPosterAddress = "Melbourne, Victoria, Australia";
        String jobPostedDate = "2023/05/01";
        String jobExperienceLevel = "Executive";
        String jobType = "Part-time";
        String[] jobRequiredSkills = {"Writing Unit Tests", "Java"};
        double jobSalary = 80000;
        String jobDescription = "Description of the job.";

        // Create a job object
        Job job = new Job(jobNumber, jobTitle, jobPosterName, jobPosterAddress, jobPostedDate, jobExperienceLevel,
                jobType, jobRequiredSkills, jobSalary, jobDescription);

        // Add the job
        boolean result = job.addJob();

        // Assert that the job was not added
        Assertions.assertFalse(result);
    }
}
