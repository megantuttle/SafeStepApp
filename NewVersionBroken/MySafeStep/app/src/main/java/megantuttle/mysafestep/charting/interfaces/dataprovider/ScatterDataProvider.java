package megantuttle.mysafestep.charting.interfaces.dataprovider;

import megantuttle.mysafestep.charting.data.ScatterData;

public interface ScatterDataProvider extends BarLineScatterCandleBubbleDataProvider {

    ScatterData getScatterData();
}
