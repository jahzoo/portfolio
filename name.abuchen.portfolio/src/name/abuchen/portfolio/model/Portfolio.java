package name.abuchen.portfolio.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Portfolio
{
    private String uuid;
    private String name;
    private boolean IsReportable;

    private Account referenceAccount;

    private List<PortfolioTransaction> transactions = new ArrayList<PortfolioTransaction>();

    public Portfolio()
    {
        this.uuid = UUID.randomUUID().toString();
        this.IsReportable = true;
    }

    public String getUUID()
    {
        return uuid;
    }

    /* package */void generateUUID()
    {
        // needed to assign UUIDs when loading older versions from XML
        uuid = UUID.randomUUID().toString();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean getIsReportable()
    {
        return IsReportable;
    }

    public void setIsReportable(boolean IsReportable)
    {
        this.IsReportable = IsReportable;
    }

    public Account getReferenceAccount()
    {
        return referenceAccount;
    }

    public void setReferenceAccount(Account referenceAccount)
    {
        this.referenceAccount = referenceAccount;
    }

    public List<PortfolioTransaction> getTransactions()
    {
        return transactions;
    }

    public void addTransaction(PortfolioTransaction transaction)
    {
        this.transactions.add(transaction);
    }

    public void addAllTransaction(List<PortfolioTransaction> transactions)
    {
        this.transactions.addAll(transactions);
    }

    @Override
    public String toString()
    {
        return name;
    }
}
