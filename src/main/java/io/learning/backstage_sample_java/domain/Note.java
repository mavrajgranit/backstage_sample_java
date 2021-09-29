package io.learning.backstage_sample_java.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Table("notes")
public class Note implements Persistable<Long> {

    @Id
    @Min(1)
    @Column("id")
    private Long id;

    @NotBlank
    @Size(min=3, max=2000)
    @Pattern(regexp = "^.*\\S.*$")
    @Column("content")
    private String content;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }
}
