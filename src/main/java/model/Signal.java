package model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import enums.Severity;
import enums.SignalType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
 

@Entity
@Data
public class Signal {
    @Id
    @GeneratedValue
    private UUID id;
    
    @OneToOne
    private RawInput rawinput;
    
    @Enumerated(EnumType.STRING)
    private SignalType type;
    private String category;
     
    @Enumerated(EnumType.STRING)
    private Severity severity;
    private double confidenceScore;
    @ElementCollection
    private List<String> tags;
    private LocalDateTime createdAt;
}
