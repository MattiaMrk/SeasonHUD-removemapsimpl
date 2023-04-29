package club.iananderson.seasonhud.impl.minimaps;

import journeymap.client.api.IClientAPI;

@journeymap.client.api.ClientPlugin
public abstract class JourneyMapAPI implements IClientAPI {
    private IClientAPI jmAPI = null;
    private static JourneyMapAPI INSTANCE;

    public static JourneyMapAPI getInstance(){
        return INSTANCE;
    }
}
