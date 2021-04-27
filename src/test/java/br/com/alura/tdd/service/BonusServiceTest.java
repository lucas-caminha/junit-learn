package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		// Verifica se durante a chamada do m�todo ocorreu alguma exception.
		assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Lucas", LocalDate.now(), new BigDecimal("25000"))));
		
		// Outra forma de verificar se ocorreu alguma exception ao chamar o m�todo.
		/*
		try {
			service.calcularBonus(new Funcionario("Lucas", LocalDate.now(), new BigDecimal("25000")));
			fail("N�o gerou excpetion");
		} catch(Exception e) {
			assertEquals("Funcionario com sal�rio maior que R$10.000,00 n�o pode receber b�nus.");
		}
		*/
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
