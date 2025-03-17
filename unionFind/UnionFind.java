package unionFind;

public class UnionFind {
    protected Node[] a;

    public UnionFind(Node[] iarray){
        a = iarray;
    }

    protected int find(int i){
        if (i != a[i].Parent())
            a[i].setParent(find(a[i].getParent()));
        return a[i].getParent();
    }

    public void union(int i, int j){
        int iroot = find(i);
        int jroot = find(j);
        if(iroot = jroot)
            return;
    }
    pubic void printsets()
    {

    }

}
