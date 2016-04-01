package megantuttle.mysafestep.charting.interfaces.dataprovider;

import megantuttle.mysafestep.charting.components.YAxis;
import megantuttle.mysafestep.charting.data.LineData;

public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}
