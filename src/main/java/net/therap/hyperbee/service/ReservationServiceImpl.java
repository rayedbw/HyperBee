package net.therap.hyperbee.service;

import net.therap.hyperbee.dao.ReservationDao;
import net.therap.hyperbee.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rumman
 * @since 11/29/16
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    @Override
    public void saveReservation(Reservation reservation) {
        reservationDao.saveOrUpdate(reservation);
    }

    @Override
    public Reservation findReservationById(int reservationId) {
        return reservationDao.findById(reservationId);
    }

    @Override
    public List<Reservation> findAllReservation() {
        return reservationDao.findAll();
    }

    @Override
    public void delete(int reservationId) {
        reservationDao.delete(reservationId);
    }
}
