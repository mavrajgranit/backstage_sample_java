package io.learning.backstage_sample_java.controller;

import io.learning.backstage_sample_java.controller.exception.NoteNotFoundException;
import io.learning.backstage_sample_java.domain.Note;
import io.learning.backstage_sample_java.persistence.NoteRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RequiredArgsConstructor

@RestController
@RequestMapping("/notes")
@Validated
public class NoteController {

    private final NoteRepository noteRepository;

    @Operation(summary = "Get all Notes")
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Note> getAll(){
        return noteRepository.findAll();
    }

    @Operation(summary = "Create new Note")
    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<Note>> create(@Valid @RequestBody final Note note){
        note.setId(null);
        return noteRepository.save(note)
                .map(note_ -> ResponseEntity.status(HttpStatus.CREATED).body(note));
    }

    @Operation(summary = "Get Note By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Note"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied"),
            @ApiResponse(responseCode = "404", description = "Note not found") })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<Note> getById(@PathVariable("id") @Min(1) final Long id){
        return noteRepository.findById(id)
                .switchIfEmpty(Mono.error(NoteNotFoundException.forMissingId(id)));
    }
}
