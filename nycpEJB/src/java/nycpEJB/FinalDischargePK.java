package nycpEJB;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DetaX
 */
@Embeddable
public class FinalDischargePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DECISION_TYPE_NUMBER")
    private String decisionTypeNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PRISON_FILE_NUMBER")
    private String prisonFileNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_OF_DECISION")
    @Temporal(TemporalType.DATE)
    private Date dateOfDecision;

    public FinalDischargePK() {
    }

    public FinalDischargePK(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision) {
        this.decisionTypeNumber = decisionTypeNumber;
        this.prisonFileNumber = prisonFileNumber;
        this.dateOfDecision = dateOfDecision;
    }

    public String getDecisionTypeNumber() {
        return decisionTypeNumber;
    }

    public void setDecisionTypeNumber(String decisionTypeNumber) {
        this.decisionTypeNumber = decisionTypeNumber;
    }

    public String getPrisonFileNumber() {
        return prisonFileNumber;
    }

    public void setPrisonFileNumber(String prisonFileNumber) {
        this.prisonFileNumber = prisonFileNumber;
    }

    public Date getDateOfDecision() {
        return dateOfDecision;
    }

    public void setDateOfDecision(Date dateOfDecision) {
        this.dateOfDecision = dateOfDecision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (decisionTypeNumber != null ? decisionTypeNumber.hashCode() : 0);
        hash += (prisonFileNumber != null ? prisonFileNumber.hashCode() : 0);
        hash += (dateOfDecision != null ? dateOfDecision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinalDischargePK)) {
            return false;
        }
        FinalDischargePK other = (FinalDischargePK) object;
        if ((this.decisionTypeNumber == null && other.decisionTypeNumber != null) || (this.decisionTypeNumber != null && !this.decisionTypeNumber.equals(other.decisionTypeNumber))) {
            return false;
        }
        if ((this.prisonFileNumber == null && other.prisonFileNumber != null) || (this.prisonFileNumber != null && !this.prisonFileNumber.equals(other.prisonFileNumber))) {
            return false;
        }
        if ((this.dateOfDecision == null && other.dateOfDecision != null) || (this.dateOfDecision != null && !this.dateOfDecision.equals(other.dateOfDecision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nycpEJB.FinalDischargePK[ decisionTypeNumber=" + decisionTypeNumber + ", prisonFileNumber=" + prisonFileNumber + ", dateOfDecision=" + dateOfDecision + " ]";
    }
    
}
