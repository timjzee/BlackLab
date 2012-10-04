/*******************************************************************************
 * Copyright (c) 2010, 2012 Institute for Dutch Lexicology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package nl.inl.blacklab.indexers.anwcorpus;

import java.io.File;
import java.util.Properties;

import nl.inl.blacklab.index.Indexer;
import nl.inl.util.PropertiesUtil;

/**
 * The indexer class and main program for the ANW corpus.
 */
public class IndexAnwCorpus {
	public static void main(String[] args) throws Exception {
		// Read property file
		Properties properties = PropertiesUtil.getFromResource("anwcorpus.properties");

		// Where to create the index and UTF-16 content
		File indexDir = PropertiesUtil.getFileProp(properties, "indexDir", null);
		if (!indexDir.isDirectory())
			indexDir.mkdir();

		// Where the source files are
		File inputDir = PropertiesUtil.getFileProp(properties, "inputDir", null);

		// The indexer tool
		Indexer indexer = new Indexer(indexDir, true, DocIndexerXmlAnw.class);
		try {
			// How many documents to process (0 = all of them)
			int maxDocs = PropertiesUtil.getIntProp(properties, "maxDocs", 0);
			if (maxDocs > 0)
				indexer.setMaxDocs(maxDocs);

			// Index a directory
			indexer.indexDir(inputDir, false);

			// Test: just one large file
			// File largeFile = new File(inputDir, "ANW_Kranten-versie2.1 (4).xml");
			// indexer.indexFile(largeFile, factory);
		} catch (Exception e) {
			System.err.println("An error occurred, aborting indexing. Error details follow.");
			e.printStackTrace();
		} finally {
			// Finalize and close the index.
			// This method also takes care of saved lemmatization information (for quick lookups of
			// word forms).
			indexer.close();
		}
	}
}
