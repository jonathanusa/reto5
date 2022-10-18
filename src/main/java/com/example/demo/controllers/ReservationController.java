package com.example.demo.controllers;

import com.example.demo.entities.Reservation;
import com.example.demo.entities.dto.StatusAccount;
import com.example.demo.entities.dto.TopClients;
import com.example.demo.services.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/Reservation")
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;
    
    // Endpoint para retornar todos los elementos de la tabla
    @GetMapping("/all")
    public List<Reservation> getReservations(){ return reservationService.getAll(); }
    
    // Endpoint para retornar un elemento particular de la tabla
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation( @PathVariable("id") int reservationId ){
        return reservationService.getReservation(reservationId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save( @RequestBody Reservation reservation ){ return reservationService.save(reservation); }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update( @RequestBody Reservation reservation ){ return reservationService.update(reservation); }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete( @PathVariable("id") int reservationId ){
        return reservationService.deleteReservation(reservationId);
    }
    
    @GetMapping("/report-dates/{dateA}/{dateB}")
    public List<Reservation> getByDates(@PathVariable("dateA")String da,@PathVariable("dateB")String db ){
        return reservationService.getReservationsByPeriod(da,db);
    }
    @GetMapping("/report-status")
    public StatusAccount getByStatus(){
        return reservationService.getReportByStatus();
    }
    @GetMapping("/report-clients")
    public List<TopClients> getTopClients(){
        return reservationService.getTopclients();
    }
    
}
