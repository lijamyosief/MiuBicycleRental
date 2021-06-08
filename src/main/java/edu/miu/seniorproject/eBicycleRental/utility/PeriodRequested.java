package edu.miu.seniorproject.eBicycleRental.utility;

import org.springframework.format.annotation.DateTimeFormat;

import edu.miu.seniorproject.eBicycleRental.utility.validators.ConsistentDateParameters;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PeriodRequested {
	
	@FutureOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate start;


	@FutureOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate end;

	@ConsistentDateParameters

	public PeriodRequested(LocalDate start, LocalDate end) {
		this.start = start;
		this.end = end;
	}
	
	public PeriodRequested() {}

	public LocalDate getStart() {
		return start;
	}
	@ConsistentDateParameters
	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}
	@ConsistentDateParameters
	public void setEnd(LocalDate end) {
		this.end = end;
	}

}
