package hu.steve.webshop.dto;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import hu.steve.webshop.model.Address;

public class UserDto {

	private Long userId;
	
	private String email;	
	private String username;
	private String password;
	
	private String firstName;
	private String lastName;

    private boolean isActive;
    private boolean isNotLocked;
    
    private Set<String> roles;
    
	private Address address;

	@CreationTimestamp
	private LocalDateTime createDate;

	@UpdateTimestamp
	private LocalDateTime modifyDate;
	
	public UserDto() {
		super();
	}

	public UserDto(String email, String username, String password, String firstName, String lastName, boolean isActive,
			boolean isNotLocked, Set<String> roles, Address address, LocalDateTime createDate,
			LocalDateTime modifyDate) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
		this.isNotLocked = isNotLocked;
		this.roles = roles;
		this.address = address;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public UserDto(Long userId, String email, String username, String password, String firstName, String lastName,
			boolean isActive, boolean isNotLocked, Set<String> roles, Address address, LocalDateTime createDate,
			LocalDateTime modifyDate) {
		super();
		this.userId = userId;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
		this.isNotLocked = isNotLocked;
		this.roles = roles;
		this.address = address;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isNotLocked() {
		return isNotLocked;
	}

	public void setNotLocked(boolean isNotLocked) {
		this.isNotLocked = isNotLocked;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}
