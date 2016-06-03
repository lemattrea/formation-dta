package fr.pizzeria.aspects;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.model.Performance;
import fr.pizzeria.repos.PerformanceRepository;

@Aspect
@Component
public class PizzaPerformanceAspect {
	
	@Autowired private PerformanceRepository performanceRepository;
	
	@Transactional
	@Around("execution(* fr.pizzeria.doa.pizza.*.*(..))")
	public Object timerMethode(ProceedingJoinPoint pop) throws Throwable {
		Performance perf = new Performance();
		perf.setService(pop.getSignature().toShortString());
		perf.setDate(LocalDateTime.now());
		
		long begin = System.currentTimeMillis();
		Object obj = pop.proceed();
		long end = System.currentTimeMillis();
		perf.setTempsExecution((int)(end-begin));
		
		performanceRepository.save(perf);
		
		return obj;
	}
}
