package com.ayushi.authorizationService.service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * This class consists of all security related functions.
 */ 
@Component
public class JwtUtil {
	   private String secretKey = "secretkey";
	   
	   /**
		* @param token
		* returns extracted username from the token
		*/
	    public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }
	    
	    /**
		 * @param token
		 * returns expiration of the token
		 */ 
	    public Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }
	    
	    /**
		 * @param token
		 * returns extracted claims
		 */ 
	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }
	    
	    /**
		 * @param token
		 * returns extracted all claims
		 */ 
	    private Claims extractAllClaims(String token) {
	        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	    }
	    
	    /**
		 * @param userDetails
		 * returns generated token by calling createToken method
		 */ 
	    public String generateToken(UserDetails userDetails) {
	        Map<String, Object> claims = new HashMap<>();
	        return createToken(claims, userDetails.getUsername());
	    }
	    
	    /**
		 * @param claims
		 * @param subject
		 * To create token
		 */ 
	    private String createToken(Map<String, Object> claims, String subject) {

	        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + 500 * 60 * 30))
	                .signWith(SignatureAlgorithm.HS256, secretKey).compact();
	    }
	    
	    /**
		 * @param token
		 * To validate token
		 */ 
	    public Boolean validateToken(String token) {
	    	try {
				Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
				return true;
			}
			catch(Exception e) {
				return false;
			}
	    }
   
}
