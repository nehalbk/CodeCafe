package com.codecafe.exceptions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ExceptionsRepo extends JpaRepository<ExceptionDetails, Integer>{

}
