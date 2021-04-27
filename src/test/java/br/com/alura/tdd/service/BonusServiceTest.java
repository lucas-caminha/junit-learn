package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Lucas", LocalDate.now(), new BigDecimal("25000")));
		
		assertEquals(BigDecimal.ZERO, bonus);
	}

	
	@Test
	void bonusDeveriaSerDezPorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Lucas", LocalDate.now(), new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.0"), bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamenteDezMil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Lucas", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.0"), bonus);
	}
}
