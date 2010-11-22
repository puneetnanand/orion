package orion.core.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.analysis.snowball.SnowballAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.util.AttributeImpl;
import org.apache.lucene.util.AttributeSource.State;
import org.apache.lucene.util.Version;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import java.util.Set;


public class SearchUtil {
	public static void main (String args[]) {
		try {
		StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);
		//StandardFilter filter = new StandardFilter();
		Reader reader = new StringReader("digested singing internet and am what :) ''whatda hahaha");
/*  		Iterator iterator = analyzer.STOP_WORDS_SET.iterator();
		while (iterator.hasNext()) {
			String word = (String)iterator.next();
			System.out.println(word);
		}*/
		
/*		TokenStream tokenStream = analyzer.tokenStream("", reader);
		OffsetAttribute offsetAttribute = tokenStream.getAttribute(OffsetAttribute.class);
		TermAttribute termAttribute = tokenStream.getAttribute(TermAttribute.class);

		while (tokenStream.incrementToken()) {
		    int startOffset = offsetAttribute.startOffset();
		    int endOffset = offsetAttribute.endOffset();
		    String term = termAttribute.term();
		    System.out.println(term);
		}
		
		reader.reset();*/
		HashSet<String> setOfStopWords = new HashSet<String>();
		setOfStopWords.add("and");
		setOfStopWords.add("what");
		SnowballAnalyzer sAnalyzer = new SnowballAnalyzer(Version.LUCENE_30, "English", setOfStopWords);
		TokenStream tokenStream2 = sAnalyzer.tokenStream("", reader);
		tokenStream2.reset();
		OffsetAttribute offsetAttribute2 = tokenStream2.getAttribute(OffsetAttribute.class);
		TermAttribute termAttribute2 = tokenStream2.getAttribute(TermAttribute.class);

		while (tokenStream2.incrementToken()) {
		    int startOffset = offsetAttribute2.startOffset();
		    int endOffset = offsetAttribute2.endOffset();
		    String term = termAttribute2.term();
		    System.out.println(term);
		}

		
/*	    TokenStream tokenStream = analyzer.tokenStream("", reader);
	    tokenStream.reset();
	    Iterator i1 = tokenStream.getAttributeClassesIterator();
	    while (i1.hasNext()) {
	    	Object o = i1.next();
	    	Class c = (Class)o;
	    	System.out.println(c.getName());
	    }
	    
	    tokenStream.reset();
	    Iterator i2 = tokenStream.getAttributeImplsIterator();
	    while (i2.hasNext()) {
	    	AttributeImpl impl = (AttributeImpl)i2.next();
	    	System.out.println(impl.toString());
	    }*/
	    
	    
	    
	    /*	    System.out.println(tokenStream.incrementToken());
	    Iterator<AttributeImpl> i = tokenStream.getAttributeImplsIterator();
	    while (tokenStream.incrementToken()) {
	    	token = tokenStream.
	    	System.out.println(token.term());
	    }*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}