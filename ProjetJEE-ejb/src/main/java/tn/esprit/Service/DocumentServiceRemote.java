package tn.esprit.Service;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Document;


@Remote
public interface DocumentServiceRemote {
	
	
	public void saveDocument(Document doc) ; 
	public void updateDocument(Document doc) ; 
	public void deleteDocument(String docId) ; 
	public Document getDocument(String docId) ; 
	public List<Document> getDocumentList() ; 

}
