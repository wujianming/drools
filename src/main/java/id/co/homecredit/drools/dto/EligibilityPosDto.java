package id.co.homecredit.drools.dto;

import java.util.*;

public class EligibilityPosDto {


    private String requestId;
    private List<String> idAgreement = new ArrayList<>();
    private List<String> idAgreementReject = new ArrayList<>();
    private List<String> rejectReason = new ArrayList<>();
    private double totalLoanDaily;
    private double age;
    private double downPayment;
    private int tenor;
    private double maxAgeTenor;
    private Date createdDate;


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public List<String> getIdAgreement() {
        return idAgreement;
    }

    public void setIdAgreement(List<String> idAgreement) {
        this.idAgreement = idAgreement;
    }

    public List<String> getIdAgreementReject() {
        return idAgreementReject;
    }

    public void setIdAgreementReject(List<String> idAgreementReject) {
        this.idAgreementReject = idAgreementReject;
    }

    public double getTotalLoanDaily() {
        return totalLoanDaily;
    }

    public void setTotalLoanDaily(double totalLoanDaily) {
        this.totalLoanDaily = totalLoanDaily;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public int getTenor() {
        return tenor;
    }

    public void setTenor(int tenor) {
        this.tenor = tenor;
    }

    public double getMaxAgeTenor() {
        return maxAgeTenor;
    }

    public void setMaxAgeTenor() {
        this.maxAgeTenor = ((tenor / 12) + age);
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void addIdAgreement(String name) {
        idAgreement.add(name);
    }

    public void addIdAgreementReject(String name) {
        idAgreementReject.add(name);
    }

    public List<String> getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String name) {
        rejectReason.add(name);
    }

    @Override
    public String toString() {
        return "EligibilityPosDto{" +
                "requestId='" + requestId + '\'' +
                ", idAgreement=" + idAgreement +
                ", idAgreementReject=" + idAgreementReject +
                ", rejectReason=" + rejectReason +
                ", totalLoanDaily=" + totalLoanDaily +
                ", age=" + age +
                ", downPayment=" + downPayment +
                ", tenor=" + tenor +
                ", maxAgeTenor=" + maxAgeTenor +
                ", createdDate=" + createdDate +
                '}';
    }
}
