package hu.steve.transport.config;

import java.time.Duration;
import java.util.TreeMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "transports")
@Component
public class DelayConfigProperties {

	private DeclinePercentage declinePercentage = new DeclinePercentage();
	private JwtData jwt = new JwtData();
	
	public DeclinePercentage getDeclinePercentage() {
		return declinePercentage;
	}
	public void setDeclinePercentage(DeclinePercentage declinePercentage) {
		this.declinePercentage = declinePercentage;
	}

	public static class DeclinePercentage {

		private TreeMap<Integer, Integer> limits;

		public TreeMap<Integer, Integer> getLimits() {
			return limits;
		}

		public void setLimits(TreeMap<Integer, Integer> limits) {
			this.limits = limits;
		}
	}
	
	public JwtData getJwt() {
		return jwt;
	}
	public void setJwt(JwtData jwt) {
		this.jwt = jwt;
	}	
	
	public static class JwtData {
		private String issuer;
		private String secret;
		private String alg;
		private Duration duration;
		
		public String getIssuer() {
			return issuer;
		}
		public void setIssuer(String issuer) {
			this.issuer = issuer;
		}
		public String getSecret() {
			return secret;
		}
		public void setSecret(String secret) {
			this.secret = secret;
		}
		public String getAlg() {
			return alg;
		}
		public void setAlg(String alg) {
			this.alg = alg;
		}
		public Duration getDuration() {
			return duration;
		}
		public void setDuration(Duration duration) {
			this.duration = duration;
		}			
	}
}
