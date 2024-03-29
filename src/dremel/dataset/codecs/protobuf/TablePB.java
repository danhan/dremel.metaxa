/**
 * Copyright 2010, BigDataCraft.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dremel.dataset.codecs.protobuf;

import com.google.protobuf.Descriptors.Descriptor;

import dremel.dataset.codecs.protobuf.Schema.Document;
import dremel.dataset.impl.TableImpl;

/**
 * @author Constantine Peresypkin
 *
 */
public class TablePB extends TableImpl {

	
	private Descriptor descriptor;

	/**
	 * @param name
	 */
	public TablePB(String name) {
		super(name);
		if (name.equalsIgnoreCase("[document]"))
			descriptor = Document.getDescriptor();
	}
	
	String getFieldName(String name) {
		// input schema.Document.*
		// trim prefix: schema.Document.
		int p = name.indexOf('.');
		if (p > 0) {
			p = name.indexOf('.', p + 1);
			if (p > 0) {
				name = name.substring(p + 1);
			}
		}
		return name;
	}
}
