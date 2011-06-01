package org.cl.model.hit;

import java.util.List;

import org.cl.model.Damage;

public interface Hit {

	List<Damage> getDamages();

	void addDamage(Damage nt);

}
