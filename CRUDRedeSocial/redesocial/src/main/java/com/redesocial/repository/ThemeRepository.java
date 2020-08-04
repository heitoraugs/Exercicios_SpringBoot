package com.redesocial.repository;

import com.redesocial.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeRepository extends JpaRepository <Theme,Long>{
    public List<Theme> findAllByDescriptionContainingIgnoreCase(String description);

}
