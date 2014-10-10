/*
 * Copyright (c) 2008-2014 akquinet tech@spree GmbH
 *
 * This file is part of Hibersap.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this software except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hibersap.it.bapi;

import org.hibersap.annotations.Bapi;
import org.hibersap.annotations.Export;
import org.hibersap.annotations.Import;
import org.hibersap.annotations.Parameter;
import org.hibersap.it.AbstractBapiTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.hibersap.annotations.ParameterType.TABLE_STRUCTURE;

public class MapTablesInImportAndExportParametersTest extends AbstractBapiTest {

    @Test
    public void bapiWithTableInStructure() throws Exception {

        CarListBapi bapi = new CarListBapi();
        bapi.addCarImport( "Alfa Romeo", "Spider", 2 );
        bapi.addCarImport( "Kia", "cee'd", 5 );

        session.execute( bapi );

        assertThat( bapi.carsExport ).onProperty( "manufacturer" ).containsExactly( "Alfa Romeo", "Kia" );
        assertThat( bapi.carsExport ).onProperty( "model" ).containsExactly( "Spider", "cee'd" );
        assertThat( bapi.carsExport ).onProperty( "numberOfSeats" ).containsExactly( 2, 5 );
    }

    @Bapi( "Z_CAR_LIST" )
    public static class CarListBapi {

        @Import
        @Parameter( value = "I_CARS", type = TABLE_STRUCTURE )
        private List<Car> carsImport = new ArrayList<Car>();

        @Export
        @Parameter( value = "E_CARS", type = TABLE_STRUCTURE )
        private List<Car> carsExport;

        public void addCarImport( String manufacturer, String model, int numberOfSeats ) {
            carsImport.add( new Car( manufacturer, model, numberOfSeats ) );
        }
    }

    public static class Car {

        @Parameter( "MANUFACTURER" )
        private String manufacturer;

        @Parameter( "MODEL" )
        private String model;

        @Parameter( "NUM_SEATS" )
        private int numberOfSeats;

        private Car() {
            // needed by Hibersap
        }

        public Car( String manufacturer, String model, int numberOfSeats ) {

            this.manufacturer = manufacturer;
            this.model = model;
            this.numberOfSeats = numberOfSeats;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public String getModel() {
            return model;
        }

        public int getNumberOfSeats() {
            return numberOfSeats;
        }
    }
}
