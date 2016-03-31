
package megantuttle.mysafestep.charting.buffer;

import megantuttle.mysafestep.charting.data.Entry;
import megantuttle.mysafestep.charting.interfaces.datasets.IScatterDataSet;

public class ScatterBuffer extends AbstractBuffer<IScatterDataSet> {
    
    public ScatterBuffer(int size) {
        super(size);
    }

    protected void addForm(float x, float y) {
        buffer[index++] = x;
        buffer[index++] = y;
    }

    @Override
    public void feed(IScatterDataSet data) {
        
        float size = data.getEntryCount() * phaseX;
        
        for (int i = 0; i < size; i++) {

            Entry e = data.getEntryForIndex(i);
            addForm(e.getXIndex(), e.getVal() * phaseY);
        }
        
        reset();
    }
}
