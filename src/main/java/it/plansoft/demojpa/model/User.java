package it.plansoft.demojpa.model;/* ggrosso created on 21/02/2021 inside the package - it.plansoft.demojpa.model */

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User extends BaseId<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	@Column(name = "sso", unique = true, nullable = false)
	private String sso;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "password", nullable = false)
	private String password;


	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private UserProfile userProfile;

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public String getSso() {
		return sso;
	}

	public void setSso(String sso) {
		this.sso = sso;
	}

	public User(String sso, String email, String name, String lastName, String password) {
		this.sso = sso;
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", sso='" + sso + '\'' +
				", email='" + email + '\'' +
				", name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", password='" + password + '\'' +
				", userProfile=" + userProfile +
				'}';
	}
}