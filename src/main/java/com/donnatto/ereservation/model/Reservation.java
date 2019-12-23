package com.donnatto.ereservation.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Class representing reservation table
 * @author donnatto
 */
@Entity
@Table(name = "reservation")
@Data
public class Reservation {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String resId;
    @Temporal(TemporalType.DATE)
    private Date resEntryDate;
    @Temporal(TemporalType.DATE)
    private Date resExitDate;
    private int resPeopleQuantity;
    private String resDescription;

    @ManyToOne
    @JoinColumn(name = "cliId")
    private Client client;

}
