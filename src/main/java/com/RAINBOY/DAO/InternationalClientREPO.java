package com.RAINBOY.DAO;

import com.RAINBOY.BO.InternationalClientPOJO;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.util.List;

@Repository
public interface InternationalClientREPO extends JpaRepository<InternationalClientPOJO, Serializable>
{}
