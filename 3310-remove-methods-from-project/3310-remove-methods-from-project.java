import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // Build adjacency list for directional invocations: u -> v
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] inv : invocations) {
            graph.get(inv[0]).add(inv[1]);
        }

        // Step 1: Identify all suspicious methods reachable starting from method k
        Set<Integer> suspicious = new HashSet<>();
        dfs(k, graph, suspicious);

        // Step 2: Check if any non-suspicious method invokes a suspicious method
        for (int[] inv : invocations) {
            int u = inv[0];
            int v = inv[1];
            if (!suspicious.contains(u) && suspicious.contains(v)) {
                // An outside method invokes a suspicious method, so we cannot remove any
                List<Integer> allMethods = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    allMethods.add(i);
                }
                return allMethods;
            }
        }

        // Step 3: Remove all suspicious methods and return remaining
        List<Integer> remaining = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious.contains(i)) {
                remaining.add(i);
            }
        }
        return remaining;
    }

    private void dfs(int node, List<List<Integer>> graph, Set<Integer> suspicious) {
        suspicious.add(node);
        for (int neighbor : graph.get(node)) {
            if (!suspicious.contains(neighbor)) {
                dfs(neighbor, graph, suspicious);
            }
        }
    }
}