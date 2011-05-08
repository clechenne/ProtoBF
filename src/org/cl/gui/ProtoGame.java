package org.cl.gui;

import org.cl.model.Game;
import org.cl.model.Level;
import org.cl.model.Point;
import org.cl.model.Ship;
import org.cl.model.Side;
import org.cl.model.Type;
import org.cl.model.Weapon;
import org.cl.util.WeaponReader;

public class ProtoGame extends Game {
	
	public ProtoGame() {
		
		ships = new Ship[4];
		
		ships[0] = new Ship(0, Type.BB, 18);
		ships[0].name = "Mikasa";
		ships[0].pos = new Point(50, 50);
		ships[0].heading = 90;
		ships[0].currentSpeedBox = 2;
		ships[0].side = Side.JAPENESE;
		ships[0].size = 60;
		ships[0].armorVitals = 15;
		ships[0].armorUpperworks = 6;
		ships[0].upperworksProtection = Level.GREAT;
		ships[0].floodProtection = Level.GREAT;
		ships[0].stability = Level.GOOD;
		ships[0].seawayRating = Level.NORMAL;
		ships[0].weapons = new Weapon[1];
		ships[0].weapons[0] = WeaponReader.parse("4#30cm#MAIN#60#1#16#13#10");
		
		ships[1] = new Ship(1, Type.BB, 18);
		ships[1].name = "BB2";
		ships[1].pos = new Point(75, 50);
		ships[1].heading = 90;
		ships[1].currentSpeedBox = 2;
		ships[1].side = Side.JAPENESE;
		ships[1].weapons = new Weapon[1];
		ships[1].weapons[0] = WeaponReader.parse("4#30cm#MAIN#60#1#16#13#10");
		
		ships[2] = new Ship(2, Type.BB, 18);
		ships[2].name = "BB1";
		ships[2].pos = new Point(200, 200);
		ships[2].heading = 270;
		ships[2].currentSpeedBox = 2;
		ships[2].side = Side.RUSSIAN;
		
		ships[3] = new Ship(3, Type.BB, 18);
		ships[3].name = "BB2";
		ships[3].pos = new Point(225, 200);
		ships[3].heading = 270;
		ships[3].currentSpeedBox = 2;
		ships[3].side = Side.RUSSIAN;		
	}
}
