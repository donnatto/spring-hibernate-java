package com.donnatto.ereservation.business.repository;

import com.donnatto.ereservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Interface to define DB operations related to reservations
 * @author donnatto
 */
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    @Query("select r from Reservation r where r.resEntryDate =: startDate and r.resExitDate =: exitDate")
    public List<Reservation> find(@Param("startDate") Date startDate, @Param("exitDate") Date exitDate);
}
