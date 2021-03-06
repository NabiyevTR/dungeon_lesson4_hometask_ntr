package ru.geekbrains.dungeon.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import org.graalvm.compiler.loop.MathUtil;
import ru.geekbrains.dungeon.BattleCalc;
import ru.geekbrains.dungeon.GameController;
import ru.geekbrains.dungeon.GameMap;

public class Hero extends Unit {
    public Hero(TextureAtlas atlas, GameController gc) {
        super(gc, 1, 1, 10);
        this.hpMax = 100;
        this.hp = this.hpMax;
        this.texture = atlas.findRegion("knight");
        this.textureHp = atlas.findRegion("hp");
    }

    public void update(float dt) {
        super.update(dt);
        if (Gdx.input.justTouched() && canIMakeAction()) {
            Monster m = gc.getUnitController().getMonsterController().getMonsterInCell(gc.getCursorX(), gc.getCursorY());
            if (m != null && canIAttackThisTarget(m)) {
                attack(m);
            } else {
                goTo(gc.getCursorX(), gc.getCursorY());
            }
        }
    }
}
