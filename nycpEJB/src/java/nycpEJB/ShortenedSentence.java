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
@Table(name = "SHORTENED_SENTENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShortenedSentence.findAll", query = "SELECT s FROM ShortenedSentence s"),
    @NamedQuery(name = "ShortenedSentence.findByDecisionTypeNumber", query = "SELECT s FROM ShortenedSentence s WHERE s.shortenedSentencePK.decisionTypeNumber = :decisionTypeNumber"),
    @NamedQuery(name = "ShortenedSentence.findByPrisonFileNumber", query = "SELECT s FROM ShortenedSentence s WHERE s.shortenedSentencePK.prisonFileNumber = :prisonFileNumber"),
    @NamedQuery(name = "ShortenedSentence.findByDateOfDecision", query = "SELECT s FROM ShortenedSentence s WHERE s.shortenedSentencePK.dateOfDecision = :dateOfDecision"),
    @NamedQuery(name = "ShortenedSentence.findByDuration", query = "SELECT s FROM ShortenedSentence s WHERE s.duration = :duration")})
public class ShortenedSentence implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ShortenedSentencePK shortenedSentencePK;
    @Column(name = "DURATION")
    private Integer duration;
    @JoinColumns({
        @JoinColumn(name = "DECISION_TYPE_NUMBER", referencedColumnName = "DECISION_TYPE_NUMBER", insertable = false, updatable = false),
        @JoinColumn(name = "PRISON_FILE_NUMBER", referencedColumnName = "PRISON_FILE_NUMBER", insertable = false, updatable = false),
        @JoinColumn(name = "DATE_OF_DECISION", referencedColumnName = "DATE_OF_DECISION", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private JudicialDecision judicialDecision;

    public ShortenedSentence() {
    }

    public ShortenedSentence(ShortenedSentencePK shortenedSentencePK) {
        this.shortenedSentencePK = shortenedSentencePK;
    }

    public ShortenedSentence(String decisionTypeNumber, String prisonFileNumber, Date dateOfDecision) {
        this.shortenedSentencePK = new ShortenedSentencePK(decisionTypeNumber, prisonFileNumber, dateOfDecision);
    }

    public ShortenedSentencePK getShortenedSentencePK() {
        return shortenedSentencePK;
    }

    public void setShortenedSentencePK(ShortenedSentencePK shortenedSentencePK) {
        this.shortenedSentencePK = shortenedSentencePK;
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
        hash += (shortenedSentencePK != null ? shortenedSentencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShortenedSentence)) {
            return false;
        }
        ShortenedSentence other = (ShortenedSentence) object;
        if ((this.shortenedSentencePK == null && other.shortenedSentencePK != null) || (this.shortenedSentencePK != null && !this.shortenedSentencePK.equals(other.shortenedSentencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nycpEJB.ShortenedSentence[ shortenedSentencePK=" + shortenedSentencePK + " ]";
    }
    
}
