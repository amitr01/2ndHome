package com.app.services;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.app.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
     
	private final String SECRET_KEY="c899b677c895ce36dc019eb2be6d9fff951313a63bf6f40d46d189a9abbaf828";
	
	
	public String extractUsername(String token) {
		return extractClaim(token,Claims::getSubject);
	}
	
	public boolean isValid(String token,UserDetails user) {
		String username=extractUsername(token);
		return (username.equals(user.getUsername()))&& !isTokenExpired(token);
	}
	
	
	private boolean isTokenExpired(String token) {
	     
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		// TODO Auto-generated method stub
		return extractClaim(token,Claims::getExpiration);
	}

	public <T> T extractClaim(String token,Function<Claims,T> resolver) {
		Claims claims=extractAllClaims(token);
		return resolver.apply(claims);
				
	}
	private Claims extractAllClaims(String token) {
		return  Jwts
				.parser()
				.setSigningKey(getSigninKey())
				.parseClaimsJws(token)
				.getBody();
				
	}
	public String generateToken(User user) {
		String token=Jwts
				.builder()
				.setSubject(user.getEmail())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+24*60*60*1000))
				.signWith(getSigninKey())
				.compact();
		return token;
			
	}
	private SecretKey getSigninKey() {
		byte[] keyBytes=Decoders.BASE64URL.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
