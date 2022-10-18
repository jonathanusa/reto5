package com.example.demo.services;

import com.example.demo.entities.Client;
import com.example.demo.entities.Reservation;
import com.example.demo.entities.dto.StatusAccount;
import com.example.demo.entities.dto.TopClients;
import com.example.demo.repositories.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    // Retorna todos los elementos de la tabla reservation
    public List<Reservation> getAll() { return reservationRepository.getAll(); }
    
    // Retorna un elemento que refiera al identificador id de la tabla reservation
    public Optional<Reservation> getReservation( int id ) { return reservationRepository.getReservation(id); }
    
    // Guarda un elemento en la tabla reservation
    public Reservation save( Reservation reservation ) { 
        
        if (reservation.getIdReservation()== null) {
            reservation.setStatus("created");
            
            if (reservation.getStartDate()== null){
                Date current_time = new Date();
                
                current_time.setTime(current_time.getTime()-5*3600000);
                reservation.setStartDate(current_time);
            }
            return reservationRepository.save(reservation);
        }
        else{
            Optional<Reservation> b = reservationRepository.getReservation(reservation.getIdReservation());
            if ( b.isEmpty() ){ return reservationRepository.save(reservation); }
            else{ return reservation; }
        }
    }
    
    // Actualiza un elemento en la tabla reservation
    public Reservation update ( Reservation reservation ){
        
        if( reservation.getIdReservation()!= null ){
            
            Optional<Reservation> b = reservationRepository.getReservation(reservation.getIdReservation());
            
            if( !b.isEmpty() ){
                
                // Se retornan los atributos en caso de que sean no nulos
                if( reservation.getStartDate()!= null ){ b.get().setStartDate(reservation.getStartDate()); }
                if( reservation.getDevolutionDate()!= null ){ b.get().setDevolutionDate(reservation.getDevolutionDate()); }
                if( reservation.getStatus()!= null ){ b.get().setStatus(reservation.getStatus()); }
                if( reservation.getClient()!= null ){ b.get().setClient(reservation.getClient()); }
                if( reservation.getBoat()!= null ){ b.get().setBoat(reservation.getBoat()); }
                if( reservation.getScore()!= null ){ b.get().setScore(reservation.getScore()); }
                
                // Se realiza la actualización del objeto con ayuda del repositorio
                reservationRepository.save(b.get());
                return b.get();
            }
            else{
                return reservation;
            }
        }
        else{
            return reservation;
        }
    }
    
    // Elimina un elemento en la tabla reservation
    public boolean deleteReservation( int id ){
        
        Boolean bBoolean = getReservation(id).map( reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        
        return bBoolean;
    }
    
    public List<Reservation> getReservationsByPeriod(String dateA,String dateB){

        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date a= new Date();
        Date b=new Date();
        try {
            a=parser.parse(dateA);
            b=parser.parse(dateB);
        }catch (ParseException e){
            e.printStackTrace();;
        }
        if(a.before(b)){
            return reservationRepository.getDatesReport(a,b);
        }else{
            return new ArrayList<Reservation>();
        }
    }
    public StatusAccount getReportByStatus(){
        List<Reservation> completes=reservationRepository.getStatusReport("completed");
        List<Reservation> cancelled=reservationRepository.getStatusReport("cancelled");

        StatusAccount resultado = new StatusAccount( completes.size(), cancelled.size());
        return resultado;

    }
    public List<TopClients> getTopclients(){
        List<TopClients> tc=new ArrayList<>();
        List<Object[]> result= reservationRepository.getTopClients();

        for(int i=0;i<result.size();i++){
            int total=Integer.parseInt(result.get(i)[1].toString());
            Client client= (Client) result.get(i)[0];
            TopClients topClient=new TopClients(total,client);
            tc.add(topClient);
        }
        return tc;
    }
    
}

