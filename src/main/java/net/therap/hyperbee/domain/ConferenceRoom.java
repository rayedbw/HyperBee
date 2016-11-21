package net.therap.hyperbee.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * @author bashir
 * @author rayed
 * @since 11/21/16
 */
@Entity
@Table(name = "conference_room")
public class ConferenceRoom implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    private int id;

    private String title;

    private int capacity;

    @OneToMany(mappedBy = "conferenceRoom")
    private List<Reservation> reservationList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
