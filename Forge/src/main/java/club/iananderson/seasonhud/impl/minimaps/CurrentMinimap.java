package club.iananderson.seasonhud.impl.minimaps;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;

import java.util.Objects;

import static club.iananderson.seasonhud.config.Config.enableMod;
import static club.iananderson.seasonhud.impl.sereneseasons.Calendar.calendar;
import static net.minecraft.world.level.Level.OVERWORLD;

public class CurrentMinimap {
    public static boolean loadedMinimap(String minimap){
        if(enableMod.get() && calendar() && !hideMinimap()){
            return ModList.get().isLoaded(minimap);
        }
        else return false;
    }

    public static boolean noMinimap(){
        if(!hideMinimap()) {
            return !loadedMinimap("xaerominimap")  && !loadedMinimap("xaerominimapfair")
                    && !loadedMinimap("journeymap") && !loadedMinimap("ftbchunks");
        }
        else return false;
    }

    public static boolean hideMinimap(){
        Minecraft mc = Minecraft.getInstance();
        ResourceKey<Level> currentDim = Objects.requireNonNull(mc.level).dimension();

        return currentDim != OVERWORLD;

    }
}
