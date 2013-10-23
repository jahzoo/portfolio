package name.abuchen.portfolio.snapshot;

import java.util.ArrayList;
import java.util.List;

import name.abuchen.portfolio.model.Classification;

public class AssetCategory
{
    private final Classification classification;
    private final List<AssetPosition> positions = new ArrayList<AssetPosition>();
    private final long totalAssets;
    private long valuation = 0;
    private long purchasevalue = 0;
    
    /* package */AssetCategory(Classification classification, long totalAssets)
    {
        this.classification = classification;
        this.totalAssets = totalAssets;
    }

    public long getValuation()
    {
        return this.valuation;
    }
    
    public long getPurchaseValue()
    {
        return this.purchasevalue;
    }

    public long getProfitLoss()
    {
        return this.valuation-this.purchasevalue;
    }
    
    protected void setValuation(long valuation)
    {
        this.valuation = valuation;
    }

    protected void setPurchaseValue(long purchasevalue)
    {
        this.purchasevalue = purchasevalue;
    }

    public double getShare()
    {
        return (double) this.valuation / (double) this.totalAssets;
    }

    public Classification getClassification()
    {
        return this.classification;
    }

    public List<AssetPosition> getPositions()
    {
        return positions;
    }

    public void addPosition(AssetPosition p)
    {
        this.positions.add(p);
        this.valuation += p.getValuation();
        this.purchasevalue += p.getPurchaseValue();
    }
}
