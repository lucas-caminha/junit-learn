package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.model.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
	
	private ReajusteService service;
	private Funcionario funcionario;
	
	// Executa uma unica vez antes de todos os métodos serem chamados
	@BeforeAll
	public static void initAntesDeTodos() {
		
	}
	
	// Executa uma unica vez depois de todos os métodos serem chamados
	@AfterAll
	public static void finalizaDepoisDeTodos() {
		
	}
	

	// Antes de executar cada teste, execute este método.
	@BeforeEach
	public void init() {
		service = new ReajusteService();
		funcionario = new Funcionario("Lucas", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	// Depois de executar cada teste, execute este método.
	@AfterEach
	public void finaliza() {
		System.out.println("Finalizado.");
	}
	
	@Test
	void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {	
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);	
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {	
		service.concederReajuste(funcionario, Desempenho.BOM);	
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {	
		service.concederReajuste(funcionario, Desempenho.OTIMO);	
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

}
