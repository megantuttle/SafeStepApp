package megantuttle.mysafestep.charting.interfaces.dataprovider;

import megantuttle.mysafestep.charting.data.BubbleData;

public interface BubbleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    BubbleData getBubbleData();
}
