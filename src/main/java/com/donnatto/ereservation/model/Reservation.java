package com.donnatto.ereservation.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Class representing reservation table
 * @author donnatto
 */
@Entity
@Table(name = "reservation")
@Data
public class Reservation {

    private String resId;
    private Date resEntryDate;
    private Date resExitDate;
    private int resPeopleQuantity;
    private String resDescription;

    @ManyToOne
    @JoinColumn(name = "cliId")
    private Client client;

}
