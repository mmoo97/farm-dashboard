package farm.dashboard;

class PricingVisitor extends Visitor {

    private double total;

    public PricingVisitor(){
        total=0;
    }
    @Override
    public void visitItemContainer(ItemContainer itemContainer) {
        total += itemContainer.getNetPrice();
    }

    @Override
    public void visitItem(Item item) {
        total += item.getPrice();
    }

    public double getValue(){
        return total;
    }


}