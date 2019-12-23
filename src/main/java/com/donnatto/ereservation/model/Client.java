package com.donnatto.ereservation.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Class representing client table
 * @author donnatto
 */
@Entity
@Table(name = "client")
@Data
public class Client {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String cliId;
    private String cliName;
    private String cliLastName;
    private String cliIdentification;
    private String cliAddress;
    private String cliPhone;
    private String cliEmail;

    @OneToMany(mappedBy = "client")
    private Set<Reservation> reservations;
}
