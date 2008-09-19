package org.hibersap.examples.flightlist;

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

import java.util.Date;

import org.hibersap.annotations.BapiStructure;
import org.hibersap.annotations.Parameter;
import org.hibersap.util.DateUtil;

/**
 * @author Carsten Erker
 */
@BapiStructure
public class Flight
{
    @Parameter(name = "CARRID")
    private String carrierId;

    @Parameter(name = "CONNID")
    private String connectionId;

    @Parameter(name = "AIRPFROM")
    private String airportFrom;

    @Parameter(name = "AIRPTO")
    private String airportTo;

    @Parameter(name = "FLDATE")
    private Date flightDate;

    @Parameter(name = "DEPTIME")
    private Date departureTime;

    @Parameter(name = "SEATSMAX")
    private int seatsMax;

    @Parameter(name = "SEATSOCC")
    private int seatsOccupied;

    public String getAirportFrom()
    {
        return this.airportFrom;
    }

    public String getAirportTo()
    {
        return this.airportTo;
    }

    public String getCarrierId()
    {
        return this.carrierId;
    }

    public String getConnectionId()
    {
        return this.connectionId;
    }

    public Date getDepartureTime()
    {
        return DateUtil.joinDateAndTime( flightDate, departureTime );
    }

    public Date getFlightDate()
    {
        return flightDate;
    }

    public int getSeatsMax()
    {
        return this.seatsMax;
    }

    // TODO remove setters

    public int getSeatsOccupied()
    {
        return this.seatsOccupied;
    }

    public void setAirportFrom( String airportFrom )
    {
        this.airportFrom = airportFrom;
    }

    public void setAirportTo( String airportTo )
    {
        this.airportTo = airportTo;
    }

    public void setCarrierId( String carrierId )
    {
        this.carrierId = carrierId;
    }

    public void setConnectionId( String connectionId )
    {
        this.connectionId = connectionId;
    }

    public void setDepartureTime( Date departureTime )
    {
        this.departureTime = departureTime;
    }

    public void setFlightDate( Date flightDate )
    {
        this.flightDate = flightDate;
    }

    public void setSeatsMax( int seatsMax )
    {
        this.seatsMax = seatsMax;
    }

    public void setSeatsOccupied( int seatsOccupied )
    {
        this.seatsOccupied = seatsOccupied;
    }
}
