package orion.core.search;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		String url = "http://localhost:8983/solr";
		// Make singleton in future
		SolrServer server = new CommonsHttpSolrServer( url );
	    SolrInputDocument doc1 = new SolrInputDocument();
	    doc1.addField( "id", "id5", 1.0f );
	    doc1.addField( "name", "doc4", 1.0f );
	    doc1.addField( "price", 10 );
	    server.add(doc1);
	    server.commit();
	    
	    
	    
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
