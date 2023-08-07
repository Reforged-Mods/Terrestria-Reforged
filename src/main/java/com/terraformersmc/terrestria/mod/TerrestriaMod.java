package com.terraformersmc.terrestria.mod;

import com.terraformersmc.terrestria.Terrestria;
import com.terraformersmc.terrestria.client.TerrestriaClientMod;
import com.terraformersmc.terrestria.worldgen.TerrestriaWorldgen;
import net.minecraftforge.fml.common.Mod;

@Mod(Terrestria.MOD_ID)
public class TerrestriaMod {

	public TerrestriaMod(){
		new Terrestria();
		new TerrestriaWorldgen();
		new TerrestriaClientMod();
	}
}
