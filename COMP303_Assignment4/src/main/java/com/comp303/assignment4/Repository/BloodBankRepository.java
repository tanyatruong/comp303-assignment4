package com.comp303.assignment4.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.comp303.assignment4.Entity.BloodBank;

@Repository
public interface BloodBankRepository extends MongoRepository<BloodBank, String> {}
