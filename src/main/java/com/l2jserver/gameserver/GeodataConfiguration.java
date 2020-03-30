/*
 * Copyright © 2004-2020 L2J Server
 *
 * This file is part of L2J Server.
 *
 * L2J Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * L2J Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.gameserver;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.aeonbits.owner.Config.HotReloadType.ASYNC;

import java.io.File;
import java.util.List;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.HotReload;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Mutable;
import org.aeonbits.owner.Reloadable;

/**
 * Geodata Configuration.
 * @author Zoey76
 * @version 2.6.1.0
 */
@Sources({
        "file:./config/geodata.properties",
        "classpath:config/geodata.properties"
})
@HotReload(value = 20, unit = MINUTES, type = ASYNC)
public interface GeodataConfiguration extends Config, Mutable, Reloadable {

    /**
     * Pathfinding options:
     * <ul>
     * <li>0 = Disabled</li>
     * <li>1 = Enabled using path node files</li>
     * <li>2 = Enabled using geodata cells at runtime</li>
     * </ul>
     * @return
     */
    @Key("PathFinding")
    Integer getPathFinding();

    @Key("PathnodePath")
    File getPathnodePath();

    @Key("PathFindBuffers")
    String getPathFindBuffers();

    @Key("LowWeight")
    Float getLowWeight();

    @Key("MediumWeight")
    Float getMediumWeight();

    @Key("HighWeight")
    Float getHighWeight();

    @Key("AdvancedDiagonalStrategy")
    Boolean advancedDiagonalStrategy();

    @Key("DiagonalWeight")
    Float getDiagonalWeight();

    @Key("MaxPostfilterPasses")
    Integer getMaxPostfilterPasses();

    @Key("DebugPath")
    Boolean debugPath();

    @Key("ForceGeoData")
    Boolean forceGeoData();

    @Key("CoordSynchronize")
    Integer getCoordSynchronize();

    @Key("GeoDataPath")
    File getGeoDataPath();

    @Key("TryLoadUnspecifiedRegions")
    Boolean tryLoadUnspecifiedRegions();

    @Separator(";")
    @Key("IncludedRegions")
    List<String> getIncludedRegions();

    @Separator(";")
    @Key("ExcludedRegions")
    List<String> getExcludedRegions();
}