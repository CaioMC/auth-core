package com.titan.auth.sys.core.infra.config.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;


@Getter(AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class AbstractAuditableAggregate<A extends AbstractAggregate<A, K>, K> extends AbstractAggregate<A, K> {
	@CreatedDate
	@Column(
			name = "row_created_at"
	)
	private ZonedDateTime entityCreatedAt;
	@CreatedBy
	@Column(
			name = "row_created_by"
	)
	private String entityCreatedBy = "unknown";
	@LastModifiedDate
	@Column(
			name = "row_updated_at"
	)
	private ZonedDateTime entityUpdatedAt;
	@LastModifiedBy
	@Column(
			name = "row_updated_by"
	)
	private String entityUpdatedBy = "unknown";

	public AbstractAuditableAggregate() {
	}
}
