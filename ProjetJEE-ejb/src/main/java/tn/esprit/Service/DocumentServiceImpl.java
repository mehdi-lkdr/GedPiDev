package tn.esprit.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Courrier;
import tn.esprit.entities.Document;

@Stateless
public class DocumentServiceImpl implements DocumentServiceLocal , DocumentServiceRemote {

	
	@PersistenceContext
	private EntityManager em;
	
	
	
	@Override
	public void saveDocument(Document doc) {
		// TODO Auto-generated method stub
		em.persist(doc);
	}

	@Override
	public void updateDocument(Document doc) {
		// TODO Auto-generated method stub
		em.merge(doc);
	}

	@Override
	public void deleteDocument(int docId) {
		// TODO Auto-generated method stub
		em.remove(getDocument(docId));
	}

	@Override
	public Document getDocument(int docId) {
		// TODO Auto-generated method stub
		return em.find(Document.class, docId);
	}

	@Override
	public List<Document> getDocumentList() {
		// TODO Auto-generated method stub
		return em.createQuery("select d from Document d", Document.class).getResultList() ; 
	}

}
