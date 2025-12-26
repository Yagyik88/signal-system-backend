package controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.RawInputRequest;
import enums.SourceType;
import model.RawInput;
import model.Signal;
import repository.RawInputRepository;
import repository.SignalRepository;
import service.SignalProcessor;

@RestController
@RequestMapping("/api/signals")
@CrossOrigin
public class SignalController {
     private final RawInputRepository rawRepo;
     private final SignalRepository signalRepo;
     private final SignalProcessor processor;
     
	public SignalController(RawInputRepository rawRepo, SignalRepository signalRepo, SignalProcessor processor) {
		this.rawRepo = rawRepo;
		this.signalRepo = signalRepo;
		this.processor = processor;
	}
    @PostMapping
	public Signal createSignal(@RequestBody RawInputRequest request) {
	
		RawInput raw= new RawInput();
		raw.setRawText(request.getText());
		raw.setSource(SourceType.MANUAL);
		raw.setReceivedAt(LocalDateTime.now());
		
		rawRepo.save(raw);
		
		Signal signal = processor.process(raw);
		return signalRepo.save(signal);
	}
	
	@GetMapping
	public List<Signal> getAllSignals(){
		return signalRepo.findAll();
	}
     
}
