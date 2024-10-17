package com.example.Security.Repository;

import com.example.Security.Entity.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SecurityRepo extends JpaRepository<Security, Long>{
    public Optional<Security> findByUsername(String username);
}
