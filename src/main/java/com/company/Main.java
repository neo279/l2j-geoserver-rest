package com.company;

import com.l2jserver.gameserver.GeoData;
import com.l2jserver.gameserver.pathfinding.PathFinding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.l2jserver.gameserver.config.Configuration.geodata;

@SpringBootApplication
public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        GeoData.getInstance();

        if (geodata().getPathFinding() > 0) {
            PathFinding.getInstance();
        }

        var x = -80733;
        var y=149886;var z=-3040;var tx=-84540;var ty=150879; var tz=-3120;

        var list = PathFinding.getInstance().findPath(x,y,z,tx,ty,tz, 0, true);

        if (list != null) {
            for (var a : list) {
                LOG.info("found path {} {} {}", a.getX(), a.getY(), a.getZ());
            }
        } else {
            LOG.warn("Could not find path for given");
        }

        SpringApplication.run(Main.class, args);
    }
}
