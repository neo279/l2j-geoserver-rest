package com.company;

import java.util.List;

import com.l2jserver.gameserver.GeoData;
import com.l2jserver.gameserver.pathfinding.AbstractNodeLoc;
import com.l2jserver.gameserver.pathfinding.PathFinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

class CanSeeTarget {

    public boolean canSee;

    CanSeeTarget(boolean canSee) {
        this.canSee = canSee;
    }
}

@RestController
public class GreetingController {

    private static final Logger LOG = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/findPath")
    public List<AbstractNodeLoc> findPath(
            @RequestParam() int x,
            @RequestParam() int y,
            @RequestParam() int z,
            @RequestParam() int tx,
            @RequestParam() int ty,
            @RequestParam() int tz
    ) {
        var list = PathFinding.getInstance().findPath(x, y, z, tx, ty, tz, 0, true);

        LOG.info("returned {} paths", list != null ? list.size() : 0);
        LOG.info(String.join("\n", PathFinding.getInstance().getStat()));

        return list;
    }

    @GetMapping("/canSeeTarget")
    public CanSeeTarget canSeeTarget(
            @RequestParam() int x,
            @RequestParam() int y,
            @RequestParam() int z,
            @RequestParam() int tx,
            @RequestParam() int ty,
            @RequestParam() int tz
    ) {
        var res = GeoData.getInstance().canSeeTarget(x, y, z, tx, ty, tz);

        return new CanSeeTarget(res);
    }
}
