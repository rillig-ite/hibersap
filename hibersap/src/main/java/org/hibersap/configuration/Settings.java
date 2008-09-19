package org.hibersap.configuration;

/*
 * Copyright (C) 2008 akquinet tech@spree GmbH
 * 
 * This file is part of Hibersap.
 * 
 * Hibersap is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * 
 * Hibersap is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with Hibersap. If
 * not, see <http://www.gnu.org/licenses/>.
 */

import org.hibersap.execution.Connection;
import org.hibersap.session.Context;

/**
 * @author Carsten Erker
 */
public final class Settings
{
    Context context;

    Class<? extends Connection> connectionClass;

    public Class<? extends Connection> getConnectionClass()
    {
        return connectionClass;
    }

    public Context getContext()
    {
        return context;
    }

    public void setConnectionClass( Class<? extends Connection> connectionClass )
    {
        this.connectionClass = connectionClass;
    }

    public void setContext( Context context )
    {
        this.context = context;
    }
}
