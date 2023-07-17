package com.terraformersmc.terrestria.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod("terrestria_client")
public class TerrestriaClientMod {
	public TerrestriaClientMod(){
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> TerrestriaClient::new);
	}
}
