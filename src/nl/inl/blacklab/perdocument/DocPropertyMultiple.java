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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * A collection of GroupProperty's identifying a particular group.
 */
public class DocPropertyMultiple extends DocProperty implements Iterable<DocProperty> {
	List<DocProperty> criteria;

	/**
	 * Quick way to create group criteria. Just call this method with the GroupCriterium object(s)
	 * you want.
	 *
	 * @param criteria
	 *            the desired criteria
	 */
	public DocPropertyMultiple(DocProperty... criteria) {
		this.criteria = new ArrayList<DocProperty>(Arrays.asList(criteria));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof DocPropertyMultiple) {
			return ((DocPropertyMultiple) obj).criteria.equals(criteria);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return criteria.hashCode();
	}

	public void addCriterium(DocProperty crit) {
		criteria.add(crit);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		int i = 0;
		for (DocProperty prop : criteria) {
			if (i > 0)
				str.append(",");
			str.append(prop.toString());
			i++;
		}
		return str.toString();
	}

	@Override
	public Iterator<DocProperty> iterator() {
		return criteria.iterator();
	}

	@Override
	public String get(DocResult result) {
		StringBuilder b = new StringBuilder();
		for (DocProperty crit : criteria) {
			if (b.length() > 0)
				b.append(";");
			b.append(crit.get(result));
		}
		return b.toString();
	}

	@Override
	public String getHumanReadable(DocResult result) {
		StringBuilder b = new StringBuilder();
		for (DocProperty crit : criteria) {
			if (b.length() > 0)
				b.append(", ");
			b.append(crit.getHumanReadable(result));
		}
		return b.toString();
	}

	@Override
	public String getName() {
		StringBuilder b = new StringBuilder();
		for (DocProperty crit : criteria) {
			if (b.length() > 0)
				b.append(", ");
			b.append(crit.getName());
		}
		return b.toString();
	}

}
