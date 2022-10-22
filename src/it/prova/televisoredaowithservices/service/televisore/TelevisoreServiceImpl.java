package it.prova.televisoredaowithservices.service.televisore;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import it.prova.televisoredaowithservices.dao.televisore.TelevisoreDAO;
import it.prova.televisoredaowithservices.model.Televisore;

public class TelevisoreServiceImpl implements TelevisoreService {
	private TelevisoreDAO televisoreDAO;

	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO) {
		this.televisoreDAO = televisoreDAO;
	}

	@Override
	public List<Televisore> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Televisore findById(Long idInput) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int aggiorna(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inserisciNuovo(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rimuovi(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Televisore> findByExample(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Televisore> findAllByProdottiTra(Date data1, Date data2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Televisore findTelevisorePiuGrande() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Televisore> findAllMarcheProdottiUltimi6Mesi() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
