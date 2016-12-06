package org.shanoir.ng.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.shanoir.ng.model.hateoas.HalEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * User
 */
@Entity
@Table(name = "users")
@JsonPropertyOrder({ "_links", "id", "firstName", "lasName", "username", "email" })
public class User extends HalEntity implements UserDetails {

	/**
	 * UID
	 */
	private static final long serialVersionUID = -5277815428510293236L;

	@Id
	@GeneratedValue
	private Long id;

	private boolean canAccessToDicomAssociation;

	@NotNull
	private Date creationDate;

	@NotBlank
	@Column(unique = true)
	private String email;
	
	private Date expirationDate;

	@NotBlank
	private String firstName;
	
	private boolean isFirstExpirationNotificationSent;
	
	@NotNull
	private boolean isMedical;

	private boolean isOnDemand;

	private boolean isSecondExpirationNotificationSent;
	
	private Date lastLogin;

	@NotNull
	private String lastName;
	
	private String password;

	@ManyToOne
	@NotNull
	private Role role;

	private String teamName;

	@NotBlank
	@Column(unique = true)
	private String username;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the canAccessToDicomAssociation
	 */
	public boolean isCanAccessToDicomAssociation() {
		return canAccessToDicomAssociation;
	}

	/**
	 * @param canAccessToDicomAssociation the canAccessToDicomAssociation to set
	 */
	public void setCanAccessToDicomAssociation(boolean canAccessToDicomAssociation) {
		this.canAccessToDicomAssociation = canAccessToDicomAssociation;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the isFirstExpirationNotificationSent
	 */
	public boolean isFirstExpirationNotificationSent() {
		return isFirstExpirationNotificationSent;
	}

	/**
	 * @param isFirstExpirationNotificationSent the isFirstExpirationNotificationSent to set
	 */
	public void setFirstExpirationNotificationSent(boolean isFirstExpirationNotificationSent) {
		this.isFirstExpirationNotificationSent = isFirstExpirationNotificationSent;
	}

	/**
	 * @return the isMedical
	 */
	public boolean isMedical() {
		return isMedical;
	}

	/**
	 * @param isMedical the isMedical to set
	 */
	public void setMedical(boolean isMedical) {
		this.isMedical = isMedical;
	}

	/**
	 * @return the isOnDemand
	 */
	public boolean isOnDemand() {
		return isOnDemand;
	}

	/**
	 * @param isOnDemand the isOnDemand to set
	 */
	public void setOnDemand(boolean isOnDemand) {
		this.isOnDemand = isOnDemand;
	}

	/**
	 * @return the isSecondExpirationNotificationSent
	 */
	public boolean isSecondExpirationNotificationSent() {
		return isSecondExpirationNotificationSent;
	}

	/**
	 * @param isSecondExpirationNotificationSent the isSecondExpirationNotificationSent to set
	 */
	public void setSecondExpirationNotificationSent(boolean isSecondExpirationNotificationSent) {
		this.isSecondExpirationNotificationSent = isSecondExpirationNotificationSent;
	}

	/**
	 * @return the lastLogin
	 */
	public Date getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(role);
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}

}
