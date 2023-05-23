package com.linkedin.jobs;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Hello world!
 */
public class Job {

    private String jobNumber;
    private String jobTitle;
    private String jobPosterName;
    private String jobPosterAddress;
    private String jobPostedDate;
    private String jobExbperienceLevel;
    private String jobType;
    private String[] jobRequiredSkills;

    private double jobSalary;
    private String jobDescription;

    public Job(String jobNumber, String jobTitle, String jobPosterName, String jobPosterAddress, String jobPostedDate,
               String jobExbperienceLevel, String jobType, String[] jobRequiredSkills, double jobSalary, String jobDescription) {
        this.jobNumber = jobNumber;
        this.jobTitle = jobTitle;
        this.jobPosterName = jobPosterName;
        this.jobPosterAddress = jobPosterAddress;
        this.jobPostedDate = jobPostedDate;
        this.jobExbperienceLevel = jobExbperienceLevel;
        this.jobType = jobType;
        this.jobRequiredSkills = jobRequiredSkills;
        this.jobSalary = jobSalary;
        this.jobDescription = jobDescription;
    }

    public boolean addJob() {
        // Condition 1: Job ID validation
        if (jobNumber.matches("[1-5]{5}[A-Z]{3}_") && jobNumber.length() == 9) {
            // Condition 2: Posted date validation
            if (jobPostedDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                // Condition 3: Poster address validation
                if (jobPosterAddress.matches("[A-Za-z]+, [A-Za-z]+, [A-Za-z]+")) {
                    // Condition 4: Senior, Junior Executive job salary validation
                    if (((jobExbperienceLevel.equals("Senior") || jobExbperienceLevel.equals("Executive")) && jobSalary >= 100000)||
                            (jobExbperienceLevel.equals("Junior") && jobSalary >= 40000 && jobSalary <= 70000)) {
                        // Condition 6: Part-time job level validation
                        if (!(jobType.equals("Part-time") && (jobExbperienceLevel.equals("Senior") || jobExbperienceLevel.equals("Executive")))) {
                                // Condition 7: Required skills validation
                                if (jobRequiredSkills.length >= 1 && jobRequiredSkills.length <= 3) {
                                    for (String skill : jobRequiredSkills) {
                                        // Each skill should have a maximum of two words
                                        if (skill.split("\\s+").length > 2) {
                                            return false;
                                        }
                                    }
                                    // All conditions met, add job information to the text file
                                    try {
                                        FileWriter writer = new FileWriter("jobs.txt", true);
                                        writer.write("Job Number: " + jobNumber + "\n");
                                        writer.write("Job Title: " + jobTitle + "\n");
                                        writer.write("Job Poster Name: " + jobPosterName + "\n");
                                        writer.write("Job Poster Address: " + jobPosterAddress + "\n");
                                        writer.write("Job Posted Date: " + jobPostedDate + "\n");
                                        writer.write("Job Experience Level: " + jobExbperienceLevel + "\n");
                                        writer.write("Job Type: " + jobType + "\n");
                                        writer.write("Job Required Skills: ");
                                        for (String skill : jobRequiredSkills) {
                                            writer.write(skill + ", ");
                                        }
                                        writer.write("\n");
                                        writer.write("Job Salary: " + jobSalary + "\n");
                                        writer.write("Job Description: " + jobDescription + "\n");
                                        writer.write("\n");
                                        writer.close();
                                    } catch (IOException e) {
                                        System.out.println("Error writing to the file.");
                                        return false;
                                    }
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        return false;
    }

    public boolean updateJob(){

        return true;
    }
    public static void main(String[] args) {
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

    }

}
