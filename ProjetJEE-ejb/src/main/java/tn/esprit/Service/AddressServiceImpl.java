package tn.esprit.Service;

import java.io.InputStream;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;


import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;

import tn.esprit.entities.Adress;

@Stateless
public class AddressServiceImpl implements AddressService , AddressServiceRemote {

	@Override
	public void saveAdresse(Adress adress) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAdresse(Adress adress) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAdresse(Adress adress) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Adress getAdresseById(int idAdresse) throws Exception {
		String uri =
			    "http://192.168.1.102:10040/api/adresse/1";
			URL url = new URL(uri);
			HttpURLConnection connection =
			    (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/xml");

			JAXBContext jc = JAXBContext.newInstance(Adress.class);
			InputStream xml = connection.getInputStream();
			Adress adresse =
			    (Adress) jc.createUnmarshaller().unmarshal(xml);

			connection.disconnect();
			
			return adresse ; 
	}

	@Override
	public List<Adress> getListAdresse() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
}
