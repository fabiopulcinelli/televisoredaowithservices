package it.prova.televisoredaowithservices.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.prova.televisoredaowithservices.model.Televisore;
import it.prova.televisoredaowithservices.service.MyServiceFactory;
import it.prova.televisoredaowithservices.service.televisore.TelevisoreService;

public class TestTelevisore {

	public static void main(String[] args) {
		// parlo direttamente con il service
		TelevisoreService userService = MyServiceFactory.getTelevisoreServiceImpl();

		try {

			// ora con il service posso fare tutte le invocazioni che mi servono
			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");

			testInserimentoNuovoTelevisore(userService);
			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");

			testRimozioneTelevisore(userService);
			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");

			testFindByExample(userService);
			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");

			testFindAllByProdottiTra(userService);
			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");

			testFindTelevisorePiuGrande(userService);
			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");

			testFindAllMarcheProdottiUltimi6Mesi(userService);
			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// metodi statici per il main
	public static void testInserimentoNuovoTelevisore(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testInserimentoNuovoTelevisore inizio.............");
		Televisore newTelevisoreInstance = new Televisore("Tele1", "visore1", 30, new Date());
		if (televisoreService.inserisciNuovo(newTelevisoreInstance) != 1)
			throw new RuntimeException("testInserimentoNuovoTelevisore FAILED ");

		System.out.println(".......testInserimentoNuovoTelevisore PASSED.............");
	}

	private static void testRimozioneTelevisore(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testRimozioneTelevisore inizio.............");
		// recupero tutti gli user
		List<Televisore> interoContenutoTabella = televisoreService.listAll();
		if (interoContenutoTabella.isEmpty() || interoContenutoTabella.get(0) == null)
			throw new Exception("Non ho nulla da rimuovere");

		Long idUltimo = interoContenutoTabella.get(interoContenutoTabella.size() - 1).getId();
		// ricarico per sicurezza con l'id individuato
		Televisore toBeRemoved = televisoreService.findById(idUltimo);
		if (televisoreService.rimuovi(toBeRemoved) != 1)
			throw new RuntimeException("testRimozioneTelevisore FAILED ");

		System.out.println(".......testRimozioneTelevisore PASSED.............");
	}

	private static void testFindByExample(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testFindByExample inizio.............");

		Televisore example = new Televisore();
		example.setMarca("Sa");
		example.setModello("X");

		// preparo un example che ha come nome 'as' e ricerco
		List<Televisore> risultatifindByExample = televisoreService.findByExample(example);
		for (Televisore teleItem : risultatifindByExample) {
			System.out.println(teleItem);
		}

		System.out.println(".......testFindByExample PASSED.............");
	}

	private static void testFindAllByProdottiTra(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testFindAllByProdottiTra inizio.............");

		// preparo un example che ha come nome 'as' e ricerco
		Date data1 = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2020");
		Date data2 = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2023");
		List<Televisore> risultatifindByExample = televisoreService.findAllByProdottiTra(data1, data2);
		for (Televisore teleItem : risultatifindByExample) {
			System.out.println(teleItem);
		}

		System.out.println(".......testFindAllByProdottiTra PASSED.............");
	}

	private static void testFindTelevisorePiuGrande(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testFindTelevisorePiuGrande inizio.............");

		// preparo un example che ha come nome 'as' e ricerco
		Televisore televisorePiuGrande = televisoreService.findTelevisorePiuGrande();
		System.out.println(televisorePiuGrande);

		System.out.println(".......testFindTelevisorePiuGrande PASSED.............");
	}

	private static void testFindAllMarcheProdottiUltimi6Mesi(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testFindAllMarcheProdottiUltimi6Mesi inizio.............");

		// preparo un example che ha come nome 'as' e ricerco
		List<Televisore> risultatifindByExample = televisoreService.findAllMarcheProdottiUltimi6Mesi();
		for (Televisore teleItem : risultatifindByExample) {
			System.out.println(teleItem);
		}

		System.out.println(".......testFindAllMarcheProdottiUltimi6Mesi PASSED.............");
	}
}
