Special Features:

1) Fancy Movement: Blue Fighters begin all 3 levels by entering in a linear path and then looping in a circle before moving into formation.

2) Explosion Animation: Whenever a fighter or ship is hit then an explosion animation begins. This uses the KeyframeAnimator class from the
    programming extra-credit exercise we did in class to loop through series of explosion jpgs found on OpenGameArt.com.

    NOTE: If an enemy is exploding and hits the ship it still kills you. Likewise, if you get hit by a bullet or ship you can still move
          the ship-now-ball-off-fire to kamikaze an enemy fighter (but you can't fire anymore bullets).

3) Background Stars: In some versions of Galaga there are background stars that give the game a little more life and make it look like the action
    is moving. I implemented the background stars here by just painting 100 1x1 dots random colors and giving them a random position on the
    game panel. They then move vertically every time the panel updates. Once their Y position is greater than the frame height, it gets sets to 0
    so there is always the appearance of a continuous flow of stars.

Notes:
1. There is a point multiple by level. It's 10 pts x level.
2. Increase in difficulty by level is just more fighters with the total number of fighters on an attack run being the proportional to the level.

Glitches:
1. If your ship explodes for what appears to be no reason, it's because the explosion animation is on a dark frame and hit you (most likely).
2. Sometimes things explode twice for no apparent reason (likely hit with more than one bullet or something like that).
3. Played it enough times now that I believe I've worked out most of the bugs so hopefully there is no combination of events that causes it crash. For collisions,
    I had problems with comodifications if I wasn't using iterators. I believe I've elemented all the foreach-type iterations, but that may be a
    source on any crash.


Thanks! Enjoyed the class - Jake