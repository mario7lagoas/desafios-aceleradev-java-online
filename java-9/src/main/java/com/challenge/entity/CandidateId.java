package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class CandidateId implements Serializable {

	@NotNull
	@ManyToOne
	private User user;

	@NotNull
	@ManyToOne
	private Acceleration acceleration;

	@NotNull
	@ManyToOne
	private Company company;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acceleration == null) ? 0 : acceleration.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidateId other = (CandidateId) obj;
		if (acceleration == null) {
			if (other.acceleration != null)
				return false;
		} else if (!acceleration.equals(other.acceleration))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
