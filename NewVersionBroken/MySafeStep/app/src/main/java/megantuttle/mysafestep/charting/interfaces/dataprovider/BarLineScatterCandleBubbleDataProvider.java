package megantuttle.mysafestep.charting.interfaces.dataprovider;

import megantuttle.mysafestep.charting.components.YAxis.AxisDependency;
import megantuttle.mysafestep.charting.data.BarLineScatterCandleBubbleData;
import megantuttle.mysafestep.charting.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {

    Transformer getTransformer(AxisDependency axis);
    int getMaxVisibleCount();
    boolean isInverted(AxisDependency axis);
    
    int getLowestVisibleXIndex();
    int getHighestVisibleXIndex();

    BarLineScatterCandleBubbleData getData();
}
