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
package nl.inl.blacklab.perdocument;

/**
 * For grouping DocResult objects on the number of hits. This would put documents with 1 hit in a
 * group, documents with 2 hits in another group, etc.
 */
public class DocPropertyNumberOfHits extends DocProperty {
	@Override
	public String get(DocResult result) {
		return String.format("%5d", result.getHits().size());
	}

	@Override
	public boolean defaultSortDescending() {
		return true;
	}

	@Override
	public String getName() {
		return "number of hits";
	}
}
