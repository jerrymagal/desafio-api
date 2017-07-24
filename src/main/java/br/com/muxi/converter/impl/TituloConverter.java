package br.com.muxi.converter.impl;

import br.com.muxi.converter.Converter;
import br.com.muxi.model.Titulo;

public class TituloConverter implements Converter<Titulo>{

	@Override
	public Titulo toObject(String objeto) {
		
		Titulo titulo = new Titulo();

		if(objeto == null || objeto.trim().isEmpty()) {
			return titulo;
		}
		
		String[] campos = objeto.split(";");
		
		Integer logic = Integer.parseInt(campos[0]);
		String serial = campos[1];
		String model = campos[2];
		Integer sam = Integer.parseInt(campos[3]);
		String ptid = campos[4];
		Integer plat = Integer.parseInt(campos[5]);
		String version = campos[6];
		Integer mxr = Integer.parseInt(campos[7]);
		Integer mxf = Integer.parseInt(campos[8]);
		String VERFM = campos[9];
		
		titulo.setLogic(logic);
		titulo.setSerial(serial);
		titulo.setModel(model);
		titulo.setSam(sam);
		titulo.setPtid(ptid);
		titulo.setPlat(plat);
		titulo.setVersion(version);
		titulo.setMxr(mxr);
		titulo.setMxf(mxf);
		titulo.setVERFM(VERFM);
		
		return titulo;
	}

}
