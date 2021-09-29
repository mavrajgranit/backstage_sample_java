package io.learning.backstage_sample_java.persistence;

import io.learning.backstage_sample_java.domain.Note;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface NoteRepository extends ReactiveCrudRepository<Note, Long> {
}
