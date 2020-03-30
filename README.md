# l2j-geoserver-rest
Use L2j GeoData &amp; Pathfinding over REST API

## API

### `/canSeeTarget?&x=&y=&z=&tx=&ty=&tz=`

```json
{"canSee": true}
```

### `/findPath?&x=&y=&z=&tx=&ty=&tz=`

``` json
[
   {
      "x":-81256,
      "z":-3120,
      "y":150184,
      "nodeX":35881,
      "nodeY":46250
   },
   {
      "x":-84536,
      "z":-3120,
      "y":150872,
      "nodeX":35676,
      "nodeY":46293
   }
]
```

## Credits

This project is heavily based on [L2J Server](https://www.l2jserver.com/) source code, whole GeoData logic was extracted and exposed via JSON REST API. I would like to thank to whole L2J Team to making this possible.
