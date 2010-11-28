package orion.core.search.impl;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

import orion.core.models.User;
import orion.core.models.UserSkill;
import orion.core.search.SearchTemplate;

public class UserSearchImpl extends SearchTemplate{

	public static boolean index(User user, String[] skills, String[] experiences) {
		SolrServer server = getSolrServer();
		SolrInputDocument document = new SolrInputDocument();
		document.addField("userName", user.getUserName());
		
		int size = skills.length;
		for (int i=0; i<size; i++) {
			document.addField("skill", skills[i]);
			document.addField("experience", experiences[i]);
		}		

		try {
			server.add(document);
			UpdateResponse r = server.commit();
			System.out.println("Printing solr response "+r.getStatus());
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}