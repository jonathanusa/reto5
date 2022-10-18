package com.example.demo.repositories.crudRepositories;

import com.example.demo.entities.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
    @Query("SELECT c.client,COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT (c.client) DESC")
    public List<Object[]>getTopClients();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date d1,Date d2);

    public List<Reservation> findAllByStatus(String sts);
    
}
