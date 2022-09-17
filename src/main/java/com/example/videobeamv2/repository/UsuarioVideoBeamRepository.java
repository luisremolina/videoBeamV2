package com.example.videobeamv2.repository;

import com.example.videobeamv2.entity.UsuarioVideoBeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioVideoBeamRepository extends JpaRepository<UsuarioVideoBeam, Long> {
    public String getByCorreo(String correo);
    boolean existsByCorreo(String correo);

}
