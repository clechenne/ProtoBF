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
		
		ships = new Ship[2];
		
		ships[0] = new Ship(0, Type.BB, 18);
		ships[0].name = "Mikasa";
		ships[0].pos = new Point(100, 100);
		ships[0].heading = 45;
		ships[0].currentSpeedBox = 2;
		ships[0].side = Side.JAPENESE;
		ships[0].size = 60;
		ships[0].armorVitals = 15;
		ships[0].armorUpperworks = 6;
		ships[0].upperworksProtection = Level.GREAT;
		ships[0].floodProtection = Level.GREAT;
		ships[0].stability = Level.GOOD;
		ships[0].seawayRating = Level.NORMAL;
		ships[0].weapons = new Weapon[2];
		ships[0].weapons[0] = WeaponReader.parse("4#30cm#MAIN#60#1#16#13#10#A-Z");
		ships[0].weapons[1] = WeaponReader.parse("14#15cm#SECONDARY#7#2#5#3#2#2");
				
		ships[1] = new Ship(2, Type.BB, 18);
		ships[1].name = "Borodino";
		ships[1].pos = new Point(200, 200);
		ships[1].heading = 270;
		ships[1].currentSpeedBox = 2;
		ships[1].side = Side.RUSSIAN;
		ships[1].size = 60;
		ships[1].armorVitals = 13;
		ships[1].armorUpperworks = 4;
		ships[1].upperworksProtection = Level.GOOD;
		ships[1].floodProtection = Level.GREAT;
		ships[1].stability = Level.POOR;
		ships[1].seawayRating = Level.NORMAL;
		ships[1].weapons = new Weapon[2];
		//Quantity-Type:×4 - 30cm Main Size:50  ROF:1  Penetration:17-13-9  Positions:A Z
		ships[1].weapons[0] = WeaponReader.parse("4#30cm#MAIN#50#1#17#13#9#A-Z");
		//Quantity-Type:×12 - 15cm Secondary  Size:6  ROF:2  Penetration:6-4-2  Positions:DE PR VW
		ships[1].weapons[1] = WeaponReader.parse("12#15cm#SECONDARY#6#2#6#4#2#D-E-P-R-V-W");

	}
}
