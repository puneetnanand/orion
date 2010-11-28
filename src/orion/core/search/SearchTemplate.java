package orion.core.search;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;

public abstract class SearchTemplate {
	protected static String solrUrl = "http://localhost:8983/solr";
	private static SolrServer solrServer;

	protected static SolrServer getSolrServer() {
		if (solrServer == null) {
			try {
				solrServer = new CommonsHttpSolrServer(solrUrl);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error while instantiating solr server.");
			}
		}
		return solrServer;
	}
}
