package com.comp303.assignment4.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.comp303.assignment4.Entity.BloodBank;
import com.comp303.assignment4.Repository.BloodBankRepository;

@RestController
@RequestMapping("/api/bloodbanks")
public class BloodBankController {
    @Autowired
    private BloodBankRepository bloodBankRepository;

    @PostMapping
    public BloodBank addBloodBank(@RequestBody BloodBank bloodBank) {
        return bloodBankRepository.save(bloodBank);
    }

    @GetMapping
    public List<BloodBank> getAllBloodBanks() {
        return bloodBankRepository.findAll();
    }

    @GetMapping("/{id}")
    public BloodBank getBloodBank(@PathVariable String id) {
        return bloodBankRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Blood Bank not found"));
    }

    @PutMapping("/{id}")
    public BloodBank updateBloodBank(@PathVariable String id, @RequestBody BloodBank bloodBank) {
        BloodBank existingBloodBank = bloodBankRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Blood Bank not found"));
        existingBloodBank.setName(bloodBank.getName());
        existingBloodBank.setAddress(bloodBank.getAddress());
        return bloodBankRepository.save(existingBloodBank);
    }
}