package com.comfandi.bono.recompra.batch.bono.steps;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class BonoExecutionListener implements StepExecutionListener {

	   @Override
	    public void beforeStep(StepExecution stepExecution) {
	        // Lógica antes de la ejecución del paso
	    }

	    @Override
	    public ExitStatus afterStep(StepExecution stepExecution) {
	        // Verifica si el ItemReader no ha leído elementos
	        if (stepExecution.getReadCount() == 0) {
	            // Aquí puedes agregar lógica, como registrar un mensaje o cambiar el estado del paso
	            System.out.println("No se leyeron elementos en este paso.");
	        }
	        return ExitStatus.COMPLETED;
	    }

}
