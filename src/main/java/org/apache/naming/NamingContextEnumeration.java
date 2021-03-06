/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 


package org.apache.naming;

import java.util.Vector;
import java.util.Enumeration;
import javax.naming.NamingException;
import javax.naming.NamingEnumeration;
import javax.naming.NameClassPair;

/**
 * Naming enumeration implementation.
 *
 * @author Remy Maucherat
 * @version $Revision: 466595 $ $Date: 2006-10-21 23:24:41 +0100 (Sat, 21 Oct 2006) $
 */

public class NamingContextEnumeration 
    implements NamingEnumeration {


    // ----------------------------------------------------------- Constructors


    public NamingContextEnumeration(Vector entries) {
        enumeration = entries.elements();
    }


    public NamingContextEnumeration(Enumeration enumeration) {
        this.enumeration = enumeration;
    }


    // -------------------------------------------------------------- Variables


    /**
     * Underlying enumeration.
     */
    protected Enumeration enumeration;


    // --------------------------------------------------------- Public Methods


    /**
     * Retrieves the next element in the enumeration.
     */
    public Object next()
        throws NamingException {
        return nextElement();
    }


    /**
     * Determines whether there are any more elements in the enumeration.
     */
    public boolean hasMore()
        throws NamingException {
        return enumeration.hasMoreElements();
    }


    /**
     * Closes this enumeration.
     */
    public void close()
        throws NamingException {
    }


    public boolean hasMoreElements() {
        return enumeration.hasMoreElements();
    }


    public Object nextElement() {
        NamingEntry entry = (NamingEntry) enumeration.nextElement();
        return new NameClassPair(entry.name, entry.value.getClass().getName());
    }


}

