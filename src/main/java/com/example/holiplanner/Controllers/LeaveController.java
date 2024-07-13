package com.example.holiplanner.Controllers;

import com.example.holiplanner.DTOs.LeaveDTO;
import com.example.holiplanner.Entities.Leave;
import com.example.holiplanner.Entities.Status;
import com.example.holiplanner.Repositories.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/leaves")
@CrossOrigin(origins = "http://localhost:4200")
public class LeaveController {

    @Autowired
    private LeaveRepository leaveRepository;

    @GetMapping("/validated")
    public List<LeaveDTO> getValidatedLeaves() {
        List<Leave> validatedLeaves = leaveRepository.findByStatus(Status.Validated);
        return validatedLeaves.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private LeaveDTO convertToDTO(Leave leave) {
        LeaveDTO dto = new LeaveDTO();
        dto.setTitle(leave.getTitle());
        dto.setStart(leave.getStart());
        dto.setEnd(leave.getEnd());
        dto.setEmployeeName(leave.getEmployee().getName());
        dto.setTeam(leave.getEmployee().getTeam());
        dto.setType(leave.getType());
        return dto;
    }
}
