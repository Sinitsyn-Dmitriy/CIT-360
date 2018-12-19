

package com.dmitriy;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity(name = "users")
@Table(name = "users")
public class Notes {

	@Id
	@Column(name = "user_id")
	int userId;
	@Column(name = "username")
	String username;
	@Column(name = "note")
	String note;
	@Column(name = "first_name")
	String firstName;
	@Column(name = "last_name")
	String lastName;

	public Notes() {

	}

	public Notes(String username, String note, String firstName, String lastName) {

		this.username = username;
		this.note = note;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNote() {
		return note;
	}

	public void setPassword(String note) {
		this.note = note;
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

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", note=" + note + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

}
