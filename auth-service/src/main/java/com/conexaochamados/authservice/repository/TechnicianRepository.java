package com.conexaochamados.authservice.repository;

import com.conexaochamados.authservice.model.TechnicianModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnicianRepository extends JpaRepository<TechnicianModel, Long> {

    Optional<TechnicianModel> findByEmail(String email);

}
