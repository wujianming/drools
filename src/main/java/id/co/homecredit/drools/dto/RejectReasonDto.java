package id.co.homecredit.drools.dto;

import java.util.ArrayList;
import java.util.List;

public class RejectReasonDto {

    private String idAgreementReject;
    private List<String> listReason = new ArrayList<>();

    public String getIdAgreementReject() {
        return idAgreementReject;
    }

    public void setIdAgreementReject(String idAgreementReject) {
        this.idAgreementReject = idAgreementReject;
    }

    public List<String> getListReason() {
        return listReason;
    }

    public void setListReason(List<String> listReason) {
        this.listReason = listReason;
    }

    @Override
    public String toString() {
        return "RejectReasonDto{" +
                "idAgreementReject='" + idAgreementReject + '\'' +
                ", listReason=" + listReason +
                '}';
    }
}
