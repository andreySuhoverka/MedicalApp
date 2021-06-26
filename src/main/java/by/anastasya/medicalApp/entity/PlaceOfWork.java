package by.anastasya.medicalApp.entity;


public class PlaceOfWork {
    private int jobId;
    private String jobName;
    private String address;
    private boolean isMedicalCenter;
    private boolean isPoliclinic;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isMedicalCenter() {
        return isMedicalCenter;
    }

    public void setMedicalCenter(boolean medicalCenter) {
        isMedicalCenter = medicalCenter;
    }

    public boolean isPoliclinic() {
        return isPoliclinic;
    }

    public void setPoliclinic(boolean policlinic) {
        isPoliclinic = policlinic;
    }
}
