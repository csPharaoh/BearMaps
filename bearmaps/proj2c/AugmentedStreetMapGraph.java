package bearmaps.proj2c;

import bearmaps.hw4.streetmap.Node;
import bearmaps.hw4.streetmap.StreetMapGraph;
import bearmaps.proj2ab.KDTree;
import bearmaps.proj2ab.MyTrieSet;
import bearmaps.proj2ab.Point;
import bearmaps.proj2ab.WeirdPointSet;
import edu.princeton.cs.algs4.TST;
import edu.princeton.cs.algs4.TrieSET;

import javax.naming.Name;
import java.util.*;

/**
 * An augmented graph that is more powerful that a standard StreetMapGraph.
 * Specifically, it supports the following additional operations:
 *
 *
 * @author Alan Yao, Josh Hug, ________
 */
public class AugmentedStreetMapGraph extends StreetMapGraph {

    KDTree NodesToKd;

    WeirdPointSet wps;

    Map<Point, Node> PointToNode;

    Map<String, Map<String, Integer>> DirtyToClean;

    Map<String, List<Node>> NameToLocs;

    List<Point> pointsFromNodes;

    Map <String, String> extraDTC;

    List <String> dirtyNames;

    MyTrieSet TS;

    public AugmentedStreetMapGraph(String dbPath) {
        super(dbPath);
        // You might find it helpful to uncomment the line below:

        List<Node> nodes = this.getNodes();
        TS = new MyTrieSet();
        String cleanName="";
        NameToLocs = new HashMap<>();
        PointToNode = new HashMap<>();
        DirtyToClean = new HashMap<>();

        for (Node n: nodes)
        {
            if(n.name() != null)
            {
                if(!NameToLocs.containsKey(cleanString(n.name())))
                {
                    List<Node> temp = new ArrayList<Node>();
                    temp.add(n);
                    NameToLocs.put(cleanString(n.name()),temp);

                }
                else
                {
                    NameToLocs.get(cleanString(n.name())).add(n);
                }

                cleanName = cleanString(n.name());
                if(DirtyToClean.containsKey(cleanName))
                {

                    if(!DirtyToClean.get(cleanName).containsKey(n.name()))
                        DirtyToClean.get(cleanName).put(n.name(),1);

                }
                else
                {
                    Map <String, Integer> temp = new HashMap<>();
                    temp.put(n.name(),1);
                    DirtyToClean.put(cleanName,temp);
                }

                TS.add(cleanName);
            }

            if(neighbors(n.id()).size() != 0)
            {
                PointToNode.put(new Point(n.lon(), n.lat()), n);
            }
        }

        //System.out.println(NameToLocs.get("forthrite").size());

        pointsFromNodes = new ArrayList<Point>(PointToNode.keySet());

        wps = new WeirdPointSet(pointsFromNodes);
        NodesToKd = new KDTree(pointsFromNodes);

    }


    /**
     * For Project Part II
     * Returns the vertex closest to the given longitude and latitude.
     * @param lon The target longitude.
     * @param lat The target latitude.
     * @return The id of the node in the graph closest to the target.
     */
    public long closest(double lon, double lat)
    {
        Point closestPoint =  wps.nearest(lon, lat);

        return PointToNode.get(closestPoint).id();
    }


    /**
     * For Project Part III (gold points)
     * In linear time, collect all the names of OSM locations that prefix-match the query string.
     * @param prefix Prefix string to be searched for. Could be any case, with our without
     *               punctuation.
     * @return A <code>List</code> of the full names of locations whose cleaned name matches the
     * cleaned <code>prefix</code>.
     */
    public List<String> getLocationsByPrefix(String prefix)
    {
        List<String> temp;
        dirtyNames = new ArrayList<String>();

        for(String s : TS.keysWithPrefix(prefix))
        {
            for (int i = 0; i<DirtyToClean.get(s).size(); i++)
            {
                 temp = new ArrayList<String>(DirtyToClean.get(s).keySet());
                 dirtyNames.add(temp.get(i));
            }
        }

        return dirtyNames;

    }

    /**
     * For Project Part III (gold points)
     * Collect all locations that match a cleaned <code>locationName</code>, and return
     * information about each node that matches.
     * @param locationName A full name of a location searched for.
     * @return A list of locations whose cleaned name matches the
     * cleaned <code>locationName</code>, and each location is a map of parameters for the Json
     * response as specified: <br>
     * "lat" -> Number, The latitude of the node. <br>
     * "lon" -> Number, The longitude of the node. <br>
     * "name" -> String, The actual name of the node. <br>
     * "id" -> Number, The id of the node. <br>
     */
    public List<Map<String, Object>> getLocations(String locationName) {

        List <Map <String, Object>> result = new ArrayList<>();

        if (NameToLocs.get(cleanString(locationName)) == null)
            return new ArrayList<>();

        for(Node n :NameToLocs.get(cleanString(locationName)))
        {
            Map<String, Object> temp = new HashMap<>();
            temp.put("lat",n.lat());
            temp.put("lon",n.lon());
            temp.put("name",n.name());
            temp.put("id",n.id());
            result.add(temp);
        }
        return result;
    }


    /**
     * Useful for Part III. Do not modify.
     * Helper to process strings into their "cleaned" form, ignoring punctuation and capitalization.
     * @param s Input string.
     * @return Cleaned string.
     */
    private static String cleanString(String s) {
        return s.replaceAll("[^a-zA-Z ]", "").toLowerCase();
    }

}
