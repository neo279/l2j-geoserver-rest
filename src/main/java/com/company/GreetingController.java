package com.company;

import java.util.List;

import com.l2jserver.gameserver.GeoData;
import com.l2jserver.gameserver.pathfinding.AbstractNodeLoc;
import com.l2jserver.gameserver.pathfinding.PathFinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.l2jserver.gameserver.config.Configuration.geodata;

class CanSeeTarget {

    public boolean canSee;

    CanSeeTarget(boolean canSee) {
        this.canSee = canSee;
    }
}

class CanMove {

    public boolean canMove;

    CanMove(boolean canMove) {
        this.canMove = canMove;
    }
}

class Loc extends AbstractNodeLoc {

    private int X;
    private int Y;
    private int Z;

    Loc(int x, int y, int z) {
        this.X = x;
        this.Y = y;
        this.Z = z;
    }

    @Override
    public int getX() {
        return this.X;
    }

    @Override
    public int getY() {
        return this.Y;
    }

    @Override
    public int getZ() {
        return this.Z;
    }

    @Override
    public void setZ(short z) {
        this.Z = z;
    }

    @Override
    public int getNodeX() {
        return 0;
    }

    @Override
    public int getNodeY() {
        return 0;
    }
}


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "path not found")
class PathNotFound extends RuntimeException {
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
        if (geodata().getPathFinding() == 0) {
            throw new PathNotFound();
        }

        var list = PathFinding.getInstance().findPath(x, y, z, tx, ty, tz, 0, true);

        LOG.info("{} {} {} -> {} {} {} => returned {} paths", x, y, z, tx, ty, tz, list != null ? list.size() : 0);

        if (list == null || list.size() == 0) {
            throw new PathNotFound();
        }

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

    @GetMapping("/canMove")
    public CanMove canMove(
            @RequestParam() int x,
            @RequestParam() int y,
            @RequestParam() int z,
            @RequestParam() int tx,
            @RequestParam() int ty,
            @RequestParam() int tz
    ) {
        var res = GeoData.getInstance().canMove(x, y, z, tx, ty, tz, 0);

        return new CanMove(res);
    }

    @GetMapping("/moveCheck")
    public AbstractNodeLoc moveCheck(
            @RequestParam() int x,
            @RequestParam() int y,
            @RequestParam() int z,
            @RequestParam() int tx,
            @RequestParam() int ty,
            @RequestParam() int tz
    ) {
        var loc = GeoData.getInstance().moveCheck(x, y, z, tx, ty, tz, 0);

        if (loc == null) {
            throw new PathNotFound();
        }

        return new Loc(loc.getX(), loc.getY(), loc.getZ());
    }

    @GetMapping("/stats")
    public String stats() {
        return String.join("\n", PathFinding.getInstance().getStat());
    }
}
