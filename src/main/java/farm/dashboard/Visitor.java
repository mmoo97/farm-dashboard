package farm.dashboard;

abstract class Visitor {
    public abstract void visitItemContainer(ItemContainer itemContainer);
    public abstract void visitItem(Item item);

}
