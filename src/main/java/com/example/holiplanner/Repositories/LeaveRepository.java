package com.example.holiplanner.Repositories;

import com.example.holiplanner.Entities.Leave;
import com.example.holiplanner.Entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave,Long> {
    List<Leave> findByStatus(Status status);
}
