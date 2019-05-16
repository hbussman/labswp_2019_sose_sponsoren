package sponsoren.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sponsor_attraktion", schema = "buga19sponsoren", catalog = "")
public class AttraktionEntity {
    private String name;
    // TODO add all the shitz;

    @Id
    @Column(name = "SponsorName")
    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    @Id
    @Column(name = "AttraktionID")
    public int getAttraktionId() {
        return attraktionId;
    }

    public void setAttraktionId(int attraktionId) {
        this.attraktionId = attraktionId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        AttraktionEntity that = (AttraktionEntity)o;
        return attraktionId == that.attraktionId &&
                Objects.equals(sponsorName, that.sponsorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sponsorName, attraktionId);
    }
}
