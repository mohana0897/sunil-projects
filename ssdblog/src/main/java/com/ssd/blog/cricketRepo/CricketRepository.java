package com.ssd.blog.cricketRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssd.blog.cricketmodel.Cricket;
@Repository
public interface CricketRepository extends JpaRepository<Cricket, Integer> {

}
