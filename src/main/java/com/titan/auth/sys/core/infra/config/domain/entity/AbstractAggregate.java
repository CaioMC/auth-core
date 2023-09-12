package com.titan.auth.sys.core.infra.config.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.domain.Persistable;

import java.util.Objects;

@MappedSuperclass
public abstract class AbstractAggregate<A extends AbstractAggregateRoot<A>, K> extends AbstractAggregateRoot<A> implements Persistable<K> {
	@Transient
	private transient int hash;

	@Version
	@Column(
			name = "row_version"
	)
	private Long entityVersion;

	public AbstractAggregate() {
	}

	@JsonIgnore
	public boolean isNew() {
		return this.entityVersion == null;
	}

	protected Long getEntityVersion() {
		return this.entityVersion;
	}

	public final int hashCode() {
		if (this.hash == 0) {
			this.hash = Objects.hash(new Object[]{this.getId()});
		}

		return this.hash;
	}

	public final boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj != null && this.getClass().equals(obj.getClass())) {
			AbstractAggregate<A, K> other = (AbstractAggregate)obj;
			return Objects.equals(this.getId(), other.getId());
		} else {
			return false;
		}
	}

	public final String toString() {
		String var10000 = this.getClass().getSimpleName();
		return var10000 + " [id=" + this.getId() + ", isNew=" + this.isNew() + ", entityVersion=" + this.entityVersion + "]";
	}
}
