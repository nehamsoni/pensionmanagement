package com.cognizant.pensionmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.pensionmanagement.model.PensionDetails;

@Repository
public interface PensionDetailsRepository extends JpaRepository<PensionDetails, Long>
{
}
