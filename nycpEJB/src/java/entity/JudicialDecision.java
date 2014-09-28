package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DetaX
 */
@Entity
@Table(name = "JUDICIAL_DECISION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JudicialDecision.findAll", query = "SELECT j FROM JudicialDecision j"),
    @NamedQuery(name = "JudicialDecision.findByDecisionTypeNumber", query = "SELECT j FROM JudicialDecision j WHERE j.judicialDecisionPK.decisionTypeNumber = :decisionTypeNumber"),
    @NamedQuery(name = "JudicialDecision.findByPrisonFileNumber", query = "SELECT j FROM JudicialDecision j WHERE j.judicialDecisionPK.prisonFileNumber = :prisonFileNumber"),
    @NamedQuery(name = "JudicialDecision.findByDateOfDecision", query = "SELECT j FROM JudicialDecision j WHERE j.judicialDecisionPK.dateOfDecision = :dateOfDecision")})
public class JudicialDecision implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JudicialDecisionPK judicialDecisionPK;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "judicialDecision")
    private Conviction conviction;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "judicialDecision")
    private FinalDischarge finalDischarge;
    @JoinColumn(name = "PRISON_FILE_NUMBER", referencedColumnName = "PRISON_FILE_NUMBER", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prisoner prisoner;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "judicialDecision")
    private ShortenedSentence shortenedSentence;

    public JudicialDecision() {
    }

    public JudicialDecision(JudicialDecisionPK judicialDecisionPK) {
        this.judicialDecisionPK = judicialDecisionPK;
    }

    public JudicialDecision(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision) {
        this.judicialDecisionPK = new JudicialDecisionPK(decisionTypeNumber, prisonFileNumber, dateOfDecision);
    }

    public JudicialDecisionPK getJudicialDecisionPK() {
        return judicialDecisionPK;
    }

    public void setJudicialDecisionPK(JudicialDecisionPK judicialDecisionPK) {
        this.judicialDecisionPK = judicialDecisionPK;
    }

    public Conviction getConviction() {
        return conviction;
    }

    public void setConviction(Conviction conviction) {
        this.conviction = conviction;
    }

    public FinalDischarge getFinalDischarge() {
        return finalDischarge;
    }

    public void setFinalDischarge(FinalDischarge finalDischarge) {
        this.finalDischarge = finalDischarge;
    }

    public Prisoner getPrisoner() {
        return prisoner;
    }

    public void setPrisoner(Prisoner prisoner) {
        this.prisoner = prisoner;
    }

    public ShortenedSentence getShortenedSentence() {
        return shortenedSentence;
    }

    public void setShortenedSentence(ShortenedSentence shortenedSentence) {
        this.shortenedSentence = shortenedSentence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (judicialDecisionPK != null ? judicialDecisionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JudicialDecision)) {
            return false;
        }
        JudicialDecision other = (JudicialDecision) object;
        if ((this.judicialDecisionPK == null && other.judicialDecisionPK != null) || (this.judicialDecisionPK != null && !this.judicialDecisionPK.equals(other.judicialDecisionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nycpEJB.JudicialDecision[ judicialDecisionPK=" + judicialDecisionPK + " ]";
    }
    
}
