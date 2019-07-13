package com.napptilus.test.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.napptilus.test.model.Oompa;

@Repository
public interface OompaRepository extends JpaRepository<Oompa, Integer> {


}
