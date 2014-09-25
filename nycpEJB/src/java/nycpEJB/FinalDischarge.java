package nycpEJB;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DetaX
 */
@Entity
@Table(name = "FINAL_DISCHARGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinalDischarge.findAll", query = "SELECT f FROM FinalDischarge f"),
    @NamedQuery(name = "FinalDischarge.findByDecisionTypeNumber", query = "SELECT f FROM FinalDischarge f WHERE f.finalDischargePK.decisionTypeNumber = :decisionTypeNumber"),
    @NamedQuery(name = "FinalDischarge.findByPrisonFileNumber", query = "SELECT f FROM FinalDischarge f WHERE f.finalDischargePK.prisonFileNumber = :prisonFileNumber"),
    @NamedQuery(name = "FinalDischarge.findByDateOfDecision", query = "SELECT f FROM FinalDischarge f WHERE f.finalDischargePK.dateOfDecision = :dateOfDecision"),
    @NamedQuery(name = "FinalDischarge.findByDateOfFinalDischarge", query = "SELECT f FROM FinalDischarge f WHERE f.dateOfFinalDischarge = :dateOfFinalDischarge")})
public class FinalDischarge implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FinalDischargePK finalDischargePK;
    @Column(name = "DATE_OF_FINAL_DISCHARGE")
    @Temporal(TemporalType.DATE)
    private Date dateOfFinalDischarge;
    @JoinColumns({
        @JoinColumn(name = "DECISION_TYPE_NUMBER", referencedColumnName = "DECISION_TYPE_NUMBER", insertable = false, updatable = false),
        @JoinColumn(name = "PRISON_FILE_NUMBER", referencedColumnName = "PRISON_FILE_NUMBER", insertable = false, updatable = false),
        @JoinColumn(name = "DATE_OF_DECISION", referencedColumnName = "DATE_OF_DECISION", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private JudicialDecision judicialDecision;

    public FinalDischarge() {
    }

    public FinalDischarge(FinalDischargePK finalDischargePK) {
        this.finalDischargePK = finalDischargePK;
    }

    public FinalDischarge(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision) {
        this.finalDischargePK = new FinalDischargePK(decisionTypeNumber, prisonFileNumber, dateOfDecision);
    }

    public FinalDischargePK getFinalDischargePK() {
        return finalDischargePK;
    }

    public void setFinalDischargePK(FinalDischargePK finalDischargePK) {
        this.finalDischargePK = finalDischargePK;
    }

    public Date getDateOfFinalDischarge() {
        return dateOfFinalDischarge;
    }

    public void setDateOfFinalDischarge(Date dateOfFinalDischarge) {
        this.dateOfFinalDischarge = dateOfFinalDischarge;
    }

    public JudicialDecision getJudicialDecision() {
        return judicialDecision;
    }

    public void setJudicialDecision(JudicialDecision judicialDecision) {
        this.judicialDecision = judicialDecision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finalDischargePK != null ? finalDischargePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinalDischarge)) {
            return false;
        }
        FinalDischarge other = (FinalDischarge) object;
        if ((this.finalDischargePK == null && other.finalDischargePK != null) || (this.finalDischargePK != null && !this.finalDischargePK.equals(other.finalDischargePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nycpEJB.FinalDischarge[ finalDischargePK=" + finalDischargePK + " ]";
    }
    
}
