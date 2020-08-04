package com.redesocial.repository;

import com.redesocial.model.Postage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostageRepository extends JpaRepository<Postage,Long> {
    public List<Postage> findAllByMessageContainingIgnoreCase(String message);
}
