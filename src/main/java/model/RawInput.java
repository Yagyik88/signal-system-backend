package model;

import java.time.LocalDateTime;
import java.util.UUID;

import enums.SourceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class RawInput {
    @Id
    @GeneratedValue
    private UUID id;
    
    @Column
    private String rawText;
    
    @Enumerated(EnumType.STRING)
    private SourceType source;
    
    private LocalDateTime receivedAt;
}
