// DFS to traverse the flight itinerary
// Visit destinations in lexical order
// Add the current airport to itinerary after visiting all destinations
// Populate the flight graph using ticket information
// Sort destinations in reverse order to visit lexical smaller destinations first
// Start the DFS from the JFK airport
// Reverse the itinerary AGAIN for correct order
class Solution {
    private Map<String, List<String>> flightGraph;
    private List<String> it;

    public Solution() {
        flightGraph = new HashMap<>();
        it = new ArrayList<>();
    }

    private void dfs(String airport) {
        List<String> destinations = flightGraph.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            String nextDestination = destinations.remove(destinations.size() - 1);
            dfs(nextDestination);
        }
        it.add(airport);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            flightGraph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }

        
        for (List<String> destinations : flightGraph.values()) {
            destinations.sort(Collections.reverseOrder());
        }
        dfs("JFK");

        
        Collections.reverse(it);
        return it;
    }
}