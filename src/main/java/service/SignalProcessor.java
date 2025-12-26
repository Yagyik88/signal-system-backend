package service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import enums.Severity;
import enums.SignalType;
import model.RawInput;
import model.Signal;

@Service
public class SignalProcessor {
    public Signal process(RawInput rawInput) {
    	String text= rawInput.getRawText().toLowerCase();
    
    	Signal signal= new Signal();
    	signal.setRawinput(rawInput);
    	signal.setCreatedAt(LocalDateTime.now());
    	
    	if(text.contains("fail")|| text.contains("overheat")) {
    		  signal.setType(SignalType.ISSUE);
              signal.setSeverity(Severity.HIGH);
         
              signal.setCategory("QUALITY");
              signal.setConfidenceScore(0.8);
              signal.setTags(List.of("failure"));
    	}
    	else if (text.contains("delay") || text.contains("shipment")) {
            signal.setType(SignalType.SUPPLY);
            signal.setSeverity(Severity.MEDIUM);
            signal.setCategory("SUPPLY_CHAIN");
            signal.setConfidenceScore(0.7);
            signal.setTags(List.of("delay"));
        } else {
            signal.setType(SignalType.UNKNOWN);
            signal.setSeverity(Severity.UNKNOWN);
            signal.setCategory("UNCLASSIFIED");
            signal.setConfidenceScore(0.3);
            signal.setTags(List.of("unknown"));
        }
    	return signal;
    }
}
