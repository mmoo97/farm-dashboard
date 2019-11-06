package farm.dashboard;

class MarketValueVisitor extends Visitor {

    private double total;

    public MarketValueVisitor(){
        total=0;
    }
    @Override
    public void visitItemContainer(ItemContainer itemContainer) {
        total += itemContainer.getNetMarketValue();
    }

    @Override
    public void visitItem(Item item) {
        total += item.getMarketValue();
    }

    public double getValue(){
       return total;
    }
}
