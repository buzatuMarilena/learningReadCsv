import java.time.LocalTime;

public class SkiAthletModel {

    private Long athleteNumber;
    private String athleteName;
    private String countryCode;
    private String skiTimeResult;
    private String firstShootingRange;
    private String secondShootingRange;
    private String thirdShootingRange;
    private LocalTime finalResult;
    private int penalities;

    public SkiAthletModel( Long athleteNumber, String athleteName ,String countryCode, String skiTimeResult,
                           String firstShootingRange, String secondShootingRange, String thirdShootingRange){

        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
    }

    public Long getAthleteNumber() {
        return athleteNumber;
    }

    public void setAthleteNumber(Long athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public void setSkiTimeResult(String skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public String getFirstShootingRange() {
        return firstShootingRange;
    }

    public void setFirstShootingRange(String firstShootingRange) {
        this.firstShootingRange = firstShootingRange;
    }

    public String getSecondShootingRange() {
        return secondShootingRange;
    }

    public void setSecondShootingRange(String secondShootingRange) {
        this.secondShootingRange = secondShootingRange;
    }

    public String getThirShootingRange() {
        return thirdShootingRange;
    }

    public void setThirShootingRange(String thirShootingRange) {
        this.thirdShootingRange = thirShootingRange;
    }

    public String getThirdShootingRange() {
        return thirdShootingRange;
    }

    public void setThirdShootingRange(String thirdShootingRange) {
        this.thirdShootingRange = thirdShootingRange;
    }

    public LocalTime getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(LocalTime finalResult) {
        this.finalResult = finalResult;
    }

    public int getPenalities() {
        return penalities;
    }

    public void setPenalities(int penalities) {
        this.penalities = penalities;
    }
}
