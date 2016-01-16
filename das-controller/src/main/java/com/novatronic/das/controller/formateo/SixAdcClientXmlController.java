package com.novatronic.das.controller.formateo;

import java.util.List;

import com.novatronic.das.controller.SixAdcClientController;
import com.novatronic.das.dao.xml.SixAdcClientXmlDAO;
import com.novatronic.das.dao.xml.format.SixAdcClientXml;
import com.novatronic.das.util.out.Respuesta;
import com.novatronic.das.xml.configclient.SixadcClient;

/**
 * @author wcahuaya
 *
 */
public class SixAdcClientXmlController implements SixAdcClientController{

	public Respuesta insertar(List<SixadcClient> sixadcClient) {
		SixAdcClientXml mfx = new SixAdcClientXml();
		SixAdcClientXmlDAO sacxd = new SixAdcClientXmlDAO();
		for (SixadcClient sixClient : sixadcClient) {
			mfx.addSixadcClient(sixClient);
			sacxd.create(mfx);
		}
		return null;
	}

	public Respuesta actualizar(List<SixadcClient> sixadcClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SixadcClient> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Respuesta insertar(SixadcClient t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Respuesta actualizar(SixadcClient t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Respuesta insertarLista(List<SixadcClient> t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Respuesta eliminar(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
