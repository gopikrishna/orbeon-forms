/**
 *  Copyright (C) 2004 Orbeon, Inc.
 *
 *  This program is free software; you can redistribute it and/or modify it under the terms of the
 *  GNU Lesser General Public License as published by the Free Software Foundation; either version
 *  2.1 of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU Lesser General Public License for more details.
 *
 *  The full text of the license is available at http://www.gnu.org/copyleft/lesser.html
 */
package org.orbeon.oxf.transformer.xupdate.statement;

import org.apache.log4j.Logger;
import org.orbeon.oxf.transformer.xupdate.Statement;
import org.orbeon.oxf.transformer.xupdate.VariableContextImpl;
import org.orbeon.oxf.transformer.xupdate.DocumentContext;
import org.orbeon.oxf.util.LoggerFactory;
import org.orbeon.oxf.xml.dom4j.LocationData;

import javax.xml.transform.URIResolver;
import java.util.Collections;

public class Message extends Statement {

    static private Logger logger = LoggerFactory.createLogger(Message.class);
    private Statement[] statements;

    public Message(LocationData locationData, Statement[] statements) {
        super(locationData);
        this.statements = statements;
    }

    public Object execute(URIResolver uriResolver, Object context, VariableContextImpl variableContext, DocumentContext documentContext) {
        Object statementsResult = Utils.execute(uriResolver, context, variableContext, documentContext, statements);
        if (logger.isInfoEnabled()) {
            logger.info(Utils.xpathObjectToString(statementsResult));
        }
        return Collections.EMPTY_LIST;
    }
}
