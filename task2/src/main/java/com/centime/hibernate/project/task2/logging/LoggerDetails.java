package com.centime.hibernate.project.task2.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggerDetails {

	 private static final Logger logger = LoggerFactory.getLogger(LoggerDetails.class);
	 private static final ObjectMapper objectMapper = new ObjectMapper();
	 
	    @After("@annotation(logMethodParam)")
	    public void logMethodParams(JoinPoint joinPoint, LogMethodParam logMethodParam) {
	        String methodName = joinPoint.getSignature().getName();
	        Object[] args = joinPoint.getArgs();
	        
	        // Create a string representation of parameters
	        StringBuilder paramsBuilder = new StringBuilder();
	        for (Object arg : args) {
	            if (arg != null) {
	                try {
	                    // Convert each argument to a JSON string
	                    String json = objectMapper.writeValueAsString(arg);
	                    paramsBuilder.append(json).append(", ");
	                } catch (Exception e) {
	                    logger.error("Error converting parameter to JSON", e);
	                }
	            } else {
	                paramsBuilder.append("null");
	            }
	            paramsBuilder.append(", ");
	        }
	        
	        // Remove the last comma and space
	        if (paramsBuilder.length() > 0) {
	            paramsBuilder.setLength(paramsBuilder.length() - 2);
	        }
	        logger.info("Method: {} called with parameters: {}", methodName, paramsBuilder.toString());
	    }
}
