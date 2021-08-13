package com.example.mimimimetr.repo;

import com.example.mimimimetr.domain.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {

    @Transactional
    @Modifying
    @Query(value = "update Cat c set c.catPoint = :point where c.catId = :id")
    void pointCounter(@Param("id") int id, @Param("point") int point);


}
