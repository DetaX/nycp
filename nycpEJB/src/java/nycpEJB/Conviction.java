/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DetaX
 */
@Entity
@Table(name = "CONVICTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conviction.findAll", query = "SELECT c FROM Conviction c"),
    @NamedQuery(name = "Conviction.findByDecisionTypeNumber", query = "SELECT c FROM Conviction c WHERE c.convictionPK.decisionTypeNumber = :decisionTypeNumber"),
    @NamedQuery(name = "Conviction.findByPrisonFileNumber", query = "SELECT c FROM Conviction c WHERE c.convictionPK.prisonFileNumber = :prisonFileNumber"),
    @NamedQuery(name = "Conviction.findByDateOfDecision", query = "SELECT c FROM Conviction c WHERE c.convictionPK.dateOfDecision = :dateOfDecision"),
    @NamedQuery(name = "Conviction.findByDuration", query = "SELECT c FROM Conviction c WHERE c.duration = :duration")})
public class Conviction implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConvictionPK convictionPK;
    @Column(name = "DURATION")
    private Integer duration;
    @JoinColumns({
        @JoinColumn(name = "DECISION_TYPE_NUMBER", referencedColumnName = "DECISION_TYPE_NUMBER", insertable = false, updatable = false),
        @JoinColumn(name = "PRISON_FILE_NUMBER", referencedColumnName = "PRISON_FILE_NUMBER", insertable = false, updatable = false),
        @JoinColumn(name = "DATE_OF_DECISION", referencedColumnName = "DATE_OF_DECISION", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private JudicialDecision judicialDecision;

    public Conviction() {
    }

    public Conviction(ConvictionPK convictionPK) {
        this.convictionPK = convictionPK;
    }

    public Conviction(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision) {
        this.convictionPK = new ConvictionPK(decisionTypeNumber, prisonFileNumber, dateOfDecision);
    }

    public ConvictionPK getConvictionPK() {
        return convictionPK;
    }

    public void setConvictionPK(ConvictionPK convictionPK) {
        this.convictionPK = convictionPK;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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
        hash += (convictionPK != null ? convictionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conviction)) {
            return false;
        }
        Conviction other = (Conviction) object;
        if ((this.convictionPK == null && other.convictionPK != null) || (this.convictionPK != null && !this.convictionPK.equals(other.convictionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nycpEJB.Conviction[ convictionPK=" + convictionPK + " ]";
    }
    
}
