package ch.sebastianm.dynamicconf.main.models.UIModels.SwitchControls;

import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.WifiManager;

import java.util.HashSet;
import java.util.Set;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;
import ch.sebastianm.dynamicconf.main.listeners.BroadcastListener;
import ch.sebastianm.dynamicconf.main.listeners.RingModeChangeListener;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class RingModeSilence extends SwitchControls {

    DynamicConfConstantes constantes = new DynamicConfConstantes();

    @Override
    public String getId(){
        return constantes.RINGMODESILENCESWTID;
    }

    @Override
    public String getTitel(Context con) {
        return con.getResources().getString(R.string.title_switch_silence);
    }


    @Override
    public void setBusinessLogic(Boolean bool, Context con) {
        AudioManager audioManager = (AudioManager) con.getSystemService(Context.AUDIO_SERVICE);
        if(bool)
            audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        else if(audioManager.getRingerMode() == AudioManager.RINGER_MODE_SILENT)
            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);

    }

    @Override
    public Boolean getState(Context con) {
        AudioManager audioManager = (AudioManager) con.getSystemService(Context.AUDIO_SERVICE);
        return (audioManager.getRingerMode() == AudioManager.RINGER_MODE_SILENT);
    }

    @Override
    public Set<BroadcastListener> getListeners(Context con){
        Set<BroadcastListener> bcl =  new HashSet<BroadcastListener>();
        bcl.add(new RingModeChangeListener());
        return bcl;
    }

}
