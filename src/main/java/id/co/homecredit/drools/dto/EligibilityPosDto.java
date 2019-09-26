package id.co.homecredit.drools.dto;

import java.util.ArrayList;
import java.util.List;

public class EligibilityPosDto {

    private List<String> bankName = new ArrayList<>();
    private double totalLoanDaily;
    private double age;
    private double downPayment;
    private int tenor;
    private double maxAgeTenor;

    public List<String> getBankName() {
        return bankName;
    }

    public void setBankName(List<String> bankName) {
        this.bankName = bankName;
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
        this.maxAgeTenor = ((tenor/12) + age);
    }

    public void addListBankName(String name){
        bankName.add(name);
    }
}
