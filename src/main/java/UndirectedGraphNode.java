import java.util.*;

public class UndirectedGraphNode{
    int label = 0;
    UndirectedGraphNode left = null;
    UndirectedGraphNode right = null;
    ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }

    /**
     * 深度优先搜索(递归)
     */
    Map<UndirectedGraphNode, Boolean> visitedMap = new HashMap<>();

    private boolean checkDFS(UndirectedGraphNode a, UndirectedGraphNode b) {
        if (a == null || b == null){
            return false;
        }
        if (a == b) {
            return true;
        }

        visitedMap.put(a, true);

        for (UndirectedGraphNode neighbor : a.neighbors) {

            //下面的写法是错误的，原因是在这种情况下,如果a先访问邻居c就会最终返回true；如果a先访问到邻居d就会返回false。而访问的顺序与存储的结构和存储的顺序有关，所以可能会存在一定概率出错。简单的说，这种写法的含义是，DFS搜索的到的第一条线路如果是要找到就返回true并不在继续找，如果不是返回false，也不会继续找其他线路了。
            //   ↗ d → e
            // a
            //   ↘ c → b
            // if (!visitedMap.containsKey(neighbor)) {
            // return checkDFS(neighbor, b);
            // }


            //没访问过等于：根本没包含 或者 包含了但是为false(其中第二种情况不可能存在，因为从来没赋值过false)，这种写法是正确的，含义是:找到了就直接返回true，并不再寻找下一条线路。如果没找到，继续for的下一个循环就行（也就是继续找其他线路，不会return false）
            if (!visitedMap.containsKey(neighbor) && checkDFS(neighbor, b)) {
                return true;
            }
        }

        return false;

    }

    /**
     * 广度优先搜索
     */
    private boolean checkBFS(UndirectedGraphNode a, UndirectedGraphNode b) {

        if (a == null || b == null) {
            return false;
        }
        if (a == b) {
            return true;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        //用来标记是否访问过该节点
        HashMap<UndirectedGraphNode, Boolean> visitedMap = new HashMap<>();
        visitedMap.put(a, true);
        queue.offer(a);
        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();//从队列头部移除
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (!visitedMap.containsKey(neighbor)) {//如果没访问过

                    if (neighbor == b) {
                        return true;
                    }
                    visitedMap.put(neighbor, true);
                    queue.offer(neighbor);
                }
            }
        }
        return false;
    }
}