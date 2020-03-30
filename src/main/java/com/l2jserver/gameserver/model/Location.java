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
package com.l2jserver.gameserver.model;

import com.l2jserver.gameserver.ILocational;
import com.l2jserver.gameserver.IPositionable;

/**
 * Location data transfer object.<br>
 * Contains coordinates data, heading and instance Id.
 * @author Zoey76
 */
public class Location implements IPositionable {
    private int _x;
    private int _y;
    private int _z;
    private int _heading;
    private int _instanceId;

    public Location(int x, int y, int z) {
        this(x, y, z, 0, -1);
    }

    public Location(int x, int y, int z, int heading) {
        this(x, y, z, heading, -1);
    }

//    public Location(L2Object obj) {
//        this(obj.getX(), obj.getY(), obj.getZ(), obj.getHeading(), obj.getInstanceId());
//    }

    public Location(int x, int y, int z, int heading, int instanceId) {
        _x = x;
        _y = y;
        _z = z;
        _heading = heading;
        _instanceId = instanceId;
    }

    /**
     * Get the x coordinate.
     * @return the x coordinate
     */
    @Override
    public int getX() {
        return _x;
    }

    /**
     * Set the x coordinate.
     * @param x the x coordinate
     */
    @Override
    public void setX(int x) {
        _x = x;
    }

    /**
     * Get the y coordinate.
     * @return the y coordinate
     */
    @Override
    public int getY() {
        return _y;
    }

    /**
     * Set the y coordinate.
     * @param y the x coordinate
     */
    @Override
    public void setY(int y) {
        _y = y;
    }

    /**
     * Get the z coordinate.
     * @return the z coordinate
     */
    @Override
    public int getZ() {
        return _z;
    }

    /**
     * Set the z coordinate.
     * @param z the z coordinate
     */
    @Override
    public void setZ(int z) {
        _z = z;
    }

    /**
     * Set the x, y, z coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     */
    @Override
    public void setXYZ(int x, int y, int z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    /**
     * Set the x, y, z coordinates.
     * @param loc The location.
     */
    @Override
    public void setXYZ(ILocational loc) {
        setXYZ(loc.getX(), loc.getY(), loc.getZ());
    }

    /**
     * Get the heading.
     * @return the heading
     */
    @Override
    public int getHeading() {
        return _heading;
    }

    /**
     * Set the heading.
     * @param heading the heading
     */
    @Override
    public void setHeading(int heading) {
        _heading = heading;
    }

    /**
     * Get the instance Id.
     * @return the instance Id
     */
    @Override
    public int getInstanceId() {
        return _instanceId;
    }

    /**
     * Set the instance Id.
     * @param instanceId the instance Id to set
     */
    @Override
    public void setInstanceId(int instanceId) {
        _instanceId = instanceId;
    }

    @Override
    public IPositionable getLocation() {
        return this;
    }

    @Override
    public void setLocation(Location loc) {
        _x = loc.getX();
        _y = loc.getY();
        _z = loc.getZ();
        _heading = loc.getHeading();
        _instanceId = loc.getInstanceId();
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj != null) && (obj instanceof Location)) {
            final Location loc = (Location) obj;
            return (getX() == loc.getX()) && (getY() == loc.getY()) && (getZ() == loc.getZ()) && (getHeading() == loc.getHeading()) && (getInstanceId() == loc.getInstanceId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + getClass().getSimpleName() + "] X: " + getX() + " Y: " + getY() + " Z: " + getZ() + " Heading: " + _heading + " InstanceId: " + _instanceId;
    }
}
