package br.com.testcode.eletronicvoting.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit {

	@CreatedDate
	@Column(name = "dt_create_date", nullable = false, updatable = false)
	private LocalDateTime createDate;

	@LastModifiedDate
	@Column(name = "dt_last_modified", updatable = false)
	private LocalDateTime lastModifiedDate;

}
