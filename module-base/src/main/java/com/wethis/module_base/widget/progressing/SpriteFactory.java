package com.wethis.module_base.widget.progressing;


import com.wethis.module_base.widget.progressing.sprite.Sprite;
import com.wethis.module_base.widget.progressing.style.ChasingDots;
import com.wethis.module_base.widget.progressing.style.Circle;
import com.wethis.module_base.widget.progressing.style.CubeGrid;
import com.wethis.module_base.widget.progressing.style.DoubleBounce;
import com.wethis.module_base.widget.progressing.style.FadingCircle;
import com.wethis.module_base.widget.progressing.style.FoldingCube;
import com.wethis.module_base.widget.progressing.style.MultiplePulse;
import com.wethis.module_base.widget.progressing.style.MultiplePulseRing;
import com.wethis.module_base.widget.progressing.style.Pulse;
import com.wethis.module_base.widget.progressing.style.PulseRing;
import com.wethis.module_base.widget.progressing.style.RotatingCircle;
import com.wethis.module_base.widget.progressing.style.RotatingPlane;
import com.wethis.module_base.widget.progressing.style.ThreeBounce;
import com.wethis.module_base.widget.progressing.style.WanderingCubes;
import com.wethis.module_base.widget.progressing.style.Wave;

/**
 * Created by ybq.
 */
public class SpriteFactory {

    public static Sprite create(Style style) {
        Sprite sprite = null;
        switch (style) {
            case ROTATING_PLANE:
                sprite = new RotatingPlane();
                break;
            case DOUBLE_BOUNCE:
                sprite = new DoubleBounce();
                break;
            case WAVE:
                sprite = new Wave();
                break;
            case WANDERING_CUBES:
                sprite = new WanderingCubes();
                break;
            case PULSE:
                sprite = new Pulse();
                break;
            case CHASING_DOTS:
                sprite = new ChasingDots();
                break;
            case THREE_BOUNCE:
                sprite = new ThreeBounce();
                break;
            case CIRCLE:
                sprite = new Circle();
                break;
            case CUBE_GRID:
                sprite = new CubeGrid();
                break;
            case FADING_CIRCLE:
                sprite = new FadingCircle();
                break;
            case FOLDING_CUBE:
                sprite = new FoldingCube();
                break;
            case ROTATING_CIRCLE:
                sprite = new RotatingCircle();
                break;
            case MULTIPLE_PULSE:
                sprite = new MultiplePulse();
                break;
            case PULSE_RING:
                sprite = new PulseRing();
                break;
            case MULTIPLE_PULSE_RING:
                sprite = new MultiplePulseRing();
                break;
            default:
                break;
        }
        return sprite;
    }
}
